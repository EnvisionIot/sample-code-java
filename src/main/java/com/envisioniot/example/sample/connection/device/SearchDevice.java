/**
 * Copyright (C), 2015-2021, Envision
 * FileName: SearchDevice
 * Author:  Arihant jain
 * Date:    30/12/21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.connection.device;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.request.Pagination;
import com.envisioniot.enos.api.common.constant.request.Projection;
import com.envisioniot.enos.connect_service.v2_1.device.SearchDeviceRequest;
import com.envisioniot.enos.connect_service.v2_1.device.SearchDeviceResponse;
;

import java.util.ArrayList;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/replace_device.html  <br>
 * refer to the resources/ConnectionsServiceModels/Device/model_demo_smartbattery_model.json
 *
 * @author arihantjain97
 * @create 30/12/21
 * @since --
 */

public class SearchDevice {
    private String modelId;
    
    public SearchDevice(String modelId){
        this.modelId = modelId;
    }
    //A general method which takes in a valid expression
    private void searchBy (
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String exp,
            ArrayList<String> ProjectionList)
    {
        SearchDeviceRequest request = new SearchDeviceRequest();
        request.setOrgId(orgId);
        request.setExpression(exp);
        request.setPagination(new Pagination(20, 1, null));
        Projection projection = new Projection();

        projection.addAll(ProjectionList); //You can set other projection parameters here.
        request.setProjection(projection);
        SearchDeviceResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, SearchDeviceResponse.class);
    }

    //search by modelId
    public void searchDevice_model (
            String accessKey,
            String secretKey,
            String orgId,
            String url)
    {
        //projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();

        //using '=' operator
        String exp_equals = "modelId='" + modelId + "'";
        //using 'in' operator
        String exp_in = "modelId in (\"" + modelId + "\")";
        //adding projection parameters
        ProjectionList.add("assetId");
        ProjectionList.add("deviceName");
        ProjectionList.add("productName");
        ProjectionList.add("modelId");

        searchBy(accessKey, secretKey, orgId, url, exp_equals, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_in, ProjectionList);

    }
    //search by deviceAttributes
    public void searchDevice_deviceAttributes(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String deviceAttributeName,
            String deviceAttributeValue)
    {
        //projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();

        //using '=' operator
        String exp_equals = "deviceAttributes." + deviceAttributeName + " =" + "'" + deviceAttributeValue + "'";
        //using 'in' operator
        String exp_in = "deviceAttributes." + deviceAttributeName +  " in" + "(\"" + deviceAttributeValue + "\")";
        //using 'exists' operator (alternatively you can use 'not exists')
        String exp_exists = "exists(" + "deviceAttributes." + deviceAttributeName + ")";
        //adding projection parameters
        ProjectionList.add("assetId");
        ProjectionList.add("deviceName");
        ProjectionList.add("productName");
        ProjectionList.add("modelId");

        searchBy(accessKey, secretKey, orgId, url, exp_equals, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_in, ProjectionList);

    }

    //search by deviceTags
    public void searchDevice_deviceTags(
            String accessKey,
            String secretKey,
            String orgId,
            String url)
    {
        //projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();

        //Searching using a single tag
        String exp_equals = "deviceTags.tag2= \"value2\"";
        String exp_exists = "exists(deviceTags.tag2)"; //Alternatively you can use 'not exists(exp)'
        //Searching using multiple tags
        String exp_and_equals = "deviceTags.tag1= \"value1\" and deviceTags.tag2= \"value2\"";
        String exp_and_exists = "exists(deviceTags.tag1) and exists(deviceTags.tag2)";
        String exp_or_equals = "deviceTags.tag1= \"value1\" or deviceTags.tag1= \"value3\"";
        String exp_or_exists = "exists(deviceTags.tag1) or exists(deviceTags.tag3)";
        //Combined Expressions
        //combine logical operators
        String exp_combined_logical = "(deviceTags.tag1= \"value1\" and deviceTags.tag2= \"value2\") " +
                "or (deviceTags.tag1= \"value3\")";
        //limit scope of search to a particular model
        String exp_combined_limit = "modelId= \"" + modelId + "\" and exists(deviceTags.tag2)";

        //adding projection parameters
        ProjectionList.add("assetId");
        ProjectionList.add("deviceName");
        ProjectionList.add("productName");
        ProjectionList.add("modelId");

        searchBy(accessKey, secretKey, orgId, url, exp_equals, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_exists, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_and_equals, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_and_exists, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_or_equals, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_or_exists, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_combined_logical, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_combined_limit, ProjectionList);

    }
    //search by productKey
    public void searchDevice_productKey(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey)
    {
        //projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();

        //using '=' operator
        String exp_equals = "productKey='" + productKey + "'";
        //using 'in' operator
        String exp_in = "productKey in (\"" + productKey + "\")";
        //adding projection parameters
        ProjectionList.add("assetId");
        ProjectionList.add("deviceName");
        ProjectionList.add("productName");
        ProjectionList.add("modelId");

        searchBy(accessKey, secretKey, orgId, url, exp_equals, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_in, ProjectionList);

    }
    //search by deviceKey
    public void searchDevice_deviceKey(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String deviceKey)
    {
        //projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();

        //using '=' operator
        String exp_equals = "deviceKey='" + deviceKey + "'";
        //using 'in' operator
        String exp_in = "deviceKey in (\"" + deviceKey + "\")";
        //adding projection parameters
        ProjectionList.add("assetId");
        ProjectionList.add("deviceName");
        ProjectionList.add("productName");
        ProjectionList.add("modelId");

        searchBy(accessKey, secretKey, orgId, url, exp_equals, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_in, ProjectionList);

    }
    //search by assetId
    public void searchDevice_assetId(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String assetId)
    {
        //projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();

        //using '=' operator
        String exp_equals = "assetId='" + assetId + "'";
        //using 'in' operator
        String exp_in = "assetId in (\"" + assetId + "\")";
        //adding projection parameters
        ProjectionList.add("assetId");
        ProjectionList.add("deviceName");
        ProjectionList.add("productName");
        ProjectionList.add("modelId");

        searchBy(accessKey, secretKey, orgId, url, exp_equals, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_in, ProjectionList);

    }
    //search by productType
    public void searchDevice_productType(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productType)
    {
        //projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();

        //using '=' operator
        String exp_equals = "productType='" + productType + "'" + "and modelId= \"" + modelId + "\"";
        //adding projection parameters
        ProjectionList.add("assetId");
        ProjectionList.add("deviceName");
        ProjectionList.add("productName");
        ProjectionList.add("modelId");

        searchBy(accessKey, secretKey, orgId, url, exp_equals, ProjectionList);

    }
    //search by firmwareVersion
    public void searchDevice_firmwareVersion(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String firmwareVersion)
    {
        //projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();

        //using '=' operator
        String exp_equals = "firmwareVersion='" + firmwareVersion + "'"+ "and modelId= \"" + modelId + "\"";;
        //using 'in' operator
        String exp_in = "firmwareVersion in (\"" + firmwareVersion + "\")"+ "and modelId= \"" + modelId + "\"";;
        //adding projection parameters
        ProjectionList.add("assetId");
        ProjectionList.add("deviceName");
        ProjectionList.add("productName");
        ProjectionList.add("modelId");

        searchBy(accessKey, secretKey, orgId, url, exp_equals, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_in, ProjectionList);

    }
    //search by deviceName
    public void searchDevice_deviceName_default(
            String accessKey,
            String secretKey,
            String orgId,
            String url)
    {
        //projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();

        //Using the 'like' operator
        //search using a full default product name
        String exp_like = "deviceName.default like '" + "yourDefaultDeviceName" + "'";
        //search using a partial default product name
        String exp_like_fuzzy = "deviceName.default like '" + "DefaultDevice" + "'";

        //adding projection parameters
        ProjectionList.add("assetId");
        ProjectionList.add("deviceName");
        ProjectionList.add("productName");
        ProjectionList.add("modelId");

        searchBy(accessKey, secretKey, orgId, url, exp_like, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_like_fuzzy, ProjectionList);

    }

    public void searchDevice_deviceName_locale(
            String accessKey,
            String secretKey,
            String orgId,
            String url)
    {
        //projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();

        //Using 'like' operators for matching partial locale device names
        String exp_fuzzy_cn = "deviceName.zh_CN like '" + "备名称" + "'";
        String exp_fuzzy_us = "deviceName.en_US like '" + "device name" + "'";
        String exp_fuzzy_jp = "deviceName.ja_JP like '" + "置名" + "'";
        String exp_fuzzy_es = "deviceName.es_ES like '" + "del dispositivo" + "'";

        //adding projection parameters
        ProjectionList.add("assetId");
        ProjectionList.add("deviceName");
        ProjectionList.add("productName");
        ProjectionList.add("modelId");

        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_cn, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_us, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_jp, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_es, ProjectionList);

    }
    //search by status
    public void searchDevice_status(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String status)
    {
        //projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();

        //using '=' operator
        String exp_equals = "status='" + status + "'";

        //adding projection parameters
        ProjectionList.add("assetId");
        ProjectionList.add("deviceName");
        ProjectionList.add("productName");
        ProjectionList.add("modelId");

        searchBy(accessKey, secretKey, orgId, url, exp_equals, ProjectionList);
    }

}
