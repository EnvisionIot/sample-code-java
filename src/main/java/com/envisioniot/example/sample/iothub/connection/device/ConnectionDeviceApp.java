package com.envisioniot.example.sample.iothub.connection.device;

import com.envisioniot.enos.connect_service.vo.DeviceCreateResult;
import com.envisioniot.enos.connect_service.vo.DeviceReplaceResult;
import com.envisioniot.example.sample.iothub.connection.product.CreateProduct;

import java.util.HashMap;
import java.util.Map;

public class ConnectionDeviceApp {
    public void connectionDeviceAppGeneral(String accessKey, String secretKey, String orgId, String url) {
        String modelId = "demo_smartbattery_model";

        CreateProduct createproduct_device = new CreateProduct(modelId);
        CreateDevice createdevice = new CreateDevice();
        DisableDevice disableDevice = new DisableDevice();
        EnableDevice enableDevice = new EnableDevice();
        UpdateDevice updateDevice = new UpdateDevice();
        ReplaceDevice replacedevice = new ReplaceDevice();
        GetDevice getdevice = new GetDevice();
        GetStatisticsDevice getstatisticsdevice = new GetStatisticsDevice();
        DeleteDevice deletedevice = new DeleteDevice();
        SearchDevice searchdevice = new SearchDevice(modelId);

        // Create A Product.
        String productKey = createproduct_device.createProduct(accessKey, secretKey, orgId, url);

        // Create a device, and obtaining its assetId.
        // note: Alternatively, if device is already on enOS, its assetId is listed at Device Management/Device Assets.
        // AssetId example: "Nmw9npSq"
        DeviceCreateResult device1_info = createdevice.createDevice(accessKey, secretKey, orgId, url, productKey);
        String device1AssetId = device1_info.getAssetId();
        // Disabling, and Enabling device using assetId.
        disableDevice.disableDevice_assetID(accessKey, secretKey, orgId, url, device1AssetId);
        enableDevice.enableDevice_assetID(accessKey, secretKey, orgId, url, device1AssetId);
        // Updating a device using assetId.
        updateDevice.updateDevice_assetId_NotPatchUpdate(accessKey, secretKey, orgId, url, device1AssetId);
        updateDevice.updateDevice_assetId(accessKey, secretKey, orgId, url,device1AssetId);
        // Replacing a device using assetId.
        // note: Replacing a device would change its deviceKey and deviceSecret, without changing the assetId.
        DeviceReplaceResult replaced_device1_info =
                replacedevice.replaceDevice_assetID(accessKey, secretKey, orgId, url, device1AssetId);
        // Get device information via assetId.
        getdevice.getDevice_assetID(accessKey, secretKey, orgId, url, device1AssetId);
        // Get device statistics via productKey.
        // note: Alternatively, if device already on enOS, productKey is listed at Device Management/Device Assets/view.
        getstatisticsdevice.getStatisticsDevice(accessKey, secretKey, orgId, url, productKey);
        // Delete device using assetId
        deletedevice.deleteDevice_assetID(accessKey, secretKey, orgId, url, device1AssetId);

        //-----------------------------------------------------------------------------

        // Create a device, and obtaining its productKey and deviceKey.
        // note: Alternatively, if device is already on enOS, Keys are listed at Device Management/Device Assets/view.
        // deviceKey example: "GW46kFBhkN"
        // productKey example: "4kZqiPoC"
        DeviceCreateResult device2_info = createdevice.createDevice(accessKey, secretKey, orgId, url, productKey);
        String device2_deviceKey = device2_info.getDeviceKey();
        // Disabling, and Enabling device using Keys.
        disableDevice.disableDevice_Keys(accessKey, secretKey, orgId, url, productKey, device2_deviceKey);
        enableDevice.enableDevice_Keys(accessKey, secretKey, orgId, url, productKey, device2_deviceKey);
        // Updating a device using Keys.
        updateDevice.updateDevice_Keys_NotPatchUpdate(accessKey, secretKey, orgId, url, productKey, device2_deviceKey);
        updateDevice.updateDevice_Keys(accessKey, secretKey, orgId, url, productKey, device2_deviceKey);
        // Replacing a device using Keys.
        // note: Replacing a device would change its deviceKey and deviceSecret, without changing the assetId.
        DeviceReplaceResult replaced_device2_info =
                replacedevice.replaceDevice_Keys(accessKey, secretKey, orgId, url, productKey, device2_deviceKey);
        String device2_NewDeviceKey = replaced_device2_info.getDeviceKey();
        // Get device information via Keys.
        // note: Alternatively, if device already on enOS, productKey is listed at Device Management/Device Assets/view.
        getdevice.getDevice_Keys(accessKey, secretKey, orgId, url, productKey, device2_NewDeviceKey);
        getstatisticsdevice.getStatisticsDevice(accessKey, secretKey, orgId, url, productKey);
        // Delete device using Keys.
        deletedevice.deleteDevice_Keys(accessKey, secretKey, orgId, url, productKey, device2_NewDeviceKey);

        //-----------------------------------------------------------------------------

        // Create devices with tags
        Map<String, String> deviceTags = new HashMap<>();
        deviceTags.put("tag1", "value3");
        deviceTags.put("tag2", "value4");
        DeviceCreateResult device3_info = createdevice.createDevice_optionalParameters(accessKey, secretKey, orgId, url,
                productKey);
        DeviceCreateResult device4_info = createdevice.createDevice_optionalParameters(accessKey, secretKey, orgId, url,
                productKey, deviceTags);

        // Obtain information about newly created devices.
        // note: Alternatively, if device already on enOS, information is listed at Device Management/Device Assets/view
        String device3AssetId = device3_info.getAssetId();
        String device3_deviceKey = device3_info.getDeviceKey();
        String device4AssetId = device4_info.getAssetId();
        String device4_deviceKey = device4_info.getDeviceKey();

        // Searching devices via search expressions
        // note: search expressions are defined within the iothub.
        searchdevice.searchDevice_model(accessKey, secretKey, orgId, url);
        searchdevice.searchDevice_deviceAttributes(accessKey, secretKey, orgId, url,
                "brand", "yourAttributeValue");
        searchdevice.searchDevice_deviceTags(accessKey, secretKey, orgId, url);
        searchdevice.searchDevice_productKey(accessKey, secretKey, orgId, url, productKey);
        searchdevice.searchDevice_deviceKey(accessKey, secretKey, orgId, url, device3_deviceKey);
        searchdevice.searchDevice_assetId(accessKey, secretKey, orgId, url, device4AssetId);
        searchdevice.searchDevice_productType(accessKey, secretKey, orgId, url,"Device");
        searchdevice.searchDevice_firmwareVersion(accessKey, secretKey, orgId, url,"");
        searchdevice.searchDevice_deviceName_default(accessKey, secretKey, orgId, url);
        searchdevice.searchDevice_deviceName_locale(accessKey, secretKey, orgId, url);
        searchdevice.searchDevice_status(accessKey, secretKey, orgId, url,"inactive");

    }
}
