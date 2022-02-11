package com.envisioniot.example.sample.functions.simulator;

import com.envisioniot.enos.iot_mqtt_sdk.core.ConnCallback;
import com.envisioniot.enos.iot_mqtt_sdk.core.MqttClient;
import com.envisioniot.enos.iot_mqtt_sdk.core.exception.EnvisionException;
import com.envisioniot.enos.iot_mqtt_sdk.core.msg.IMessageHandler;
import com.envisioniot.enos.iot_mqtt_sdk.core.msg.IMqttDeliveryMessage;
import com.envisioniot.enos.iot_mqtt_sdk.core.profile.DefaultProfile;
import com.envisioniot.enos.iot_mqtt_sdk.message.downstream.ota.OtaUpgradeCommand;
import com.envisioniot.enos.iot_mqtt_sdk.message.upstream.ota.*;
import lombok.SneakyThrows;

public class UpgradeTest {

/*
    public static void upgradeFirmwareByCloudPush() {
        client.setArrivedMsgHandler(OtaUpgradeCommand.class, new IMessageHandler<OtaUpgradeCommand, IMqttDeliveryMessage>() {
            @Override
            public IMqttDeliveryMessage onMessage(OtaUpgradeCommand otaUpgradeCommand, List<String> list) throws Exception {
                System.out.println("receive command: " + otaUpgradeCommand);

                Firmware firmware = otaUpgradeCommand.getFirmwareInfo();

                //TODO: download firmware from firmware.fileUrl

                //mock reporting progress
                reportUpgradeProgress("20", "20");
                TimeUnit.SECONDS.sleep(2);

                reportUpgradeProgress("25", "25");
                TimeUnit.SECONDS.sleep(20);

                reportUpgradeProgress("80", "80");
                TimeUnit.SECONDS.sleep(20);

                //firmware upgrade success, report new version
                reportVersion(otaUpgradeCommand.getFirmwareInfo().version);

                return null;
            }
        });
    }
 */
}
