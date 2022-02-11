package com.envisioniot.example.sample.functions.connection.product;

import java.util.HashMap;
import java.util.Map;

public class ConnectionProductApp {
    public void connectionProductAppGeneral(String accessKey, String secretKey, String orgId, String url) {
        String modelId = "demo_smartbattery_model";

        CreateProduct createproduct_create = new CreateProduct(modelId);
        GetProduct getproduct = new GetProduct();
        DeleteProduct deleteproduct = new DeleteProduct();
        UpdateProduct updateproduct = new UpdateProduct();
        SearchProduct searchproduct = new SearchProduct(modelId);

        // Creating, Getting and Deleting a product.
        // note: Alternatively, if product already on enOS, it's productKey is listed at Device Management/Products.
        // productKey example: "8f7KmDED"
        String productKey_create = createproduct_create.createProduct(accessKey, secretKey, orgId, url);
        getproduct.getProduct(accessKey ,secretKey, orgId, url, productKey_create);
        deleteproduct.deleteProduct(accessKey ,secretKey, orgId, url, productKey_create);


        // Creating, Getting and Deleting a product with bidirectional_Auth.
        // note: Alternatively, if product already on enOS, it's productKey is viewable at Device Management/Products.
        // productKey example: "8f7KmDED"
        String productKey_bidirectional_Auth =
                createproduct_create.createProduct_bidirectional_Auth(accessKey, secretKey, orgId, url);
        getproduct.getProduct(accessKey ,secretKey, orgId, url, productKey_bidirectional_Auth);
        deleteproduct.deleteProduct(accessKey ,secretKey, orgId, url, productKey_bidirectional_Auth);


        // Creating, Getting and Deleting a product with dataFormat being custom.
        // note: Alternatively, if product already on enOS, it's productKey is viewable at Device Management/Products.
        // productKey example: "8f7KmDED"
        String productKey_dataFormat_custom = 
                createproduct_create.createProduct_dataFormat_custom(accessKey, secretKey, orgId, url);
        getproduct.getProduct(accessKey ,secretKey, orgId, url, productKey_dataFormat_custom);
        deleteproduct.deleteProduct(accessKey ,secretKey, orgId, url, productKey_dataFormat_custom);


        // Creating, Getting and Deleting a product with a set defaultValidDay.
        // note: Alternatively, if product already on enOS, it's productKey is viewable at Device Management/Products.
        // productKey example: "8f7KmDED"
        String productKey_defaultValidDay = 
                createproduct_create.createProduct_defaultValidDay(accessKey, secretKey, orgId, url);
        getproduct.getProduct(accessKey ,secretKey, orgId, url, productKey_defaultValidDay);
        deleteproduct.deleteProduct(accessKey ,secretKey, orgId, url, productKey_defaultValidDay);


        // Creating, Getting and Deleting a product with dynamicActivateEnabled.
        // note: Alternatively, if product already on enOS, it's productKey is viewable at Device Management/Products.
        // productKey example: "8f7KmDED"
        String productKey_dynamicActivateEnabled = 
                createproduct_create.createProduct_dynamicActivateEnabled(accessKey, secretKey, orgId, url);
        getproduct.getProduct(accessKey ,secretKey, orgId, url, productKey_dynamicActivateEnabled);
        deleteproduct.deleteProduct(accessKey ,secretKey, orgId, url, productKey_dynamicActivateEnabled);


        // Creating, Getting and Deleting a product with a set maxValidDay.
        // note: Alternatively, if product already on enOS, it's productKey is viewable at Device Management/Products.
        // productKey example: "8f7KmDED"
        String productKey_maxValidDay = 
                createproduct_create.createProduct_maxValidDay(accessKey, secretKey, orgId, url);
        getproduct.getProduct(accessKey ,secretKey, orgId, url, productKey_maxValidDay);
        deleteproduct.deleteProduct(accessKey ,secretKey, orgId, url, productKey_maxValidDay);

        // Creating, Getting and Deleting a product with productTags.
        // note: Alternatively, if product already on enOS, it's productKey is viewable at Device Management/Products.
        // productKey example: "8f7KmDED"
        String productKey_productTags = 
                createproduct_create.createProduct_productTags(accessKey, secretKey, orgId, url);
        getproduct.getProduct(accessKey ,secretKey, orgId, url, productKey_productTags);
        deleteproduct.deleteProduct(accessKey ,secretKey, orgId, url, productKey_productTags);


        // Creating, Getting and Deleting a product with productType being gateway.
        // note: Alternatively, if product already on enOS, it's productKey is viewable at Device Management/Products.
        // productKey example: "8f7KmDED"
        String productKey_productType_gateway = 
                createproduct_create.createProduct_productType_gateway(accessKey, secretKey, orgId, url);
        getproduct.getProduct(accessKey ,secretKey, orgId, url, productKey_productType_gateway);
        deleteproduct.deleteProduct(accessKey ,secretKey, orgId, url, productKey_productType_gateway);

        // Creating, Getting and Deleting a product with defined locale productName.
        // note: Alternatively, if product already on enOS, it's productKey is viewable at Device Management/Products.
        // productKey example: "8f7KmDED"
        String productKey_productName_locale = 
                createproduct_create.createProduct_productName_locale(accessKey, secretKey, orgId, url);
        getproduct.getProduct(accessKey ,secretKey, orgId, url, productKey_productName_locale);
        deleteproduct.deleteProduct(accessKey ,secretKey, orgId, url, productKey_productName_locale);

        // Updating a particular created product, and then deleting it.
        // note: Alternatively, if product already on enOS, it's productKey is viewable at Device Management/Products.
        // productKey example: "8f7KmDED"
        String productKey_productToUpdate = createproduct_create.createProduct(accessKey, secretKey, orgId, url);
        updateproduct.updateProduct_productDesc(accessKey, secretKey, orgId, url, productKey_productToUpdate);
        updateproduct.updateProduct_biDirectionalAuth(accessKey, secretKey, orgId, url, productKey_productToUpdate);
        updateproduct.updateProduct_dynamicActivateEnabled(accessKey, secretKey, orgId, url, productKey_productToUpdate);
        updateproduct.updateProduct_productName(accessKey, secretKey, orgId, url, productKey_productToUpdate);
        updateproduct.updateProduct_productTags(accessKey, secretKey, orgId, url, productKey_productToUpdate);
        updateproduct.updateProduct_defaultValidDay(accessKey, secretKey, orgId, url, productKey_productToUpdate);
        updateproduct.updateProduct_maxValidDay(accessKey, secretKey, orgId, url, productKey_productToUpdate);
        deleteproduct.deleteProduct(accessKey, secretKey, orgId, url, productKey_productToUpdate);


        // Creating and Searching through model for certain products matching defined expressions.
        Map<String, String> tagMap_search_b = new HashMap<>();
        Map<String, String> tagMap_search_c = new HashMap<>();
        tagMap_search_b.put("tag1","value3");
        tagMap_search_b.put("tag2","value4");
        tagMap_search_c.put("tag1","value5");
        tagMap_search_c.put("tag2","value6");

        // Create Products for searching purposes.
        // note: Alternatively, if product already on enOS, it's productKey is viewable at Device Management/Products.
        // productKey example: "8f7KmDED"
        String productKey_ToSearch_1 = createproduct_create.createProduct(accessKey, secretKey, orgId, url);
        String productKey_ToSearch_2 =
                createproduct_create.createProduct_bidirectional_Auth(accessKey, secretKey, orgId, url);
        String productKey_ToSearch_3 =
                createproduct_create.createProduct_dataFormat_custom(accessKey, secretKey, orgId, url);
        String productKey_ToSearch_4 =
                createproduct_create.createProduct_defaultValidDay(accessKey, secretKey, orgId, url);
        String productKey_ToSearch_5 =
                createproduct_create.createProduct_dynamicActivateEnabled(accessKey, secretKey, orgId, url);
        String productKey_ToSearch_6 =
                createproduct_create.createProduct_maxValidDay(accessKey, secretKey, orgId, url);
        String productKey_ToSearch_7 =
                createproduct_create.createProduct_productTags(accessKey, secretKey, orgId, url);
        String productKey_ToSearch_8 =
                createproduct_create.createProduct_productType_gateway(accessKey, secretKey, orgId, url);
        String productKey_ToSearch_9 =
                createproduct_create.createProduct_productName_locale(accessKey, secretKey, orgId, url);
        String productKey_ToSearch_10 =
                createproduct_create.createProduct_productTags(accessKey, secretKey, orgId, url,tagMap_search_b);
        String productKey_ToSearch_11 =
                createproduct_create.createProduct_productTags(accessKey, secretKey, orgId, url, tagMap_search_c);

        // Search for products
        // note: the search expressions used are defined within the search functions.
        // note: Alternatively, if product already on enOS, it's productKey is viewable at Device Management/Products.
        // productKey example: "8f7KmDED"
        searchproduct.searchProduct_model(accessKey, secretKey, orgId, url);
        searchproduct.searchProduct_productKey(accessKey, secretKey, orgId, url, productKey_ToSearch_1);
        searchproduct.searchProduct_productTag(accessKey, secretKey, orgId, url);
        searchproduct.searchProduct_productName_default(accessKey, secretKey, orgId, url);
        searchproduct.searchProduct_productName_locale(accessKey, secretKey, orgId, url);

    }
}
