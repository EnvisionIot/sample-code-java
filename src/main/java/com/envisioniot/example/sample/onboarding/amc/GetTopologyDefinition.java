package com.envisioniot.example.sample.onboarding.amc;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.amc_app_service.v1_0.topology.GetTopologyDefinitionRequest;
import com.envisioniot.enos.amc_app_service.v1_0.topology.GetTopologyDefinitionResponse;

/**
 * @link https://support.eniot.io/docs/onboarding-tool-api/zh_CN/dev/get_topology_definition.html<br/>
 *       this code for example to get topology definition
 *
 * @author qiwei.tan
 * @version 1.0
 * @date 2022/11/29 11:56
 */
public class GetTopologyDefinition {

    public void getTopologyDefinition(String accessKey, String secretKey, String orgId, String url) {
        GetTopologyDefinitionRequest request = new GetTopologyDefinitionRequest();
        // The id of the topology instance you want to get
        request.setTopologyId("F3euPFgp/leGSujLz");
        request.setOrgId(orgId);
        GetTopologyDefinitionResponse response =
            Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug()).url(url).getResponse(request,
                request.getResponseClass());
    }

}
