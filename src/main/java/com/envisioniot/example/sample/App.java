package com.envisioniot.example.sample;


import com.envisioniot.example.sample.aep.appportal.AppPortalApp;
import com.envisioniot.example.sample.aep.bpm.BpmApp;
import com.envisioniot.example.sample.aep.iamservice.IAMApp;
import com.envisioniot.example.sample.aep.iamservice.LogIn;
import com.envisioniot.example.sample.aep.notificationmanagement.NotificationManagementApp;
import com.envisioniot.example.sample.edp.streamprocessing.StreamProcessingApp;
import com.envisioniot.example.sample.edp.tsdbdata.TSDBDataApp;
import com.envisioniot.example.sample.edp.tsdbpolicy.TSDBPolicyApp;
import com.envisioniot.example.sample.iothub.connection.device.ConnectionDeviceApp;
import com.envisioniot.example.sample.iothub.connection.devicedata.ConnectionDeviceDataApp;
import com.envisioniot.example.sample.iothub.connection.gatewayandsubdevice.ConnectionGatewayAndSubdeviceApp;
import com.envisioniot.example.sample.iothub.connection.product.ConnectionProductApp;
import com.envisioniot.example.sample.iothub.model.ModelApp;
import com.envisioniot.example.sample.iothub.alert.AlertApp;
import com.envisioniot.example.sample.iothub.asset.AssetApp;
import com.envisioniot.example.sample.iothub.connection.firmwaremanagement.ConnectionFirmwareManagementApp;
import com.envisioniot.example.sample.iothub.connection.firmwareotaupgrademanagement.ConnectionFirmwareOTAupgradeManagementApp;
import com.envisioniot.example.sample.iothub.connection.httpmessageintegration.ConnectionHttpApp;
import com.envisioniot.example.sample.utility.PropertyUtil;

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


        /* Run GetThings */
        // https://support.envisioniot.com/docs/model-api/en/2.3.0/overview.html
/*
        ModelApp model = new ModelApp();
        model.modelappGeneral(accessKey, secretKey, orgId, url);
*/

        /* Connection Service */

        // Connection Service - Product
        // https://support.envisioniot.com/docs/connection-api/en/2.3.0/overview.html
/*
        ConnectionProductApp product = new ConnectionProductApp();
        product.connectionProductAppGeneral(accessKey, secretKey, orgId, url);
*/


        // Connection Service - Device
        // https://support.envisioniot.com/docs/connection-api/en/2.3.0/index_device.html
/*
        ConnectionDeviceApp device = new ConnectionDeviceApp();
        device.connectionDeviceAppGeneral(accessKey, secretKey, orgId, url);
*/


        // Connection Service - Certificate
        // https://support.envisioniot.com/docs/connection-api/en/2.3.0/index_certificate.html
        /*
        ConnectionCertificateApp certificate = new ConnectionCertificateApp();
        certificate.connectionCertificateAppGeneral(accessKey, secretKey, orgId, url);
        */

        // Connection Services - Gateway and Sub-Device
        // https://support.envisioniot.com/docs/connection-api/en/2.3.0/index_gateway_subdevice.html
/*
        ConnectionGatewayAndSubdeviceApp gatewayandsubdevice = new ConnectionGatewayAndSubdeviceApp();
        gatewayandsubdevice.connectionGatewayAndSubdeviceAppGeneral(accessKey, secretKey, orgId, url);
*/


        // Connection Services - Device Data
        // https://support.envisioniot.com/docs/connection-api/en/2.3.0/index_device_data.html
/*
        ConnectionDeviceDataApp devicedata = new ConnectionDeviceDataApp();
        devicedata.connectionDeviceDataAppGeneral(accessKey, secretKey, orgId, url);
*/


        // Connection Services - HTTP Message Integration
        // https://support.envisioniot.com/docs/connection-api/en/2.3.0/index_integration.html
/*
        ConnectionHttpApp http = new ConnectionHttpApp();
        http.connectionHttpApp(accessKey,secretKey,orgId,url);
*/


        // Connection Services - Firmware Management
        //https://support.envisioniot.com/docs/connection-api/en/2.3.0/index_firmware.html
/*
        ConnectionFirmwareManagementApp firmwaremanagement = new ConnectionFirmwareManagementApp();
        firmwaremanagement.connectionFirmwareManagement(accessKey, secretKey, orgId, url);
*/


        // Connection Services - Firmware OTA upgrade Management
        //https://support.envisioniot.com/docs/connection-api/en/2.3.0/index_ota.html
/*
        ConnectionFirmwareOTAupgradeManagementApp firmwareotaupgrademanagement = new ConnectionFirmwareOTAupgradeManagementApp();
        firmwareotaupgrademanagement.firmwareOTAupgradeManagement(accessKey, secretKey, orgId, url);
*/


        // Asset Service
        // https://support.envisioniot.com/docs/asset-api/en/2.3.0/overview.html

/*        AssetApp asset = new AssetApp();
        asset.assetAppGeneral(accessKey, secretKey, orgId, url);*/


        // Alert
        // https://support.envisioniot.com/docs/alert-api/en/2.3.0/overview.html
/*
        AlertApp alert =  new AlertApp();
        alert.alertAppGeneral(accessKey, secretKey, orgId, url);
*/


/*      //Stream Processing Services, Get Stage State

        StreamProcessingApp streamprocessingapp = new StreamProcessingApp();
        streamprocessingapp.streamProcessingAppGeneral(accessKey, secretKey, orgId, url);*/

        //TSDP Policy
/*        TSDBPolicyApp tsdbpolicyapp = new TSDBPolicyApp();
        tsdbpolicyapp.tsdbPolicyAppGeneral(accessKey, secretKey, orgId, url);*/

//        TSDBDataApp tsdbdataapp = new TSDBDataApp();
//        tsdbdataapp.tsdbDataAppGeneral(accessKey, secretKey, orgId, url);


/*        AppPortalApp appPortalApp = new AppPortalApp();
        appPortalApp.appPortalGeneral(accessKey, secretKey, orgId, url);*/

/*
        BpmApp bpmApp = new BpmApp();
        bpmApp.bpmAppGeneral(accessKey, secretKey, orgId, url);
*/

/*        IAMApp iamApp = new IAMApp();
        iamApp.IAMAppGeneral(accessKey, secretKey, orgId, url);*/

/*        NotificationManagementApp notificationManagementApp = new NotificationManagementApp();
        notificationManagementApp.notificationManagementApp(accessKey, secretKey, orgId, url);*/


    }

}
