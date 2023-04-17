package com.envisioniot.example.sample.connection.httpmessageintegration;

import com.envisioniot.enos.iot_http_integration.HttpConnection;
import com.envisioniot.enos.iot_http_integration.message.IntegrationMeasurepointPostRequest;
import com.envisioniot.enos.iot_http_integration.message.IntegrationResponse;
import com.envisioniot.enos.iot_mqtt_sdk.core.exception.EnvisionException;
import com.envisioniot.enos.sdk.data.DeviceInfo;
import com.google.common.collect.Maps;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.HashMap;

public class MeasurepointIntegrationSample_PDC_Ong {
    static final String TOKEN_SERVER_URL = "https://ag-pdc1.eniot.io";
    static final String BROKER_URL = "https://iot-http-integration-pdc1.eniot.io";

    // EnOS Application AccessKey and SecretKey, which can be obtain in Application Registration page in EnOS Console
    static final String APP_KEY = "cde4edb7-0b45-48d3-b3a5-82f7ffede77c";;
    static final String APP_SECRET = "e5de8340-6211-41e5-bc29-8fdb72cb44bf";

    // Device credentials, which can be obtained from Device Details page in EnOS Console
    static final String ORG_ID = "o16369576837801930";
    static final String ASSET_ID = "WbYFoYM6";
//    static final String PRODUCT_KEY = "UUSfFZxG";
//    static final String DEVICE_KEY = "uiPq5RuH2o";

    private static IntegrationMeasurepointPostRequest buildMeasurepointPostRequest() {
        DeviceInfo deviceInfo1 = new DeviceInfo().setAssetId(ASSET_ID);
        //DeviceInfo deviceInfo2 = new DeviceInfo().setKey(PRODUCT_KEY, DEVICE_KEY);

        // Measurepoints are defined in ThingModel
        // FileMeasurePoint1 is a file-type measurepoint
        HashMap<String, Object> hashMap = Maps.newHashMap();
        hashMap.put("stat_door_close", (int)(Math.random()*10));
        return IntegrationMeasurepointPostRequest.builder()
                .addMeasurepoint(deviceInfo1, System.currentTimeMillis(), hashMap)
               // .addMeasurepoint(deviceInfo2, System.currentTimeMillis(), hashMap)
                .build();
    }

    public static void main(String[] args) throws EnvisionException {

        int errorCount = 0;
        int total = 100;
        for(int i=0;i<total;i++) {
            // Construct a http connection
            HttpConnection connection = new HttpConnection.Builder(
                    BROKER_URL, TOKEN_SERVER_URL, APP_KEY, APP_SECRET, ORG_ID)
                    .build();

            IntegrationMeasurepointPostRequest request = buildMeasurepointPostRequest();

            try {
                IntegrationResponse response = connection.publish(request, (bytes, length) ->
                        System.out.println(String.format("Progress: %.2f %%", (float) bytes / length * 100.0)));
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(response));
                if(response.getCode()!=0){
                    errorCount++;
                }
            } catch (EnvisionException | IOException e) {
                if(e instanceof EnvisionException){
                    System.out.println(((EnvisionException) e).getErrorCode());
                }
                e.printStackTrace();
            }
        }
        System.out.println("Error count: " + errorCount + " of " + total);

        // Asynchronously call the measurepoint post with file
//        request = buildMeasurepointPostRequest();
//
//        try {
//            connection.publish(request, new IIntegrationCallback() {
//                        @Override
//                        public void onResponse(IntegrationResponse response) {
//                            System.out.println("receive response asynchronously");
//                            System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(response));
//                        }
//
//                        @Override
//                        public void onFailure(Exception failure) {
//                            failure.printStackTrace();
//                        }
//                    }, (bytes, length) ->
//                            System.out.println(String.format("Progress: %.2f %%", (float) bytes / length * 100.0))
//            );
//        } catch (IOException | EnvisionException e) {
//            e.printStackTrace();
//        }
    }
}
