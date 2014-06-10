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
    String clientAppVersion;

    String client;
    /**
     * Legacy for 3.0 referring to under the JComplete 3.0 umbrella
     */
    String milestone;
    /**
     * Choices of DEV STG or TEST or EXT
     */
    String environmentType;

    /**
     * Server type JBoss or Weblogic at this point
     * At this point the hope is that we can manipulate the server to start or stop
     */
    String serverType;


    /**
     * Server console url
     */

    String serverConsoleUrl;


    /**
     * url for accessing the app
     */
    String appURL;

    /**
     * uTrack url for tickets creation or other wise
     * may need to separate information in order to have advance features such as
     * creating tickets or viewing product specific ids
     * need to research and may need to define further information
     */
    String uTrackURL;


    /**
     * Teamcity CI/build server location where the app can be deployed and built
     * Teamcity build url. May need additional information to build server in order to have advance
     * features kile initializing builds. need to research and may need to define further inforation
     */

    String teamCityURL;

    /**
     * Ftp Deployment tool
     */

    String ftpReleaseLocation;


    String dbConnectionString;

    String versionControlRoot;

    public String getuTrackURL() {
        return uTrackURL;
    }

    public void setuTrackURL(String uTrackURL) {
        this.uTrackURL = uTrackURL;
    }

    public String getDbConnectionString() {
        return dbConnectionString;
    }

    public void setDbConnectionString(String dbConnectionString) {
        this.dbConnectionString = dbConnectionString;
    }

    public String getVersionControlRoot() {
        return versionControlRoot;
    }

    public void setVersionControlRoot(String versionControlRoot) {
        this.versionControlRoot = versionControlRoot;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "IntegAppInfo{" +
                "productName='" + productName + '\'' +
                ", clientAppVersion='" + clientAppVersion + '\'' +
                ", client='" + client + '\'' +
                ", milestone='" + milestone + '\'' +
                ", environmentType='" + environmentType + '\'' +
                ", serverType='" + serverType + '\'' +
                ", serverConsoleUrl='" + serverConsoleUrl + '\'' +
                ", appURL='" + appURL + '\'' +
                ", uTrackURL='" + uTrackURL + '\'' +
                ", teamCityURL='" + teamCityURL + '\'' +
                ", ftpReleaseLocation='" + ftpReleaseLocation + '\'' +
                ", dbConnectionString='" + dbConnectionString + '\'' +
                ", versionControlRoot='" + versionControlRoot + '\'' +
                '}';
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getMilestone() {
        return milestone;
    }

    public void setMilestone(String milestone) {
        this.milestone = milestone;
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

    public String getServerConsoleUrl() {
        return serverConsoleUrl;
    }

    public void setServerConsoleUrl(String serverConsoleUrl) {
        this.serverConsoleUrl = serverConsoleUrl;
    }

    public String getAppURL() {
        return appURL;
    }

    public void setAppURL(String appURL) {
        this.appURL = appURL;
    }


    public String getTeamCityURL() {
        return teamCityURL;
    }

    public void setTeamCityURL(String teamCityURL) {
        this.teamCityURL = teamCityURL;
    }


    public String getFtpReleaseLocation() {
        return ftpReleaseLocation;
    }

    public void setFtpReleaseLocation(String ftpReleaseLocation) {
        this.ftpReleaseLocation = ftpReleaseLocation;
    }

    public String getClientAppVersion() {
        return clientAppVersion;
    }

    public void setClientAppVersion(String clientAppVersion) {
        this.clientAppVersion = clientAppVersion;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntegAppInfo)) return false;

        IntegAppInfo that = (IntegAppInfo) o;

        if (!appURL.equals(that.appURL)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return appURL.hashCode();
    }
}
