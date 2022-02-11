/**
 * Copyright (C), 2015-2022, Envision
 * FileName: ModelApp
 * Author:   xibin.song
 * Date:     1/6/2022 9:18 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.functions.model;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 1/6/2022
 * @since 1.0.0
 */

public class ModelApp {
    public void modelappGeneral(String accessKey, String secretKey, String orgId, String url){
        /*
        GetThings getthings = new GetThings();
        getthings.getThings(accessKey, secretKey, orgId, url);
         */

        // Search Model


        SearchThingModel searchthingmodel = new SearchThingModel();
        searchthingmodel.searchmodel_withexpression(accessKey, secretKey, orgId, url, "modelId in ( \"EnOS_Solar_Site\", \"ESSHVAC\" )");
        searchthingmodel.searchmodel_projection(accessKey, secretKey, orgId, url);
/*        searchthingmodel.searchmodel_withexpression(accessKey, secretKey, orgId, url, "modelId in ( 'demo_lift_model' )");
        searchthingmodel.searchmodel_withexpression(accessKey, secretKey, orgId, url, "modelId in ( \"EnOS_Solar_Site\" )");
        searchthingmodel.searchmodel_withexpression(accessKey, secretKey, orgId, url, "tags.amc_solar_o15952073792221_product = 'tA4ZSAFR' ");
        searchthingmodel.searchmodel_withexpression(accessKey, secretKey, orgId, url, "attribute_tags.location = \"singapore\" ");
        searchthingmodel.searchmodel_withexpression(accessKey, secretKey, orgId, url, "measurepoint_tags.location = \"floor\" ");
        searchthingmodel.searchmodel_withexpression(accessKey, secretKey, orgId, url, "service_tags.function = \"toogle\" ");
        searchthingmodel.searchmodel_withexpression(accessKey, secretKey, orgId, url, "event_tags.type = \"temp\" ");
        searchthingmodel.searchmodel_withexpression(accessKey, secretKey, orgId, url, "service_tags.function = 'toogle' and event_tags.type = 'temp' ");

        searchthingmodel.searchmodel_withexpression(accessKey, secretKey, orgId, url, "event_tags.type like 'temp' ");
        searchthingmodel.searchmodel_withexpression(accessKey, secretKey, orgId, url, "exists(event_tags.type) ");
        searchthingmodel.searchmodel_withexpression(accessKey, secretKey, orgId, url, "not exists(event_tags.type) ");

        searchthingmodel.searchmodel_projection(accessKey, secretKey, orgId, url);
        searchthingmodel.searchmodel_pagination(accessKey, secretKey, orgId, url);
*/

        /*searchthingmodel.searchmodel_name(accessKey, secretKey, orgId, url);
        searchthingmodel.searchmodel_publicmodels(accessKey, secretKey, orgId, url);
        searchthingmodel.searchmodel_features_pagination(accessKey, secretKey, orgId, url);
        searchthingmodel.searchmodel_tag_pagination(accessKey, secretKey, orgId, url);
        searchthingmodel.searchmodel_attributeTags(accessKey, secretKey, orgId, url);
        searchthingmodel.searchmodel_serviceTags(accessKey, secretKey, orgId, url);*/

    }
}
