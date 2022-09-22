package com.envisioniot.example.sample.connection.simulator;

import com.envisioniot.enos.iot_mqtt_sdk.core.ConnCallback;
import com.envisioniot.enos.iot_mqtt_sdk.core.MqttClient;
import com.envisioniot.enos.iot_mqtt_sdk.core.exception.EnvisionException;
import com.envisioniot.enos.iot_mqtt_sdk.core.profile.DefaultProfile;
import com.envisioniot.enos.iot_mqtt_sdk.message.upstream.ota.*;

public class ReportFirmwareVersion {
    public void reportFirmwareVersion(String secretKey, String productKey, String deviceKey, String version){

        String brokerUrl = "tcp://mqtt-ppe1.envisioniot.com:11883";
        System.out.println(" MqttClient  client = new MqttClient(new DefaultProfile(brokerUrl, productKey, deviceKey, secretKey)");
        MqttClient  client = new MqttClient(new DefaultProfile(brokerUrl, productKey, deviceKey, secretKey));

        System.out.println("initWithCallback(client);");
        initWithCallback(client);

        System.out.println("OtaVersionReportRequest.Builder builder = new OtaVersionReportRequest.Builder();");
        OtaVersionReportRequest.Builder builder = new OtaVersionReportRequest.Builder();
        System.out.println("builder.setProductKey(productKey).setDeviceKey(deviceKey).setVersion(version);");
        builder.setProductKey(productKey).setDeviceKey(deviceKey).setVersion(version);
        System.out.println("OtaVersionReportRequest request = builder.build();");
        OtaVersionReportRequest request = builder.build();
        System.out.println("request.getVersion();");
        request.getVersion();
        System.out.println("System.out.println(\"send =>\" + request.toString());");
        System.out.println("send =>" + request.toString());
        try {
            Thread.sleep(4000);
            //client.fastPublish(builder.build());
            client.publish(builder.build());
        } catch (EnvisionException e) {
            e.printStackTrace();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                client.disconnect();
            } catch (EnvisionException e) {
                e.printStackTrace();
            }
        }
    }

    private static void initWithCallback(MqttClient client) {
        System.out.println("start connect with callback ... ");
        client.connect(new ConnCallback() {
                @Override
                public void connectComplete(boolean b) {
                    System.out.println("connect success");
                }
                @Override
                public void connectLost(Throwable throwable) {
                    System.out.println("onConnectLost");

                }

                @Override
                public void connectFailed(Throwable throwable) {
                    System.out.println("onConnectionFailed");
                }

            });
    }
}
