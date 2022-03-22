/**
 * Copyright (C), 2015-2022, Envision
 * FileName: Test
 * Author:   xibin.song
 * Date:     2/8/2022 4:10 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.test;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 2/8/2022
 * @since 1.0.0
 */

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envision.apim.poseidon.request.PoseidonRequest;
import com.envisioniot.example.sample.iothub.alert.record.old.CreateActiveAlert;
import com.envisioniot.example.sample.iothub.alert.record.old.CreateActiveAlertBatch;
import com.envisioniot.example.sample.iothub.alert.record.old.SearchActiveAlert;
import com.envisioniot.example.sample.iothub.alert.record.old.history.SearchHistoryAlert;
import com.envisioniot.example.sample.iothub.alert.rule.SearchAlertRule;
import com.envisioniot.example.sample.utility.PropertyUtil;
import org.junit.Before;

import java.io.IOException;

/**
 * @author darwen
 * @since 2022/2/8 3:43 下午
 **/
public class Test {

    private static final String API_Gateway_URL = "https://apim-ppe1.envisioniot.com";
    private Poseidon poseidon;


    private static class Request extends PoseidonRequest {

        public void setBodyParams(String key, Object value) {
            bodyParams().put(key, value);
        }

        public void setMethod(String method) {
            this.method = method;
        }

        private String method;

        @Override
        public String baseUri() {
            return "";
        }

        @Override
        public String method() {
            return method;
        }
    }

    @Before
    public void init() {
        poseidon = Poseidon.config(
                PConfig.init()
                        .appKey("a4ba942c-ca4a-4b898ea0cf8c-0398-41a9")
                        .appSecret("8ea0cf8c-0398-41a9-a231-5925cc9cf3fd")
        ).method("POST");
    }

    //@org.junit.Test
    public void GetStageState() {
        Request request = new Request();
        request.setBodyParams("assetIds", "ChahG3d9");
        request.setBodyParams("pointIds", "temp");
        request.setBodyParams("pipelineId", "ade78e6a-0df6-4312-9afd-574959278286");
        request.setBodyParams("stageInstanceName", "LatePointTagger_01");

        JSONObject response = poseidon
                .url(API_Gateway_URL + "/streaming/v2.0/stage-state")
                .queryParam("orgId", "o15520323695671")
                .queryParam("action", "get")
                .getResponse(request, JSONObject.class);
        System.out.println(response);
    }
    @org.junit.Test
    public void TestData(){
        PropertyUtil pptfile = null;
        try {
            pptfile = new PropertyUtil("env.properties");
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        String accessKey = pptfile.getProperty("accessKey");
        String secretKey = pptfile.getProperty("secretKey");
        String orgId = pptfile.getProperty("orgId");
        String url = pptfile.getProperty("url");


        CreateActiveAlertBatch activeAlertBatch = new CreateActiveAlertBatch();
        activeAlertBatch.createActiveAlertBatch(accessKey, secretKey, orgId, url);
    }

//    @org.junit.Test
    public void SearchData(){
        PropertyUtil pptfile = null;
        try {
            pptfile = new PropertyUtil("env.properties");
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        String accessKey = pptfile.getProperty("accessKey");
        String secretKey = pptfile.getProperty("secretKey");
        String orgId = pptfile.getProperty("orgId");
        String url = pptfile.getProperty("url");


        SearchActiveAlert searchActiveAlert = new SearchActiveAlert();
        // eventId is from DevPortal - Alert - Alert - Active Alert  - Event ID column
        searchActiveAlert.searchActiveAlert(accessKey, secretKey, orgId, url, "eventId = '2022021772ed00a2fa22be097ca2dff11fa19091'");
        searchActiveAlert.searchActiveAlert(accessKey, secretKey, orgId, url, "eventId = '2022021704cb00ca6a7276668111e43384ba777d'");
    }

}