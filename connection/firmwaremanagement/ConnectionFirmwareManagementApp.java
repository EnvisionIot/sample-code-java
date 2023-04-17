package com.envisioniot.example.sample.connection.firmwaremanagement;
import com.envisioniot.enos.connect_service.vo.DeviceCreateResult;
import com.envisioniot.example.sample.connection.device.CreateDevice;
import com.envisioniot.example.sample.connection.device.DeleteDevice;
import com.envisioniot.example.sample.connection.product.CreateProduct;
import com.envisioniot.example.sample.connection.product.DeleteProduct;
import com.envisioniot.example.sample.connection.simulator.ReportFirmwareVersion;

public class ConnectionFirmwareManagementApp {

    public void connectionFirmwareManagement(String accessKey, String secretKey, String orgId, String url){

        String modelId = "demo_smartbattery_model_16";

        // Creating a product and 3 devices for this example.
        // note: if product and devices aready exist, modelId is viewable on enOS at IoT hub/Models,
        // productKey is viewable on enOS at IoT hub/Device Management/Products/View,
        // deviceKey and assetId is viewable on enOS at IoT hub/Device Assets/View
        
        // Create product
        CreateProduct createproduct = new CreateProduct(modelId);
        String productKey = createproduct.createProduct(accessKey, secretKey, orgId, url);
        // Create devices
        CreateDevice createdevice = new CreateDevice();
        DeviceCreateResult device1_Info = createdevice.createDevice(accessKey, secretKey, orgId, url, productKey);
        DeviceCreateResult device2_Info = createdevice.createDevice(accessKey, secretKey, orgId, url, productKey);
        DeviceCreateResult device3_Info = createdevice.createDevice(accessKey, secretKey, orgId, url, productKey);
        // Get device information
        String device1ProductKey = device1_Info.getProductKey();
        String device1DeviceKey = device1_Info.getDeviceKey();
        String device1AssetId = device1_Info.getAssetId();
        String device1Secret = device1_Info.getDeviceSecret();
        String device2ProductKey  = device2_Info.getProductKey();
        String device2DeviceKey = device2_Info.getDeviceKey();
        String device2AssetId = device2_Info.getAssetId();
        String device2Secret = device2_Info.getDeviceSecret();
        String device3ProductKey = device3_Info.getProductKey();
        String device3DeviceKey = device3_Info.getDeviceKey();
        String device3AssetId = device3_Info.getAssetId();
        String device3Secret = device3_Info.getDeviceSecret();

        // Create firmware files on enOS platform.
        // note: enable verification (ev)

        CreateFirmwareFile createfirmwarefile = new CreateFirmwareFile();
        String firmwareId_v1_0 =
                createfirmwarefile.createFirmwareFile(accessKey, secretKey, orgId, url, productKey, "1.0");
        String firmwareId_v1_1_ev = createfirmwarefile
                        .createFirmwareFile_enableVerification(accessKey, secretKey, orgId, url, productKey, "1.1");
        String firmwareId_v1_2 =
                createfirmwarefile.createFirmwareFile(accessKey, secretKey, orgId, url, productKey, "1.2");

        // Get firmware files.
        GetFirmwareFile getFirmwareFile = new GetFirmwareFile();
        String firmwareVersionNumber_v1_0 = getFirmwareFile
                .getFirmwareFile(accessKey, secretKey, orgId, url, firmwareId_v1_0)
                .getData()
                .getVersion();

        String firmwareVersionNumber_v1_1_ev = getFirmwareFile
                .getFirmwareFile(accessKey, secretKey, orgId, url, firmwareId_v1_1_ev)
                .getData()
                .getVersion();

        String firmwareVersionNumber_v1_2 = getFirmwareFile
                .getFirmwareFile(accessKey, secretKey, orgId, url, firmwareId_v1_2)
                .getData()
                .getVersion();

        // Devices reporting their firmware versions to enOS platform.
        ReportFirmwareVersion reportfirmwareversion = new ReportFirmwareVersion();
        reportfirmwareversion
                .reportFirmwareVersion(device1Secret, productKey, device1DeviceKey, firmwareVersionNumber_v1_0);
        reportfirmwareversion
                .reportFirmwareVersion(device2Secret, productKey, device2DeviceKey, firmwareVersionNumber_v1_1_ev);
        reportfirmwareversion
                .reportFirmwareVersion(device3Secret, productKey, device3DeviceKey, firmwareVersionNumber_v1_2);

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
        searchdeviceupgrade
                .searchDeviceUpgrade_firmwareVersion(accessKey, secretKey, orgId, url,firmwareVersionNumber_v1_0);
        searchdeviceupgrade
                .searchDeviceUpgrade_firmwareVersion(accessKey, secretKey, orgId, url,firmwareVersionNumber_v1_1_ev);
        searchdeviceupgrade
                .searchDeviceUpgrade_firmwareVersion(accessKey, secretKey, orgId, url,firmwareVersionNumber_v1_2);
        searchdeviceupgrade.searchDeviceUpgrade_isUpgrading(accessKey, secretKey, orgId, url,productKey);


        DeleteFirmware deletefirmware = new DeleteFirmware();
        deletefirmware.deleteFirmware(accessKey, secretKey, orgId, url, firmwareId_v1_0);
        deletefirmware.deleteFirmware(accessKey, secretKey, orgId, url, firmwareId_v1_1_ev);
        deletefirmware.deleteFirmware(accessKey, secretKey, orgId, url, firmwareId_v1_2);
        DeleteDevice deletedevice = new DeleteDevice();
        deletedevice.deleteDevice_assetID(accessKey, secretKey, orgId, url, device1AssetId);
        deletedevice.deleteDevice_assetID(accessKey, secretKey, orgId, url, device2AssetId);
        deletedevice.deleteDevice_assetID(accessKey, secretKey, orgId, url, device3AssetId);
        DeleteProduct deleteproduct = new DeleteProduct();
        deleteproduct.deleteProduct(accessKey, secretKey, orgId, url, productKey);

    }
}
