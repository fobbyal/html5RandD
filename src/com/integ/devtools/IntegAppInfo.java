package com.integ.devtools;

import java.io.Serializable;

/**
 * Created by showdown on 6/10/14.
 */
public class IntegAppInfo implements Serializable {

    String productName;


    /**
     * optional tag for AEP REG/UNREG
     */
    String clientAppVersiont;

    String client;
    /**
     * Legacy for 3.0 referring to under the JComplete 3.0 umbrella
     */
    String mileStone;
    /**
     * Choices of DEV STG or TEST or EXT
     */
    String environmentType;

    /**
     * Server type JBoss or Weblogic at this point
     * At this point the hope is that we can manipulate the server to start or stop
     *
     */
    String serverType;

    /**
     * server status
     * May be implement some server status logic where we can check on the status of the app
     */

    String serverStatus;




    /**
     * Server console url
     */

    String serverConsoleUrl;


    /**
     * url for accessing the app
     */
    String appLocation;

    /**
     * uTrack url for tickets creation or other wise
     * may need to separate information in order to have advance features such as
     * creating tickets or viewing product specific ids
     * need to research and may need to define further information
     */
    String uTrackLocation;


    /**
     * Teamcity CI/build server location where the app can be deployed and built
     * Teamcity build url. May need additional information to build server in order to have advance
     * features kile initializing builds. need to research and may need to define further inforation
     */

    String teamyCityLocation;

    /**
     *
     */
    String oracleDB;


    /**
     *  Ftp Deployment tool
     */

    String ftpLocation;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getMileStone() {
        return mileStone;
    }

    public void setMileStone(String mileStone) {
        this.mileStone = mileStone;
    }

    public String getEnvironmentType() {
        return environmentType;
    }

    public void setEnvironmentType(String environmentType) {
        this.environmentType = environmentType;
    }

    public String getServerType() {
        return serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    public String getServerStatus() {
        return serverStatus;
    }

    public void setServerStatus(String serverStatus) {
        this.serverStatus = serverStatus;
    }

    public String getServerConsoleUrl() {
        return serverConsoleUrl;
    }

    public void setServerConsoleUrl(String serverConsoleUrl) {
        this.serverConsoleUrl = serverConsoleUrl;
    }

    public String getAppLocation() {
        return appLocation;
    }

    public void setAppLocation(String appLocation) {
        this.appLocation = appLocation;
    }

    public String getuTrackLocation() {
        return uTrackLocation;
    }

    public void setuTrackLocation(String uTrackLocation) {
        this.uTrackLocation = uTrackLocation;
    }

    public String getTeamyCityLocation() {
        return teamyCityLocation;
    }

    public void setTeamyCityLocation(String teamyCityLocation) {
        this.teamyCityLocation = teamyCityLocation;
    }

    public String getOracleDB() {
        return oracleDB;
    }

    public void setOracleDB(String oracleDB) {
        this.oracleDB = oracleDB;
    }

    public String getFtpLocation() {
        return ftpLocation;
    }

    public void setFtpLocation(String ftpLocation) {
        this.ftpLocation = ftpLocation;
    }

    public String getClientAppVersiont() {
        return clientAppVersiont;
    }

    public void setClientAppVersiont(String clientAppVersiont) {
        this.clientAppVersiont = clientAppVersiont;
    }
}
