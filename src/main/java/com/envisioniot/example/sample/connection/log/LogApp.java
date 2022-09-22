package com.envisioniot.example.sample.connection.log;

/**
 * @Author: song.xu
 * @Date: 2022/9/22
 */
public class LogApp {
    public void logApp(String accessKey, String secretKey, String orgId, String url) {
        String expr = "asset = 'dskksdd'"; // input expr
        SearchCloudLog searchCloudLog = new SearchCloudLog();
        searchCloudLog.searchCloudLog(accessKey, secretKey, orgId, url, expr);

        SearchDeviceLog searchDeviceLog = new SearchDeviceLog();
        searchDeviceLog.searchDeviceLog(accessKey, secretKey, orgId, url, expr);
    }
}
