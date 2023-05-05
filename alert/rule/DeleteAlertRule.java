/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.alert.rule;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.event_service.v2_1.DeleteAlertRuleRequest;
import com.envisioniot.enos.event_service.v2_1.DeleteAlertRuleResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 1/6/2022
 * @since 1.0.0
 */

public class DeleteAlertRule {
    public void deleteAlertRule(String accessKey, String secretKey, String orgId, String url, String ruleId) {
        DeleteAlertRuleRequest request = new DeleteAlertRuleRequest();
        request.setOrgId(orgId);
        request.setRuleId(ruleId);
        try {
            DeleteAlertRuleResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, DeleteAlertRuleResponse.class);
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
