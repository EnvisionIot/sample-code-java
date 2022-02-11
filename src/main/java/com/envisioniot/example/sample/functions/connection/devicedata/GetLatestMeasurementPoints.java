/**
 * Copyright (C), 2015-2022, Envision
 * FileName: GetLatestMeasurementPoints
 * Author:  Arihant jain
 * Date:    5/1/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.functions.connection.devicedata;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.measurepoints.QueryLatestMeasurepointsRequest;
import com.envisioniot.enos.connect_service.v2_1.measurepoints.QueryLatestMeasurepointsResponse;
import com.google.common.collect.ImmutableList;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/get_latest_measurement_points.html  <br>
 * refer to the resources/ConnectionsServiceModels/DeviceData/model_demo_smartbattery_model_15.json
 * @author arihantjain97
 * @create 5/1/22
 * @since --
 */

public class GetLatestMeasurementPoints {
    public void getLatestMeasurementPoints_keys(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey,
            String deviceKey)
    {
        // Create a request to query the latest measurement point.
        QueryLatestMeasurepointsRequest request = new QueryLatestMeasurepointsRequest();

        // Set the organisation
        request.setOrgId(orgId);

        // Set the device the measurement point will be queried from via its assetId
        //request.setAssetId("XxGNnbeg");

        // Set the device the measurement point will be queried from via its productKey and deviceKey
        // note: This is an alternative method to setting via assetId.
        request.setProductKey(productKey);
        request.setDeviceKey(deviceKey);

        // Set the point's identifier.
        request.setMeasurepointIds(ImmutableList.of("temperature"));

        QueryLatestMeasurepointsResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, QueryLatestMeasurepointsResponse.class);

    }

    public void getLatestMeasurementPoints_assetId(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String assetId)
    {
        // Create a request to query the latest measurement point.
        QueryLatestMeasurepointsRequest request = new QueryLatestMeasurepointsRequest();

        // Set the organisation
        request.setOrgId(orgId);

        // Set the device the measurement point will be queried from via its assetId
        request.setAssetId(assetId);

        // Set the point's identifier.
        request.setMeasurepointIds(ImmutableList.of("temperature"));

        QueryLatestMeasurepointsResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, QueryLatestMeasurepointsResponse.class);

    }
}
