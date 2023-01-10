package com.envisioniot.example.sample.onboarding.amc;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.amc_app_service.v1_0.device.SearchDeviceRequest;
import com.envisioniot.enos.amc_app_service.v1_0.device.SearchDeviceResponse;
import com.envisioniot.enos.api.common.constant.request.Pagination;
import com.google.common.collect.Lists;

/**
 * @link https://support.eniot.io/docs/onboarding-tool-api/zh_CN/dev/search_device.html <br/>
 *       this code for example to search device
 *
 * @author qiwei.tan
 * @version 1.0
 * @date 2022/11/29 11:44
 */
public class SearchDevice {

    public void searchDevice(String accessKey, String secretKey, String orgId, String url) {
        SearchDeviceRequest request = new SearchDeviceRequest();
        // If you want to search for devices under the specified site
        request.setSiteAssetId("leGSujLz");
        request.setOrgId(orgId);
        // If you want to filter by device type, these device types are defined in configuration app.
        request.setDeviceTypes(Lists.newArrayList("Inverter", "Transformer"));
        // If there are multiple pages, change the pageNo of pagination
        request.setPagination(Pagination.builder().pageNo(1).pageSize(10).build());
        SearchDeviceResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
            .url(url).getResponse(request, request.getResponseClass());
    }

}
