package com.envisioniot.example.sample.onboarding.amc;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.amc_app_service.v1_0.site.SearchSiteRequest;
import com.envisioniot.enos.amc_app_service.v1_0.site.SearchSiteResponse;
import com.envisioniot.enos.api.common.constant.request.Pagination;

/**
 * @link https://support.eniot.io/docs/onboarding-tool-api/zh_CN/dev/search_site.html <br/>
 *       this code for example to search site
 *
 * @author qiwei.tan
 * @version 1.0
 * @date 2022/11/29 11:11
 */
public class SearchSite {

    public void searchSite(String accessKey, String secretKey, String orgId, String url) {
        SearchSiteRequest request = new SearchSiteRequest();
        request.setOrgId(orgId);
        // if you want to filter by siteType,input site type id
        request.setSiteTypeId("SolarSite");
        // expression currently supported fields are attributes、name、assetId
//        request.setExpression("assetId in ('leGSujLz','rqbSKlta')");
        request.setOrgId(orgId);
        // If there are multiple pages, change the pageNo of pagination
        request.setPagination(Pagination.builder().pageNo(1).pageSize(10).build());
        SearchSiteResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
            .url(url).getResponse(request, request.getResponseClass());
    }

}
