package com.envisioniot.example.sample;

import com.envisioniot.example.sample.functions.connection.gatewayandsubdevice.ConnectionGatewayAndSubdeviceApp;
import com.envisioniot.example.sample.functions.streamprocessing.StreamProcessingApp;

import java.io.IOException;

/**
 * API 2.3.0 testing
 */
public class App {
    private static String accessKey ;
    private static String secretKey ;
    private static String orgId ;
    private static String url ;

    public static void main(String[] args)  {
        // Preconfiguration
        PropertyUtil pptfile = null;
        try {
            pptfile = new PropertyUtil("env.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        accessKey = pptfile.getProperty("accessKey");
        secretKey = pptfile.getProperty("secretKey");
        orgId = pptfile.getProperty("orgId");
        url = pptfile.getProperty("url");

        // Functions

        // Run GetThings functions
        /*ModelApp model = new ModelApp();
        model.modelappGeneral(accessKey, secretKey, orgId, url);*/

        // Connection Service, Product

        //ConnectionProductApp product = new ConnectionProductApp();
        //product.connectionProductAppGeneral(accessKey, secretKey, orgId, url);


        // Connection Service, Device
        /*
        ConnectionDeviceApp device = new ConnectionDeviceApp();
        device.connectionDeviceAppGeneral(accessKey, secretKey, orgId, url);
         */

        // Connection Service, Certificate
        /*
        ConnectionCertificateApp certificate = new ConnectionCertificateApp();
        certificate.connectionCertificateAppGeneral(accessKey, secretKey, orgId, url);
        */

        // Connection Services, Gateway and Sub-Device
        /*
        ConnectionGatewayAndSubdeviceApp gatewayandsubdevice = new ConnectionGatewayAndSubdeviceApp();
        gatewayandsubdevice.connectionGatewayAndSubdeviceAppGeneral(accessKey, secretKey, orgId, url);
        */

        // Connection Services, Device Data
        /*
        ConnectionDeviceDataApp devicedata = new ConnectionDeviceDataApp();
        devicedata.connectionDeviceDataAppGeneral(accessKey, secretKey, orgId, url);
         */

        //Connection Services, HTTP Message Integration
        /*
        ConnectionHttpApp http = new ConnectionHttpApp();

        http.connectionHttpApp(accessKey,secretKey,orgId,url);
         */

        // Connection Services, Firmware Management

        //ConnectionFirmwareManagementApp firmwaremanagement = new ConnectionFirmwareManagementApp();
        //firmwaremanagement.connectionFirmwareManagement(accessKey, secretKey, orgId, url);


        // Connection Services, Firmware OTA upgrade Management
        //ConnectionFirmwareOTAupgradeManagementApp  firmwareotaupgrademanagement = new ConnectionFirmwareOTAupgradeManagementApp();
        //firmwareotaupgrademanagement.firmwareOTAupgradeManagement(accessKey, secretKey, orgId, url);

//        http.connectionHttpApp(accessKey,secretKey,orgId,url);


        //Asset
        //AssetApp asset = new AssetApp();
//        asset.assetAppGeneral(accessKey, secretKey, orgId, url);

        // Alert
        //AlertApp alert =  new AlertApp();
       // alert.alertAppGeneral(accessKey, secretKey, orgId, url);

        //Stream Processing Services, Get Stage State
        StreamProcessingApp streamprocessingapp = new StreamProcessingApp();
        streamprocessingapp.streamProcessingAppGeneral(accessKey, secretKey, orgId, url);

    }

}
