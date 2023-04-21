/**
 * Copyright (C), 2015-2022, Envision
 * FileName: SearchEvent
 * Author:  Arihant jain
 * Date:    5/1/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.connection.devicedata;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.request.Pagination;
import com.envisioniot.enos.connect_service.v2_1.event.SearchEventRequest;
import com.envisioniot.enos.connect_service.v2_1.event.SearchEventResponse;
import com.google.gson.Gson;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/search_event.html  <br>
 * refer to the resources/ConnectionsServiceModels/DeviceData/model_demo_smartbattery_model_15.json
 * @author arihantjain97
 * @create 5/1/22
 * @since --
 */

public class SearchEvent {
    private void searchBy(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String exp)
    {
        SearchEventRequest request = new SearchEventRequest();
        request.setOrgId(orgId);
        request.setExpression(exp);
        request.setPagination(new Pagination(10, 1, null));
        request.setResolveName(true);
        try {
            SearchEventResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, SearchEventResponse.class);
            Gson gson = new Gson();
            System.out.println(gson.toJson(response));
        } catch (Exception e) {
            System.out.print(e);
        }
    }


    //tslEventKey
    public void searchEvent_tslEventKey(
            String accessKey,
            String secretKey,
            String orgId,
            String url)
    {
        // Setting the expression
        String exp_equalsTo = "tslEventKey = \"tempExceed27\"";
        String exp_in = "tslEventKey in (\"tempExceed27\")";

        // Use assetId to identify device (whose commands will be searched through)
        searchBy(accessKey, secretKey, orgId, url, exp_equalsTo);
        searchBy(accessKey, secretKey, orgId, url, exp_in);
    }

    //tslEventType
    public void searchEvent_tslEventType(
            String accessKey,
            String secretKey,
            String orgId,
            String url)
    {
        // Setting the expression
        String exp_equalsTo = "tslEventType = \"WARN\"";
        String exp_in = "tslEventType in (\"WARN\")";

        // Use assetId to identify device (whose commands will be searched through)
        searchBy(accessKey, secretKey, orgId, url, exp_equalsTo);
        searchBy(accessKey, secretKey, orgId, url, exp_in);
    }

    //Keys
    public void searchEvent_productDeviceKey(
            String accessKey,
            String secretKey,
            String orgId,
            String url)
    {
        // Setting the expression
        String exp_equalsTo = "productKey = \"pk1\" AND deviceKey = \"dk1\"";
        String exp_in = "productKey in (\"pk1\") AND deviceKey in (\"dk1\")";

        // Use assetId to identify device (whose commands will be searched through)
        searchBy(accessKey, secretKey, orgId, url, exp_equalsTo);
        searchBy(accessKey, secretKey, orgId, url, exp_in);
    }

    //Keys
    public void searchEvent_assetId(
            String accessKey,
            String secretKey,
            String orgId,
            String url)
    {
        // Setting the expression
        String exp_equalsTo = "assetId = \"assetId1\"";
        String exp_in = "assetId in (\"assetId1\")";

        // Use assetId to identify device (whose commands will be searched through)
        searchBy(accessKey, secretKey, orgId, url, exp_equalsTo);
        searchBy(accessKey, secretKey, orgId, url, exp_in);
    }

    //startTime, endTime
    public void searchEvent_startEndTime(
            String accessKey,
            String secretKey,
            String orgId,
            String url)
    {
        SearchEventRequest request = new SearchEventRequest();
        request.setOrgId(orgId);
        request.setPagination(new Pagination(10, 1, null));
        request.setResolveName(true);
        request.setStartTime("2022-01-12 12:30:10");
        request.setEndTime("2022-01-12 12:30:12");
        try {
            SearchEventResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, SearchEventResponse.class);
            Gson gson = new Gson();
            System.out.println(gson.toJson(response));
        } catch (Exception e) {
            System.out.print(e);
        }
    }

}
