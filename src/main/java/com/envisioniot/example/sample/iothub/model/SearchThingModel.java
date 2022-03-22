/**
 * Copyright (C), 2015-2021, Envision
 * FileName: SearchThingModel
 * Author:   xibin.song
 * Date:     12/6/2021 11:36 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.iothub.model;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.request.Pagination;
import com.envisioniot.enos.api.common.constant.request.Projection;
import com.envisioniot.enos.model_service.v2_1.SearchThingModelRequest;
import com.envisioniot.enos.model_service.v2_1.SearchThingModelResponse;


/**
 * https://support.envisioniot.com/docs/model-api/en/2.3.0/searchmodel.html  <br>
 * refer to the resources/SearchThingModel/model_demo_lift_model.json file
 *
 * @author xibin.song
 * @create 12/6/2021
 * @since 1.0.0
 */

public class SearchThingModel {
    public void searchmodel_withexpression(String accessKey, String secretKey, String orgId, String url, String expression) {
        SearchThingModelRequest request = new SearchThingModelRequest();
        request.setOrgId(orgId);
        request.setExpression(expression);
        request.setScope(1);
        Projection projection = new Projection();
        projection.add("modelId");
        projection.add("name");
        request.setProjection(projection);
        SearchThingModelResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, request.getResponseClass());
    }
    public void searchmodel_projection(String accessKey, String secretKey, String orgId, String url) {
        SearchThingModelRequest request = new SearchThingModelRequest();
        request.setOrgId(orgId);
        request.setExpression("event_tags.type = \"temp\" ");
        Projection projection = new Projection();
        projection.add("modelId");
        projection.add("name");
        projection.add("events");
        projection.add("modelIdPath");
        projection.add("orgId");
        projection.add("desc");
        projection.add("tags");
        projection.add("attributes");
        projection.add("measurepoints");
        projection.add("services");
        projection.add("events");
        request.setProjection(projection);

        SearchThingModelResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, request.getResponseClass());
        System.out.println(response.getData());
    }

    public void searchmodel_pagination(String accessKey, String secretKey, String orgId, String url) {
        SearchThingModelRequest request = new SearchThingModelRequest();
        request.setOrgId(orgId);
        request.setExpression("event_tags.type = \"temp\" ");
        Projection projection = new Projection();
        projection.add("modelId");
        projection.add("name");
        projection.add("events");
        request.setProjection(projection);

        Pagination pagination = new Pagination();
        pagination.setPageNo(1);
        pagination.setPageSize(20);
        /*List< Sorter > sorterList = new ArrayList< >();
        sorterList.add(new Sorter("modelId", Sorter.Order.DESC));
        pagination.setSorters(sorterList);*/
        request.setPagination(pagination);

        SearchThingModelResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, request.getResponseClass());
        System.out.println(response.getData());
    }

    public void searchmodel_name(String accessKey, String secretKey, String orgId, String url) {
        SearchThingModelRequest request = new SearchThingModelRequest();
        request.setOrgId(orgId);
        request.setExpression("modelId in ( \"epb_battery_socket\" )");
        request.setScope(1);
        Projection projection = new Projection();
        projection.add("modelId");
        projection.add("name");
        request.setProjection(projection);
        SearchThingModelResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, request.getResponseClass());
        System.out.println(response.getData());
    }

    public void searchmodel_publicmodels(String accessKey, String secretKey, String orgId, String url) {
        SearchThingModelRequest request = new SearchThingModelRequest();
        request.setOrgId(orgId);
        request.setExpression("modelId in ( \"EnOS_Solar_Site\", \"ESSHVAC\" )");
        Projection projection = new Projection();
        projection.add("modelId");
        projection.add("name");
        request.setProjection(projection);
        SearchThingModelResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, request.getResponseClass());
        System.out.println(response.getData());
    }

    public void searchmodel_features_pagination(String accessKey, String secretKey, String orgId, String url) {
        SearchThingModelRequest request = new SearchThingModelRequest();
        request.setOrgId(orgId);
        request.setExpression("modelId in ( \"EnOS_Solar_Site\" )");
        Projection projection = new Projection();
        projection.add("modelId");
        projection.add("name");
        projection.add("attributes");
        projection.add("measurepoints");
        projection.add("services");
        projection.add("events");
        request.setProjection(projection);
        Pagination pagination = new Pagination();
        pagination.setPageSize(10);
        pagination.setPageNo(1);
        /*Sorter sorter = new Sorter(field: "severityId", Sorter.Order.ASC);
        List< Sorter > sorterList = new ArrayList< >();
        sorterList.add(sorter);
        pagination.setSorters(sorterList);*/
        request.setPagination(pagination);


        SearchThingModelResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, request.getResponseClass());
        System.out.println(response.getData());
    }

    public void searchmodel_tag_pagination(String accessKey, String secretKey, String orgId, String url) {
        SearchThingModelRequest request = new SearchThingModelRequest();
        request.setOrgId(orgId);
        request.setExpression("tags.amc_solar_o15952073792221_product = \"tA4ZSAFR\" ");
        Projection projection = new Projection();
        projection.add("modelId");
        projection.add("name");
        projection.add("attributes");
        projection.add("measurepoints");
        request.setProjection(projection);

        SearchThingModelResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, request.getResponseClass());
        System.out.println(response.getData());
    }

    public void searchmodel_attributeTags(String accessKey, String secretKey, String orgId, String url) {
        SearchThingModelRequest request = new SearchThingModelRequest();
        request.setOrgId(orgId);
        request.setExpression("attribute_tags.location = \"singapore\" ");
        Projection projection = new Projection();
        projection.add("modelId");
        projection.add("name");
        projection.add("attributes");
        request.setProjection(projection);

        SearchThingModelResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, request.getResponseClass());
        System.out.println(response.getData());
    }

    public void searchmodel_measurementTags(String accessKey, String secretKey, String orgId, String url) {
        SearchThingModelRequest request = new SearchThingModelRequest();
        request.setOrgId(orgId);
        request.setExpression("measurepoint_tags.location = \"floor\" ");
        Projection projection = new Projection();
        projection.add("modelId");
        projection.add("name");
        projection.add("measurepoints");
        request.setProjection(projection);

        SearchThingModelResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, request.getResponseClass());
        System.out.println(response.getData());
    }

    public void searchmodel_serviceTags(String accessKey, String secretKey, String orgId, String url) {
        SearchThingModelRequest request = new SearchThingModelRequest();
        request.setOrgId(orgId);
        request.setExpression("service_tags.function = \"toogle\" ");
        Projection projection = new Projection();
        projection.add("modelId");
        projection.add("name");
        projection.add("services");
        request.setProjection(projection);

        SearchThingModelResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, request.getResponseClass());
        System.out.println(response.getData());
    }

    public void searchmodel_eventTags(String accessKey, String secretKey, String orgId, String url) {
        SearchThingModelRequest request = new SearchThingModelRequest();
        request.setOrgId(orgId);
        request.setExpression("event_tags.type = \"temp\" ");
        Projection projection = new Projection();
        projection.add("modelId");
        projection.add("name");
        projection.add("events");
        projection.add("modelIdPath");
        projection.add("orgId");
        projection.add("desc");
        projection.add("tags");
        projection.add("attributes");
        projection.add("measurepoints");
        projection.add("services");
        projection.add("events");
        request.setProjection(projection);

        SearchThingModelResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, request.getResponseClass());
        System.out.println(response.getData());
    }
}
