/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.alert.content;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.request.Pagination;
import com.envisioniot.enos.api.common.constant.request.Sorter;
import com.envisioniot.enos.event_service.v2_1.SearchAlertContentRequest;
import com.envisioniot.enos.event_service.v2_1.SearchAlertContentResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 1/6/2022
 * @since 1.0.0
 */

public class SearchAlertContent {
    public void searchAlertContent(String accessKey, String secretKey, String orgId, String url) {
        SearchAlertContentRequest request = new SearchAlertContentRequest();
        request.setOrgId(orgId);
        Pagination pagination = new Pagination();
        pagination.setPageNo(1);
        pagination.setPageSize(10);
        List< Sorter > sorterList = new ArrayList< >();
        sorterList.add(new Sorter("contentId", Sorter.Order.DESC));
        pagination.setSorters(sorterList);
        request.setPagination(pagination);
        try {
            SearchAlertContentResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, SearchAlertContentResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void searchAlertContentwithModelId(String accessKey, String secretKey, String orgId, String url) {
        SearchAlertContentRequest request = new SearchAlertContentRequest();
        request.setOrgId(orgId);
        // Optional
        request.setModelId("RPi");
        Pagination pagination = new Pagination();
        pagination.setPageNo(1);
        pagination.setPageSize(10);
        List< Sorter > sorterList = new ArrayList< >();
        sorterList.add(new Sorter("contentId", Sorter.Order.DESC));
        pagination.setSorters(sorterList);
        request.setPagination(pagination);
        try {
            SearchAlertContentResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, SearchAlertContentResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void searchAlertContentwithAlertTypeId(String accessKey, String secretKey, String orgId, String url) {
        SearchAlertContentRequest request = new SearchAlertContentRequest();
        request.setOrgId(orgId);
        // Optional
        request.setAlertTypeId("Limit");
        Pagination pagination = new Pagination();
        pagination.setPageNo(1);
        pagination.setPageSize(10);
        List< Sorter > sorterList = new ArrayList< >();
        sorterList.add(new Sorter("contentId", Sorter.Order.DESC));
        pagination.setSorters(sorterList);
        request.setPagination(pagination);
        try {
            SearchAlertContentResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, SearchAlertContentResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void searchAlertContentwithSubAlertTypeId(String accessKey, String secretKey, String orgId, String url) {
        SearchAlertContentRequest request = new SearchAlertContentRequest();
        request.setOrgId(orgId);
        // Optional
        request.setAlertTypeId("Limit_01");
        Pagination pagination = new Pagination();
        pagination.setPageNo(1);
        pagination.setPageSize(10);
        List< Sorter > sorterList = new ArrayList< >();
        sorterList.add(new Sorter("contentId", Sorter.Order.DESC));
        pagination.setSorters(sorterList);
        request.setPagination(pagination);
        try {
            SearchAlertContentResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, SearchAlertContentResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
