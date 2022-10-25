/**
 * Copyright (C), 2015-2022, Envision
 * FileName: SearchCommand
 * Author:  Arihant jain
 * Date:    5/1/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.connection.devicedata;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.request.Pagination;
import com.envisioniot.enos.api.common.constant.request.Projection;
import com.envisioniot.enos.connect_service.v2_1.service.SearchCommandRequest;
import com.envisioniot.enos.connect_service.v2_1.service.SearchCommandResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/search_command.html  <br>
 * refer to the resources/ConnectionsServiceModels/DeviceData/model_demo_smartbattery_model_15.json
 * @author arihantjain97
 * @create 5/1/22
 * @since --
 */

public class SearchCommand {
    private void searchBy_keys(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String exp,
            String productKey,
            String deviceKey,
            ArrayList<String> ProjectionList)
    {
        SearchCommandRequest request = new SearchCommandRequest();
        request.setOrgId(orgId);
        request.setProductKey(productKey);
        request.setDeviceKey(deviceKey);
        request.setExpression(exp);
        request.setPagination(new Pagination(20, 1, null));

        Projection projection = new Projection();
        projection.addAll(ProjectionList);
        request.setProjection(projection);
        SearchCommandResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, SearchCommandResponse.class);
    }

    private void searchBy_assetId(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String exp,
            String assetId,
            ArrayList<String> ProjectionList)
    {
        SearchCommandRequest request = new SearchCommandRequest();
        request.setOrgId(orgId);
        request.setAssetId(assetId);
        request.setExpression(exp);
        request.setPagination(new Pagination(10, 1, null));

        Projection projection = new Projection();
        projection.addAll(ProjectionList);
        request.setProjection(projection);
        SearchCommandResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, SearchCommandResponse.class);
    }

    private String timeToUnix(String timeToConvert){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(timeToConvert);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return String.valueOf(date.getTime());
    }

    /*
    The query expression, which supports sql-like query. The fields that are supported for query include:
    state, commandName, and createTime. state: supports arithmetic operator “=”. commandName: supports fuzzy inquiry,
    where locale is mandatory, such as “commandName.zh_CN” or “commandName.en_US”. createTime: supports “>”, “=”,
    and “<” to specify the time range.
     */

    public void searchCommand_state_assetId(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String assetId)
    {
        // projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();

        // Setting the expression
        // note: The integer value assigned (range : 1-7) corresponds to a particular status.
        String exp = "state = 3";

        ProjectionList.add("commandId");

        // Use assetId to identify device (whose commands will be searched through)
        searchBy_assetId(accessKey, secretKey, orgId, url, exp, assetId, ProjectionList);


    }

    public void searchCommand_commandName_default_assetId(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String assetId)
    {
        // projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();

        // Setting the expression
        String exp_like = "commandName.default like \"temperature\"";
        // note: You can use fuzzy matching (partial matching of names)
        String exp_like_fuzzy = "commandName.default like \"temper\"";

        ProjectionList.add("commandId");

        // Use assetId to identify device (whose commands will be searched through)
        searchBy_assetId(accessKey, secretKey, orgId, url, exp_like, assetId, ProjectionList);
        searchBy_assetId(accessKey, secretKey, orgId, url, exp_like_fuzzy, assetId, ProjectionList);

    }

    public void searchCommand_commandName_locale_assetId(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String assetId)
    {
        // projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();

        // Setting the expression
        String exp_like_cn = "commandName.zh_CN like '" + "温度" + "'";
        String exp_like_us = "commandName.en_US like '" + "temperature" + "'";
        String exp_like_jp = "commandName.ja_JP like '" + "温度" + "'";
        String exp_like_es = "commandName.es_ES like '" +  "temperatura" + "'";

        // note: You can use fuzzy matching (partial matching of names)
        String exp_fuzzy_cn = "commandName.zh_CN like '" + "温" + "'";
        String exp_fuzzy_us = "commandName.en_US like '" + "temp" + "'";
        String exp_fuzzy_jp = "commandName.ja_JP like '" + "度" + "'";
        String exp_fuzzy_es = "commandName.es_ES like '" + "ratura" + "'";

        ProjectionList.add("commandId");

        // Use assetId to identify device (whose commands will be searched through)
        searchBy_assetId(accessKey, secretKey, orgId, url, exp_like_cn, assetId, ProjectionList);
        searchBy_assetId(accessKey, secretKey, orgId, url, exp_like_us, assetId, ProjectionList);
        searchBy_assetId(accessKey, secretKey, orgId, url, exp_like_jp, assetId, ProjectionList);
        searchBy_assetId(accessKey, secretKey, orgId, url, exp_like_es, assetId, ProjectionList);
        searchBy_assetId(accessKey, secretKey, orgId, url, exp_fuzzy_cn, assetId, ProjectionList);
        searchBy_assetId(accessKey, secretKey, orgId, url, exp_fuzzy_us, assetId, ProjectionList);
        searchBy_assetId(accessKey, secretKey, orgId, url, exp_fuzzy_jp, assetId, ProjectionList);
        searchBy_assetId(accessKey, secretKey, orgId, url, exp_fuzzy_es, assetId, ProjectionList);

    }


    public void searchCommand_createTime_assetId(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String assetId)
    {
        // projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();

        // Setting the expression
        String exp_moreThan = "createTime > \"2022-01-12 00:00:00\"";
        String exp_lessThan = "createTime < \"2022-01-12 12:13:25\"";
        String exp_equalsTo = "createTime = \"2022-01-12 12:13:25\"";
        String exp_moreThanEqualTo = "createTime >= \"2022-01-12 12:29:55\"";

        ProjectionList.add("commandId");

        // Use assetId to identify device (whose commands will be searched through)
        searchBy_assetId(accessKey, secretKey, orgId, url, exp_moreThan, assetId, ProjectionList);
        searchBy_assetId(accessKey, secretKey, orgId, url, exp_lessThan, assetId, ProjectionList);
        searchBy_assetId(accessKey, secretKey, orgId, url, exp_equalsTo, assetId, ProjectionList);
        searchBy_assetId(accessKey, secretKey, orgId, url, exp_moreThanEqualTo, assetId, ProjectionList);
    }

    public void searchCommand_state_Keys(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey,
            String deviceKey)
    {
        // projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();

        // Setting the expression
        // note: The integer value assigned (range : 1-7) corresponds to a particular status.
        String exp = "state = 5";

        ProjectionList.add("commandId");

        // Use productKey and deviceKey to identify device (whose commands will be searched through)
        // note: This is an alternative way of identifying the device
        searchBy_keys(accessKey, secretKey, orgId, url, exp, productKey, deviceKey, ProjectionList);
    }

    public void searchCommand_commandName_default_Keys(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey,
            String deviceKey)
    {
        // projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();

        // Setting the expression
        String exp_like = "commandName.default like \"temperature\"";
        // note: You can use fuzzy matching (partial matching of names)
        String exp_like_fuzzy = "commandName.default like \"temper\"";

        ProjectionList.add("commandId");

        // Use productKey and deviceKey to identify device (whose commands will be searched through)
        // note: This is an alternative way of identifying the device
        searchBy_keys(accessKey, secretKey, orgId, url, exp_like, productKey, deviceKey, ProjectionList);
        searchBy_keys(accessKey, secretKey, orgId, url, exp_like_fuzzy, productKey, deviceKey, ProjectionList);

    }

    public void searchCommand_commandName_locale_Keys(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey,
            String deviceKey)
    {
        // projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();

        // Setting the expression
        String exp_like_cn = "commandName.zh_CN like '" + "温度" + "'";
        String exp_like_us = "commandName.en_US like '" + "temperature" + "'";
        String exp_like_jp = "commandName.ja_JP like '" + "温度" + "'";
        String exp_like_es = "commandName.es_ES like '" +  "temperatura" + "'";

        // note: You can use fuzzy matching (partial matching of names)
        String exp_fuzzy_cn = "commandName.zh_CN like '" + "温" + "'";
        String exp_fuzzy_us = "commandName.en_US like '" + "temp" + "'";
        String exp_fuzzy_jp = "commandName.ja_JP like '" + "度" + "'";
        String exp_fuzzy_es = "commandName.es_ES like '" + "ratura" + "'";

        ProjectionList.add("commandId");

        // Use productKey and deviceKey to identify device (whose commands will be searched through)
        // note: This is an alternative way of identifying the device
        searchBy_keys(accessKey, secretKey, orgId, url, exp_like_cn, productKey, deviceKey, ProjectionList);
        searchBy_keys(accessKey, secretKey, orgId, url, exp_like_us, productKey, deviceKey, ProjectionList);
        searchBy_keys(accessKey, secretKey, orgId, url, exp_like_jp, productKey, deviceKey, ProjectionList);
        searchBy_keys(accessKey, secretKey, orgId, url, exp_like_es, productKey, deviceKey, ProjectionList);
        searchBy_keys(accessKey, secretKey, orgId, url, exp_fuzzy_cn, productKey, deviceKey, ProjectionList);
        searchBy_keys(accessKey, secretKey, orgId, url, exp_fuzzy_us, productKey, deviceKey, ProjectionList);
        searchBy_keys(accessKey, secretKey, orgId, url, exp_fuzzy_jp, productKey, deviceKey, ProjectionList);
        searchBy_keys(accessKey, secretKey, orgId, url, exp_fuzzy_es, productKey, deviceKey, ProjectionList);

    }


    public void searchCommand_createTime_Keys(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey,
            String deviceKey)
    {
        // projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();

        // Setting the expression
        // note: the value used in the expression is a UNIX timestamp. 1641968127060
        String exp_lessThan = "createTime < \"2022-01-12 12:13:25\"";
        String exp_moreThanEqualTo = "createTime >= \"2022-01-12 12:29:55\"";

        ProjectionList.add("commandId");

        // Use productKey and deviceKey to identify device (whose commands will be searched through)
        // note: This is an alternative way of identifying the device
        //searchBy_keys(accessKey, secretKey, orgId, url, exp_moreThan, productKey, deviceKey, ProjectionList);
        searchBy_keys(accessKey, secretKey, orgId, url, exp_lessThan, productKey, deviceKey, ProjectionList);
        //searchBy_keys(accessKey, secretKey, orgId, url, exp_equalsTo, productKey, deviceKey, ProjectionList);
        searchBy_keys(accessKey, secretKey, orgId, url, exp_moreThanEqualTo, productKey, deviceKey, ProjectionList);
    }

}
