/**
 * Copyright (C), 2015-2021, Envision
 * FileName: CreateAssetTree
 * Author:   xibin.song
 * Date:     12/28/2021 9:00 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.assettree.treenode;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.request.Projection;
import com.envisioniot.enos.asset_tree_service.v2_1.SearchRelatedAssetNodeRequest;
import com.envisioniot.enos.asset_tree_service.v2_1.SearchRelatedAssetNodeResponse;
import com.envisioniot.enos.asset_tree_service.vo.I18nSearchVo;
import com.envisioniot.enos.asset_tree_service.vo.RelatedAssetSearchVo;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 12/28/2021
 * @since 1.0.0
 */

public class SearchRelatedAssetNode {
    // for logic Assets
    public void searchRelatedAssetNodeAll(String accessKey, String secretKey, String orgId, String url) {

        RelatedAssetSearchVo filter1 = new RelatedAssetSearchVo();
        filter1.setIsChildOfAssetId("ChahG3d9");
        searchRelatedAssetNodeUnderChild(accessKey, secretKey, orgId, url, filter1);

        RelatedAssetSearchVo filter2 = new RelatedAssetSearchVo();
        filter2.setIsParentOfAssetId("L48RzYEF");
        searchRelatedAssetNodeUnderChild(accessKey, secretKey, orgId, url, filter2);

        RelatedAssetSearchVo filter3 = new RelatedAssetSearchVo();
        filter3.setIsAncestorOfAssetId("L48RzYEF");
        searchRelatedAssetNodeUnderChild(accessKey, secretKey, orgId, url, filter3);

        RelatedAssetSearchVo filter4 = new RelatedAssetSearchVo();
        filter4.setIsDescendantOfAssetId("gHSYigXY");
        searchRelatedAssetNodeUnderChild(accessKey, secretKey, orgId, url, filter4);
        RelatedAssetSearchVo filter5 = new RelatedAssetSearchVo();
        filter5.setAssetIds(Arrays.asList("gHSYigXY", "QLhgPFGc", "wdLa8m9d"));
        searchRelatedAssetNodeUnderChild(accessKey, secretKey, orgId, url, filter5);

        RelatedAssetSearchVo filter6 = new RelatedAssetSearchVo();
        I18nSearchVo i18nSearchVo = new I18nSearchVo();
        i18nSearchVo.setLocale("en_US");
        i18nSearchVo.setValue("SG_Demo_Edge");
        filter6.setNameLike(i18nSearchVo);
        searchRelatedAssetNodeUnderChild(accessKey, secretKey, orgId, url, filter6);

        RelatedAssetSearchVo filter7 = new RelatedAssetSearchVo();
        I18nSearchVo i18nSearchVo2 = new I18nSearchVo();
        i18nSearchVo2.setValue("SG_Demo_Edge");
        filter7.setNameLike(i18nSearchVo2);
        searchRelatedAssetNodeUnderChild(accessKey, secretKey, orgId, url, filter7);

        RelatedAssetSearchVo filter8 = new RelatedAssetSearchVo();
        filter8.setModelIds(Arrays.asList("SmartBattery_Model_a01a", "EnOS_Solar_EMT_Generic"));
        searchRelatedAssetNodeUnderChild(accessKey, secretKey, orgId, url, filter8);

        RelatedAssetSearchVo filter9 = new RelatedAssetSearchVo();
        filter9.setRootModelIds(Arrays.asList("TrainingMeter", "demo_lift_model"));
        searchRelatedAssetNodeUnderChild(accessKey, secretKey, orgId, url, filter9);
    }

    public void searchRelatedAssetNodeUnderChild(String accessKey, String secretKey, String orgId, String url, RelatedAssetSearchVo filter) {
        SearchRelatedAssetNodeRequest request = new SearchRelatedAssetNodeRequest();
        request.setOrgId(orgId);
        request.setTreeId("U22GDyrC");
        request.setFilter(filter);
        Projection projection = new Projection();
        //projection.addAll(Arrays.asList("attributes", "assetId", "name"));
        projection.addAll(Arrays.asList("name","assetId"));
        request.setProjection(projection);
        SearchRelatedAssetNodeResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(request, SearchRelatedAssetNodeResponse.class);

    }
}
