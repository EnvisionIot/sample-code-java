/**
 * Copyright (C), 2015-2021, Envision
 * FileName: SearchAssetPath
 * Author:   xibin.song
 * Date:     12/29/2021 8:56 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.functions.asset.treenode;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.request.Pagination;
import com.envisioniot.enos.api.common.constant.request.Projection;
import com.envisioniot.enos.api.common.constant.request.Sorter;
import com.envisioniot.enos.asset_tree_service.v2_1.SearchAssetPathRequest;
import com.envisioniot.enos.asset_tree_service.v2_1.SearchAssetPathResponse;
import com.envisioniot.enos.asset_tree_service.vo.AssetTreePathSearchEndVo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * refer to AssetTree/AssetTreeExample.png for the tree structure.
 * 〈〉
 *
 * @author xibin.song
 * @create 12/29/2021
 * @since 1.0.0
 */

public class SearchAssetPath {
    public void searchAssetPathAll(String accessKey, String secretKey, String orgId, String url) {

        AssetTreePathSearchEndVo from = new AssetTreePathSearchEndVo();
        from.setAssetIds(Arrays.asList("Ewp17ypI","wdLa8m9d"));
        AssetTreePathSearchEndVo to = new AssetTreePathSearchEndVo();
        to.setRootModelIds(Arrays.asList("DataDiode_Model","LSBP_SolarSite"));
        searchAssetPath(accessKey, secretKey, orgId, url, from, to);

        AssetTreePathSearchEndVo from2 = new AssetTreePathSearchEndVo();
        from2.setAssetIds(Arrays.asList("wdLa8m9d"));
        AssetTreePathSearchEndVo to2 = new AssetTreePathSearchEndVo();
        to2.setAssetIds(Arrays.asList("oy7QrZXl"));
        searchAssetPath(accessKey, secretKey, orgId, url, from2, to2);

        AssetTreePathSearchEndVo from3 = new AssetTreePathSearchEndVo();
        from3.setModelIds(Arrays.asList("EnOS_CITY_BUILDING"));
        AssetTreePathSearchEndVo to3 = new AssetTreePathSearchEndVo();
        to3.setModelIds(Arrays.asList("DataDiode_Model"));
        searchAssetPath(accessKey, secretKey, orgId, url, from3, to3);

        AssetTreePathSearchEndVo from4 = new AssetTreePathSearchEndVo();
        from4.setRootModelIds(Arrays.asList("EnOS_CITY_BUILDING"));
        AssetTreePathSearchEndVo to4 = new AssetTreePathSearchEndVo();
        to4.setRootModelIds(Arrays.asList("SmartBattery_Model_a01a"));
        searchAssetPath(accessKey, secretKey, orgId, url, from4, to4);


        AssetTreePathSearchEndVo from5 = new AssetTreePathSearchEndVo();
        from5.setModelIds(Arrays.asList("EnOS_CITY_BUILDING", "demo_lift_model"));
        AssetTreePathSearchEndVo to5 = new AssetTreePathSearchEndVo();
        to5.setModelIds(Arrays.asList("SmartBattery_Model_a01a"));
        searchAssetPath(accessKey, secretKey, orgId, url, from5, to5);

        AssetTreePathSearchEndVo from6 = new AssetTreePathSearchEndVo();
        from6.setModelIds(Arrays.asList("EnOS_CITY_BUILDING"));
        AssetTreePathSearchEndVo to6 = new AssetTreePathSearchEndVo();
        to6.setAssetIds(Arrays.asList("kt2x05jd", "BQ4hUvhc"));
        searchAssetPath(accessKey, secretKey, orgId, url, from6, to6);

    }
    public void searchAssetPath(String accessKey, String secretKey, String orgId, String url, AssetTreePathSearchEndVo from, AssetTreePathSearchEndVo to) {
        SearchAssetPathRequest request = new SearchAssetPathRequest();
        request.setOrgId(orgId);
        request.setTreeId("U22GDyrC");
        request.setFrom(from);
        request.setTo(to);
        Projection projection = new Projection();
        projection.add("assetPaths");
        projection.add("assets.*.attributes");
        request.setProjection(projection);
        Pagination page = new Pagination();
        page.setPageNo(1);
        page.setPageSize(100);
        page.setSorters(new ArrayList<Sorter>());
        request.setPagination(page);

        //request.setPathProjection("END_NODE_ONLY");
        request.setPathProjection("COMPLETE");


        SearchAssetPathResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, SearchAssetPathResponse.class);
    }
}
