/**
 * Copyright (C), 2015-2022, Envision
 * FileName: AssetApp
 * Author:   xibin.song
 * Date:     1/6/2022 9:47 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.iothub.asset;

import com.envisioniot.enos.asset_service.vo.Asset;
import com.envisioniot.example.sample.iothub.asset.tree.*;
import com.envisioniot.example.sample.iothub.asset.treenode.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 1/6/2022
 * @since 1.0.0
 */

public class AssetApp {
    public void assetAppGeneral(String accessKey, String secretKey, String orgId, String url){

        // Assets
//        GetAsset asset = new GetAsset();
//        asset.getAsset(accessKey, secretKey, orgId, url);

//        UpdateAsset updateAsset = new UpdateAsset();
//        updateAsset.updateAsset(accessKey, secretKey, orgId, url);
//        updateAsset.updateAsset_Timezone(accessKey, secretKey, orgId, url);

//        DeleteLogicAsset deleteLogicAsset = new DeleteLogicAsset();
//        deleteLogicAsset.deleteAsset(accessKey, secretKey, orgId, url);
//
//        CreateLogicalAsset createLogicalAsset = new CreateLogicalAsset();
//        createLogicalAsset.createLogicalAsset(accessKey, secretKey, orgId, url);

//        UpdateLogicAsset updateLogicAsset = new UpdateLogicAsset();
//        updateLogicAsset.updateLogicAsset(accessKey, secretKey, orgId, url);



        /* Asset Tree Service API */
        // https://support.envisioniot.com/docs/asset-tree-api/en/2.3.0/overview.html

//        CreateAssetTree createAssetTree = new CreateAssetTree();
//        createAssetTree.createAssetTree(accessKey, secretKey, orgId, url);
//
//        CreateAssetTreeAssociate createAssetTreeAssociate = new CreateAssetTreeAssociate();
//        createAssetTreeAssociate.createAssetTreewithAssetId(accessKey, secretKey, orgId, url);
//        createAssetTreeAssociate.createAssetTreewithProductandDeviceKey(accessKey, secretKey, orgId, url);

        GetAssetTree getAssetTree = new GetAssetTree();
        getAssetTree.getAssetTree(accessKey, secretKey, orgId, url);

        SearchAssetTree searchAssetTree = new SearchAssetTree();
        searchAssetTree.searchAssetTree(accessKey, secretKey, orgId, url);
//
//        UpdateAssetTree updateAssetTree = new UpdateAssetTree();
//        updateAssetTree.updateAssetTree(accessKey, secretKey, orgId, url);
//
//        searchAssetTree.searchAssetTree(accessKey, secretKey, orgId, url);

        /* Asset Tree Node */
        // https://support.envisioniot.com/docs/asset-tree-api/en/2.3.0/index_asset_node.html

//        AssociateTree associateTree =  new AssociateTree();
//        associateTree.associateTree(accessKey, secretKey, orgId, url);
//        associateTree.associateTreewithProductDevicekey(accessKey, secretKey, orgId, url);
//
//        CreateAssetAssociate createAssetAssociate = new CreateAssetAssociate();
//        createAssetAssociate.createAssetAssociate(accessKey, secretKey, orgId, url);
//
//        DeleteAssetNode deleteAssetNode = new DeleteAssetNode();
//        deleteAssetNode.deleteAssetNode(accessKey, secretKey, orgId, url);
//
//        SearchAssetNode searchAssetNode = new SearchAssetNode();
//        searchAssetNode.searchAssetNodeAll(accessKey, secretKey, orgId, url);
//
//        SearchRelatedAssetNode searchRelatedAssetNode = new SearchRelatedAssetNode();
//        searchRelatedAssetNode.searchRelatedAssetNodeAll(accessKey, secretKey, orgId, url);
//
//        GetAssetTreeNode getAssetTreeNode = new GetAssetTreeNode();
//        getAssetTreeNode.searchAssetTreeByAssetIds(accessKey, secretKey, orgId, url);
//
//        SearchAssetPath searchAssetPath = new SearchAssetPath();
//        searchAssetPath.searchAssetPathAll(accessKey, secretKey, orgId, url);
    }
}
