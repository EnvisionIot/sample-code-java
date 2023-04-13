package com.envisioniot.example.sample.tsdbdata.v2_1;

import com.alibaba.fastjson.JSONObject;
import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.example.sample.utility.Request;

import java.util.List;

/**
 * @author jinghui.zhao
 */
public class CheckDeadData {

    public JSONObject checkDeadData(String gatewayUrl,
                                    String accessKey,
                                    String secretKey,
                                    String orgId,
                                    List<CheckDeadDataParam> checkDeadDataParams) {
        Poseidon poseidon = Poseidon.config(
                PConfig.init()
                        .appKey(accessKey)
                        .appSecret(secretKey)
        )
                .method("POST")
                .header("Content-Type", "application/json");

        Request request = new Request();
        request.setBodyParams("payload", checkDeadDataParams);

        JSONObject response = poseidon
                .url(gatewayUrl + "/tsdb-service/v2.1/data/latest/check-dead")
                .queryParam("orgId", orgId)
                .getResponse(request, JSONObject.class);
        System.out.println(response);
        return response;
    }

    public static class CheckDeadDataParam {
        private String assetId;
        private String pointId;
        private Integer interval;

        public String getAssetId() {
            return assetId;
        }

        public void setAssetId(String assetId) {
            this.assetId = assetId;
        }

        public String getPointId() {
            return pointId;
        }

        public void setPointId(String pointId) {
            this.pointId = pointId;
        }

        public Integer getInterval() {
            return interval;
        }

        public void setInterval(Integer interval) {
            this.interval = interval;
        }
    }
}
