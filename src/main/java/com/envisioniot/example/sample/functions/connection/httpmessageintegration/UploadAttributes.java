/**
 * Copyright (C), 2015-2022, Envision
 * FileName: UploadAttributes
 * Author:  Arihant jain
 * Date:    18/1/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.functions.connection.httpmessageintegration;

import com.alibaba.fastjson.JSONObject;
import com.envisioniot.enos.iot_http_integration.HttpConnection;
import com.envisioniot.enos.iot_http_integration.message.IIntegrationCallback;
import com.envisioniot.enos.iot_http_integration.message.IntegrationAttributePostRequest;
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
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/upload_integration_attributes.html  <br>
 * refer to the resources/ConnectionsServiceModels/DeviceData/model_demo_smartbattery_model_15.json
 * @author arihantjain97
 * @create 18/1/22
 * @since --
 */

public class UploadAttributes {

    public void attributeUpload(HttpConnection connection, IntegrationAttributePostRequest request){
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

    public void uploadAttributes_assetId(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String assetId)
    {

        String API_GW_URL  = url;
        String INTEGRATION_CHANNEL_URL  = "https://iot-http-integration-ppe1.envisioniot.com";

        DeviceInfo deviceInfo = new DeviceInfo().setAssetId(assetId);

        // Map of attribute Ids (map key) and their new values (map value).
        // note: Ensure attribute's value of correct type. In this example, attributeId 'brand' is of type String.
        HashMap <String, Object> attIdToValueMap = Maps.newHashMap();
        File f = new File("UploadFileSample.txt");
        attIdToValueMap.put("intAttribute", 1);
       //attIdToValueMap.put("floatAttribute", Float.MAX_VALUE - 10);
        attIdToValueMap.put("doubleAttribute", Double.MAX_VALUE);
        attIdToValueMap.put("boolAttribute", false);
        attIdToValueMap.put("stringAttribute", "attributeValue");
        attIdToValueMap.put("timestampAttribute", 1642495457548L);
        attIdToValueMap.put("dateAttribute", "2022-12-31");
        attIdToValueMap.put("structAttribute", new JSONObject().put("structParameter", 10));
        //attIdToValueMap.put("structAttribute", "{'structParameter': 10}");
        attIdToValueMap.put("arrayAttribute", new int[]{ 1,2,3,4,5,6,7,8,9,10 });
        attIdToValueMap.put("file", f);

        // Additional Information about file.
        // note: optional.
        List<UploadFileInfo> fileInfoList = new ArrayList<>();
        UploadFileInfo uploadfileinfo = new UploadFileInfo();
        uploadfileinfo.setFile(f);
        uploadfileinfo.setOriginalFilename("UploadFileSample_att_assetId.txt");
        uploadfileinfo.setAssetId(assetId);
        uploadfileinfo.setFeatureId("file");
        uploadfileinfo.setFeatureType("FILE");
        uploadfileinfo.setFilename("UploadFileSample.txt");
        fileInfoList.add(uploadfileinfo);

        HttpConnection connection = new HttpConnection.Builder(
                INTEGRATION_CHANNEL_URL, API_GW_URL, accessKey, secretKey, orgId)
                .build();


        IntegrationAttributePostRequest request = new IntegrationAttributePostRequest().builder()
                .addAttribute(deviceInfo, attIdToValueMap)
                .build();

        request.setFiles(fileInfoList);
        attributeUpload(connection,request);
    }

    public void uploadAttributes_keys(
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

        // Map of attribute Ids (map key) and their new values (map value).
        HashMap <String, Object> attIdToValueMap = Maps.newHashMap();
        File f = new File("UploadFileSample.txt");
        attIdToValueMap.put("intAttribute", Integer.MAX_VALUE);
        //attIdToValueMap.put("floatAttribute", Float.MAX_VALUE - 10);
        attIdToValueMap.put("doubleAttribute", Double.MAX_VALUE);
        attIdToValueMap.put("boolAttribute", false);
        attIdToValueMap.put("stringAttribute", "attributeValue");
        attIdToValueMap.put("timestampAttribute", 1642495457548L);
        attIdToValueMap.put("dateAttribute", "2022-12-31");
        attIdToValueMap.put("structAttribute", new JSONObject().put("test1", "test2"));
        attIdToValueMap.put("arrayAttribute", new int[]{ 1,2,3,4,5,6,7,8,9,10 });
        attIdToValueMap.put("file", f);


        // Additional Information about file.
        // note: optional.
        List<UploadFileInfo> fileInfoList = new ArrayList<>();
        UploadFileInfo ufi = new UploadFileInfo();
        ufi.setFile(f);
        ufi.setOriginalFilename("UploadFileSample.txt");
        ufi.setDeviceKey(deviceKey);
        ufi.setProductKey(productKey);
        ufi.setFeatureId("file");
        ufi.setFeatureType("FILE");
        ufi.setFilename("UploadFileSample.txt");
        fileInfoList.add(ufi);

        HttpConnection connection = new HttpConnection.Builder(
                INTEGRATION_CHANNEL_URL, API_GW_URL, accessKey, secretKey, orgId)
                .build();

        IntegrationAttributePostRequest request = new IntegrationAttributePostRequest().builder()
                .addAttribute(deviceInfo, attIdToValueMap)
                .build();

        request.setFiles(fileInfoList);
        attributeUpload(connection, request);
    }
}
