/**
 * Copyright (C), 2015-2022, Envision
 * FileName: DownloadFile
 * Author:  Arihant jain
 * Date:    5/1/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.connection.devicedata;

import com.envisioniot.enos.iot_http_integration.FileCategory;
import com.envisioniot.enos.iot_http_integration.HttpConnection;
import com.envisioniot.enos.iot_http_integration.message.IFileCallback;
import com.envisioniot.enos.iot_mqtt_sdk.core.exception.EnvisionException;
import com.envisioniot.enos.sdk.data.DeviceInfo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/download_file.html  <br>
 * refer to the resources/ConnectionsServiceModels/DeviceData/model_demo_smartbattery_model_15.json
 *
 * @author arihantjain97
 * @create 17/1/22
 * @since --
 */

public class DownloadFile {

    private void fileDownload(HttpConnection connection, DeviceInfo deviceInfo, String fileUri){

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            InputStream inputStream = connection.downloadFile(deviceInfo, fileUri, FileCategory.FEATURE);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            byte[] data = outputStream.toByteArray();
            System.out.println(new String(data));
        } catch (EnvisionException | IOException e) {
            e.printStackTrace();
        }

        // Asynchronously call the file download request
        try {
            connection.downloadFile(deviceInfo, fileUri, FileCategory.FEATURE, new IFileCallback() {
                @Override
                public void onResponse(InputStream inputStream) throws IOException {
                    System.out.println("download file asynchronously");
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, len);
                    }
                    byte[] data = outputStream.toByteArray();
                    System.out.println(new String(data));
                }

                @Override
                public void onFailure(Exception failure) {
                    failure.printStackTrace();
                }
            });
        } catch (EnvisionException e) {
            e.printStackTrace();
        }
    }

    public void downloadFile_assetId(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String assetId,
            String fileUri)
    {
        String API_GW_URL  = url;
        String INTEGRATION_CHANNEL_URL  = "https://iot-http-integration-ppe1.envisioniot.com";
        // Construct a http connection
        HttpConnection connection = new HttpConnection.Builder(
                INTEGRATION_CHANNEL_URL, API_GW_URL, accessKey, secretKey, orgId)
                .build();

        DeviceInfo deviceInfo = new DeviceInfo().setAssetId(assetId);
        // fileUri is an enos scheme file uri
        //String fileUri = "enos-connect://29846cd9c3002000.txt";

        fileDownload(connection, deviceInfo, fileUri);
    }

    public void downloadFile_keys(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey,
            String deviceKey,
            String fileUri)
    {
        String API_GW_URL  = url;
        String INTEGRATION_CHANNEL_URL  = "https://iot-http-integration-ppe1.envisioniot.com";
        // Construct a http connection
        HttpConnection connection = new HttpConnection.Builder(
                INTEGRATION_CHANNEL_URL, API_GW_URL, accessKey, secretKey, orgId)
                .build();

        DeviceInfo deviceInfo = new DeviceInfo().setKey(productKey, deviceKey);
        // fileUri is an enos scheme file uri
        //String fileUri = "enos-connect://29846cd9c3002000.txt";

        fileDownload(connection, deviceInfo, fileUri);
    }

}