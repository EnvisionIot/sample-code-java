package com.envisioniot.example.sample.functions.connection.firmwaremanagement;
import com.envisioniot.enos.connect_service.vo.DeviceCreateResult;
import com.envisioniot.example.sample.functions.connection.device.CreateDevice;
import com.envisioniot.example.sample.functions.connection.device.DeleteDevice;
import com.envisioniot.example.sample.functions.connection.product.CreateProduct;
import com.envisioniot.example.sample.functions.connection.product.DeleteProduct;
import com.envisioniot.example.sample.functions.simulator.ReportFirmwareVersion;

public class ConnectionFirmwareManagementApp {

    public void connectionFirmwareManagement(String accessKey, String secretKey, String orgId, String url){

        String modelId = "demo_smartbattery_model_16";
        CreateProduct createproduct = new CreateProduct(modelId);
        String productKey = createproduct.createProduct(accessKey, secretKey, orgId, url);

        // Create firmware files on enOS platform.
        // note: enable verification (ev)
        CreateFirmwareFile createfirmwarefile = new CreateFirmwareFile();
        String firmwareId_v1_0 = createfirmwarefile.createFirmwareFile(accessKey, secretKey, orgId, url, productKey, "1.0");
        String firmwareId_v1_1_ev = createfirmwarefile.createFirmwareFile_enableVerification(accessKey, secretKey, orgId, url, productKey, "1.1");
        String firmwareId_v1_2 = createfirmwarefile.createFirmwareFile(accessKey, secretKey, orgId, url, productKey, "1.2");

        // Get firmware files.
        GetFirmwareFile getFirmwareFile = new GetFirmwareFile();
        String firmwareVersionNumber_v1_0 = getFirmwareFile.getFirmwareFile(accessKey, secretKey, orgId, url, firmwareId_v1_0)
                .getData()
                .getVersion();

        String firmwareVersionNumber_v1_1_ev = getFirmwareFile.getFirmwareFile(accessKey, secretKey, orgId, url, firmwareId_v1_1_ev)
                .getData()
                .getVersion();

        String firmwareVersionNumber_v1_2 = getFirmwareFile.getFirmwareFile(accessKey, secretKey, orgId, url, firmwareId_v1_2)
                .getData()
                .getVersion();

        CreateDevice createdevice = new CreateDevice();
        DeviceCreateResult device1_Info = createdevice.createDevice(accessKey, secretKey, orgId, url, productKey);
        DeviceCreateResult device2_Info = createdevice.createDevice(accessKey, secretKey, orgId, url, productKey);
        DeviceCreateResult device3_Info = createdevice.createDevice(accessKey, secretKey, orgId, url, productKey);

        // Devices reporting their firmware versions to enOS platform.
        ReportFirmwareVersion reportfirmwareversion = new ReportFirmwareVersion();
        reportfirmwareversion.reportFirmwareVersion(device1_Info.getDeviceSecret(), productKey, device1_Info.getDeviceKey(), firmwareVersionNumber_v1_0);
        reportfirmwareversion.reportFirmwareVersion(device2_Info.getDeviceSecret(), productKey, device2_Info.getDeviceKey(), firmwareVersionNumber_v1_1_ev);
        reportfirmwareversion.reportFirmwareVersion(device3_Info.getDeviceSecret(), productKey, device3_Info.getDeviceKey(), firmwareVersionNumber_v1_2);

        // List all device firmware versions for a particular product.
        ListDeviceCurrentFirmware listdevicecurrentfirmware = new ListDeviceCurrentFirmware();
        listdevicecurrentfirmware.listDeviceCurrentFirmware(accessKey, secretKey, orgId, url, productKey);

        // Search firmware files on enOS platform.
        SearchFirmwareFile searchfirmwarefile = new SearchFirmwareFile();
        searchfirmwarefile.searchFirmwareFile_productKey(accessKey, secretKey, orgId, url, productKey);
        searchfirmwarefile.searchFirmwareFile_isVerified(accessKey, secretKey, orgId, url, productKey);
        System.out.println("\n\n");
        searchfirmwarefile.searchFirmwareFile_defaultName(accessKey, secretKey, orgId, url);
        searchfirmwarefile.searchFirmwareFile_localeName(accessKey, secretKey, orgId, url);
        System.out.println("\n\n");

        // Search devices via firmware parameters
        // note: ensure devices have reported back their firmware versions to the enOS platform.
        SearchDeviceUpgrade searchdeviceupgrade = new SearchDeviceUpgrade();
        searchdeviceupgrade.searchDeviceUpgrade_productKey(accessKey, secretKey, orgId, url, productKey);
        searchdeviceupgrade.searchDeviceUpgrade_firmwareVersion(accessKey, secretKey, orgId, url,firmwareVersionNumber_v1_0);
        searchdeviceupgrade.searchDeviceUpgrade_firmwareVersion(accessKey, secretKey, orgId, url,firmwareVersionNumber_v1_1_ev);
        searchdeviceupgrade.searchDeviceUpgrade_firmwareVersion(accessKey, secretKey, orgId, url,firmwareVersionNumber_v1_2);
        searchdeviceupgrade.searchDeviceUpgrade_isUpgrading(accessKey, secretKey, orgId, url,productKey);


        DeleteFirmware deletefirmware = new DeleteFirmware();
        deletefirmware.deleteFirmware(accessKey, secretKey, orgId, url, firmwareId_v1_0);
        deletefirmware.deleteFirmware(accessKey, secretKey, orgId, url, firmwareId_v1_1_ev);
        deletefirmware.deleteFirmware(accessKey, secretKey, orgId, url, firmwareId_v1_2);
        DeleteDevice deletedevice = new DeleteDevice();
        deletedevice.deleteDevice_assetID(accessKey, secretKey, orgId, url, device1_Info.getAssetId());
        deletedevice.deleteDevice_assetID(accessKey, secretKey, orgId, url, device2_Info.getAssetId());
        deletedevice.deleteDevice_assetID(accessKey, secretKey, orgId, url, device3_Info.getAssetId());
        DeleteProduct deleteproduct = new DeleteProduct();
        deleteproduct.deleteProduct(accessKey, secretKey, orgId, url, productKey);

    }
}
