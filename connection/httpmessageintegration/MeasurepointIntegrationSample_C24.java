package com.envisioniot.example.sample.connection.httpmessageintegration;

import com.envisioniot.enos.iot_http_integration.HttpConnection;
import com.envisioniot.enos.iot_http_integration.message.IntegrationMeasurepointPostRequest;
import com.envisioniot.enos.iot_http_integration.message.IntegrationResponse;
import com.envisioniot.enos.iot_mqtt_sdk.core.exception.EnvisionException;
import com.envisioniot.enos.sdk.data.DeviceInfo;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Maps;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class MeasurepointIntegrationSample_C24 {
    static final String TOKEN_SERVER_URL = "https://ag-cloud24.eniot.io";
    static final String BROKER_URL = "https://iot-http-integration-cloud24.eniot.io";

//    static final String BROKER_URL = "http://10.8.11.235:8080";
    //

    // EnOS Application AccessKey and SecretKey, which can be obtain in Application Registration page in EnOS Console
    static final String APP_KEY = "e192437f-2e73-4a62-bdde-9570cb7b6cd6";
    static final String APP_SECRET = "b2062426-64d2-44fa-bfbd-8c76fe34cc45";

    // Device credentials, which can be obtained from Device Details page in EnOS Console
    static final String ORG_ID = "o16800072865301900";
    static final String ASSET_ID = "3l8AwJKw";
    static final String PRODUCT_KEY = "TSQhQ7xu";
    static final String DEVICE_KEY = "7BZAagTDvR";

    private static IntegrationMeasurepointPostRequest buildMeasurepointPostRequest() {
        DeviceInfo deviceInfo1 = new DeviceInfo().setAssetId(ASSET_ID);
        DeviceInfo deviceInfo2 = new DeviceInfo().setKey(PRODUCT_KEY, DEVICE_KEY);

        // Measurepoints are defined in ThingModel
        // FileMeasurePoint1 is a file-type measurepoint
        HashMap<String, Object> hashMap = Maps.newHashMap();
        hashMap.put("int", (int)(Math.random() * 1000));
        return IntegrationMeasurepointPostRequest.builder()
                .addMeasurepoint(deviceInfo1, System.currentTimeMillis(), hashMap)
                .addMeasurepoint(deviceInfo2, System.currentTimeMillis(), hashMap)
                .build();
    }

    public static void main(String[] args) throws EnvisionException {

        int errorCount = 0;
        int total = 100;
        long totalElapsed = 0;
        for (int i = 0; i < total; i++) {
            // Construct a http connection
            HttpConnection connection = new HttpConnection.Builder(
                    BROKER_URL, TOKEN_SERVER_URL, APP_KEY, APP_SECRET, ORG_ID)
                    .build();

            IntegrationMeasurepointPostRequest request = buildMeasurepointPostRequest();

            try {
                Stopwatch stopwatch = Stopwatch.createStarted();
                IntegrationResponse response = connection.publish(request, (bytes, length) ->
                        System.out.println(String.format("Progress: %.2f %%", (float) bytes / length * 100.0)));
                stopwatch.stop();
                long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);
                totalElapsed += elapsed;
                System.out.println("Elapsed ms: " + elapsed);
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(response));
                if (response.getCode() != 0) {
                    errorCount++;
                }
            } catch (EnvisionException | IOException e) {
                if (e instanceof EnvisionException) {
                    System.out.println(((EnvisionException) e).getErrorCode());
                }
                e.printStackTrace();
            }
        }
        double avgElapsed = 1.0 * totalElapsed / total;
        System.out.println("Average elapsed ms: " + avgElapsed);
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
