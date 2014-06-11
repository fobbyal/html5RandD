package com.integ.devtools;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: aliang
 * Date: 6/10/14
 * Time: 2:59 PM
 */
public class AppInfoDAO {


    interface SQLGenerationInterface {
        String getSQL();
    }

    interface DataExtractionInterface {
        ArrayList<IntegAppInfo> extract(ResultSet rs) throws Exception;
    }


    public ArrayList<IntegAppInfo> getData(SQLGenerationInterface sqlString, DataExtractionInterface dataExtract) {
        String sql = "";
        try {
            Context initContext = new InitialContext();
            Context cxt = (Context) initContext.lookup("java:/comp/env");

            if (cxt == null) {
                throw new RuntimeException("Uh oh -- no context!");
            }

            DataSource ds = (DataSource) cxt.lookup("jdbc/oralocal");
            if (ds == null) {
                throw new RuntimeException("Data source not found!");
            }
            try (Connection con = ds.getConnection()) {
                ResultSet rs = con.prepareStatement(sql = sqlString.getSQL()).executeQuery();
                return dataExtract.extract(rs);
            }
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw (RuntimeException) e;
            } else {
                throw new RuntimeException("Something went wrong during Application Extraction." +
                        (sql != null ? "SQL String generated\n" + sql : ""), e);
            }
        }
    }


    public ArrayList<IntegAppInfo> extractData(ResultSet rs) throws Exception {
        ArrayList<IntegAppInfo> apps = new ArrayList<>();
        while (rs.next()) {
            IntegAppInfo info = getInfo(rs);
            apps.add(info);
        }
        return apps;
    }

    public ArrayList<IntegAppInfo> getInfo() throws RuntimeException {


        return getData(() -> "select * from APP_INFO ORDER BY CLIENT,PRODUCT_NAME,MILESTONE ", this::extractData);


    }

    private IntegAppInfo getInfo(ResultSet rs) throws SQLException {
        IntegAppInfo info = new IntegAppInfo();
        info.setProductName(rs.getString("PRODUCT_NAME"));
        info.setClient(rs.getString("CLIENT"));
        info.setMilestone(rs.getString("MILESTONE"));
        info.setEnvironmentType(rs.getString("ENVIRONMENT"));
        info.setAppURL(rs.getString("APP_URL"));
        info.setServerType(rs.getString("SERVER_TYPE"));
        info.setServerConsoleUrl(rs.getString("SERVER_CONSOLE_URL"));
        info.setuTrackURL(rs.getString("U_TRACK_URL"));
        info.setTeamCityURL(rs.getString("TEAMCITY_URL"));
        info.setDbConnectionString(rs.getString("DB_CONNECTION_STRING"));
        info.setVersionControlRoot(rs.getString("VERSION_CONTROL_ROOT"));
        info.setFtpReleaseLocation(rs.getString("FTP_RELEASE_ROOT"));
        return info;
    }

    public ArrayList<IntegAppInfo> search(String searchString, String searchType) throws RuntimeException {
        String client = "select * from APP_INFO WHERE CLIENT='" + searchString + "'";
        String product = "select * from APP_INFO WHERE CLIENT='" + searchString + "'";
        String sql;
        if (searchType != null && searchType.equalsIgnoreCase("CLIENT")) {
            sql = client;
        } else if (searchType != null && searchType.equalsIgnoreCase("CLIENT")) {
            sql = product;
        } else {
            sql = client + " union " + product;
        }

        sql = "SELECT * FROM (" + sql + ") ORDER BY CLIENT,PRODUCT_NAME,MILESTONE ";

        final String finalSQl = sql;

        return getData(() -> finalSQl, this::extractData);


    }

}
