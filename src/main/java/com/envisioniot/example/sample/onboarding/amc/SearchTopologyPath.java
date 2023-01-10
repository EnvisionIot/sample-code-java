package com.envisioniot.example.sample.onboarding.amc;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.amc_app_service.v1_0.topology.SearchTopologyPathRequest;
import com.envisioniot.enos.amc_app_service.v1_0.topology.SearchTopologyPathResponse;
import com.envisioniot.enos.api.common.constant.request.Pagination;

/**
 * @link https://support.eniot.io/docs/onboarding-tool-api/zh_CN/dev/search_topology_path.html<br/>
 *       this code for example to search specify topology path
 *
 * @author qiwei.tan
 * @version 1.0
 * @date 2022/11/29 14:27
 */
public class SearchTopologyPath {

    public void searchTopologyPath(String accessKey, String secretKey, String orgId, String url) {
        SearchTopologyPathRequest request = new SearchTopologyPathRequest();
        // If there are multiple pages, change the pageNo of pagination
        request.setPagination(Pagination.builder().pageNo(1).pageSize(10).build());
        // The id of the topology instance you want to get
        request.setTopologyId("F3euPFgp/leGSujLz");
        request.setOrgId(orgId);
        SearchTopologyPathResponse response =
            Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug()).url(url).getResponse(request,
                request.getResponseClass());
    }

}
