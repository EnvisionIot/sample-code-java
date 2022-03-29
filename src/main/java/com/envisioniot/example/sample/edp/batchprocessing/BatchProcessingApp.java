package com.envisioniot.example.sample.edp.batchprocessing;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.envisioniot.example.sample.edp.batchprocessing.v2_0.*;
import com.envisioniot.example.sample.edp.batchprocessing.v2_1.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

public class BatchProcessingApp {
    public void batchProcessingAppGeneral(String accessKey, String secretKey, String orgId, String url) {

/*        // Cancel Flow Instance: V2.1
        CancelFlowInstanceV2_1 cancelflowinstancev2_1 = new CancelFlowInstanceV2_1();
        cancelflowinstancev2_1.cancelFlowInstanceV2_1(accessKey, secretKey, orgId, url,"u16401376440891600",
            "13718-20220304044200");
        // Cancel Flow Instance: V2.0
        CancelFlowInstanceV2_0 cancelflowinstancev2_0 = new CancelFlowInstanceV2_0();
        cancelflowinstancev2_0.cancelFlowInstanceV2_0(accessKey, secretKey, orgId, url,"u16401376440891600",
            "13718-20220304044200");*/


/*        // List Workflow Directories: V2.1
        ListWorkflowDirectoriesV2_1 listworkflowdirectoriesv2_1 = new ListWorkflowDirectoriesV2_1();
        listworkflowdirectoriesv2_1.listWorkflowDirectoriesV2_1(accessKey, secretKey, orgId, url, "u16401376440891600");
        // List Workflow Directories: V2.0
        ListWorkflowDirectoriesV2_0 listworkflowdirectoriesv2_0 = new ListWorkflowDirectoriesV2_0();
        listworkflowdirectoriesv2_0.listWorkflowDirectoriesV2_0(accessKey, secretKey, orgId, url, "u16401376440891600");*/


/*        // Create New Workflow Directory: V2.1
        CreateDirectoryV2_1 createdirectoryv2_1 = new CreateDirectoryV2_1();
        createdirectoryv2_1.createDirectoryV2_1
                (accessKey, secretKey, orgId, url,
                "u16401376440891600", "71f03ea6ffd844dda5ef6380fc013592", "yourDirectoryNameHere");
        // Create New Workflow Directory: V2.0
        CreateDirectoryV2_0 createDirectoryV2_0 = new CreateDirectoryV2_0();
        createDirectoryV2_0.createDirectoryV2_0
                (accessKey, secretKey, orgId, url,
                "u16401376440891600", "71f03ea6ffd844dda5ef6380fc013592", "yourDirectoryNameHereV2_0");*/

/*        // Delete Flow: V2.0
        DeleteFlowV2_0 deleteflowv2_0 = new DeleteFlowV2_0();
        deleteflowv2_0.createDirectoryV2_0(accessKey, secretKey, orgId, url, "u16401376440891600", "13718");
        // Delete Flow: V2.1
        DeleteFlowV2_1 deleteflowv2_1 = new DeleteFlowV2_1();
        deleteflowv2_1.createDirectoryV2_1(accessKey, secretKey, orgId, url, "u16401376440891600", "13719");
 */

/*        // Disable Flow: V2.0
        DisableFlowV2_0 disableflowv2_0 = new DisableFlowV2_0();
        disableflowv2_0.disableFlowV2_0(accessKey, secretKey, orgId, url, "u16401376440891600","13720");*/
        // Disable Flow: V2.1
/*        DisableFlowV2_1 disableflowv2_1 = new DisableFlowV2_1();
        disableflowv2_1.disableFlowV2_1(accessKey, secretKey, orgId, url, "u16401376440891600","13720");*/

/*
        // Enable Flow: V2.0
        EnableFlowV2_0 enableflowv2_0 = new EnableFlowV2_0();
        enableflowv2_0.enableFlowV2_0(accessKey, secretKey, orgId, url, "u16401376440891600","13720");
        // Enable Flow: V2.1
        EnableFlowV2_1 enableflowv2_1 = new EnableFlowV2_1();
        enableflowv2_1.enableFlowV2_1(accessKey, secretKey, orgId, url, "u16401376440891600","13720");*/

       // Export Flow: V2.0
/*        ExportFlowV2_0 exportflowv2_0 = new ExportFlowV2_0();
        JSONObject flowjson = exportflowv2_0.exportFlowV2_0(accessKey, secretKey, orgId, url, "u16401376440891600","13720");*/
       // System.out.println("\n\n\n" + flowjson.get("data").toString());

        // Export Flow: V2.1
/*        ExportFlowV2_1 exportflowv2_1 = new ExportFlowV2_1();
        exportflowv2_1.exportFlowV2_1(accessKey, secretKey, orgId, url, "u16401376440891600","13720");*/

        // Get Current Time: V2.0
/*        GetCurrentTimeV2_0 getCurrentTimeV2_0 = new GetCurrentTimeV2_0();
        getCurrentTimeV2_0.getCurrentTimeV2_0(accessKey, secretKey, url);
        // Get Current Time: V2.1
        GetCurrentTimeV2_1 getCurrentTimeV2_1 = new GetCurrentTimeV2_1();
        getCurrentTimeV2_1.getCurrentTimeV2_1(accessKey, secretKey, url);*/

/*        // Get Flow: V2.0
        GetFlowV2_0 getflowv2_0 = new GetFlowV2_0();
        getflowv2_0.getFlowV2_0(accessKey, secretKey, orgId, url, "u16401376440891600","13720");
        // Get Flow: V2.1
        GetFlowV2_1 getflowv2_1 = new GetFlowV2_1();
        getflowv2_1.getFlowV2_1(accessKey, secretKey, orgId, url, "u16401376440891600","13720");*/

/*       // Get Flow Instance: V2.0
        GetFlowInstanceV2_0 getflowinstancev2_0 = new GetFlowInstanceV2_0();
        getflowinstancev2_0.getFlowInstanceV2_0(accessKey, secretKey, orgId, url,"u16401376440891600",
            "13720-20220307062900");
        // Get Flow Instance: V2.1
        GetFlowInstanceV2_1 getflowinstancev2_1 = new GetFlowInstanceV2_1();
        getflowinstancev2_1.getFlowInstanceV2_1(accessKey, secretKey, orgId, url,"u16401376440891600",
            "13720-20220307062900");*/

/*        // Get My Flow: V2.0
        GetMyFlowV2_0 getmyflowv2_0 = new GetMyFlowV2_0();
        // Search by flowId
        getmyflowv2_0.getMyFlowV2_0(accessKey, secretKey, orgId, url,"u16401376440891600", "13720");
        // Search by flowName
        getmyflowv2_0.getMyFlowV2_0(accessKey, secretKey, orgId, url,"u16401376440891600", "api23test");*/

/*        // Get My Flow: V2.1
        GetMyFlowV2_1 getmyflowv2_1 = new GetMyFlowV2_1();
        // Search by flowId
        getmyflowv2_1.getMyFlowV2_1(accessKey, secretKey, orgId, url,"u16401376440891600", "13720");
        // Search by flowName
        getmyflowv2_1.getMyFlowV2_1(accessKey, secretKey, orgId, url,"u16401376440891600", "api23test");*/

        // Get Task Instance: V2.1
/*        GetTaskInstanceV2_1 gettaskinstancev2_1 = new GetTaskInstanceV2_1();
        gettaskinstancev2_1.getTaskInstanceV2_1(accessKey, secretKey, orgId, url,"u16401376440891600",
            "612852-2022030800");*/

       // Get Task Instance Log: V2.0
/*        GetTaskInstanceLogV2_0 gettaskinstancelogv2_0 = new GetTaskInstanceLogV2_0();
        gettaskinstancelogv2_0.getTaskInstanceLogV2_0(accessKey, secretKey, orgId, url,"u16401376440891600",
                "612852-2022030800", "2");*/
        // Get Task Instance Log: V2.1
/*        GetTaskInstanceLogV2_1 gettaskinstancelogv2_1 = new GetTaskInstanceLogV2_1();
        gettaskinstancelogv2_1.getTaskInstanceLogV2_1(accessKey, secretKey, orgId, url,"u16401376440891600",
                "612852-2022030800", null);*/


/*        // Get Timezone: V2.0
        GetTimeZoneV2_0 gettimezonev2_0 = new GetTimeZoneV2_0();
        gettimezonev2_0.getTimeZoneV2_0(accessKey, secretKey, orgId, url);
        // Get Timezone: V2.1
        GetTimeZoneV2_1 gettimezonev2_1 = new GetTimeZoneV2_1();
        gettimezonev2_1.getTimeZoneV2_1(accessKey, secretKey, orgId, url);*/



/*
        // Import Flow: V2.0
        ImportFlowV2_0 importflowv2_0 = new ImportFlowV2_0();
        // Import Flow: V2.0 - Declaring Flow Struct
        HashMap<String,Object> flowHashMapV2_0 = new HashMap<String, Object>();
        // Import Flow: V2.0 - Declaring Flow Struct - Task Struct Array
        JSONArray taskStructJsonArrayV2_0 = new JSONArray();
        JSONObject taskStructJsonV2_0 = new JSONObject();
        String runModeStruct =
                        "{\"taskMode\":1," +
                        "\"cpu\":0.5," +
                        "\"memory\":1," +
                        "\"maxParallel\":0," +
                        "\"keyType\":0," +
                        "\"datasourceId\":0," +
                        "\"path\":\"\"," +
                        "\"content\":\"\"}";
        taskStructJsonV2_0.put("name", "api_task_copy_5439");
        taskStructJsonV2_0.put("resource", "default");
        taskStructJsonV2_0.put("type", "COMMAND");
        taskStructJsonV2_0.put("syncType", 1);
        taskStructJsonV2_0.put("cmd", "echo \"hello\"");
        taskStructJsonV2_0.put("submitter", "");
        taskStructJsonV2_0.put("filePackage", "");
        taskStructJsonV2_0.put("cron", "");
        taskStructJsonV2_0.put("priorityLevel", 0);
        taskStructJsonV2_0.put("timeout", 300);
        taskStructJsonV2_0.put("retryLimit", 3);
        taskStructJsonV2_0.put("retryInterval", 0);
        taskStructJsonV2_0.put("successCode", "0");
        taskStructJsonV2_0.put("waitCode", "");
        taskStructJsonV2_0.put("asLink", false);
        taskStructJsonV2_0.put("runMode", runModeStruct);
        taskStructJsonArrayV2_0.add(taskStructJsonV2_0);
        // Import Flow: V2.0 - Declaring Flow Struct - FlowLink Struct Array
        JSONArray flowLinkStructJsonArrayV2_0 = new JSONArray();
        JSONObject flowLinkStructJsonV2_0 = new JSONObject();
        flowLinkStructJsonV2_0.put("linkId", "0");
        flowLinkStructJsonV2_0.put("sourceFlowName", null);
        flowLinkStructJsonArrayV2_0.add(flowLinkStructJsonV2_0);

        // Import Flow: V2.0 - Declaring Flow Struct - TaskLink Struct
        JSONArray taskLinkStructJsonArrayV2_0 = new JSONArray();
*/
/*        JSONObject taskLinkStructJsonV2_0 = new JSONObject();
        taskLinkStructJsonV2_0.put("linkId", "0");
        taskLinkStructJsonV2_0.put("sourceFlowName", "");
        taskLinkStructJsonV2_0.put("sourceTaskName", "");
        taskLinkStructJsonArrayV2_0.add(taskLinkStructJsonV2_0);*//*

        // Import Flow: V2.0 - Declaring Flow Struct - Relation Struct
        JSONArray relationStructJsonArrayV2_0 = new JSONArray();
*/
/*        JSONObject relationStructJsonV2_0 = new JSONObject();
        relationStructJsonV2_0.put("sourceTaskName", "");
        relationStructJsonV2_0.put("targetTaskName", "");
        relationStructJsonV2_0.put("rerun", false);
        relationStructJsonArrayV2_0.add(relationStructJsonV2_0);*//*


        // Import Flow: V2.0 - Declaring Flow Struct - LinkRelation Struct
        JSONArray linkRelationStructJsonArrayV2_0 = new JSONArray();
*/
/*        JSONObject linkRelationStructJsonV2_0 = new JSONObject();
        linkRelationStructJsonV2_0.put("linkId", "0");
        linkRelationStructJsonV2_0.put("targetTaskName", "");
        linkRelationStructJsonV2_0.put("rerun", null);
        linkRelationStructJsonArrayV2_0.add(linkRelationStructJsonV2_0);*//*



        flowHashMapV2_0.put("name","yourWorkFlowNameV2_0");
        flowHashMapV2_0.put("cycle","D");
        flowHashMapV2_0.put("cron","0 0 0 * * ? *");
        flowHashMapV2_0.put("parameters","[]");
        flowHashMapV2_0.put("alertMode",3);
        flowHashMapV2_0.put("alertTo","");
        flowHashMapV2_0.put("appId","");
        flowHashMapV2_0.put("submitter","db_demomanager");
        flowHashMapV2_0.put("owners","arihant.jain");
        flowHashMapV2_0.put("visitors",";arihant.jain;");
        flowHashMapV2_0.put("type",1);
        flowHashMapV2_0.put("syncType",1);
        //error giver desc
        flowHashMapV2_0.put("desc","desc");
        flowHashMapV2_0.put("startTime","2022-03-10");

        flowHashMapV2_0.put("tasks",taskStructJsonArrayV2_0);
        flowHashMapV2_0.put("flowLinks",flowLinkStructJsonArrayV2_0);
        flowHashMapV2_0.put("taskLinks",taskLinkStructJsonArrayV2_0);
        flowHashMapV2_0.put("relations",relationStructJsonArrayV2_0);
        flowHashMapV2_0.put("linkRelations",linkRelationStructJsonArrayV2_0);

        importflowv2_0.importFlowV2_0(accessKey, secretKey, orgId, url,
                "u16401376440891600",
                null,
                (String) flowHashMapV2_0.get("name"),
                (String) flowHashMapV2_0.get("desc"),
                "71f03ea6ffd844dda5ef6380fc013592",
                flowHashMapV2_0);
*/

/*        // Import Flow: V2.1
        ImportFlowV2_1 importflowv2_1 = new ImportFlowV2_1();

        // Import Flow: V2.1 - Declaring Flow Struct
        HashMap<String,Object> flowHashMapV2_1 = new HashMap<String, Object>();

        // Import Flow: V2.1 - Declaring Flow Struct - Task Struct Array
        JSONArray taskStructJsonArrayV2_1 = new JSONArray();
        JSONObject taskStructJsonV2_1 = new JSONObject();
        String runModeStructV2_1 =
                        "{\"taskMode\":1," +
                        "\"cpu\":0.5," +
                        "\"memory\":1," +
                        "\"maxParallel\":0," +
                        "\"keyType\":0," +
                        "\"datasourceId\":0," +
                        "\"path\":\"\"," +
                        "\"content\":\"\"}";
        taskStructJsonV2_1.put("name", "api_task_copy_5439");
        taskStructJsonV2_1.put("resource", "default");
        taskStructJsonV2_1.put("type", "COMMAND");
        taskStructJsonV2_1.put("syncType", 1);
        taskStructJsonV2_1.put("cmd", "echo \"hello\"");
        taskStructJsonV2_1.put("submitter", "");
        taskStructJsonV2_1.put("filePackage", "");
        taskStructJsonV2_1.put("cron", "");
        taskStructJsonV2_1.put("priorityLevel", 0);
        taskStructJsonV2_1.put("timeout", 300);
        taskStructJsonV2_1.put("retryLimit", 3);
        taskStructJsonV2_1.put("retryInterval", 0);
        taskStructJsonV2_1.put("successCode", "0");
        taskStructJsonV2_1.put("asLink", false);
        taskStructJsonV2_1.put("runMode", runModeStructV2_1);
        taskStructJsonArrayV2_1.add(taskStructJsonV2_1);

        // Import Flow: V2.1 - Declaring Flow Struct - FlowLink Struct Array
        JSONArray flowLinkStructJsonArrayV2_1 = new JSONArray();
*//*        JSONObject flowLinkStructJsonV2_1 = new JSONObject();
        flowLinkStructJsonV2_1.put("linkId", "0");
        flowLinkStructJsonV2_1.put("sourceFlowName", null);
        flowLinkStructJsonArrayV2_1.add(flowLinkStructJsonV2_1);*//*

        // Import Flow: V2.1 - Declaring Flow Struct - TaskLink Struct
        JSONArray taskLinkStructJsonArrayV2_1 = new JSONArray();
*//*        JSONObject taskLinkStructJsonV2_1 = new JSONObject();
        taskLinkStructJsonV2_1.put("linkId", "0");
        taskLinkStructJsonV2_1.put("sourceFlowName", "");
        taskLinkStructJsonV2_1.put("sourceTaskName", "");
        taskLinkStructJsonArrayV2_1.add(taskLinkStructJsonV2_1);*//*

        // Import Flow: V2.1 - Declaring Flow Struct - Relation Struct
        JSONArray relationStructJsonArrayV2_1 = new JSONArray();
*//*        JSONObject relationStructJsonV2_1 = new JSONObject();
        relationStructJsonV2_1.put("sourceTaskName", "");
        relationStructJsonV2_1.put("targetTaskName", "");
        relationStructJsonV2_1.put("rerun", false);
        relationStructJsonArrayV2_1.add(relationStructJsonV2_1);*//*

        // Import Flow: V2.1 - Declaring Flow Struct - LinkRelation Struct
        JSONArray linkRelationStructJsonArrayV2_1 = new JSONArray();
*//*        JSONObject linkRelationStructJsonV2_1 = new JSONObject();
        linkRelationStructJsonV2_1.put("linkId", "0");
        linkRelationStructJsonV2_1.put("targetTaskName", "");
        linkRelationStructJsonV2_1.put("rerun", null);
        linkRelationStructJsonArrayV2_1.add(linkRelationStructJsonV2_1);*//*

        flowHashMapV2_1.put("name","yourWorkFlowNameV2_1");
        flowHashMapV2_1.put("cycle","D");
        flowHashMapV2_1.put("cron","0 0 0 * * ? *");
        flowHashMapV2_1.put("parameters","[]");
        flowHashMapV2_1.put("alertMode",3);
        flowHashMapV2_1.put("appId","");
        flowHashMapV2_1.put("submitter","db_demomanager");
        flowHashMapV2_1.put("owners","arihant.jain");
        flowHashMapV2_1.put("visitors",";arihant.jain;");
        flowHashMapV2_1.put("type",1);
        flowHashMapV2_1.put("syncType",1);
        //error giver desc
        flowHashMapV2_1.put("desc","desc");
        flowHashMapV2_1.put("startTime","2022-03-10");

        flowHashMapV2_1.put("tasks",taskStructJsonArrayV2_1);
        flowHashMapV2_1.put("flowLinks",flowLinkStructJsonArrayV2_1);
        flowHashMapV2_1.put("taskLinks",taskLinkStructJsonArrayV2_1);
        flowHashMapV2_1.put("relations",relationStructJsonArrayV2_1);
        flowHashMapV2_1.put("linkRelations",linkRelationStructJsonArrayV2_1);

        // Import Flow: V2.1 (more testing required)
        importflowv2_1.importFlowV2_1(accessKey, secretKey, orgId, url,
                "u16401376440891600",
                null,
                (String) flowHashMapV2_1.get("name"),
                (String) flowHashMapV2_1.get("desc"),
                "71f03ea6ffd844dda5ef6380fc013592",
                flowHashMapV2_1);*/



/*        // List Flow Instances: V2.0
        ListFlowInstancesV2_0 listflowinstancesv2_0 = new ListFlowInstancesV2_0();

        // List Flow Instances: V2.0 - Pagination Struct
        JSONObject sortersJSONV2_0 = new JSONObject();
        // Supported field values: createTime, updateTime, and startTime.
        sortersJSONV2_0.put("field", "create_time");
        // Supported order values: ASC (default), DESC.
        sortersJSONV2_0.put("order", "ASC");
        JSONArray sortersArrayV2_0 = new JSONArray();
        sortersArrayV2_0.add(sortersJSONV2_0);
        JSONObject paginationJSONV2_0 = new JSONObject();
        paginationJSONV2_0.put("pageNo", 0);
        paginationJSONV2_0.put("pageSize", 10);
        paginationJSONV2_0.put("sorters", sortersArrayV2_0);

        Long fromTriggerTimeV2_0 = 0L;
        Long toTriggerTimeV2_0 = 0L;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
             fromTriggerTimeV2_0 = df.parse("2022-02-09 22:00:00").getTime();
             toTriggerTimeV2_0 = df.parse("2022-03-10 00:18:08").getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // List Flow Instances: V2.0 - Parameter Map
        HashMap<String, Object> ListflowInstanceParamMapV2_0 = new HashMap<>();
        // Possible types: 0, 1, 2.
        ListflowInstanceParamMapV2_0.put("type", "1");
        // Expression supports fuzzy matching query for flowInstanceId and flowName.
        ListflowInstanceParamMapV2_0.put("expression", "");
        ListflowInstanceParamMapV2_0.put("owner", "arihant.jain");
        ListflowInstanceParamMapV2_0.put("fromTriggerTime", fromTriggerTimeV2_0);
        ListflowInstanceParamMapV2_0.put("toTriggerTime", toTriggerTimeV2_0 + 100);
        // Possible status (can support singular): "-1,0,1,2,3,4,5,6,7,8,9,10"
        ListflowInstanceParamMapV2_0.put("status", "-1");
        ListflowInstanceParamMapV2_0.put("pagination", paginationJSONV2_0);

        // List Flow Instances: V2.0
        listflowinstancesv2_0.listFlowInstancesV2_0
                (accessKey, secretKey, orgId, url,"u16401376440891600", ListflowInstanceParamMapV2_0);


        // List Flow Instances: V2.1
        ListFlowInstancesV2_1 listflowinstancesv2_1 = new ListFlowInstancesV2_1();

        // List Flow Instances: V2.1 - Pagination Struct
        JSONObject sortersJSONV2_1 = new JSONObject();
        // Supported field values: createTime, updateTime, and startTime.
        sortersJSONV2_1.put("field", "create_time");
        // Supported order values: ASC (default), DESC.
        sortersJSONV2_1.put("order", "ASC");
        JSONArray sortersArrayV2_1 = new JSONArray();
        sortersArrayV2_1.add(sortersJSONV2_1);
        JSONObject paginationJSONV2_1 = new JSONObject();
        paginationJSONV2_1.put("pageNo", 1);
        paginationJSONV2_1.put("pageSize", 10);
        paginationJSONV2_1.put("sorters", sortersArrayV2_1);

        Long fromTriggerTimeV2_1 = 0L;
        Long toTriggerTimeV2_1 = 0L;
        SimpleDateFormat dfV2_1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
             fromTriggerTimeV2_1 = dfV2_1.parse("2022-02-09 22:00:00").getTime();
             toTriggerTimeV2_1 = dfV2_1.parse("2022-03-10 00:18:08").getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // List Flow Instances: V2.0 - Parameter Map
        HashMap<String, Object> ListflowInstanceParamMapV2_1 = new HashMap<>();
        // Possible types: 0, 1, 2.
        ListflowInstanceParamMapV2_1.put("type", "1");
        // Expression supports fuzzy matching query for flowInstanceId and flowName.
        ListflowInstanceParamMapV2_1.put("expression", "api2");
        ListflowInstanceParamMapV2_1.put("owner", "arihant.jain");
        ListflowInstanceParamMapV2_1.put("fromTriggerTime", fromTriggerTimeV2_1);
        ListflowInstanceParamMapV2_1.put("toTriggerTime", toTriggerTimeV2_1 + 100);
        // Possible status (can support singular): "-1,0,1,2,3,4,5,6,7,8,9,10"
        ListflowInstanceParamMapV2_1.put("status", "-1");
        ListflowInstanceParamMapV2_1.put("pagination", paginationJSONV2_1);

        listflowinstancesv2_1.listFlowInstancesV2_1
                (accessKey, secretKey, orgId, url,"u16401376440891600",ListflowInstanceParamMapV2_1);*/

        // Load Flow For Edit: V2.0
/*        LoadFlowForEditV2_0 loadflowforeditv2_0 = new LoadFlowForEditV2_0();
        loadflowforeditv2_0.loadFlowForEditV2_0(accessKey, secretKey, orgId, url, "u16401376440891600", "13720");

        // Load Flow For Edit: V2.1
        LoadFlowForEditV2_1 loadflowforeditv2_1 = new LoadFlowForEditV2_1();
        loadflowforeditv2_1.loadFlowForEditV2_1(accessKey, secretKey, orgId, url, "u16401376440891600", "13720");*/

        /*// Save Flow: V2.0
        SaveFlowV2_0 saveflowv2_0 = new SaveFlowV2_0();

        // Save Flow: V2.0 - TaskSimpleInfo Struct Array
        JSONArray taskSimpleInfoArrayV2_0 = new JSONArray();
        JSONObject taskSimpleInfoJSONV2_0 = new JSONObject();
        taskSimpleInfoJSONV2_0.put("taskName","saveFlowTaskNodeV2_0");
        taskSimpleInfoJSONV2_0.put("x",0.0132);
        taskSimpleInfoJSONV2_0.put("y",0.008100000381469727);
        taskSimpleInfoJSONV2_0.put("taskId","613015");
        taskSimpleInfoJSONV2_0.put("nodeId","t_613015");
        taskSimpleInfoArrayV2_0.add(taskSimpleInfoJSONV2_0);

        // Save Flow: V2.0 - FlowSimpleInfo Struct Array
        JSONArray flowSimpleInfoArrayV2_0 = new JSONArray();
        JSONObject flowSimpleInfoJSONV2_0 = new JSONObject();
        flowSimpleInfoJSONV2_0.put("flowId","13778");
        flowSimpleInfoJSONV2_0.put("flowName","test123copy");
        flowSimpleInfoJSONV2_0.put("nodeId","t_13778");
        flowSimpleInfoJSONV2_0.put("isVirtual",true);
        flowSimpleInfoJSONV2_0.put("x",0.0132);
        flowSimpleInfoJSONV2_0.put("y",0.008100000381469727);
        flowSimpleInfoArrayV2_0.add(flowSimpleInfoJSONV2_0);

        // Save Flow: V2.0 - Relation Struct Array
        JSONArray relationArrayV2_0 = new JSONArray();
        JSONObject relationStructJSONV2_0 = new JSONObject();
        relationStructJSONV2_0.put("cycleGap", "D0");
        relationStructJSONV2_0.put("rerun", true);
        relationStructJSONV2_0.put("source", "t_13778");
        relationStructJSONV2_0.put("target", "t_613015");
        relationArrayV2_0.add(relationStructJSONV2_0);

        // Save Flow: 2.0 - Body Parameters Map
        HashMap<String, Object> saveFlowBodyParamMapV2_0 = new HashMap<>();
        saveFlowBodyParamMapV2_0.put("id",13776);
        saveFlowBodyParamMapV2_0.put("type",1);
        saveFlowBodyParamMapV2_0.put("name","saveflow_dependV2_0");
        saveFlowBodyParamMapV2_0.put("freq","0 0 0 * * ? *");
        saveFlowBodyParamMapV2_0.put("cycle","D");
        saveFlowBodyParamMapV2_0.put("alertMode",3);
        saveFlowBodyParamMapV2_0.put("doAs","db_demomanager");
        saveFlowBodyParamMapV2_0.put("owners","arihant.jain");
        saveFlowBodyParamMapV2_0.put("visitors",";arihant.jain;");
        saveFlowBodyParamMapV2_0.put("startTime","2022-03-10");
        saveFlowBodyParamMapV2_0.put("active",0);
        saveFlowBodyParamMapV2_0.put("parameters","[]");
        saveFlowBodyParamMapV2_0.put("desc","desc");
        saveFlowBodyParamMapV2_0.put("queue","");
        saveFlowBodyParamMapV2_0.put("tasks", taskSimpleInfoArrayV2_0);
        saveFlowBodyParamMapV2_0.put("flows", flowSimpleInfoArrayV2_0);
        saveFlowBodyParamMapV2_0.put("relations",relationArrayV2_0);

        saveflowv2_0.saveFlowV2_0(accessKey, secretKey, orgId, url, "u16401376440891600",saveFlowBodyParamMapV2_0);


        // Save Flow: V2.0
        SaveFlowV2_1 saveflowV2_1 = new SaveFlowV2_1();

        // Save Flow: V2.0 - TaskSimpleInfo Struct Array
        JSONArray taskSimpleInfoArrayV2_1 = new JSONArray();
        JSONObject taskSimpleInfoJSONV2_1 = new JSONObject();

        taskSimpleInfoJSONV2_1.put("taskName","saveFlowTaskNodeV2_1");
        taskSimpleInfoJSONV2_1.put("x",0.0132);
        taskSimpleInfoJSONV2_1.put("y",0.008100000381469727);
        taskSimpleInfoJSONV2_1.put("taskId","613014");
        taskSimpleInfoJSONV2_1.put("nodeId","t_613014");
        taskSimpleInfoArrayV2_1.add(taskSimpleInfoJSONV2_1);

        // Save Flow: V2.0 - FlowSimpleInfo Struct Array
        JSONArray flowSimpleInfoArrayV2_1 = new JSONArray();
        JSONObject flowSimpleInfoJSONV2_1 = new JSONObject();
        flowSimpleInfoJSONV2_1.put("flowId","13720");
        flowSimpleInfoJSONV2_1.put("flowName","api23test");
        flowSimpleInfoJSONV2_1.put("nodeId","t_13720");
        flowSimpleInfoJSONV2_1.put("isVirtual",true);
        flowSimpleInfoJSONV2_1.put("x",0.0132);
        flowSimpleInfoJSONV2_1.put("y",0.008100000381469727);
        flowSimpleInfoArrayV2_1.add(flowSimpleInfoJSONV2_1);

        // Save Flow: V2.0 - Relation Struct Array
        JSONArray relationArrayV2_1 = new JSONArray();
        JSONObject relationStructJSONV2_1 = new JSONObject();
        relationStructJSONV2_1.put("cycleGap", "D0");
        relationStructJSONV2_1.put("source", "t_13720");
        relationStructJSONV2_1.put("target", "t_613014");
        relationStructJSONV2_1.put("rerun", true);
        relationArrayV2_1.add(relationStructJSONV2_1);

        // Save Flow: 2.0 - Body Parameters Map
        HashMap<String, Object> saveFlowBodyParamMapV2_1 = new HashMap<>();
        saveFlowBodyParamMapV2_1.put("id",13777);
        saveFlowBodyParamMapV2_1.put("type",1);
        saveFlowBodyParamMapV2_1.put("name","saveFlowV2_1");
        saveFlowBodyParamMapV2_1.put("freq","0 0 0 * * ? *");
        saveFlowBodyParamMapV2_1.put("cycle","D");
        saveFlowBodyParamMapV2_1.put("alertMode",3);
        saveFlowBodyParamMapV2_1.put("doAs","db_demomanager");
        saveFlowBodyParamMapV2_1.put("owners","arihant.jain");
        saveFlowBodyParamMapV2_1.put("visitors",";arihant.jain;");
        saveFlowBodyParamMapV2_1.put("startTime","2022-03-10");
        saveFlowBodyParamMapV2_1.put("active",0);
        saveFlowBodyParamMapV2_1.put("parameters","[]");
        saveFlowBodyParamMapV2_1.put("desc","desc");
        saveFlowBodyParamMapV2_1.put("queue","");
        saveFlowBodyParamMapV2_1.put("tasks", taskSimpleInfoArrayV2_1);
        saveFlowBodyParamMapV2_1.put("flows", flowSimpleInfoArrayV2_1);
        saveFlowBodyParamMapV2_1.put("relations",relationArrayV2_1);

        saveflowV2_1.saveFlowV2_1(accessKey, secretKey, orgId, url, "u16401376440891600",saveFlowBodyParamMapV2_1);*/


/*        // Search Flow: V2.0
        SearchFlowV2_0 searchflowv2_0 = new SearchFlowV2_0();

        // Search Flow: V2.0 - Pagination Struct
        JSONObject searchFlowSortersJSONV2_0 = new JSONObject();
        // Supported field values: createTime, updateTime, and startTime.
        searchFlowSortersJSONV2_0.put("field", "create_time");
        // Supported order values: ASC (default), DESC.
        searchFlowSortersJSONV2_0.put("order", "ASC");
        JSONArray searchFlowSortersArrayV2_0 = new JSONArray();
        searchFlowSortersArrayV2_0.add(searchFlowSortersJSONV2_0);
        JSONObject searchFlowPaginationJSONV2_0 = new JSONObject();
        searchFlowPaginationJSONV2_0.put("pageNo", 1);
        searchFlowPaginationJSONV2_0.put("pageSize", 10);
        searchFlowPaginationJSONV2_0.put("sorters", searchFlowSortersArrayV2_0);

        // Search by task Id (supports fuzzy enquiry)
        searchflowv2_0.searchFlowV2_0
                (accessKey, secretKey, orgId, url, "u16401376440891600", "1377", searchFlowPaginationJSONV2_0);
        // Search by task name (supports fuzzy enquiry)
        searchflowv2_0.searchFlowV2_0
                (accessKey, secretKey, orgId, url, "u16401376440891600", "saveFlow", searchFlowPaginationJSONV2_0);


        // Search Flow: V2.1
        SearchFlowV2_1 searchflowV2_1 = new SearchFlowV2_1();

        // Search Flow: V2.1 - Pagination Struct
        JSONObject searchFlowSortersJSONV2_1 = new JSONObject();
        // Supported field values: createTime, updateTime, and startTime.
        searchFlowSortersJSONV2_1.put("field", "create_time");
        // Supported order values: ASC (default), DESC.
        searchFlowSortersJSONV2_1.put("order", "ASC");
        JSONArray searchFlowSortersArrayV2_1 = new JSONArray();
        searchFlowSortersArrayV2_1.add(searchFlowSortersJSONV2_1);
        JSONObject searchFlowPaginationJSONV2_1 = new JSONObject();
        searchFlowPaginationJSONV2_1.put("pageNo", 1);
        searchFlowPaginationJSONV2_1.put("pageSize", 10);
        searchFlowPaginationJSONV2_1.put("sorters", searchFlowSortersArrayV2_1);

        // Search by task Id (supports fuzzy enquiry)
        searchflowV2_1.searchFlowV2_1
                (accessKey, secretKey, orgId, url, "u16401376440891600", "1377", searchFlowPaginationJSONV2_1);
        // Search by task name (supports fuzzy enquiry)
        searchflowV2_1.searchFlowV2_1
                (accessKey, secretKey, orgId, url, "u16401376440891600", "saveFlow", searchFlowPaginationJSONV2_1);*/

/*        // Trigger flow - V2.0
        TriggerFlowV2_0 triggerflowV2_0 = new TriggerFlowV2_0();
        triggerflowV2_0.triggerFlowV2_0
                (accessKey, secretKey, orgId, url, "u16401376440891600", 13776, System.currentTimeMillis());
        // Trigger flow - V2.1
       TriggerFlowV2_1 triggerflowV2_1 = new TriggerFlowV2_1();
        triggerflowV2_1.triggerFlowV2_1
                (accessKey, secretKey, orgId, url, "u16401376440891600", 13777, System.currentTimeMillis());*/

/*        // Trigger Flow From Task - V2.1
        TriggerFlowFromTaskV2_1 triggerflowfromtaskv2_1 = new TriggerFlowFromTaskV2_1();
        triggerflowfromtaskv2_1.triggerFlowFromTaskV2_1
                (accessKey, secretKey, orgId, url, "u16401376440891600", 13777, 613014,System.currentTimeMillis());
        */

        // Update And Trigger Flow - V2.0
/*        UpdateAndTriggerFlowV2_0 updateandupdatetriggerflowv2_0 = new UpdateAndTriggerFlowV2_0();
        String parametersV2_0 = "[{\"key\":\"outputTableName\",\"value\":\"2021_07_31\"}]";
        updateandupdatetriggerflowv2_0.updateAndTriggerFlowV2_0
                (accessKey, secretKey, orgId, url, "u16401376440891600",
                13720, System.currentTimeMillis(), parametersV2_0)

        // Update And Trigger Flow - V2.1
        UpdateAndTriggerFlowV2_1 updateandupdatetriggerflowv2_1 = new UpdateAndTriggerFlowV2_1();
        String parametersV2_1 = "[{\"key\":\"outputTableName\",\"value\":\"2022_07_31\"}]";
        updateandupdatetriggerflowv2_1.updateAndTriggerFlowV2_1
                (accessKey, secretKey, orgId, url, "u16401376440891600",
                13720, System.currentTimeMillis(), parametersV2_1);;*/


    }
}
