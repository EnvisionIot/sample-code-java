/**
 * Copyright (C), 2015-2022, Envision
 * FileName: CreateAlertType
 * Author:   xibin.song
 * Date:     1/6/2022 2:51 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.functions.alert.type;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.request.Pagination;
import com.envisioniot.enos.api.common.constant.request.Sorter;
import com.envisioniot.enos.event_service.v2_1.DeleteAlertTypeRequest;
import com.envisioniot.enos.event_service.v2_1.DeleteAlertTypeResponse;
import com.envisioniot.enos.event_service.v2_1.SearchAlertTypeRequest;
import com.envisioniot.enos.event_service.v2_1.SearchAlertTypeResponse;

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

public class SearchAlertType {
    public void searchAlertType(String accessKey, String secretKey, String orgId, String url) {

        SearchAlertTypeRequest request = new SearchAlertTypeRequest();
        request.setOrgId(orgId);
        Pagination pagination = new Pagination();
        pagination.setPageNo(1);
        pagination.setPageSize(10);
        List< Sorter > sorterList = new ArrayList< >();
        sorterList.add(new Sorter("typeId", Sorter.Order.DESC));
        pagination.setSorters(sorterList);
        request.setPagination(pagination);
        try {
            SearchAlertTypeResponse response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                    .url(url)
                    .getResponse(request, SearchAlertTypeResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
