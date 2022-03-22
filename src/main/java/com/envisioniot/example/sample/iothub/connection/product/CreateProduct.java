/**
 * Copyright (C), 2015-2021, Envision
 * FileName: CreateProduct
 * Author:  Arihant jain
 * Date:    23/12/21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.iothub.connection.product;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.common.StringI18n;
import com.envisioniot.enos.connect_service.v2_1.product.CreateProductRequest;
import com.envisioniot.enos.connect_service.v2_1.product.CreateProductResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/create_product.html  <br>
 * refer to the resources/ConnectionsServiceModels/Product/model_demo_smartbattery_model.json
 *
 * @author arihantjain97
 * @create 23/12/21
 * @since --
 */

public class CreateProduct {
    
    // Setting the modelId where products will be created.
    private String modelId;

    public CreateProduct(String modelId){
        this.modelId = modelId;
    }

    private String productResponse(
            String accessKey,
            String secretKey,
            String url,
            CreateProductRequest request)
    {
        CreateProductResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, CreateProductResponse.class);
        return response.getData();
    }

    public String createProduct(
            String accessKey,
            String secretKey,
            String orgId,
            String url)
    {
        // Creating the request.
        CreateProductRequest request = new CreateProductRequest();
        
        // Setting the organisation, and product details.
        request.setOrgId(orgId);
        StringI18n productName = new StringI18n("YourProductName");
        request.setProductName(productName);
        request.setProductDesc("YourProductDesc");
        request.setBiDirectionalAuth(false);
        request.setDataFormat("Json");
        request.setProductType("Device");
        request.setModelId(modelId);

        // Send request to create a product, return its productKey.
        return productResponse(accessKey, secretKey, url, request);
    }

    //bidirectional authorisation
    public String createProduct_bidirectional_Auth(
            String accessKey,
            String secretKey,
            String orgId,
            String url)
    {
        // Creating the request.        
        CreateProductRequest request = new CreateProductRequest();
        
        // Setting the organisation, and product details
        request.setOrgId(orgId);
        StringI18n productName = new StringI18n("YourProductName_bidirectional_Auth");
        request.setProductName(productName);
        request.setProductDesc("YourProductDesc");
        request.setBiDirectionalAuth(true);
        request.setDataFormat("Json");
        request.setProductType("Device");
        request.setModelId(modelId);

        // Send request to create a product, return its productKey.
        return productResponse(accessKey, secretKey, url, request);
    }
    
    //dataFormat: custom
    public String createProduct_dataFormat_custom(
            String accessKey,
            String secretKey,
            String orgId,
            String url)
            
    {
        // Creating the request.        
        CreateProductRequest request = new CreateProductRequest();
        
        // Setting the organisation, and product details
        request.setOrgId(orgId);
        StringI18n productName = new StringI18n("YourProductName_dataFormat_custom");
        request.setProductName(productName);
        request.setProductDesc("YourProductDesc");
        request.setBiDirectionalAuth(false);
        request.setDataFormat("Custom");
        request.setProductType("Device");
        request.setModelId(modelId);

        // Send request to create a product, return its productKey.
        return productResponse(accessKey, secretKey, url, request);
    }

    //productName: Locale
    public String createProduct_productName_locale(String accessKey, String secretKey, String orgId, String url)  {
        // Creating the request.        
        CreateProductRequest request = new CreateProductRequest();
        Map<String, String> nameMap = new HashMap<>();
        nameMap.put("zh_CN","您的产品名称");
        nameMap.put("en_US","your product's name");
        nameMap.put("ja_JP", "あなたの製品の名前");
        nameMap.put("es_ES", "el nombre de tu producto");
        
        // Setting the organisation, and product details
        request.setOrgId(orgId);
        StringI18n productName = new StringI18n("YourProductName_productName_locale");
        productName.setI18nValue(nameMap);
        request.setProductName(productName);
        request.setProductDesc("YourProductDesc");
        request.setBiDirectionalAuth(false);
        request.setDataFormat("Json");
        request.setProductType("Device");
        request.setModelId(modelId);

        // Send request to create a product, return its productKey.
        return productResponse(accessKey, secretKey, url, request);
    }

    //productType: gateway
    public String createProduct_productType_gateway(
            String accessKey,
            String secretKey,
            String orgId,
            String url)
            
    {
        // Creating the request.        
        CreateProductRequest request = new CreateProductRequest();
        
        // Setting the organisation, and product details
        request.setOrgId(orgId);
        StringI18n productName = new StringI18n("YourProductName_productType_gateway");
        request.setProductName(productName);
        request.setProductDesc("YourProductDesc");
        request.setBiDirectionalAuth(false);
        request.setDataFormat("Json");
        request.setProductType("Gateway");
        request.setModelId(modelId);

        // Send request to create a product, return its productKey.
        return productResponse(accessKey, secretKey, url, request);
    }

    //dynamicActivateEnabled: true
    public String createProduct_dynamicActivateEnabled(
            String accessKey,
            String secretKey,
            String orgId,
            String url)
            
    {
        // Creating the request.        
        CreateProductRequest request = new CreateProductRequest();
        
        // Setting the organisation, and product details
        request.setOrgId(orgId);
        StringI18n productName = new StringI18n("YourProductName_dynamicActivateEnabled");
        request.setProductName(productName);
        request.setProductDesc("YourProductDesc");
        request.setBiDirectionalAuth(false);
        request.setDataFormat("Json");
        request.setProductType("Device");
        request.setModelId(modelId);
        request.setDynamicActivateEnabled(true);

        // Send request to create a product, return its productKey.
        return productResponse(accessKey, secretKey, url, request);
    }

    //productTags
    public String createProduct_productTags(
            String accessKey,
            String secretKey,
            String orgId,
            String url)
    {
        // Creating the request.        
        CreateProductRequest request = new CreateProductRequest();

        //  A map with the key-value pair being (tag's name, tag's value).
        Map<String, String> TagMap = new HashMap<>();
        TagMap.put("tag1","value1");
        TagMap.put("tag2","value2");

        // Setting the organisation, and product details
        request.setOrgId(orgId);
        StringI18n productName = new StringI18n("YourProductName_productTags");
        request.setProductName(productName);
        request.setProductDesc("YourProductDesc");
        request.setBiDirectionalAuth(false);
        request.setDataFormat("Json");
        request.setProductType("Device");
        request.setModelId(modelId);
        request.setProductTags(TagMap);

        // Send request to create a product, return its productKey.
        return productResponse(accessKey, secretKey, url, request);
    }

    //overloaded method, to create product with custom tags.
    public String createProduct_productTags(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            Map<String,String> TagMap)
    {
        // Creating the request.        
        CreateProductRequest request = new CreateProductRequest();
        
        // Setting the organisation, and product details
        request.setOrgId(orgId);
        StringI18n productName = new StringI18n("YourProductName_custom_productTags");
        request.setProductName(productName);
        request.setProductDesc("YourProductDesc");
        request.setBiDirectionalAuth(false);
        request.setDataFormat("Json");
        request.setProductType("Device");
        request.setModelId(modelId);
        request.setProductTags(TagMap);

        // Send request to create a product, return its productKey.
        return productResponse(accessKey, secretKey, url, request);
    }

    //defaultValidDay
    public String createProduct_defaultValidDay(
            String accessKey,
            String secretKey,
            String orgId,
            String url)
            
    {
        // Creating the request.        
        CreateProductRequest request = new CreateProductRequest();
        
        // Setting the organisation, and product details
        request.setOrgId(orgId);
        StringI18n productName = new StringI18n("YourProductName_defaultValidDay");
        request.setProductName(productName);
        request.setProductDesc("YourProductDesc");
        request.setBiDirectionalAuth(false);
        request.setDataFormat("Json");
        request.setProductType("Device");
        request.setModelId(modelId);
        request.setDefaultValidDay(800);

        // Send request to create a product, return its productKey.
        return productResponse(accessKey, secretKey, url, request);
    }

    //maxValidDay
    public String createProduct_maxValidDay(
            String accessKey,
            String secretKey,
            String orgId,
            String url)
            
    {
        // Creating the request.        
        CreateProductRequest request = new CreateProductRequest();
        
        // Setting the organisation, and product details
        request.setOrgId(orgId);
        StringI18n productName = new StringI18n("YourProductName_maxValidDay");
        request.setProductName(productName);
        request.setProductDesc("YourProductDesc");
        request.setBiDirectionalAuth(false);
        request.setDataFormat("Json");
        request.setProductType("Device");
        request.setModelId(modelId);
        request.setMaxValidDay(2000);

        // Send request to create a product, return its productKey.
        return productResponse(accessKey, secretKey, url, request);
    }

}
