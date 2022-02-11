/**
 * Copyright (C), 2015-2021, Envision
 * FileName: UpdateProduct
 * Author:  Arihant jain
 * Date:    26/12/21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.functions.connection.product;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.common.StringI18n;
import com.envisioniot.enos.connect_service.v2_1.product.UpdateProductRequset;
import com.envisioniot.enos.connect_service.v2_1.product.UpdateProductResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * https:// support.envisioniot.com/docs/connection-api/en/2.3.0/update_product.html  <br>
 * refer to the resources/ConnectionsServiceModels/Product/model_demo_smartbattery_model.json
 *
 * @author arihantjain97
 * @create 28/12/21
 * @since --
 */

public class UpdateProduct {
    
    private void productResponse(
            String accessKey,
            String secretKey,
            String url,
            UpdateProductRequset request)
    {
        UpdateProductResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, UpdateProductResponse.class);
    }

    public void updateProduct_productDesc(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey)
    {
        UpdateProductRequset request = new UpdateProductRequset();
        // Identify product to update
        request.setOrgId(orgId);
        request.setProductKey(productKey);

        // Update product
        request.setProductDesc("Updated Description Here");

        // Send request to update a product.
        productResponse(accessKey, secretKey, url, request);
    }

    public void updateProduct_biDirectionalAuth(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey)
    {
        UpdateProductRequset request = new UpdateProductRequset();
        // Identify product to update
        request.setOrgId(orgId);
        request.setProductKey(productKey);

        // Update product
        request.setBiDirectionalAuth(true); // Alternatively, you can set biDirectionalAuth to 'false'

        // Send request to update a product.
        productResponse(accessKey, secretKey, url, request);
    }

    public void updateProduct_dynamicActivateEnabled(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey)
    {
        UpdateProductRequset request = new UpdateProductRequset();
        // Identify product to update
        request.setOrgId(orgId);
        request.setProductKey(productKey);

        // Update product
        request.setDynamicActivateEnabled(true); // Alternatively, you can set DynamicActivateEnabled to 'false'

        // Send request to update a product.
        productResponse(accessKey, secretKey, url, request);
    }

    public void updateProduct_productName(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey)
    {
        UpdateProductRequset request = new UpdateProductRequset();
        // Identify product to update
        request.setOrgId(orgId);
        request.setProductKey(productKey);

        // Update product
        StringI18n productName = new StringI18n("YourProductName_UPDATED");
        request.setProductName(productName);

        // Send request to update a product.
        productResponse(accessKey, secretKey, url, request);
    }

    public void updateProduct_productTags(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey)
    {
        UpdateProductRequset request = new UpdateProductRequset();
        // Identify product to update
        request.setOrgId(orgId);
        request.setProductKey(productKey);

        // Update product
        Map<String, String> tagMap = new HashMap<>();
        tagMap.put("tag_update_1","value_updated_1");
        tagMap.put("tag_updated_2","value_updated_2");
        request.setProductTags(tagMap);

        // Send request to update a product.
        productResponse(accessKey, secretKey, url, request);
    }

    public void updateProduct_defaultValidDay(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey)
    {
        UpdateProductRequset request = new UpdateProductRequset();
        // Identify product to update
        request.setOrgId(orgId);
        request.setProductKey(productKey);

        // Update product
        request.setDefaultValidDay(8);

        // Send request to update a product.
        productResponse(accessKey, secretKey, url, request);
    }

    public void updateProduct_maxValidDay(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey)
    {
        UpdateProductRequset request = new UpdateProductRequset();
        // Identify product to update
        request.setOrgId(orgId);
        request.setProductKey(productKey);

        // Update product
        request.setMaxValidDay(3650);

        // Send request to update a product.
        productResponse(accessKey, secretKey, url, request);
    }

}
