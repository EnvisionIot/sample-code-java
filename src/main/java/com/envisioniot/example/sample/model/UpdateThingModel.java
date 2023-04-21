package com.envisioniot.example.sample.model;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.common.StringI18n;
import com.envisioniot.enos.model_service.v2_1.UpdateThingModelRequest;
import com.envisioniot.enos.model_service.v2_1.UpdateThingModelResponse;

/**
 * @Author: song.xu
 * @Date: 2022/9/21
 */
public class UpdateThingModel {
    public void updateModel(String accessKey, String secretKey, String orgId, String url) {
        UpdateThingModelRequest request = new UpdateThingModelRequest();
        request.setOrgId(orgId);
        request.setModelId("modelId"); // input modelId
        request.setName(new StringI18n("testUpdateName"));
        request.setDesc("testUpdateDesc");
        UpdateThingModelResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, UpdateThingModelResponse.class);
        System.out.println(response);
    }
}
