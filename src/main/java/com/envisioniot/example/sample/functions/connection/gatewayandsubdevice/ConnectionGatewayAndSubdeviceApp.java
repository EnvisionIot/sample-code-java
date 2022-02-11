package com.envisioniot.example.sample.functions.connection.gatewayandsubdevice;

import com.envisioniot.enos.connect_service.vo.DeviceCreateResult;
import com.envisioniot.example.sample.functions.connection.device.CreateDevice;
import com.envisioniot.example.sample.functions.connection.device.DeleteDevice;
import com.envisioniot.example.sample.functions.connection.device.GetDevice;
import com.envisioniot.example.sample.functions.connection.product.CreateProduct;
import com.envisioniot.example.sample.functions.connection.product.DeleteProduct;

import java.util.ArrayList;

public class ConnectionGatewayAndSubdeviceApp {
    public void connectionGatewayAndSubdeviceAppGeneral(String accessKey, String secretKey, String orgId, String url){

        String modelId = "demo_smartbattery_model_15";

        // Create a gateway product
        CreateProduct createproduct = new CreateProduct(modelId);
        String gatewayProductKey = createproduct.createProduct_productType_gateway(accessKey, secretKey, orgId, url);
        // Create another product for subdevices
        String subDevProductKey = createproduct.createProduct(accessKey, secretKey, orgId, url);

        // Create devices
        CreateDevice createdevice = new CreateDevice();
        DeviceCreateResult gwDevice_Info =
                createdevice.createDevice(accessKey, secretKey, orgId, url, gatewayProductKey);
        DeviceCreateResult subDevice1_Info =
                createdevice.createDevice_optionalParameters(accessKey, secretKey, orgId, url, subDevProductKey);
        DeviceCreateResult subDevice2_Info =
                createdevice.createDevice(accessKey, secretKey, orgId, url, subDevProductKey);

        ArrayList<String> subDeviceAssetIdList1 = new ArrayList<>();
        subDeviceAssetIdList1.add(subDevice1_Info.getAssetId());

        ArrayList<String> subDeviceAssetIdList2 = new ArrayList<>();
        subDeviceAssetIdList2.add(subDevice2_Info.getAssetId());


        // Connection Services, Gateway and Sub-Device: Add Sub-Device
        AddSubDevice addsubdevice = new AddSubDevice();
        addsubdevice.addSubDevice_keys( accessKey,
                                        secretKey,
                                        orgId,
                                        url,
                                        gwDevice_Info.getProductKey(),
                                        gwDevice_Info.getDeviceKey(),
                                        subDeviceAssetIdList1);

        addsubdevice.addSubDevice_assetId(  accessKey,
                                            secretKey,
                                            orgId,
                                            url,
                                            gwDevice_Info.getAssetId(),
                                            subDeviceAssetIdList2);


        // Connection Services, Gateway and Sub-Device: Get Gateway
        // Ensure you have already created a topography consisting of a gateway device and sub-devices.

        GetGateway getgateway = new GetGateway();
        getgateway.getGateway_assetId(
                accessKey, secretKey, orgId, url, subDevice1_Info.getAssetId());
        getgateway.getGateway_keys(
                accessKey, secretKey, orgId, url, subDevice2_Info.getProductKey(), subDevice2_Info.getDeviceKey());


        // Connection Services, Gateway and Sub-Device: Search Sub-device
        System.out.println("\n\n");
        SearchSubDevice searchsubdevice = new SearchSubDevice();
        // Ensure you have already created a topography consisting of a gateway device and sub-devices.
        System.out.println("searchSubDevice_model");
        searchsubdevice.searchSubDevice_model(
                accessKey,
                secretKey,
                orgId, url,
                modelId,
                gwDevice_Info.getAssetId(),
                gwDevice_Info.getProductKey(),
                gwDevice_Info.getDeviceKey());
        System.out.println("searchSubDevice_deviceAttributes");
        searchsubdevice.searchSubDevice_deviceAttributes(
                accessKey,
                secretKey,
                orgId,
                url,
                gwDevice_Info.getAssetId(),
                gwDevice_Info.getProductKey(),
                gwDevice_Info.getDeviceKey());
        System.out.println("searchSubDevice_deviceTags");
        searchsubdevice.searchSubDevice_deviceTags(
                accessKey,
                secretKey,
                orgId,
                url,
                gwDevice_Info.getAssetId(),
                gwDevice_Info.getProductKey(),
                gwDevice_Info.getDeviceKey());
        System.out.println("searchSubDevice_productKey");
        searchsubdevice.searchSubDevice_productKey(
                accessKey,
                secretKey,
                orgId,
                url,
                gwDevice_Info.getAssetId(),
                gwDevice_Info.getProductKey(),
                gwDevice_Info.getDeviceKey(),
                subDevice1_Info.getProductKey());
        System.out.println("searchSubDevice_deviceKey");
        searchsubdevice.searchSubDevice_deviceKey(
                accessKey,
                secretKey,
                orgId,
                url,
                gwDevice_Info.getAssetId(),
                gwDevice_Info.getProductKey(),
                gwDevice_Info.getDeviceKey(),
                subDevice1_Info.getDeviceKey());
        System.out.println("searchSubDevice_assetId");
        searchsubdevice.searchSubDevice_assetId(
                accessKey,
                secretKey,
                orgId,
                url,
                gwDevice_Info.getAssetId(),
                gwDevice_Info.getProductKey(),
                gwDevice_Info.getDeviceKey(),
                subDevice1_Info.getAssetId());
        System.out.println("searchSubDevice_deviceName_default");
        searchsubdevice.searchSubDevice_deviceName_default(
                accessKey,
                secretKey,
                orgId,
                url,
                gwDevice_Info.getAssetId(),
                gwDevice_Info.getProductKey(),
                gwDevice_Info.getDeviceKey());
        System.out.println("searchSubDevice_deviceName_locale");
        searchsubdevice.searchSubDevice_deviceName_locale(
                accessKey,
                secretKey,
                orgId,
                url,
                gwDevice_Info.getAssetId(),
                gwDevice_Info.getProductKey(),
                gwDevice_Info.getDeviceKey());
        System.out.println("searchSubDevice_status");
        searchsubdevice.searchSubDevice_status(
                accessKey,
                secretKey,
                orgId,
                url,
                gwDevice_Info.getAssetId(),
                gwDevice_Info.getProductKey(),
                gwDevice_Info.getDeviceKey());
        System.out.println("\n\n");

        //Connection Services, Gateway and Sub-Device: Remove Sub-device
        RemoveSubDevice removesubdevice = new RemoveSubDevice();
        // Ensure you have already created a topography consisting of a gateway device and sub-devices.
        removesubdevice.RemoveSubDevice_assetId(accessKey,
                secretKey,
                orgId,
                url,
                gwDevice_Info.getAssetId(),
                subDeviceAssetIdList1);

        removesubdevice.RemoveSubDevice_keys(accessKey,
                secretKey,
                orgId,
                url,
                gwDevice_Info.getProductKey(),
                gwDevice_Info.getDeviceKey(),
                subDeviceAssetIdList2);

        try {
            Thread.sleep(180000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        DeleteDevice deleteDevice = new DeleteDevice();
        deleteDevice.deleteDevice_assetID(accessKey, secretKey, orgId, url, subDevice1_Info.getAssetId());
        deleteDevice.deleteDevice_assetID(accessKey, secretKey, orgId, url, subDevice2_Info.getAssetId());
        deleteDevice.deleteDevice_assetID(accessKey, secretKey, orgId, url, gwDevice_Info.getAssetId());
        DeleteProduct deleteProduct = new DeleteProduct();
        deleteProduct.deleteProduct(accessKey, secretKey, orgId, url, subDevProductKey);
        deleteProduct.deleteProduct(accessKey, secretKey, orgId, url, gatewayProductKey);

    }
}
