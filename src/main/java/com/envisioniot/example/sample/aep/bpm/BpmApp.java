package com.envisioniot.example.sample.aep.bpm;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.envisioniot.example.sample.aep.appportal.auth.Login;
import com.envisioniot.example.sample.aep.appportal.userandorg.ChooseOrganization;
import com.envisioniot.example.sample.aep.bpm.process.*;
import com.envisioniot.example.sample.aep.bpm.task.*;
import org.apache.commons.collections4.Get;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class BpmApp {
    public void bpmAppGeneral(String accessKey, String secretKey, String orgId, String url) {

        /*
         *   1. Login Session
         *   you need to follow this flow to make your own session control
         */

        Login login = new Login();
        String accessToken = login.login(accessKey, secretKey, orgId, url);
        ChooseOrganization chooseOrganization = new ChooseOrganization();
        String refreshToken = chooseOrganization.chooseOrganization(accessKey, secretKey, orgId, url, accessToken);

        //  Get Process Instance: get the details of a process instance.
        //  note: The access token, which is represented by the bearer token is required.
/*        GetProcessInstance getprocessinstance = new GetProcessInstance();
        getprocessinstance.getProcessInstance
                (accessKey, secretKey, url, accessToken, "601ed598-a8d0-11ec-ad0f-8e1ac2659f4c");*/

        //  Get Process View Columns: get the information of process view columns.
/*        GetProcessViewColumns getprocessviewcolumns = new GetProcessViewColumns();
        getprocessviewcolumns.getProcessViewColumns
                (accessKey, secretKey, url, accessToken, "GETPROCESSVIEWCOLUMNS_KEYS");*/

        //  Query Process Instance: query the list of process instances.
/*        QueryProcessInstance queryprocessinstance = new QueryProcessInstance();

        // Query Process Instance: Pagination Struct
        JSONObject queryProcessSortersJSON = new JSONObject();
        queryProcessSortersJSON.put("field", "started");
        queryProcessSortersJSON.put("order", "DESC");
        JSONArray queryProcessSortersArray = new JSONArray();
        queryProcessSortersArray.add(queryProcessSortersJSON);
        JSONObject queryProcessPaginationJSON = new JSONObject();
        queryProcessPaginationJSON.put("current", 0);
        queryProcessPaginationJSON.put("pageSize", 1);
        queryProcessPaginationJSON.put("sorts", queryProcessSortersArray);

        System.out.println("\n\n" + queryProcessPaginationJSON + "\n\n");

        long startedBefore = 0L;
        long startedAfter = 0L;

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
             startedBefore = df.parse("2022-03-16 22:43:55").getTime();
             startedAfter = df.parse("2022-03-16 18:02:37").getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Query Process Instance: setting parameters
        Map<String, Object> queryProcessInstanceParams = new HashMap<>();
        // Query Process Instance: setting processStatus (InProgress, completed, terminated)
        queryProcessInstanceParams.put("processStatus", "inProgress");
        // Query Process Instance: setting optional parameters
        //queryProcessInstanceParams.put("processName", "GetProcessInstanceTest");
        queryProcessInstanceParams.put("processInstanceId", "f381c8fe-a911-11ec-ad0f-8e1ac2659f4c");
        //queryProcessInstanceParams.put("startedBefore", startedBefore);
        //queryProcessInstanceParams.put("startedAfter", startedAfter);
        //queryProcessInstanceParams.put("startBy", "u16473063753681521");
        //queryProcessInstanceParams.put("pagination", queryProcessPaginationJSON);

        queryprocessinstance.queryProcessInstance
                (accessKey, secretKey, url, accessToken, queryProcessInstanceParams);*/

       // Query Process Instance By View
/*        QueryProcessInstanceByView queryprocessinstancebyview = new QueryProcessInstanceByView();

        JSONObject DisplayViewColumnQueryJSON = new JSONObject();
        JSONObject DisplayViewColumnQueryRepresentation = new JSONObject();
        DisplayViewColumnQueryRepresentation.put("id", "adc726ff8a5ba11ec8df5120e04f331d8_");
        DisplayViewColumnQueryRepresentation.put("filter", "started=1647522552705");
        JSONArray DisplayViewColumnQueryRepresentationArray = new JSONArray();
        DisplayViewColumnQueryRepresentationArray.add(DisplayViewColumnQueryRepresentation);

        // Query Process Instance By View: Pagination Struct
        JSONObject queryProcessViewSortersJSON = new JSONObject();
        queryProcessViewSortersJSON.put("field", "started");
        queryProcessViewSortersJSON.put("order", "DESC");
        JSONArray queryProcessViewSortersArray = new JSONArray();
        queryProcessViewSortersArray.add(queryProcessViewSortersJSON);
        JSONObject queryProcessViewPaginationJSON = new JSONObject();
        queryProcessViewPaginationJSON.put("current", 0);
        queryProcessViewPaginationJSON.put("pageSize", 4);
        queryProcessViewPaginationJSON.put("sorts", queryProcessViewSortersArray);

        // Query Process Instance By View: setting parameters
        Map<String, Object> queryProcessByViewInstanceParams = new HashMap<>();
        queryProcessByViewInstanceParams.put("pagination", queryProcessViewPaginationJSON);
        queryProcessByViewInstanceParams.put("columns", DisplayViewColumnQueryRepresentationArray);

        queryprocessinstancebyview.queryProcessInstanceByView
                (accessKey, secretKey, url, accessToken, "GETPROCESSVIEWCOLUMNS_KEY", queryProcessByViewInstanceParams);*/

        // Start Process Instance
/*        StartProcessInstance startprocessinstance = new StartProcessInstance();
        Map<String, Object> startProcessInstanceParams = new HashMap<>();
        Map<String, Object> valuesMap = new HashMap<>();

        // Start Process Instance: Mandatory Parameters
        startProcessInstanceParams.put("processDefinitionId", "4defefac-a915-11ec-8df5-120e04f331d8");
        valuesMap.put("TextBoxVariableName", "yourValueHere");
        startProcessInstanceParams.put("values", valuesMap);
        // Start Process Instance: Optional Parameters
        startProcessInstanceParams.put("name", "StartProcessInstance");
        //startProcessInstanceParams.put("formId", "formkey");
        startProcessInstanceParams.put("outcome", "yourFormOutcomeString");

        startprocessinstance.startProcessInstance(accessKey, secretKey, url, accessToken, startProcessInstanceParams);*/

        // Terminate Process Instance
/*        TerminateProcessInstance terminateprocessinstance = new TerminateProcessInstance();
        terminateprocessinstance.terminateProcessInstance
                (accessKey, secretKey, url, accessToken,
                "d594bbfd-a8c9-11ec-ad0f-8e1ac2659f4c",
                "yourTerminateReasonHere",
                "d4ebaedd-a8c2-11ec-ad0f-8e1ac2659f4c");*/

        // Get Task
/*        GetTask gettask = new GetTask();
        gettask.getTask(accessKey, secretKey, url, accessToken, "d5953135-a8c9-11ec-ad0f-8e1ac2659f4c");*/

        // Query Task
        QueryTask querytask = new QueryTask();

        // Query Task: Setting parameters
        HashMap<String, Object> queryTaskParametersMap = new HashMap<>();
        // Query Task: Setting parameters - mandatory parameters
        queryTaskParametersMap.put("taskStatus", "inProgress");
        // Query Task: Setting parameters - optional parameters
        queryTaskParametersMap.put("processInstanceId", "a48d9ec1-a982-11ec-8df5-120e04f331d8");
        //queryTaskParametersMap.put("processName", "ToClaimProcessInstance");
        //queryTaskParametersMap.put("taskName", "User Task");
        //  Query Task: Setting parameters - optional parameters, Pagination
        JSONObject queryTaskPaginationJSON = new JSONObject();
        JSONObject queryTaskSortersJSON = new JSONObject();
        queryTaskSortersJSON.put("field", "completedTime");
        queryTaskSortersJSON.put("order", "DESC");
        JSONArray queryTaskSortersArray = new JSONArray();
        queryTaskSortersArray.add(queryTaskSortersJSON);
        queryTaskPaginationJSON.put("current", 0);
        queryTaskPaginationJSON.put("pageSize", 1);
        queryTaskPaginationJSON.put("sorts", queryTaskSortersArray);
        //queryTaskParametersMap.put("pagination", queryTaskPaginationJSON);

        //querytask.queryTask(accessKey, secretKey, url, accessToken, queryTaskParametersMap);

        // claim task
/*        ClaimTask claimTask = new ClaimTask();
        claimTask.claimTask(accessKey, secretKey, url, accessToken, "09623035-a8fb-11ec-ad0f-8e1ac2659f4c");*/

        // Complete Task
        CompleteTask completetask = new CompleteTask();
        HashMap<String, Object> completeTaskParams = new HashMap<>();
        HashMap<String, Object> values = new HashMap<>();
        values.put("TextBoxVariableName", "formDataHere");
        //completeTaskParams.put("formId", "formkey");
        completeTaskParams.put("values", values);
        completeTaskParams.put("outcome", "actionkey");

        completetask.completeTask
                (accessKey, secretKey, url, accessToken, "a48e13f9-a982-11ec-8df5-120e04f331d8", completeTaskParams);

        // Claim And Complete Task
/*        ClaimAndCompleteTask claimandcompletetask = new ClaimAndCompleteTask();

        HashMap<String, Object> claimAndCompleteTaskParams = new HashMap<>();
        HashMap<String, Object> claimAndCompleteValues = new HashMap<>();
        claimAndCompleteValues.put("formkey", "formDataHere");
        //completeTaskParams.put("formId", "formkey");
        claimAndCompleteTaskParams.put("values", claimAndCompleteValues);
        claimAndCompleteTaskParams.put("outcome", "outcomeString");


        claimandcompletetask.claimAndCompleteTask
                (accessKey, secretKey, url, accessToken, "cc78d848-a91d-11ec-8df5-120e04f331d8", claimAndCompleteTaskParams);*/


    }
}
