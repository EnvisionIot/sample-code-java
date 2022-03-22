/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.iothub.alert.rule;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.request.Pagination;
import com.envisioniot.enos.event_service.v2_1.SearchAlertRuleRequest;
import com.envisioniot.enos.event_service.v2_1.SearchAlertRuleResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 1/6/2022
 * @since 1.0.0
 */

public class SearchAlertRule {
    public void searchAlertRuleWithExpression(String accessKey, String secretKey, String orgId, String url, String modelId, String measurepointId, String expression, Pagination pagination) {
        SearchAlertRuleRequest request = new SearchAlertRuleRequest();
        request.setOrgId(orgId);
        if(modelId!=null && !modelId.isEmpty())
            request.setModelId(modelId);

        if(measurepointId!=null && !measurepointId.isEmpty())
            request.setMeasurepointId(measurepointId);

        if(pagination!=null )
            request.setPagination(pagination);

        if(expression!=null && !expression.isEmpty())
            request.setExpression(expression);

        try {
            SearchAlertRuleResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, SearchAlertRuleResponse.class);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

}
