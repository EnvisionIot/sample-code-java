/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.alert.record.old;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.request.Pagination;
import com.envisioniot.enos.event_service.v2_1.SearchActiveAlertRequest;
import com.envisioniot.enos.event_service.v2_1.SearchActiveAlertResponse;
import com.envisioniot.enos.event_service.vo.RootAlert;
import com.envisioniot.enos.event_service.vo.Scope;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 1/6/2022
 * @since 1.0.0
 */

public class SearchActiveAlert {
    public void searchActiveAlert(String accessKey, String secretKey, String orgId, String url, String expression) {
        SearchActiveAlertRequest request = new SearchActiveAlertRequest();
        request.setOrgId(orgId);
        request.setExpression(expression);
        Pagination pagination = new Pagination();
        pagination.setPageSize(5);
        pagination.setPageNo(1);
        request.setPagination(pagination);
        try {
            SearchActiveAlertResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, SearchActiveAlertResponse.class);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void searchActiveAlertWithScope(String accessKey, String secretKey, String orgId, String url, String expression) {
        SearchActiveAlertRequest request = new SearchActiveAlertRequest();
        request.setOrgId(orgId);
        request.setExpression(expression);

        // Optional
        request.setModelId("demo_lift_model");
        request.setMeasurepointId("temp");
        request.setAssetId("ChahG3d9");
        request.setIsMasked(false);
//        request.setMaskedBy("ChahG3d9:/DS1qMs91");

        request.setStartOccurTime("2021-01-18 15:31:09");
        request.setEndOccurTime("2022-02-18 15:31:09");

        request.setTreeId("YUKIakDo");

        Scope scope = new Scope();
        scope.setTreeId("YUKIakDo");
        scope.setFromAssetId("ChahG3d9");
        scope.setIncludeDerivative(false);
        request.setScope(scope);

        Pagination pagination = new Pagination();
        pagination.setPageSize(20);
        pagination.setPageNo(1);
        request.setPagination(pagination);
        try {
            SearchActiveAlertResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, SearchActiveAlertResponse.class);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    //Not tested.
    public void searchActiveAlertWithRootAlert(String accessKey, String secretKey, String orgId, String url, String expression) {
        SearchActiveAlertRequest request = new SearchActiveAlertRequest();
        request.setOrgId(orgId);
//        request.setExpression(expression);

        // Optional
        request.setModelId("demo_lift_model");
        request.setMeasurepointId("temp");
//        request.setAssetId("ChahG3d9");
//        request.setIsMasked(false);
//        request.setMaskedBy("ChahG3d9:/DS1qMs91");

        request.setStartOccurTime("2021-01-18 15:31:09");
        request.setEndOccurTime("2022-02-18 15:31:09");

        //Query the derivative alerts which are blocked by the specified root alert
        RootAlert rootAlert = new RootAlert();
        rootAlert.setRootAlertId("E8siEyRg");
        rootAlert.setTreeId("YUKIakDo");
        request.setRootAlert(rootAlert);

        Pagination pagination = new Pagination();
        pagination.setPageSize(20);
        pagination.setPageNo(1);
        request.setPagination(pagination);
        try {
            SearchActiveAlertResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, SearchActiveAlertResponse.class);
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
