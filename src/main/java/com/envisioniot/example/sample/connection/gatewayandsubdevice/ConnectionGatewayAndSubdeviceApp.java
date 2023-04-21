package com.envisioniot.example.sample.connection.gatewayandsubdevice;

import com.envisioniot.enos.connect_service.vo.DeviceCreateResult;
import com.envisioniot.example.sample.connection.device.CreateDevice;
import com.envisioniot.example.sample.connection.device.DeleteDevice;
import com.envisioniot.example.sample.connection.product.CreateProduct;
import com.envisioniot.example.sample.connection.product.DeleteProduct;

import java.util.ArrayList;

public class ConnectionGatewayAndSubdeviceApp {
    public void connectionGatewayAndSubdeviceAppGeneral(String accessKey, String secretKey, String orgId, String url){

        String modelId = "demo_smartbattery_model_15";

        // Creating a topography of a gateway device and 2 sub-devices added under it.
        // note: Alternatively, if devices are already exist on enOS, their assetIds are listed
        // at Device Management/Device Assets. This is the preprocess of the applicaiton.


        // Create the gateway product.
        // note: gw (gateway)
        CreateProduct createproduct = new CreateProduct(modelId);
        String gwProductKey = createproduct.createProduct_productType_gateway(accessKey, secretKey, orgId, url);
        // Create a separate product for sub-devices.
        // note: sd (sub-device)
        String sdProductKey = createproduct.createProduct(accessKey, secretKey, orgId, url);
        // Create devices.
        CreateDevice createdevice = new CreateDevice();
        // Create Gateway Device.
        DeviceCreateResult gwDevice_Info =
                createdevice.createDevice(accessKey, secretKey, orgId, url, gwProductKey);
        // Devices which will serve as sub-devices to gateway device.
        // note: device1 includes optional information e.g. tags and locale names.
        DeviceCreateResult device1_Info =
                createdevice.createDevice_optionalParameters(accessKey, secretKey, orgId, url, sdProductKey);
        DeviceCreateResult device2_Info =
                createdevice.createDevice(accessKey, secretKey, orgId, url, sdProductKey);
        // sub-device information list(s)
        // note: lists contain assetId information of intended sub-devices (sd)
        // note: Alternatively, if device is already on enOS, its assetId is listed at Device Management/Device Assets.
        ArrayList<String> sdToAddList1 = new ArrayList<>();
        ArrayList<String> sdToAddList2 = new ArrayList<>();
        sdToAddList1.add(device1_Info.getAssetId());
        sdToAddList2.add(device2_Info.getAssetId());


        // Connection Services, Gateway and Sub-Device: Add Sub-Device
        AddSubDevice addsubdevice = new AddSubDevice();
        // Gateway device's deviceKey and assetId.
        String gwDeviceKey = gwDevice_Info.getDeviceKey();
        String gwDeviceAssetId = gwDevice_Info.getAssetId();
        // Add sub-devices to a gateway device via: gateway product and device keys
        addsubdevice.addSubDevice_keys(accessKey, secretKey, orgId, url, gwProductKey, gwDeviceKey, sdToAddList1);
        // Add sub-devices to a gateway device via: gateway assetId
        addsubdevice.addSubDevice_assetId(accessKey, secretKey, orgId, url, gwDeviceAssetId, sdToAddList2);
        
        // Connection Services, Gateway and Sub-Device: Get Gateway
        // note: Ensure you have already created a topography consisting of a gateway device and sub-devices.

        // Sub-device information
        String sd1ProductKey = device1_Info.getProductKey();
        String sd1DeviceKey = device1_Info.getDeviceKey();
        String sd1AssetId = device1_Info.getAssetId();
        String sd2ProductKey = device2_Info.getProductKey();
        String sd2DeviceKey = device2_Info.getDeviceKey();
        String sd2AssetId = device2_Info.getAssetId();

        // Get gateway device via: sub-device's assetId
        GetGateway getgateway = new GetGateway();
        getgateway.getGateway_assetId(accessKey, secretKey, orgId, url, sd1AssetId);
        // Get gateway device via: sub-device's productKey and deviceKey
        getgateway.getGateway_keys(accessKey, secretKey, orgId, url, sd2ProductKey, sd2DeviceKey);
        
        // Connection Services, Gateway and Sub-Device: Search Sub-device
        // note: Ensure you have already created a topography consisting of a gateway device and sub-devices.
        // note: Search expressions are defined within the individual search sub-functions below.

        SearchSubDevice searchsubdevice = new SearchSubDevice();
        // Find a gateway's sub-device via: modelId
        searchsubdevice.searchSubDevice_model(
                accessKey,
                secretKey,
                orgId,
                url,
                modelId,
                gwDeviceAssetId,
                gwProductKey,
                gwDeviceKey);
        // Identify a gateway's sub-device via: sub-device's attributes
        searchsubdevice.searchSubDevice_deviceAttributes(
                accessKey,
                secretKey,
                orgId,
                url,
                gwDeviceAssetId,
                gwProductKey,
                gwDeviceKey);
        // Identify a gateway's sub-device via: sub-device's tags
        searchsubdevice.searchSubDevice_deviceTags(
                accessKey,
                secretKey,
                orgId,
                url,
                gwDeviceAssetId,
                gwProductKey,
                gwDeviceKey);
        // Identify a gateway's sub-device via: sub-device's productKey
        searchsubdevice.searchSubDevice_productKey(
                accessKey,
                secretKey,
                orgId,
                url,
                gwDeviceAssetId,
                gwProductKey,
                gwDeviceKey,
                sd1ProductKey);
        // Identify a gateway's sub-device via: sub-device's deviceKey
        searchsubdevice.searchSubDevice_deviceKey(
                accessKey,
                secretKey,
                orgId,
                url,
                gwDeviceAssetId,
                gwProductKey,
                gwDeviceKey,
                sd1ProductKey);
        // Identify a gateway's sub-device via: sub-device's AssetId
        searchsubdevice.searchSubDevice_assetId(
                accessKey,
                secretKey,
                orgId,
                url,
                gwDeviceAssetId,
                gwProductKey,
                gwDeviceKey,
                sd1AssetId);
        // Identify a gateway's sub-device via: sub-device's defaultName
        searchsubdevice.searchSubDevice_deviceName_default(
                accessKey,
                secretKey,
                orgId,
                url,
                gwDeviceAssetId,
                gwProductKey,
                gwDeviceKey);
        // Identify a gateway's sub-device via: sub-device's various locale names
        searchsubdevice.searchSubDevice_deviceName_locale(
                accessKey,
                secretKey,
                orgId,
                url,
                gwDeviceAssetId,
                gwProductKey,
                gwDeviceKey);
        // Identify a gateway's sub-device via: sub-device's status
        searchsubdevice.searchSubDevice_status(
                accessKey,
                secretKey,
                orgId,
                url,
                gwDeviceAssetId,
                gwProductKey,
                gwDeviceKey);
        
        // Connection Services, Gateway and Sub-Device: Remove Sub-device
        // note: Ensure you have already created a topography consisting of a gateway device and sub-devices.

        RemoveSubDevice removesubdevice = new RemoveSubDevice();
        // Remove sub-device via: gateway's assetId and to-be-removed sub-devices' assetId(s)
        removesubdevice.RemoveSubDevice_assetId(accessKey,
                secretKey,
                orgId,
                url,
                gwDeviceAssetId,
                sdToAddList1);
        // Remove sub-device via: gateway's product and device keys and to-be-removed sub-devices' assetId(s)
        removesubdevice.RemoveSubDevice_keys(accessKey,
                secretKey,
                orgId,
                url,
                gwProductKey,
                gwDeviceKey,
                sdToAddList2);

/*        try {
            Thread.sleep(180000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        DeleteDevice deleteDevice = new DeleteDevice();
        deleteDevice.deleteDevice_assetID(accessKey, secretKey, orgId, url, device1_Info.getAssetId());
        deleteDevice.deleteDevice_assetID(accessKey, secretKey, orgId, url, device2_Info.getAssetId());
        deleteDevice.deleteDevice_assetID(accessKey, secretKey, orgId, url, gwDeviceAssetId);
        DeleteProduct deleteProduct = new DeleteProduct();
        deleteProduct.deleteProduct(accessKey, secretKey, orgId, url, sdProductKey);
        deleteProduct.deleteProduct(accessKey, secretKey, orgId, url, gwProductKey);

    }
}
