package com.envisioniot.example.sample.onboarding.amc;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.amc_app_service.v1_0.topology.SearchTopologyRequest;
import com.envisioniot.enos.amc_app_service.v1_0.topology.SearchTopologyResponse;

/**
 * @link https://support.eniot.io/docs/onboarding-tool-api/zh_CN/dev/search_topology.html<br/>
 *       this code for example to search topology
 *
 * @author qiwei.tan
 * @version 1.0
 * @date 2022/11/29 11:54
 */
public class SearchTopology {

    public void searchTopology(String accessKey, String secretKey, String orgId, String url) {
        SearchTopologyRequest request = new SearchTopologyRequest();
        // if your want to filter topology by topology root Id
        request.setTopologyRootId("leGSujLz");
        request.setOrgId(orgId);
        // if your want to filter topology by topology rule Id
        request.setTopologyRuleId("Solar_RackingGroup");
        SearchTopologyResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
            .url(url).getResponse(request, request.getResponseClass());

    }

}
