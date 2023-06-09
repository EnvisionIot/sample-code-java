/**
 * Copyright (C), 2015-2022, Envision
 * FileName: SearchDeviceUpgrade
 * Author:  Arihant jain
 * Date:    10/2/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.connection.firmwaremanagement;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.request.Pagination;
import com.envisioniot.enos.connect_service.v2_1.ota.firmware.SearchDeviceUpgradeRequest;
import com.envisioniot.enos.connect_service.v2_1.ota.firmware.SearchDeviceUpgradeResponse;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/search_device_upgrade.html  <br>
 * refer to the resources/ConnectionsServiceModels/FirmwareManagement/model_demo_smartbattery_model_15.json
 *
 * @author arihantjain97
 * @create 10/2/22
 * @since --
 */

public class SearchDeviceUpgrade {

    private void searchBy(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String exp)
    {
        SearchDeviceUpgradeRequest request = new SearchDeviceUpgradeRequest();
        request.setOrgId(orgId);
        request.setExpression(exp);
        Pagination pagination = new Pagination();
        pagination.setPageNo(1);
        pagination.setPageSize(5);
        request.setPagination(pagination);

        SearchDeviceUpgradeResponse response = Poseidon
                .config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, SearchDeviceUpgradeResponse.class);
    }

    public void searchDeviceUpgrade_productKey(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey){
        String exp_equalsTo = "productKey = '" + productKey + "'";
        String exp_in = "productKey in (\"" + productKey + "\")";

        searchBy(accessKey, secretKey, orgId, url, exp_equalsTo);
        searchBy(accessKey, secretKey, orgId, url, exp_in);

    }

    public void searchDeviceUpgrade_firmwareVersion(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String firmwareVersion){
        String exp_equalsTo = "firmwareVersion = \"" + firmwareVersion + "\"";
        String exp_in = "firmwareVersion in (\"" + firmwareVersion + "\")";

        searchBy(accessKey, secretKey, orgId, url, exp_equalsTo);
        searchBy(accessKey, secretKey, orgId, url, exp_in);

    }

    public void searchDeviceUpgrade_isUpgrading(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey){
        String exp = "isUpgrading = false" + " AND productKey = '" + productKey + "'";
        searchBy(accessKey, secretKey, orgId, url, exp);
    }

}
