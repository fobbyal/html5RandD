package com.integ.devtools;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: aliang
 * Date: 6/10/14
 * Time: 2:59 PM
 */
public class AppInfoDAO {

    public ArrayList<IntegAppInfo> getInfo() throws RuntimeException {
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
                ResultSet rs = con.prepareStatement("select * from APP_INFO").executeQuery();
                ArrayList<IntegAppInfo> apps = new ArrayList<>();
                while (rs.next()) {
                    IntegAppInfo info = new IntegAppInfo();
                    info.setProductName(rs.getString("PRODUCT_NAME"));
                    info.setClient(rs.getString("CLIENT"));
                    info.setMilestone(rs.getString("MILESTONE"));
                    info.setEnvironmentType(rs.getString("ENVIRONMENT_TYPE"));
                    info.setAppURL(rs.getString("APP_URL"));
                    info.setServerType(rs.getString("SERVER_TYPE"));
                    info.setServerConsoleUrl(rs.getString("SERVER_CONSOLE_URL"));
                    info.setuTrackURL(rs.getString("U_TRACK_URL"));
                    info.setTeamCityURL(rs.getString("TEAMCITY_URL"));
                    info.setDbConnectionString(rs.getString("DB_CONNECTION_STRING"));
                    info.setVersionControlRoot(rs.getString("VERSION_CONTROL_ROOT"));
                    info.setFtpReleaseLocation(rs.getString("FTP_RELEASE_ROOT"));
                    apps.add(info);
                }


                return apps;


            }
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw (RuntimeException) e;
            } else {
                throw new RuntimeException("Something went wrong during Application Extraction", e);
            }
        }
    }
}
