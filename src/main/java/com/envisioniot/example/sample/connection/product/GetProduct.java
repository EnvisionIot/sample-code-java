/**
 * Copyright (C), 2015-2021, Envision
 * FileName: GetProduct
 * Author:  Arihant jain
 * Date:    26/12/21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.connection.product;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.product.GetProductRequest;
import com.envisioniot.enos.connect_service.v2_1.product.GetProductResponse;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/get_product.html  <br>
 * refer to the resources/ConnectionsServiceModels/Product/model_demo_smartbattery_model.json
 *
 * @author arihantjain97
 * @create 26/12/21
 * @since --
 */
public class GetProduct {

    public void getProduct(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String productKey)
    {
        GetProductRequest request = new GetProductRequest();
        request.setOrgId(orgId);
        request.setProductKey(productKey);

        GetProductResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, GetProductResponse.class);
    }

}
