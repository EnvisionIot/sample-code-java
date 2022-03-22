/**
 * Copyright (C), 2015-2022, Envision
 * FileName: SearchFirmwareFile
 * Author:  Arihant jain
 * Date:    10/2/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.iothub.connection.firmwaremanagement;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.request.Pagination;
import com.envisioniot.enos.connect_service.v2_1.ota.firmware.SearchFirmwareFileRequest;
import com.envisioniot.enos.connect_service.v2_1.ota.firmware.SearchFirmwareFileResponse;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/delete_firmware.html  <br>
 * refer to the resources/ConnectionsServiceModels/FirmwareManagement/model_demo_smartbattery_model_15.json
 *
 * @author arihantjain97
 * @create 10/2/22
 * @since --
 */


public class SearchFirmwareFile {
    private void searchBy(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String exp)
    {
        SearchFirmwareFileRequest request = new SearchFirmwareFileRequest();
        request.setOrgId(orgId);
        request.setExpression(exp);
        Pagination pagination = new Pagination();
        pagination.setPageNo(1);
        pagination.setPageSize(5);
        request.setPagination(pagination);
        SearchFirmwareFileResponse response = Poseidon
                .config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, SearchFirmwareFileResponse.class);
    }

    public void searchFirmwareFile_productKey(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey)
    {
        String exp_equalsTo = "productKey = \"" + productKey + "\"";
        String exp_in = "productKey in (\"" + productKey + "\")";

        searchBy(accessKey, secretKey, orgId, url, exp_equalsTo);
        searchBy(accessKey, secretKey, orgId, url, exp_in);

    }

    public void searchFirmwareFile_isVerified(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey)
    {
        String exp_equalsTo = "isVerified = false" + " AND productKey = \"" + productKey + "\"";

        searchBy(accessKey, secretKey, orgId, url, exp_equalsTo);

    }

    public void searchFirmwareFile_defaultName(
            String accessKey,
            String secretKey,
            String orgId,
            String url)
    {
        String exp = "name.default like \"firmware_defaultName\"";
        String exp_fuzzy = "name.default like \"firmware_defaul\"";

        searchBy(accessKey, secretKey, orgId, url, exp);
        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy);
    }

    public void searchFirmwareFile_localeName(
            String accessKey,
            String secretKey,
            String orgId,
            String url){

        String exp_cn = "name.zh_CN like '" + "固件" + "'";
        String exp_fuzzy_cn = "name.zh_CN like '" + "固" + "'";
        String exp_us = "name.en_US like '" + "product firmware" + "'";
        String exp_fuzzy_us = "name.en_US like '" + "product" + "'";
        String exp_jp = "name.ja_JP like '" + "ファームウェア" + "'";
        String exp_fuzzy_jp = "name.ja_JP like '" + "ア" + "'";
        String exp_es = "name.es_ES like '" + "firmware del producto" + "'";
        String exp_fuzzy_es = "name.es_ES like '" + "producto" + "'";


        searchBy(accessKey, secretKey, orgId, url, exp_cn);
        searchBy(accessKey, secretKey, orgId, url, exp_us);
        searchBy(accessKey, secretKey, orgId, url, exp_jp);
        searchBy(accessKey, secretKey, orgId, url, exp_es);

        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_cn);
        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_us);
        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_jp);
        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_es);

    }



}
