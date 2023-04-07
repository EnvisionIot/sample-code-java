package com.envisioniot.example.sample.metric;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envision.apim.poseidon.request.PoseidonRequest;

/**
 * @author li.lei2
 **/
public class MetricQueryPost {

    private static String accessKey = "AccessKey of your APP";
    private static String secretKey = "SecretKey of your APP";
    private static String orgId = "yourOrgId";
    private static String metrics = "yourMetricIds";
    private static String startTime = "dataStartTime";
    private static String endTime = "dataEndTime";
    private static String mdmIds = "yourAsset";
    private static String extraFields = "yourDimensionField";
    private static String url = "https://{domain_url}";

    private static class Request extends PoseidonRequest {

        public void setQueryParam(String key, Object value) {
            queryEncodeParams().put(key, value);
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public void setBodyParams(String key, Object value) {
            bodyParams().put(key, value);
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


    public void metricQueryPost() {
        MetricQueryPost.Request request = new MetricQueryPost.Request();
        request.setQueryParam("orgId", orgId);
        request.setBodyParams("orgId", orgId);
        request.setBodyParams("metrics", metrics);
        request.setBodyParams("mdmIds", mdmIds);
        request.setBodyParams("startTime", startTime);
        request.setBodyParams("endTime", endTime);
        request.setBodyParams("extraFields", extraFields);
        request.setBodyParams("format", 0);
        request.setMethod("POST");
        try {
            JSONObject response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey))
                    .url(url + "/metric-mgmt/v1.0/metrics/data/normal")
                    .getResponse(request, JSONObject.class);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
