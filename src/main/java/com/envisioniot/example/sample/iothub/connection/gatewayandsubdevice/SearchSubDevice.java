/**
 * Copyright (C), 2015-2022, Envision
 * FileName: SearchSubDevice
 * Author:  Arihant jain
 * Date:    4/1/22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.iothub.connection.gatewayandsubdevice;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.request.Pagination;
import com.envisioniot.enos.api.common.constant.request.Projection;
import com.envisioniot.enos.connect_service.v2_1.device.topo.SearchSubDeviceRequest;
import com.envisioniot.enos.connect_service.v2_1.device.topo.SearchSubDeviceResponse;
import com.envisioniot.enos.connect_service.vo.DeviceIdentifier;

import java.util.ArrayList;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/search_sub_device.html  <br>
 * refer to the resources/ConnectionsServiceModels/Topo/model_demo_smartbattery_model_15.json
 *
 * @author arihantjain97
 * @create 4/1/22
 * @since --
 */

public class SearchSubDevice {

    //A general method which takes in a valid expression
    private void searchBy(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String exp,
            String gatewayAssetId,
            ArrayList<String> ProjectionList) {
        SearchSubDeviceRequest request = new SearchSubDeviceRequest();
        request.setOrgId(orgId);
        request.setGateway(new DeviceIdentifier(gatewayAssetId));
        request.setExpression(exp);

        Projection projection = new Projection();
        projection.addAll(ProjectionList); //You can set other projection parameters here.
        request.setProjection(projection);

        request.setPagination(new Pagination(20, 1, null));

        SearchSubDeviceResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, SearchSubDeviceResponse.class);
    }

    //A general method which takes in a valid expression
    private void searchBy(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String exp,
            String gatewayProductKey,
            String gatewayDeviceKey,
            ArrayList<String> ProjectionList) {
        SearchSubDeviceRequest request = new SearchSubDeviceRequest();
        request.setOrgId(orgId);
        request.setGateway(new DeviceIdentifier(gatewayProductKey,gatewayDeviceKey));
        request.setExpression(exp);

        Projection projection = new Projection();
        projection.addAll(ProjectionList); //You can set other projection parameters here.
        request.setProjection(projection);

        request.setPagination(new Pagination(20, 1, null));

        SearchSubDeviceResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, SearchSubDeviceResponse.class);
    }

    // modelId
    public void searchSubDevice_model(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String modelId,
            String gatewayAssetId,
            String gatewayProductKey,
            String gatewayDeviceKey) {

        //projection parameters.
        ArrayList<String> ProjectionList = new ArrayList<>();
        //using '=' operator.
        String exp_equals = "modelId='" + modelId + "'";
        //using 'in' operator.
        String exp_in = "modelId in (\"" + modelId + "\")";
        //adding projection parameters.
        ProjectionList.add("deviceName");
        ProjectionList.add("modelId");

        searchBy(accessKey, secretKey, orgId, url, exp_equals, gatewayAssetId, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_in, gatewayAssetId, ProjectionList);

        searchBy(accessKey, secretKey, orgId, url, exp_equals, gatewayProductKey,gatewayDeviceKey, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_in, gatewayProductKey,gatewayDeviceKey, ProjectionList);


    }

    // deviceAttributes
    public void searchSubDevice_deviceAttributes(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String gatewayAssetId,
            String gatewayProductKey,
            String gatewayDeviceKey) {
        // deviceAttributeName of attribute to be used in search expression.
        String deviceAttributeName = "brand";
        // deviceAttributeValue of attribute to be used in search expression.
        String deviceAttributeValue = "brand_attribute_value";
        //projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();
        //using '=' operator
        String exp_equals = "deviceAttributes." + deviceAttributeName + " =" + "'" + deviceAttributeValue + "'";
        //using 'in' operator
        String exp_in = "deviceAttributes." + deviceAttributeName + " in" + "(\"" + deviceAttributeValue + "\")";
        //using 'exists' operator (alternatively you can use 'not exists')
        String exp_exists = "exists(" + "deviceAttributes." + deviceAttributeName + ")";
        //adding projection parameters
        ProjectionList.add("deviceName");

        searchBy(accessKey, secretKey, orgId, url, exp_equals, gatewayAssetId, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_in, gatewayAssetId, ProjectionList);

        searchBy(accessKey, secretKey, orgId, url, exp_equals, gatewayProductKey, gatewayDeviceKey, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_in, gatewayProductKey, gatewayDeviceKey, ProjectionList);

    }
    // deviceTags
    public void searchSubDevice_deviceTags(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String gatewayAssetId,
            String gatewayProductKey,
            String gatewayDeviceKey)
    {
        // Searching using a single tag
        String exp_equals = "deviceTags.tag2= \"value2\"";
        String exp_exists = "exists(deviceTags.tag2)"; //Alternatively you can use 'not exists(exp)'
        // Searching using multiple tags
        String exp_and_equals = "deviceTags.tag1= \"value1\" and deviceTags.tag2= \"value2\"";
        String exp_and_exists = "exists(deviceTags.tag1) and exists(deviceTags.tag2)";
        String exp_or_equals = "deviceTags.tag1= \"value1\" or deviceTags.tag1= \"value3\"";
        String exp_or_exists = "exists(deviceTags.tag1) or exists(deviceTags.tag2)";
        // Combined Expressions
        // combine logical operators
        String exp_combined_logical = "(deviceTags.tag1= \"value1\" and deviceTags.tag2= \"value2\") " +
                "or (deviceTags.tag1= \"value3\")";
        // limit scope of search to a particular model
        String exp_combined_limit = "modelId= \"demo_smartbattery_model_15\" and exists(deviceTags.tag2)";
        // projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();
        // adding projection parameters
        ProjectionList.add("deviceName");


        searchBy(accessKey, secretKey, orgId, url, exp_equals, gatewayAssetId, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_exists, gatewayAssetId,ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_and_equals, gatewayAssetId,ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_and_exists, gatewayAssetId,ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_or_equals, gatewayAssetId,ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_or_exists, gatewayAssetId,ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_combined_logical, gatewayAssetId, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_combined_limit, gatewayAssetId,ProjectionList);



        searchBy(accessKey, secretKey, orgId, url, exp_equals, gatewayProductKey, gatewayDeviceKey , ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_exists, gatewayProductKey, gatewayDeviceKey ,ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_and_equals, gatewayProductKey, gatewayDeviceKey ,ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_and_exists, gatewayProductKey, gatewayDeviceKey ,ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_or_equals, gatewayProductKey, gatewayDeviceKey ,ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_or_exists, gatewayProductKey, gatewayDeviceKey ,ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_combined_logical, gatewayProductKey, gatewayDeviceKey , ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_combined_limit, gatewayProductKey, gatewayDeviceKey ,ProjectionList);
    }
    // productKey
    public void searchSubDevice_productKey(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String gatewayAssetId,
            String gatewayProductKey,
            String gatewayDeviceKey,
            String subDeviceProductKey)
    {
        // projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();
        // using '=' operator
        String exp_equals = "productKey='" + subDeviceProductKey + "'";
        // using 'in' operator
        String exp_in = "productKey in (\"" + subDeviceProductKey + "\")";
        // adding projection parameters
        ProjectionList.add("deviceName");
        ProjectionList.add("productKey");

        searchBy(accessKey, secretKey, orgId, url, exp_equals, gatewayAssetId, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_in, gatewayAssetId, ProjectionList);

        searchBy(accessKey, secretKey, orgId, url, exp_equals, gatewayProductKey, gatewayDeviceKey, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_in, gatewayProductKey, gatewayDeviceKey, ProjectionList);

    }
    // deviceKey
    public void searchSubDevice_deviceKey(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String gatewayAssetId,
            String gatewayProductKey,
            String gatewayDeviceKey,
            String subDeviceKey)
    {
        // projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();
        // using '=' operator
        String exp_equals = "deviceKey='" + subDeviceKey + "'";
        // using 'in' operator
        String exp_in = "deviceKey in (\"" + subDeviceKey + "\")";
        // adding projection parameters
        ProjectionList.add("deviceName");
        ProjectionList.add("deviceKey");

        searchBy(accessKey, secretKey, orgId, url, exp_equals, gatewayAssetId, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_in, gatewayAssetId, ProjectionList);

        searchBy(accessKey, secretKey, orgId, url, exp_equals, gatewayProductKey, gatewayDeviceKey, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_in, gatewayProductKey, gatewayDeviceKey, ProjectionList);

    }
    // assetId
    //search by assetId
    public void searchSubDevice_assetId(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String gatewayAssetId,
            String gatewayProductKey,
            String gatewayDeviceKey,
            String subDeviceAssetId)
    {
        // projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();
        // using '=' operator
        String exp_equals = "assetId='" + subDeviceAssetId + "'";
        // using 'in' operator
        String exp_in = "assetId in (\"" + subDeviceAssetId + "\")";
        // adding projection parameters
        ProjectionList.add("assetId");
        ProjectionList.add("deviceName");

        searchBy(accessKey, secretKey, orgId, url, exp_equals, gatewayAssetId, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_in, gatewayAssetId, ProjectionList);

        searchBy(accessKey, secretKey, orgId, url, exp_equals, gatewayProductKey, gatewayDeviceKey, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_in, gatewayProductKey, gatewayDeviceKey, ProjectionList);
    }
    // deviceName
    public void searchSubDevice_deviceName_default(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String gatewayAssetId,
            String gatewayProductKey,
            String gatewayDeviceKey)
    {

        //projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();
        //Using the 'like' operator
        //search using a full default product name
        String exp_like = "deviceName.default like '" + "yourDefaultDeviceName_optionalParameters" + "'";
        //search using a partial default product name
        String exp_like_fuzzy = "deviceName.default like '" + "alParameters" + "'";
        //adding projection parameters
        ProjectionList.add("deviceName");
        ProjectionList.add("assetId");

        searchBy(accessKey, secretKey, orgId, url, exp_like, gatewayAssetId, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_like_fuzzy, gatewayAssetId, ProjectionList);

        searchBy(accessKey, secretKey, orgId, url, exp_like, gatewayProductKey, gatewayDeviceKey, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_like_fuzzy, gatewayProductKey, gatewayDeviceKey, ProjectionList);

    }

    public void searchSubDevice_deviceName_locale(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String gatewayAssetId,
            String gatewayProductKey,
            String gatewayDeviceKey)
    {
        //projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();
        //Using 'like' operators for matching partial locale device names
        String exp_fuzzy_cn = "deviceName.zh_CN like '" + "备" + "'";
        String exp_fuzzy_us = "deviceName.en_US like '" + "device" + "'";
        String exp_fuzzy_jp = "deviceName.ja_JP like '" + "名" + "'";
        String exp_fuzzy_es = "deviceName.es_ES like '" + "dispositivo" + "'";
        //adding projection parameters
        ProjectionList.add("assetId");
        ProjectionList.add("deviceName");

        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_cn, gatewayAssetId, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_us, gatewayAssetId, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_jp, gatewayAssetId, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_es, gatewayAssetId, ProjectionList);

        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_cn, gatewayProductKey, gatewayDeviceKey, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_us, gatewayProductKey, gatewayDeviceKey, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_jp, gatewayProductKey, gatewayDeviceKey, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_es, gatewayProductKey, gatewayDeviceKey, ProjectionList);

    }
    // status
    //search by status
    public void searchSubDevice_status(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String gatewayAssetId,
            String gatewayProductKey,
            String gatewayDeviceKey)
    {
        String status = "inactive";
        //projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();
        //using '=' operator
        String exp_equals = "status='" + status + "'";
        //adding projection parameters
        ProjectionList.add("assetId");
        ProjectionList.add("deviceName");
        ProjectionList.add("productName");
        ProjectionList.add("modelId");

        searchBy(accessKey, secretKey, orgId, url, exp_equals, gatewayAssetId, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_equals, gatewayProductKey, gatewayDeviceKey, ProjectionList);
    }
}