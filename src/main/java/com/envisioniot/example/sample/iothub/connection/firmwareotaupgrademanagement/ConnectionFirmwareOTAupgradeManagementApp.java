package com.envisioniot.example.sample.iothub.connection.firmwareotaupgrademanagement;

import com.envisioniot.enos.connect_service.v2_1.ota.job.CreateJobResponse;
import com.envisioniot.enos.connect_service.vo.DeviceCreateResult;
import com.envisioniot.example.sample.iothub.connection.device.CreateDevice;
import com.envisioniot.example.sample.iothub.connection.device.DeleteDevice;
import com.envisioniot.example.sample.iothub.connection.firmwaremanagement.*;
import com.envisioniot.example.sample.iothub.connection.product.CreateProduct;
import com.envisioniot.example.sample.iothub.connection.product.DeleteProduct;
import com.envisioniot.example.sample.iothub.simulator.ReportFirmwareVersion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class ConnectionFirmwareOTAupgradeManagementApp {
    public void firmwareOTAupgradeManagement(String accessKey, String secretKey, String orgId, String url){
        String modelId = "demo_smartbattery_model_16";
        CreateProduct createproduct = new CreateProduct(modelId);
        String productKey = createproduct.createProduct(accessKey, secretKey, orgId, url);

        // 5 devices created.
        CreateDevice createdevice = new CreateDevice();
        DeviceCreateResult device1_Info = createdevice.createDevice(accessKey, secretKey, orgId, url, productKey);
        DeviceCreateResult device2_Info = createdevice.createDevice(accessKey, secretKey, orgId, url, productKey);
        DeviceCreateResult device3_Info = createdevice.createDevice(accessKey, secretKey, orgId, url, productKey);
        DeviceCreateResult device4_Info = createdevice.createDevice(accessKey, secretKey, orgId, url, productKey);
        DeviceCreateResult device5_Info = createdevice.createDevice(accessKey, secretKey, orgId, url, productKey);

        // 3 firmware files on enOS created.
        CreateFirmwareFile createfirmwarefile = new CreateFirmwareFile();
        String firmwareId_v1_0 = createfirmwarefile.createFirmwareFile(
                accessKey, secretKey, orgId, url, productKey, "1.0");
        String firmwareId_v1_1 = createfirmwarefile.createFirmwareFile(
                accessKey, secretKey, orgId, url, productKey, "1.1");
        String firmwareId_v1_2 = createfirmwarefile.createFirmwareFile(
                accessKey, secretKey, orgId, url, productKey, "1.2");
        String firmwareId_v1_3_ev = createfirmwarefile.createFirmwareFile_enableVerification(
                accessKey, secretKey, orgId, url, productKey, "1.3");

        // Get firmware files.
        GetFirmwareFile getFirmwareFile = new GetFirmwareFile();
        String firmwareVersion_v1_0 = getFirmwareFile.getFirmwareFile(
                accessKey, secretKey, orgId, url, firmwareId_v1_0)
                .getData()
                .getVersion();
        String firmwareVersion_v1_1 = getFirmwareFile.getFirmwareFile(
                accessKey, secretKey, orgId, url, firmwareId_v1_1)
                .getData()
                .getVersion();
        String firmwareVersion_v1_2 = getFirmwareFile.getFirmwareFile(
                accessKey, secretKey, orgId, url, firmwareId_v1_2)
                .getData()
                .getVersion();

        // Devices report firmware v1.1 or v1.0 back to enOS
        ReportFirmwareVersion reportfirmwareversion = new ReportFirmwareVersion();
        reportfirmwareversion.reportFirmwareVersion(
                device1_Info.getDeviceSecret(), productKey, device1_Info.getDeviceKey(), firmwareVersion_v1_0);
        reportfirmwareversion.reportFirmwareVersion(
                device2_Info.getDeviceSecret(), productKey, device2_Info.getDeviceKey(), firmwareVersion_v1_0);
        reportfirmwareversion.reportFirmwareVersion(
                device3_Info.getDeviceSecret(), productKey, device3_Info.getDeviceKey(), firmwareVersion_v1_0);
        reportfirmwareversion.reportFirmwareVersion(
                device4_Info.getDeviceSecret(), productKey, device4_Info.getDeviceKey(), firmwareVersion_v1_1);
        reportfirmwareversion.reportFirmwareVersion(
                device5_Info.getDeviceSecret(), productKey, device5_Info.getDeviceKey(), firmwareVersion_v1_1);


        // Current firmware versions list for devices under a particular product.
        ListDeviceCurrentFirmware listdevicecurrentfirmware = new ListDeviceCurrentFirmware();
        HashSet<String> versionNumberHashSet = new HashSet<>();
        versionNumberHashSet.addAll(
                listdevicecurrentfirmware.listDeviceCurrentFirmware(accessKey, secretKey, orgId, url, productKey)
                .getData());

        // Devices to upgrade to v1.2
        HashSet<String> deviceToUpgradeSet = new HashSet<>();
        deviceToUpgradeSet.add(device1_Info.getDeviceKey());
        deviceToUpgradeSet.add(device2_Info.getDeviceKey());
        deviceToUpgradeSet.add(device3_Info.getDeviceKey());
        deviceToUpgradeSet.add(device4_Info.getDeviceKey());
        deviceToUpgradeSet.add(device5_Info.getDeviceKey());

        CreateOTAjob createotajob = new CreateOTAjob();

        // create job to batch upgrade devices to v1.2
        CreateJobResponse jobUpgradeTo_v1_2_Info = createotajob.createOTAjob_upgradeTask(accessKey,
                secretKey, orgId, url, firmwareId_v1_2, deviceToUpgradeSet, versionNumberHashSet);

        Scanner input = new Scanner(System.in);
        System.out.println("continue?");
        String ans = input.nextLine();

        // Get job information
        GetOTAjob getotajob = new GetOTAjob();
        getotajob.getOTAjob(accessKey, secretKey, orgId, url, jobUpgradeTo_v1_2_Info.getData().getJobId());

        // Search jobs
        SearchOTAjob searchotajob = new SearchOTAjob();
        System.out.println("\n\n\n");
        System.out.println("searchOTAjob_productKey");
        searchotajob.searchOTAjob_productKey(accessKey, secretKey, orgId, url, productKey);
        System.out.println("searchOTAjob_firmwareId");
        searchotajob.searchOTAjob_firmwareId(accessKey, secretKey, orgId, url,firmwareId_v1_2);
        System.out.println("searchOTAjob_firmwareVersion");
        searchotajob.searchOTAjob_firmwareVersion(accessKey, secretKey, orgId, url, firmwareVersion_v1_2);
        System.out.println("searchOTAjob_type");
        searchotajob.searchOTAjob_type(accessKey, secretKey, orgId, url, "upgrade");
        System.out.println("searchOTAjob_status");
        searchotajob.searchOTAjob_status(accessKey, secretKey, orgId, url, "stopped");
        System.out.println("searchOTAjob_defaultName");
        searchotajob.searchOTAjob_defaultName(accessKey, secretKey, orgId, url);


        System.out.println("\n\n\nsearchOTAjob_localeName");
        searchotajob.searchOTAjob_localeName(accessKey, secretKey, orgId, url);
        System.out.println("\n\n\n");


        // Search tasks
        SearchOTAtask searchotatask = new SearchOTAtask();
        searchotatask.searchOTAtask_jobId(
                accessKey, secretKey, orgId, url, jobUpgradeTo_v1_2_Info.getData().getJobId());
        searchotatask.searchOTAtask_deviceKey(accessKey, secretKey, orgId, url, device1_Info.getDeviceKey());
        searchotatask.searchOTAtask_fromVersion(accessKey, secretKey, orgId, url, firmwareVersion_v1_0);
        searchotatask.searchOTAtask_toVersion(accessKey, secretKey, orgId, url, firmwareVersion_v1_2);
        searchotatask.searchOTAtask_status(accessKey, secretKey, orgId, url, "init");
        searchotatask.searchOTAtask_desc(accessKey, secretKey, orgId, url, "");

        // Start job
        StartOTAjob startotajob = new StartOTAjob();
        startotajob.startOTAjob(accessKey, secretKey, orgId, url, jobUpgradeTo_v1_2_Info.getData().getJobId());

        // Cancel Task
        CancelOTAtask cancelotatask = new CancelOTAtask();
        cancelotatask.cancelOTAtask(accessKey,
                                    secretKey,
                                    orgId,
                                    url,
                                    new HashSet<String>(Arrays.asList(device1_Info.getDeviceKey())),
                                    jobUpgradeTo_v1_2_Info.getData().getJobId());

        // Retry Task
        RetryOTAtask retryotatask = new RetryOTAtask();
        retryotatask.retryOTAtask(accessKey,
                                  secretKey,
                                  orgId,
                                  url,
                                  new HashSet<String>(Arrays.asList(device2_Info.getDeviceKey())),
                                  jobUpgradeTo_v1_2_Info.getData().getJobId());



        // Stop job
        StopOTAjob stopotajob = new StopOTAjob();
        stopotajob.stopOTAjob(accessKey, secretKey, orgId, url, jobUpgradeTo_v1_2_Info.getData().getJobId());


        // Delete job

        DeleteOTAjob deleteotajob = new DeleteOTAjob();
        deleteotajob.deleteOTAjob(accessKey, secretKey, orgId, url, jobUpgradeTo_v1_2_Info.getData().getJobId());

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DeleteFirmware deletefirmware = new DeleteFirmware();
        deletefirmware.deleteFirmware(accessKey, secretKey, orgId, url, firmwareId_v1_0);
        deletefirmware.deleteFirmware(accessKey, secretKey, orgId, url, firmwareId_v1_1);
        deletefirmware.deleteFirmware(accessKey, secretKey, orgId, url, firmwareId_v1_2);
        deletefirmware.deleteFirmware(accessKey, secretKey, orgId, url, firmwareId_v1_3_ev);
        DeleteDevice deletedevice = new DeleteDevice();
        deletedevice.deleteDevice_assetID(accessKey, secretKey, orgId, url, device1_Info.getAssetId());
        deletedevice.deleteDevice_assetID(accessKey, secretKey, orgId, url, device2_Info.getAssetId());
        deletedevice.deleteDevice_assetID(accessKey, secretKey, orgId, url, device3_Info.getAssetId());
        deletedevice.deleteDevice_assetID(accessKey, secretKey, orgId, url, device4_Info.getAssetId());
        deletedevice.deleteDevice_assetID(accessKey, secretKey, orgId, url, device5_Info.getAssetId());
        DeleteProduct deleteproduct = new DeleteProduct();
        deleteproduct.deleteProduct(accessKey, secretKey, orgId, url, productKey);

    }
}
