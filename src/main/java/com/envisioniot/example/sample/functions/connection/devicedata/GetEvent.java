/**
 * Copyright (C), 2015-2022, Envision
 * FileName: GetEvent
 * Author:  Arihant jain
 * Date:  6/1/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.functions.connection.devicedata;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.event.GetEventRequest;
import com.envisioniot.enos.connect_service.v2_1.event.GetEventResponse;
import com.google.gson.Gson;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/get_event.html  <br>
 * refer to the resources/ConnectionsServiceModels/DeviceData/model_demo_smartbattery_model_15.json
 * @author arihantjain97
 * @create 6/1/22
 * @since --
 */

public class GetEvent {
    public void getEvent(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String eventId)
    {
        // Create get event request.
        GetEventRequest request = new GetEventRequest();

        // Set organisation.
        request.setOrgId(orgId);

        // Set the unique eventId of the desired event.
        request.setEventId(eventId);

        // Restructure the data from output and return eventName and outputNames.
        request.setResolveName(true);

        try {
            GetEventResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, GetEventResponse.class);
            Gson gson = new Gson();
            System.out.println(gson.toJson(response));
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
