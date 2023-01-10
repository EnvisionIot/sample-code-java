package com.envisioniot.example.sample.onboarding;

import com.envisioniot.example.sample.onboarding.amc.*;

/**
 * this code is show for how to use amc api.<br/>
 *
 * @author qiwei.tan
 * @version 1.0
 * @date 2022/11/29 11:09
 */
public class AmcApp {

    public void amcAppGeneral(String accessKey, String secretKey, String orgId, String url) {
        SearchSite site = new SearchSite();
        site.searchSite(accessKey, secretKey, orgId, url);
        SearchDevice device = new SearchDevice();
        device.searchDevice(accessKey, secretKey, orgId, url);
        SearchTopology topology = new SearchTopology();
        topology.searchTopology(accessKey, secretKey, orgId, url);
        SearchTopologyPath topologyPath = new SearchTopologyPath();
        topologyPath.searchTopologyPath(accessKey, secretKey, orgId, url);
        GetTopologyDefinition definition = new GetTopologyDefinition();
        definition.getTopologyDefinition(accessKey, secretKey, orgId, url);
    }

}
