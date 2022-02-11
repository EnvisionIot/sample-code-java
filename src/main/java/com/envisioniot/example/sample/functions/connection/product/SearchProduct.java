/**
 * Copyright (C), 2015-2021, Envision
 * FileName: SearchProduct
 * Author:  Arihant jain
 * Date:    26/12/21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.functions.connection.product;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.request.Pagination;
import com.envisioniot.enos.api.common.constant.request.Projection;
import com.envisioniot.enos.connect_service.v2_1.product.SearchProductRequest;
import com.envisioniot.enos.connect_service.v2_1.product.SearchProductResponse;

import java.util.ArrayList;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/search_product.html  <br>
 * refer to the resources/ConnectionsServiceModels/Product/model_demo_smartbattery_model.json
 *
 * @author arihantjain97
 * @create 26/12/21
 * @since --
 */

public class SearchProduct {

    // Setting the modelId where products will be created.
    private String modelId;

    public SearchProduct(String modelId){
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
        SearchProductRequest request = new SearchProductRequest();
        request.setOrgId(orgId);
        request.setExpression(exp);
        request.setPagination(new Pagination(20, 1, null));
        Projection projection = new Projection();

        projection.addAll(ProjectionList); //You can set other projection parameters here.
        request.setProjection(projection);
        SearchProductResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, SearchProductResponse.class);
    }

    //Search By modelId
    public void searchProduct_model (
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
        ProjectionList.add("productKey");
        ProjectionList.add("productName");

        searchBy(accessKey, secretKey, orgId, url, exp_equals, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_in, ProjectionList);

    }

    //Search By Product Key
    public void searchProduct_productKey(
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
        ProjectionList.add("productName");
        ProjectionList.add("modelId");

        searchBy(accessKey, secretKey, orgId, url, exp_equals, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_in, ProjectionList);

    }
    public void searchProduct_productTag(
            String accessKey,
            String secretKey,
            String orgId,
            String url)
    {
        //projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();

        //Searching using a single tag
        String exp_equals = "productTags.tag2= \"value6\"";
        String exp_exists = "exists(productTags.tag2)"; //Alternatively you can use 'not exists(exp)'
        //Searching using multiple tags
        String exp_and_equals = "productTags.tag1= \"value1\" and productTags.tag2= \"value2\"";
        String exp_and_exists = "exists(productTags.tag1) and exists(productTags.tag2)";
        String exp_or_equals = "productTags.tag1= \"value1\" or productTags.tag1= \"value3\"";
        String exp_or_exists = "exists(productTags.tag1) or exists(productTags.tag3)";
        //Combined Expressions
            //combine logical operators
        String exp_combined_logical = "(productTags.tag1= \"value1\" and productTags.tag2= \"value2\") " +
                "or (productTags.tag1= \"value3\")";
            //limit scope of search to a particular model
        String exp_combined_limit = "modelId= \"" + modelId + "\" and exists(productTags.tag2)";

        //adding projection parameters
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

    public void searchProduct_productName_default(
            String accessKey,
            String secretKey,
            String orgId,
            String url)
    {
        //projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();

        //Using the 'like' operator
        //search using a full default product name
        String exp_like = "productName.default like '" + "YourProductName_productName_locale" + "'";
        //search using a partial default product name
        String exp_like_fuzzy = "productName.default like '" + "YourProductName_productName" + "'";

        //adding projection parameters
        ProjectionList.add("productKey");

        searchBy(accessKey, secretKey, orgId, url, exp_like, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_like_fuzzy, ProjectionList);

    }

    public void searchProduct_productName_locale(String accessKey,
            String secretKey,
            String orgId,
            String url)
    {
        //projection parameters
        ArrayList<String> ProjectionList = new ArrayList<>();

        //Using 'like' operators for matching partial locale product names
        String exp_fuzzy_cn = "productName.zh_CN like '" + "您的" + "'";
        String exp_fuzzy_us = "productName.en_US like '" + "your produc" + "'";
        String exp_fuzzy_jp = "productName.ja_JP like '" + "あなた" + "'";
        String exp_fuzzy_es = "productName.es_ES like '" + "el nombre de" + "'";

        //adding projection parameters
        ProjectionList.add("productKey");

        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_cn, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_us, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_jp, ProjectionList);
        searchBy(accessKey, secretKey, orgId, url, exp_fuzzy_es, ProjectionList);

    }

}
