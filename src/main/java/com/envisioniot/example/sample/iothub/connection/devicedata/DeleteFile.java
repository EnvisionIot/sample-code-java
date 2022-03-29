/**
 * Copyright (C), 2015-2022, Envision
 * FileName: DeleteFile
 * Author:  Arihant jain
 * Date:    5/1/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.iothub.connection.devicedata;

import com.envisioniot.enos.iot_http_integration.HttpConnection;
import com.envisioniot.enos.iot_http_integration.message.IIntegrationCallback;
import com.envisioniot.enos.iot_http_integration.message.IntegrationResponse;
import com.envisioniot.enos.iot_mqtt_sdk.core.exception.EnvisionException;
import com.envisioniot.enos.sdk.data.DeviceInfo;
import com.google.gson.GsonBuilder;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/delete_file.html  <br>
 * refer to the resources/ConnectionsServiceModels/DeviceData/model_demo_smartbattery_model_15.json
 *
 * @author arihantjain97
 * @create 17/1/22
 * @since --
 */

public class DeleteFile {

    private void fileDelete(HttpConnection connection, DeviceInfo deviceInfo, String fileUri){
        try {
            IntegrationResponse response = connection.deleteFile(deviceInfo, fileUri);
            System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(response));
        } catch (EnvisionException e) {
            e.printStackTrace();
        }

        // Asynchronously call the file delete request
        try {
            connection.deleteFile(deviceInfo, fileUri, new IIntegrationCallback() {
                @Override
                public void onResponse(IntegrationResponse response) {
                    System.out.println("receive response asynchronously");
                    System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(response));
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

    public void deleteFile_assetId(
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

        fileDelete(connection, deviceInfo, fileUri);
    }

    public void deleteFile_keys(
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

        fileDelete(connection, deviceInfo, fileUri);
    }
}
