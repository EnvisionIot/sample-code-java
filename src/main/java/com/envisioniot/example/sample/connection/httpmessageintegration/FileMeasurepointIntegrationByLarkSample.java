package com.envisioniot.example.sample.connection.httpmessageintegration;

import com.envisioniot.enos.iot_http_integration.HttpConnection;
import com.envisioniot.enos.iot_http_integration.message.IntegrationMeasurepointPostRequest;
import com.envisioniot.enos.iot_http_integration.message.IntegrationResponse;
import com.envisioniot.enos.iot_http_integration.message.UriInfo;
import com.envisioniot.enos.iot_mqtt_sdk.core.exception.EnvisionException;
import com.envisioniot.enos.sdk.data.DeviceInfo;
import com.google.common.collect.Maps;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: song.xu
 * @Date: 2022/10/24
 */
public class FileMeasurepointIntegrationByLarkSample {
    // EnOS API Gateway URL and HTTP Integration Channel URL, which can be obtained from Environment Information page in EnOS Console
    static final String API_GW_URL = "http://api_gw_url";
    static final String INTEGRATION_CHANNEL_URL = "http://integration_channel_url";

    // EnOS Application AccessKey and SecretKey, which can be obtain in Application Registration page in EnOS Console
    static final String APP_KEY = "appKey";
    static final String APP_SECRET = "appSecret";

    // Device credentials, which can be obtained from Device Details page in EnOS Console
    static final String ORG_ID = "orgId";
    static final String ASSET_ID = "assetId";
    static final String PRODUCT_KEY = "productKey";
    static final String DEVICE_KEY = "deviceKey";

    static final boolean USE_LARK = true;
    static final boolean AUTO_UPLOAD = true;

    private static IntegrationMeasurepointPostRequest buildMeasurepointPostRequest() {
        DeviceInfo deviceInfo1 = new DeviceInfo().setAssetId(ASSET_ID);
        DeviceInfo deviceInfo2 = new DeviceInfo().setKey(PRODUCT_KEY, DEVICE_KEY);

        // Measurepoints are defined in ThingModel
        HashMap<String, Object> hashMap = Maps.newHashMap();
        hashMap.put("IntMeasurePoint1", 123);
        hashMap.put("FileMeasurePoint1", new File("sample1.txt"));
        return IntegrationMeasurepointPostRequest.builder()
                .addMeasurepoint(deviceInfo1, System.currentTimeMillis(), hashMap)
                .addMeasurepoint(deviceInfo2, System.currentTimeMillis(), hashMap)
                .build();
    }

    public static void main(String[] args) {
        // Construct a http connection
        HttpConnection connection = new HttpConnection.Builder(
                INTEGRATION_CHANNEL_URL, API_GW_URL, APP_KEY, APP_SECRET, ORG_ID)
                .setUseLark(USE_LARK)
                .setAutoUpload(AUTO_UPLOAD)
                .build();

        IntegrationMeasurepointPostRequest request = buildMeasurepointPostRequest();

        try
        {
            IntegrationResponse response = connection.publish(request, (bytes, length) ->
                    System.out.println(String.format("Progress: %.2f %%", (float) bytes / length * 100.0)));
            if (USE_LARK && response.isSuccess() && request.getFiles() != null) {
                List<UriInfo> uriInfos = new ArrayList<>();
                if (response.getData() != null) {
                    uriInfos = response.getData().getUriInfoList();
                }

                uriInfos.forEach(System.out::println);

            } else {
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(response));
            }
        } catch (EnvisionException | IOException e)
        {
            e.printStackTrace();
        }
    }
}
