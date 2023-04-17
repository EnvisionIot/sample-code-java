package com.envisioniot.example.sample.connection.firmwareotaupgrademanagement;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.request.Pagination;
import com.envisioniot.enos.connect_service.v2_1.ota.job.SearchJobRequest;
import com.envisioniot.enos.connect_service.v2_1.ota.job.SearchJobResponse;

public class SearchOTAjob {

    /*The query expression, which supports sql-like query. The supported query fields are as per the below.
    productKey, firmwareId, and firmwareVersion: supports arithmetic operators “=” and “in”.
    type and status: supports arithmetic operator “=”.
    firmwareName: supports fuzzy inquiry of the specified language.
    firmwareName like ‘xxx’: fuzzy inquiry of the default name, Chinese name, and English name.
    firmwareName.default like ‘xxx’: fuzzy inquiry of the default name.
    firmwareName.zh_CN like ‘xxx’: fuzzy inquiry of the Chinese name. If no Chinese name exists, fuzzy inquiry of default name.
    firmwareName.en_US like ‘xxx’: fuzzy inquiry of the English name. If no English name exists, fuzzy inquiry of default name.*/

    private void searchBy (
                String accessKey,
                String secretKey,
                String orgId,
                String url,
                String exp)
    {
        SearchJobRequest request = new SearchJobRequest();
        request.setOrgId(orgId);

        request.setExpression(exp);

        Pagination pagination = new Pagination();
        pagination.setPageNo(1);
        pagination.setPageSize(5);

        request.setPagination(pagination);

        SearchJobResponse response = Poseidon
                .config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, SearchJobResponse.class);
    }

     public void searchOTAjob_productKey(
             String accessKey,
             String secretKey,
             String orgId,
             String url,
             String productKey)
     {
         //using '=' operator
         String exp_equals = "productKey='" + productKey + "'";
         //using 'in' operator
         String exp_in = "productKey in (\"" + productKey + "\")";

         searchBy(accessKey, secretKey, orgId, url, exp_equals);
         searchBy(accessKey, secretKey, orgId, url, exp_equals);
    }

    public void searchOTAjob_firmwareId(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String firmwareId)
    {
        //using '=' operator
        String exp_equals = "firmwareId='" + firmwareId + "'";
        //using 'in' operator
        String exp_in = "firmwareId in (\"" + firmwareId + "\")";

        searchBy(accessKey, secretKey, orgId, url, exp_equals);
        searchBy(accessKey, secretKey, orgId, url, exp_in);
    }

    public void searchOTAjob_firmwareVersion(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String firmwareVersion)
    {
        //using '=' operator
        String exp_equals = "firmwareVersion='" + firmwareVersion + "'";
        //using 'in' operator
        String exp_in = "firmwareVersion in (\"" + firmwareVersion + "\")";

        searchBy(accessKey, secretKey, orgId, url, exp_equals);
        searchBy(accessKey, secretKey, orgId, url, exp_in);
    }

    public void searchOTAjob_type(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String type)
    {
        // type should be either 'verify' or 'upgrade'

        //using '=' operator
        String exp_equals = "type='" + type + "'";

        searchBy(accessKey, secretKey, orgId, url, exp_equals);
    }


    public void searchOTAjob_status(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String status){

        // status should be either 'started' or 'stopped'

        //using '=' operator
        String exp_equals = "status='" + status + "'";

        searchBy(accessKey, secretKey, orgId, url, exp_equals);
    }

    public void searchOTAjob_defaultName(
            String accessKey,
            String secretKey,
            String orgId,
            String url)
    {
        //Using the 'like' operator
        //search using a full default product name
        String exp_like = "firmwareName.defaultValue like '" + "firmware_defaultName_1.2" + "'";
        //String exp_like = "firmwareName.defaultValue like '" + "firmware_defaultName_1.1" + "'";
        //search using a partial default product name
        String exp_like_fuzzy = "firmwareName.defaultValue like '" + "e_1.2" + "'";

        searchBy(accessKey, secretKey, orgId, url, exp_like);
        searchBy(accessKey, secretKey, orgId, url, exp_like_fuzzy);
    }

    public void searchOTAjob_localeName(
            String accessKey,
            String secretKey,
            String orgId,
            String url){

        //Using 'like' operators for matching partial locale device names
/*
        String exp_fuzzy_cn = "firmwareName.zh_CN like '" + "件_1.2" + "'";
        String exp_fuzzy_us = "firmwareName.en_US like '" + "mware_1.2" + "'";
        String exp_fuzzy_jp = "firmwareName.ja_JP like '" + "ア_1.2" + "'";
        String exp_fuzzy_es = "firmwareName.es_ES like '" + "o_1.2" + "'";
*/

        String exp_fuzzy_cn = "firmwareName like '" + "件_1.2" + "'";
        String exp_fuzzy_us = "firmwareName like '" + "mware_1.2" + "'";
        String exp_fuzzy_jp = "firmwareName like '" + "ア_1.2" + "'";
        String exp_fuzzy_es = "firmwareName like '" + "o_1.2" + "'";

        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_cn);
        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_us);
        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_jp);
        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_es);
    }


}
