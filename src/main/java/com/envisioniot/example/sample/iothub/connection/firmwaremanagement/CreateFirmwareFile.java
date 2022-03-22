/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateFirmwareFile
 * Author:  Arihant jain
 * Date:    10/2/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.iothub.connection.firmwaremanagement;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.common.StringI18n;
import com.envisioniot.enos.connect_service.v2_1.ota.firmware.CreateFirmwareFileRequest;
import com.envisioniot.enos.connect_service.v2_1.ota.firmware.CreateFirmwareFileResponse;
import com.envisioniot.enos.connect_service.vo.ota.SignMethod;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/create_firmware.html  <br>
 * refer to the resources/ConnectionsServiceModels/FirmwareManagement/model_demo_smartbattery_model_15.json
 *
 * @author arihantjain97
 * @create 10/2/22
 * @since --
 */

public class CreateFirmwareFile {

    private CreateFirmwareFileResponse firmwareResponse(
            String accessKey,
            String secretKey,
            String url,
            CreateFirmwareFileRequest request)
    {
        CreateFirmwareFileResponse response = Poseidon
                .config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, CreateFirmwareFileResponse.class);

        return response;
    }

    public String createFirmwareFile(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey,
            String version)
    {
        // create the request regarding firmware file creation.
        CreateFirmwareFileRequest request = new CreateFirmwareFileRequest();

        // set the organisation.
        request.setOrgId(orgId);

        // set the productKey
        request.setProductKey(productKey);

        // set the firmware's name
        Map<String, String> firmwareNameMap = new HashMap<>();
        firmwareNameMap.put("zh_CN","固件_" + version);
        firmwareNameMap.put("en_US","product firmware_" + version);
        firmwareNameMap.put("ja_JP", "ファームウェア_" + version);
        firmwareNameMap.put("es_ES", "firmware del producto_" + version);

        StringI18n firmwareName = new StringI18n("firmware_defaultName_" + version);
        firmwareName.setI18nValue(firmwareNameMap);
        request.setName(firmwareName);

        request.setFile(new File("SampleFirmwareFile.bin"));

        // set the firmware's version
        request.setVersion(version);

        // set the firmware's signMethod
        request.setSignMethod(SignMethod.MD5);
        //request.setSignMethod(SignMethod.SHA256);

        // set firmware's description
        // note: optional
        request.setDesc("YourFirmwareDescriptionHere_" + version);

        // enable/disable verification
        request.setEnableVerification(false);

        return firmwareResponse(accessKey, secretKey, url, request).getData().getFirmwareId();

    }


    public String createFirmwareFile_enableVerification(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey,
            String version)
    {
        // create the request regarding firmware file creation.
        CreateFirmwareFileRequest request = new CreateFirmwareFileRequest();

        // set the organisation.
        request.setOrgId(orgId);

        // set the productKey
        request.setProductKey(productKey);

        // set the firmware's name
        Map<String, String> firmwareNameMap = new HashMap<>();
        firmwareNameMap.put("zh_CN","固件_EV_" + version);
        firmwareNameMap.put("en_US","firmware_EV_" + version);
        firmwareNameMap.put("ja_JP", "ファームウェア_EV_" + version);
        firmwareNameMap.put("es_ES", "firmware del producto_EV_" + version);

        StringI18n firmwareName = new StringI18n("firmware_defaultName_EV_" + version);
        firmwareName.setI18nValue(firmwareNameMap);
        request.setName(firmwareName);

        request.setFile(new File("SampleFirmwareFile.bin"));

        // set the firmware's version
        request.setVersion(version);

        // set the firmware's signMethod
        request.setSignMethod(SignMethod.MD5);
        //request.setSignMethod(SignMethod.SHA256);

        // set firmware's description
        // note: optional
        request.setDesc("YourFirmwareDescriptionHere_EV_" + version);

        // enable/disable verification
        request.setEnableVerification(true);

        return firmwareResponse(accessKey, secretKey, url, request).getData().getFirmwareId();

    }


    /*
    public String createFirmwareFile_upgrader(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey,
            String version)
    {
        // create the request regarding firmware file creation.
        CreateFirmwareFileRequest request = new CreateFirmwareFileRequest();

        // set the organisation.
        request.setOrgId(orgId);

        // set the productKey
        request.setProductKey(productKey);

        // set the firmware's name
        Map<String, String> firmwareNameMap = new HashMap<>();
        firmwareNameMap.put("zh_CN","固件_3");
        firmwareNameMap.put("en_US","firmware_3");
        firmwareNameMap.put("ja_JP", "ファームウェア_3");
        firmwareNameMap.put("es_ES", "firmware del producto_3");

        StringI18n firmwareName = new StringI18n("firmware_defaultName_3");
        firmwareName.setI18nValue(firmwareNameMap);
        request.setName(firmwareName);

        request.setFile(new File("SampleFirmwareFile.bin"));

        // set the firmware's version
        request.setVersion(version);

        // set the firmware's signMethod
        request.setSignMethod(SignMethod.MD5);
        //request.setSignMethod(SignMethod.SHA256);

        // set firmware's description
        // note: optional
        request.setDesc("YourFirmwareDescriptionHere_3");

        // enable/disable verification
        request.setEnableVerification(false);

        return firmwareResponse(accessKey, secretKey, url, request).getData().getFirmwareId();



    }
     */


}
