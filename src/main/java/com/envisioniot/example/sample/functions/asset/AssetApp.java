/**
 * Copyright (C), 2015-2022, Envision
 * FileName: AssetApp
 * Author:   xibin.song
 * Date:     1/6/2022 9:47 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.functions.asset;

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
        GetAsset asset = new GetAsset();
        asset.getAsset(accessKey, secretKey, orgId, url);
        UpdateAsset asset2 = new UpdateAsset();
        //asset2.updateAsset(accessKey, secretKey, orgId, url);
//        asset2.updateAsset_Timezone(accessKey, secretKey, orgId, url);
        DeleteLogicAsset asset3 = new DeleteLogicAsset();
//        asset3.deleteAsset(accessKey, secretKey, orgId, url);

        CreateLogicalAsset asset4 = new CreateLogicalAsset();
//        asset4.createLogicalAsset(accessKey, secretKey, orgId, url);*/
//        UpdateLogicAsset asset5 = new UpdateLogicAsset();
//        asset5.updateLogicAsset(accessKey, secretKey, orgId, url);



        // Asset Tree Service API
        /*CreateAssetTree tree = new CreateAssetTree();
        tree.createAssetTree(accessKey, secretKey, orgId, url);*/
        /*CreateAssetTreeAssociate tree2 = new CreateAssetTreeAssociate();
        //tree2.createAssetTreewithAssetId(accessKey, secretKey, orgId, url);
        tree2.createAssetTreewithProductandDeviceKey(accessKey, secretKey, orgId, url);
        GetAssetTree tree4 = new GetAssetTree();
        tree4.getAssetTree(accessKey, secretKey, orgId, url);
        SearchAssetTree tree5 = new SearchAssetTree();
        tree5.searchAssetTree(accessKey, secretKey, orgId, url);
        UpdateAssetTree tree = new UpdateAssetTree();
        tree.updateAssetTree(accessKey, secretKey, orgId, url);
        SearchAssetTree tree5 = new SearchAssetTree();
        tree5.searchAssetTree(accessKey, secretKey, orgId, url);*/

        /*AssociateTree tree1 =  new AssociateTree();
        tree1.associateTree(accessKey, secretKey, orgId, url);
        tree1.associateTreewithProductDevicekey(accessKey, secretKey, orgId, url);
        CreateAssetAssociate tree2 = new CreateAssetAssociate();
        tree2.createAssetAssociate(accessKey, secretKey, orgId, url);
        DeleteAssetNode tree3 = new DeleteAssetNode();
        tree3.deleteAssetNode(accessKey, secretKey, orgId, url);
        SearchAssetNode tree4 = new SearchAssetNode();
        tree4.searchAssetNodeAll(accessKey, secretKey, orgId, url);
        SearchRelatedAssetNode tree5 = new SearchRelatedAssetNode();
        tree5.searchRelatedAssetNodeAll(accessKey, secretKey, orgId, url);
        GetAssetTreeNode tree6 = new GetAssetTreeNode();
        tree6.searchAssetTreeByAssetIds(accessKey, secretKey, orgId, url);
        SearchAssetPath tree7 = new SearchAssetPath();
        tree7.searchAssetPathAll(accessKey, secretKey, orgId, url);*/
    }
}
