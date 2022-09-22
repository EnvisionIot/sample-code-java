package com.envisioniot.example.sample.connection.httpmessageintegration;

public class ConnectionHttpApp {

    public void connectionHttpApp(String accessKey, String secretKey, String orgId, String url) {

        // Ensure that you have the appropriate model(s), product(s), device(s), command(s), event(s) set-up.
        // note: modelId is viewable on enOS at IoT hub/Models,
        // productKey is viewable on enOS at IoT hub/Device Management/Products/View,
        // deviceKey and assetId is viewable on enOS at IoT hub/Device Assets/View

        String modelId = "demo_smartbattery_model_15";
        String productKey = "98683knm";
        String deviceKey = "rGhMZ6daqj";
        String assetId = "szxpLiGi";
        String eventId = "202201129fba478d083db14a85439be769ad22b3";

        // Uploading attributes.
        UploadAttributes uploadattributes = new UploadAttributes();
        uploadattributes.uploadAttributes_assetId(accessKey,secretKey,orgId,url,assetId);
        //uploadattributes.uploadAttributes_keys(accessKey,secretKey,orgId,url,productKey, deviceKey);


        /*
        // Uploading events.
        UploadEvents uploadEvents = new UploadEvents();
        uploadEvents.uploadEvents_assetId(accessKey, secretKey, orgId, url, assetId);
        uploadEvents.uploadEvents_keys(accessKey, secretKey, orgId, url, productKey, deviceKey);
         */

        /*
        // Uploading measurement points.
        UploadMeasurementPoints uploadmeasurementpoints = new UploadMeasurementPoints();
        uploadmeasurementpoints.uploadMeasurementPoints_assetId(accessKey,secretKey,orgId,url,assetId);
        uploadmeasurementpoints.uploadMeasurementPoints_keys(accessKey,secretKey,orgId,url,productKey, deviceKey);
         */

    }
}
