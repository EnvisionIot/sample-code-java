package com.envisioniot.example.sample.functions.connection.firmwareotaupgrademanagement;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.common.StringI18n;
import com.envisioniot.enos.connect_service.v2_1.ota.firmware.GetFirmwareFileResponse;
import com.envisioniot.enos.connect_service.v2_1.ota.job.CreateJobRequest;
import com.envisioniot.enos.connect_service.v2_1.ota.job.CreateJobResponse;
import com.envisioniot.enos.connect_service.vo.ota.UpgradeScope;
import com.envisioniot.example.sample.functions.connection.firmwaremanagement.GetFirmwareFile;

import java.util.HashSet;
import java.util.Set;

public class CreateOTAjob {

    private CreateJobResponse response_createOTAjob(String accessKey, String secretKey, String url, CreateJobRequest request ){
        return  Poseidon
                .config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, CreateJobResponse.class);

    }
    //Upgrade Task
    public CreateJobResponse createOTAjob_upgradeTask(String accessKey, String secretKey, String orgId, String url, String firmwareId, HashSet<String> deviceToUpgradeSet, HashSet<String> versionNumberHashSet){
        CreateJobRequest request = new CreateJobRequest();
        request.setOrgId(orgId);
        request.setFirmwareId(firmwareId);

        request.setName(new StringI18n("YourUpgradeJobNameHere"));
        request.setType("upgrade");
        request.setUpgradePolicy("snapshot");

        // Instantiate upgradeScope
        UpgradeScope upgradeScope = new UpgradeScope();
        upgradeScope.setType("partial");

        // versionNumbers of the firmwares available
        GetFirmwareFile getfirmwarefile = new GetFirmwareFile();
        GetFirmwareFileResponse getfirmwarefileresponse =  getfirmwarefile.getFirmwareFile(accessKey, secretKey, orgId, url, firmwareId);
        Set<String>copy = new HashSet<>(versionNumberHashSet);
        copy.remove(getfirmwarefileresponse.getData().getVersion());
        upgradeScope.setVersionNumbers(copy);

        // devices which will be upgraded
        upgradeScope.setDeviceKeys(deviceToUpgradeSet);


        request.setUpgradeScope(upgradeScope);
        request.setEnableUpgradeRequest(true);

        return response_createOTAjob(accessKey, secretKey, url, request);

    }

    //Firmware Verification Task
    public CreateJobResponse createOTAjob_verficationTask(String accessKey, String secretKey, String orgId, String url, String firmwareId, HashSet<String> deviceToVerifySet, HashSet<String> versionNumberHashSet){
        CreateJobRequest request = new CreateJobRequest();
        request.setOrgId(orgId);
        //verify this firmwareId
        request.setFirmwareId(firmwareId);

        request.setName(new StringI18n("YourVerificationJobNameHere"));
        request.setType("verify");
        //request.setUpgradePolicy("snapshot");

        // Instantiate upgradeScope
        UpgradeScope upgradeScope = new UpgradeScope();
        upgradeScope.setType("partial");
        // devices which will be verified
        upgradeScope.setDeviceKeys(deviceToVerifySet);
        // versionNumbers of the firmwares available

        GetFirmwareFile getfirmwarefile = new GetFirmwareFile();
        GetFirmwareFileResponse getfirmwarefileresponse =  getfirmwarefile.getFirmwareFile(accessKey, secretKey, orgId, url, firmwareId);
        Set<String>copy = new HashSet<>(versionNumberHashSet);
        copy.remove(getfirmwarefileresponse.getData().getVersion());
        upgradeScope.setVersionNumbers(copy);

        //firmwareId's version cannot be in versionNumbers set.
        upgradeScope.setVersionNumbers(copy);

        request.setUpgradeScope(upgradeScope);

        return response_createOTAjob(accessKey, secretKey, url, request);
    }

}

