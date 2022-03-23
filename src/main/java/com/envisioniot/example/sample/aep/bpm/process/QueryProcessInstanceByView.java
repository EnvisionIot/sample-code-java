/**
 * Copyright (C), 2015-2022, Envision
 * FileName: QueryProcessInstanceByView
 * Author:   arihant.jain
 * Date:     17/3/2022
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.aep.bpm.process;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

import java.util.Map;

/**
 * https://www.envisioniot.com/docs/bpm-api/en/2.3.0/process/query_process_instance_by_view.html  <br>
 *
 * @author arihant.jain
 * @create 17/3/2022
 * @since --
 */

public class QueryProcessInstanceByView {
    public JSONObject queryProcessInstanceByView(
            String accessKey,
            String secretKey,
            String url,
            String bearerToken,
            String displayViewKey,
            Map<String, Object> params)
    {
        Request request = new Request();
        request.setHeaderParam("authorization", "Bearer " + bearerToken);
        request.setBodyParams(params);
        request.setMethod("POST");

        try {
            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url + "/enos-bpm-service/v2.0/work/display-view/" + displayViewKey + "/process-instances/query")
                    .getResponse(request, JSONObject.class);

            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public JSONObject queryProcessInstanceByViewWithPagination(
            String accessKey,
            String secretKey,
            String url,
            String bearerToken,
            String displayViewKey,
            Map<String, Object> params,
            int pageNo,
            int pageSize,
            String field,
            String order)
    {
        Request request = new Request();
        request.setHeaderParam("authorization", "Bearer " + bearerToken);
        request.setBodyParams(params);

        JSONObject type1SortersJSON = new JSONObject();
        type1SortersJSON.put("field", field);
        type1SortersJSON.put("order", order);
        JSONArray type1SortersArray = new JSONArray();
        type1SortersArray.add(type1SortersJSON);
        JSONObject type1JSON = new JSONObject();
        type1JSON.put("pageNo", pageNo);
        type1JSON.put("pageSize", pageSize);
        type1JSON.put("sorters", type1SortersArray);

        System.out.println("pagination json struct: " + type1JSON);

        request.setBodyParams("pagination", type1JSON);
        request.setMethod("POST");

        try {
            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url + "/enos-bpm-service/v2.0/work/display-view/" + displayViewKey + "/process-instances/query")
                    .getResponse(request, JSONObject.class);

            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public JSONObject queryProcessInstanceByViewWithPagination(
            String accessKey,
            String secretKey,
            String url,
            String bearerToken,
            String displayViewKey,
            Map<String, Object> params,
            int current,
            int pageSize,
            String field,
            String order,
            String start)
    {
        Request request = new Request();
        request.setHeaderParam("authorization", "Bearer " + bearerToken);
        request.setBodyParams(params);

        JSONObject type1SortersJSON = new JSONObject();
        type1SortersJSON.put("field", field);
        type1SortersJSON.put("order", order);
        JSONArray type1SortersArray = new JSONArray();
        type1SortersArray.add(type1SortersJSON);
        JSONObject type1JSON = new JSONObject();
        type1JSON.put("current", current);
        type1JSON.put("pageSize", pageSize);
        type1JSON.put("start", start);
        //type1JSON.put("total", total);
        type1JSON.put("sorts", type1SortersArray);

        System.out.println("pagination json struct: " + type1JSON);

        request.setBodyParams("pagination", type1JSON);

        request.setMethod("POST");

        try {
            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url + "/enos-bpm-service/v2.0/work/display-view/" + displayViewKey + "/process-instances/query")
                    .getResponse(request, JSONObject.class);

            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
