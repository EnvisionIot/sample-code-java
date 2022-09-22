/**
 * Copyright (C), 2015-2022, Envision
 * FileName: UploadMeasurementPoints
 * Author:  Arihant jain
 * Date:    18/1/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.connection.httpmessageintegration;

import com.alibaba.fastjson.JSONObject;
import com.envisioniot.enos.iot_http_integration.HttpConnection;
import com.envisioniot.enos.iot_http_integration.message.IIntegrationCallback;
import com.envisioniot.enos.iot_http_integration.message.IntegrationMeasurepointPostRequest;
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
import java.util.HashMap;
import java.util.List;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/upload_integration_measurepoints.html  <br>
 * refer to the resources/ConnectionsServiceModels/DeviceData/model_demo_smartbattery_model_15.json
 * @author arihantjain97
 * @create 18/1/22
 * @since --
 */

public class UploadMeasurementPoints {

    public void measurementPointsUpload(HttpConnection connection, IntegrationMeasurepointPostRequest request) {
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

    public void uploadMeasurementPoints_assetId(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String assetId)
    {
        String API_GW_URL  = url;
        String INTEGRATION_CHANNEL_URL  = "https://iot-http-integration-ppe1.envisioniot.com";

        DeviceInfo deviceInfo = new DeviceInfo().setAssetId(assetId);

        // Map of measurement point Ids (map key) and their new values (map value).
        // note: Ensure attribute's value of correct type. In this example, measurement point Id 'intMP' is of type int.
        HashMap <String, Object> MpIdToValueMap = Maps.newHashMap();
        File f = new File("UploadFileSample.txt");
        MpIdToValueMap.put("intMP", Integer.MAX_VALUE);
        MpIdToValueMap.put("floatMP", Float.MAX_VALUE - 10);
        MpIdToValueMap.put("temperature", Double.MAX_VALUE);
        MpIdToValueMap.put("stringMP", "attributeValue");
        MpIdToValueMap.put("timestampMP", 1642495457548L);
        MpIdToValueMap.put("dateMP", "2022-12-31");
        MpIdToValueMap.put("structMP", new JSONObject().put("structParameter", Integer.MIN_VALUE));
        MpIdToValueMap.put("arrayMP", new int[]{ 1,2,3,4,5,6,7,8,9,10 });
        MpIdToValueMap.put("fileMP", f);

        // Additional Information about file.
        // note: optional.
        List<UploadFileInfo> fileInfoList = new ArrayList<>();
        UploadFileInfo uploadfileinfo = new UploadFileInfo();
        uploadfileinfo.setFile(f);
        uploadfileinfo.setOriginalFilename("UploadFileSample_mp_assetId.txt");
        uploadfileinfo.setAssetId(assetId);
        uploadfileinfo.setFeatureId("fileMP");
        uploadfileinfo.setFeatureType("FILE");
        uploadfileinfo.setFilename("UploadFileSample.txt");
        fileInfoList.add(uploadfileinfo);

        HttpConnection connection = new HttpConnection.Builder(
                INTEGRATION_CHANNEL_URL, API_GW_URL, accessKey, secretKey, orgId)
                .build();

        IntegrationMeasurepointPostRequest request = IntegrationMeasurepointPostRequest.builder()
                .addMeasurepoint(deviceInfo, System.currentTimeMillis(), MpIdToValueMap)
                .build();

        request.setFiles(fileInfoList);
        measurementPointsUpload(connection, request);
    }

    public void uploadMeasurementPoints_keys(
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

        // Map of measurement point Ids (map key) and their new values (map value).
        // note: Ensure attribute's value of correct type. In this example, measurement point Id 'intMP' is of type int.
        HashMap <String, Object> MpIdToValueMap = Maps.newHashMap();
        File f = new File("UploadFileSample.txt");
        MpIdToValueMap.put("intMP", Integer.MAX_VALUE);
        MpIdToValueMap.put("floatMP", Float.MAX_VALUE - 10);
        MpIdToValueMap.put("temperature", Double.MAX_VALUE);
        MpIdToValueMap.put("stringMP", "attributeValue");
        MpIdToValueMap.put("timestampMP", 1642495457548L);
        MpIdToValueMap.put("dateMP", "2022-12-31");
        MpIdToValueMap.put("structMP", new JSONObject().put("structIntParam", Integer.MIN_VALUE));
        MpIdToValueMap.put("arrayMP", new int[]{ 1,2,3,4,5,6,7,8,9,10 });
        MpIdToValueMap.put("fileMP", f);
        MpIdToValueMap.put("cardNumber", 234242324);
        MpIdToValueMap.put("action", 1);

        // Additional Information about file.
        // note: optional.
        List<UploadFileInfo> fileInfoList = new ArrayList<>();
        UploadFileInfo uploadfileinfo = new UploadFileInfo();
        uploadfileinfo.setFile(f);
        uploadfileinfo.setOriginalFilename("UploadFileSample_mp_keys.txt");
        uploadfileinfo.setProductKey(productKey);
        uploadfileinfo.setDeviceKey(deviceKey);
        uploadfileinfo.setFeatureId("fileMP");
        uploadfileinfo.setFeatureType("FILE");
        uploadfileinfo.setFilename("UploadFileSample.txt");
        fileInfoList.add(uploadfileinfo);

        HttpConnection connection = new HttpConnection.Builder(
                INTEGRATION_CHANNEL_URL, API_GW_URL, accessKey, secretKey, orgId)
                .build();

        IntegrationMeasurepointPostRequest request = IntegrationMeasurepointPostRequest.builder()
                .addMeasurepoint(deviceInfo, System.currentTimeMillis(), MpIdToValueMap)
                .build();

        request.setFiles(fileInfoList);
        measurementPointsUpload(connection, request);
    }
}
