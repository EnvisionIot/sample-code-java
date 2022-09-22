/**
 * Copyright (C), 2015-2022, Envision
 * FileName: UploadEvents
 * Author:  Arihant jain
 * Date:    18/1/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.connection.httpmessageintegration;

import com.envisioniot.enos.iot_http_integration.HttpConnection;
import com.envisioniot.enos.iot_http_integration.message.IIntegrationCallback;
import com.envisioniot.enos.iot_http_integration.message.IntegrationEventPostRequest;
import com.envisioniot.enos.iot_http_integration.message.IntegrationResponse;
import com.envisioniot.enos.iot_http_integration.progress.IProgressListener;
import com.envisioniot.enos.iot_mqtt_sdk.core.exception.EnvisionException;
import com.envisioniot.enos.iot_mqtt_sdk.message.upstream.tsl.UploadFileInfo;
import com.envisioniot.enos.sdk.data.DeviceInfo;
import com.google.common.collect.Maps;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/upload_integration_events.html  <br>
 * refer to the resources/ConnectionsServiceModels/DeviceData/model_demo_smartbattery_model_15.json
 * @author arihantjain97
 * @create 18/1/22
 * @since --
 */

public class UploadEvents {

    public void eventsUpload(HttpConnection connection, IntegrationEventPostRequest request){
        try {
            connection.publish(request, new IIntegrationCallback() {
                @Override
                public void onResponse(IntegrationResponse response) {
                    System.out.println("receive response asynchronously");
                    System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(response));
                }

                @Override
                public void onFailure(Exception failure) {
                    failure.printStackTrace();
                }
            }, new IProgressListener() {
                @Override
                public void onRequestProgress(long l, long l1) {
                    System.out.println(l + " " + l1); ;
                    System.out.println(String.format("Progress: %.2f %%", (float) l / l1 * 100.0)); ;
                }
            });
        } catch (IOException | EnvisionException e) {
            e.printStackTrace();
        }
    }

    public void uploadEvents_assetId(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String assetId)
    {

        String API_GW_URL  = url;
        String INTEGRATION_CHANNEL_URL  = "https://iot-http-integration-ppe1.envisioniot.com";

        DeviceInfo deviceInfo = new DeviceInfo().setAssetId(assetId);

        // eventsMap to contain mappings between eventId (Key) and defined event's parameters map (Value).
        Map<String, Map<String, Object>> eventsMap = Maps.newHashMap();

        // events' output parameter maps.
        // note: In this example, there are two events: tempExceed27 and tempBelow10.
        Map<String, Object> tempExceed27_parametersMap = Maps.newHashMap();
        File f = new File("UploadFileSample.txt");
        tempExceed27_parametersMap.put("fileParameter", f);
        tempExceed27_parametersMap.put("temperature", Double.MAX_VALUE);

        Map<String, Object> tempBelow10_parametersMap = Maps.newHashMap();
        tempBelow10_parametersMap.put("temperature", Integer.MAX_VALUE);
        tempBelow10_parametersMap.put("floatParam", Float.MAX_VALUE - 10);

        eventsMap.put("tempExceed27", tempExceed27_parametersMap);
        eventsMap.put("tempBelow10", tempBelow10_parametersMap);

        // Additional Information about file.
        // note: optional.
        List<UploadFileInfo> fileInfoList = new ArrayList<>();
        UploadFileInfo uploadfileinfo = new UploadFileInfo();
        uploadfileinfo.setFile(f);
        uploadfileinfo.setOriginalFilename("UploadFileSample_events_assetId.txt");
        uploadfileinfo.setAssetId(assetId);
        uploadfileinfo.setFeatureId("tempExceed27");
        uploadfileinfo.setFeatureType("FILE");
        uploadfileinfo.setFilename("UploadFileSample.txt");
        fileInfoList.add(uploadfileinfo);

        HttpConnection connection = new HttpConnection.Builder(
                INTEGRATION_CHANNEL_URL, API_GW_URL, accessKey, secretKey, orgId)
                .build();

        IntegrationEventPostRequest request =  IntegrationEventPostRequest.builder()
                .addEvent(deviceInfo, System.currentTimeMillis(), eventsMap)
                .build();

        request.setFiles(fileInfoList);
        eventsUpload(connection, request);
    }

    public void uploadEvents_keys(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey,
            String deviceKey)
    {

        String API_GW_URL  = url;
        String INTEGRATION_CHANNEL_URL  = "https://iot-http-integration-ppe1.envisioniot.com";

        DeviceInfo deviceInfo = new DeviceInfo().setKey(productKey, deviceKey);

        // eventsMap to contain mappings between eventId (Key) and defined event's parameters map (Value).
        Map<String, Map<String, Object>> eventsMap = Maps.newHashMap();

        // events' output parameter maps.
        // note: In this example, there are two events: tempExceed27 and tempBelow10.
        Map<String, Object> tempExceed27_parametersMap = Maps.newHashMap();
        File f = new File("UploadFileSample.txt");
        tempExceed27_parametersMap.put("fileParameter", f);
        tempExceed27_parametersMap.put("temperature", Double.MAX_VALUE);

        Map<String, Object> tempBelow10_parametersMap = Maps.newHashMap();
        tempBelow10_parametersMap.put("temperature", Integer.MAX_VALUE);
        tempBelow10_parametersMap.put("floatParam", Float.MAX_VALUE - 10);

        eventsMap.put("tempExceed27", tempExceed27_parametersMap);
        eventsMap.put("tempBelow10", tempBelow10_parametersMap);

        // Additional Information about file.
        // note: optional.
        List<UploadFileInfo> fileInfoList = new ArrayList<>();
        UploadFileInfo uploadfileinfo = new UploadFileInfo();
        uploadfileinfo.setFile(f);
        uploadfileinfo.setOriginalFilename("UploadFileSample_event_keys.txt");
        uploadfileinfo.setProductKey(productKey);
        uploadfileinfo.setDeviceKey(deviceKey);
        uploadfileinfo.setFeatureId("tempExceed27");
        uploadfileinfo.setFeatureType("FILE");
        uploadfileinfo.setFilename("UploadFileSample.txt");
        fileInfoList.add(uploadfileinfo);

        HttpConnection connection = new HttpConnection.Builder(
                INTEGRATION_CHANNEL_URL, API_GW_URL, accessKey, secretKey, orgId)
                .build();

        IntegrationEventPostRequest request =  IntegrationEventPostRequest.builder()
                .addEvent(deviceInfo, System.currentTimeMillis(), eventsMap)
                .build();

        request.setFiles(fileInfoList);
        eventsUpload(connection, request);
    }

}
