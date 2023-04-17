/**
 * Copyright (C), 2015-2021, Envision
 * FileName: DeleteProduct
 * Author:  Arihant jain
 * Date:    23/12/21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */

package com.envisioniot.example.sample.connection.product;

/**
 * https://support.envisioniot.com/docs/connection-api/en/2.3.0/delete_product.html  <br>
 * refer to the resources/ConnectionsServiceModels/Product/model_demo_smartbattery_model.json
 *
 * @author arihantjain97
 * @create 23/12/21
 * @since --
 */

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.product.DeleteProductRequest;
import com.envisioniot.enos.connect_service.v2_1.product.DeleteProductResponse;

public class DeleteProduct {

    public void deleteProduct(String accessKey,
                              String secretKey,
                              String orgId,
                              String url,
                              String productKey)
    {
        DeleteProductRequest request = new DeleteProductRequest();
        request.setOrgId(orgId);
        request.setProductKey(productKey);
        DeleteProductResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, DeleteProductResponse.class);
    }

}
