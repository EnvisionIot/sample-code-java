package com.envisioniot.example.sample.connection.httpmessageintegration;

import com.envisioniot.enos.iot_http_integration.HttpConnection;
import com.envisioniot.enos.iot_http_integration.message.IIntegrationCallback;
import com.envisioniot.enos.iot_http_integration.message.IntegrationMeasurepointPostRequest;
import com.envisioniot.enos.iot_http_integration.message.IntegrationResponse;
import com.envisioniot.enos.iot_mqtt_sdk.core.exception.EnvisionException;
import com.envisioniot.enos.sdk.data.DeviceInfo;
import com.google.common.collect.Maps;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.HashMap;

/**
 * @Author: song.xu
 * @Date: 2022/10/24
 */
public class MeasurepointPostSample {
    // EnOS API Gateway URL and HTTP Integration Channel URL, which can be obtained from Environment Information page in EnOS Console
    static final String API_GW_URL = "https://api_gw_url";
    static final String INTEGRATION_CHANNEL_URL = "https://integration_channel_url";

    // EnOS Application AccessKey and SecretKey, which can be obtain in Application Registration page in EnOS Console
    static final String APP_KEY = "appKey";
    static final String APP_SECRET = "appSecret";

    // Device credentials, which can be obtained from Device Details page in EnOS Console
    static final String ORG_ID = "orgId";
    static final String ASSET_ID = "assetId";
    static final String PRODUCT_KEY = "productKey";
    static final String DEVICE_KEY = "deviceKey";

    private static IntegrationMeasurepointPostRequest buildMeasurepointPostRequest() {
        DeviceInfo deviceInfo1 = new DeviceInfo().setAssetId(ASSET_ID);
        DeviceInfo deviceInfo2 = new DeviceInfo().setKey(PRODUCT_KEY, DEVICE_KEY);

        // Measurepoints are defined in ThingModel
        HashMap<String, Object> hashMap = Maps.newHashMap();
        hashMap.put("IntMeasurePoint1", 123);
        hashMap.put("StringMeasurePoint1", "enos");
        return IntegrationMeasurepointPostRequest.builder()
                .addMeasurepoint(deviceInfo1, System.currentTimeMillis(), hashMap)
                .addMeasurepoint(deviceInfo2, System.currentTimeMillis(), hashMap)
                .build();
    }

    public static void main(String[] args) {
        // Construct a http connection
        HttpConnection connection = new HttpConnection.Builder(
                INTEGRATION_CHANNEL_URL, API_GW_URL, APP_KEY, APP_SECRET, ORG_ID)
                .build();

        IntegrationMeasurepointPostRequest request = buildMeasurepointPostRequest();

        try
        {
            IntegrationResponse response = connection.publish(request, null);
            System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(response));
        } catch (EnvisionException | IOException e)
        {
            e.printStackTrace();
        }

        // Asynchronously call the measurepoint post
        request = buildMeasurepointPostRequest();

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
                    }, null
            );
        } catch (IOException | EnvisionException e) {
            e.printStackTrace();
        }
    }
}
