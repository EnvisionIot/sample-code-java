
package com.envisioniot.example.sample.connection.firmwareotaupgrademanagement;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.api.common.constant.request.Pagination;
import com.envisioniot.enos.connect_service.v2_1.ota.job.task.SearchTaskRequest;
import com.envisioniot.enos.connect_service.v2_1.ota.job.task.SearchTaskResponse;


public class SearchOTAtask {

    private void searchBy (
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String exp)
    {

        SearchTaskRequest request = new SearchTaskRequest();
        request.setOrgId(orgId);

        request.setExpression(exp);

        Pagination pagination = new Pagination();
        pagination.setPageNo(1);
        pagination.setPageSize(5);

        request.setPagination(pagination);

        SearchTaskResponse response = Poseidon
                .config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, SearchTaskResponse.class);
    }

    /*The query expression, which supports sql-like query.
    The supported query fields are jobId, deviceKey, fromVersion, toVersion, status, and desc.
     All the fields support arithmetic operators “=” and “in”.*/

    public void searchOTAtask_jobId(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String jobId
    )
    {
        //using '=' operator
        String exp_equals = "jobId='" + jobId + "'";
        //using 'in' operator
        String exp_in = "jobId in (\"" + jobId + "\")";

        searchBy(accessKey, secretKey, orgId, url, exp_equals);
        searchBy(accessKey, secretKey, orgId, url, exp_in);

    }

    public void searchOTAtask_deviceKey(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String deviceKey
    )
    {
        //using '=' operator
        String exp_equals = "deviceKey='" + deviceKey + "'";
        //using 'in' operator
        String exp_in = "deviceKey in (\"" + deviceKey + "\")";

        searchBy(accessKey, secretKey, orgId, url, exp_equals);
        searchBy(accessKey, secretKey, orgId, url, exp_in);

    }

    public void searchOTAtask_fromVersion(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String fromVersion
    )
    {
        //using '=' operator
        String exp_equals = "fromVersion='" + fromVersion + "'";
        //using 'in' operator
        String exp_in = "fromVersion in (\"" + fromVersion + "\")";

        searchBy(accessKey, secretKey, orgId, url, exp_equals);
        searchBy(accessKey, secretKey, orgId, url, exp_in);

    }

    public void searchOTAtask_toVersion(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String toVersion
    )
    {
        //using '=' operator
        String exp_equals = "toVersion='" + toVersion + "'";
        //using 'in' operator
        String exp_in = "toVersion in (\"" + toVersion + "\")";

        searchBy(accessKey, secretKey, orgId, url, exp_equals);
        searchBy(accessKey, secretKey, orgId, url, exp_in);

    }

    public void searchOTAtask_status(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String status
    )
    {
        //using '=' operator
        String exp_equals = "status='" + status + "'";
        //using 'in' operator
        String exp_in = "status in (\"" + status + "\")";

        searchBy(accessKey, secretKey, orgId, url, exp_equals);
        searchBy(accessKey, secretKey, orgId, url, exp_in);

    }

    public void searchOTAtask_desc(
            String accessKey,
            String secretKey,
            String orgId,
            String url,
            String desc
    )
    {
        //using '=' operator
        String exp_equals = "desc='" + desc + "'";
        //using 'in' operator
        String exp_in = "desc in (\"" + desc + "\")";

        searchBy(accessKey, secretKey, orgId, url, exp_equals);
        searchBy(accessKey, secretKey, orgId, url, exp_in);
    }

}
