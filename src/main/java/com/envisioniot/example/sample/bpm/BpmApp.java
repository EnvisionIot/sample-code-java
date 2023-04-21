package com.envisioniot.example.sample.bpm;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.envisioniot.example.sample.appportal.auth.Login;
import com.envisioniot.example.sample.appportal.userandorg.ChooseOrganization;
import com.envisioniot.example.sample.bpm.process.*;
import com.envisioniot.example.sample.bpm.task.*;
import org.apache.commons.collections4.Get;

import java.io.File;
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
                (accessKey, secretKey, url, accessToken, "eeedc03a-a9a1-11ec-ad0f-8e1ac2659f4c");*/

        //  Get Process View Columns: get the information of process view columns.
/*        GetProcessViewColumns getprocessviewcolumns = new GetProcessViewColumns();
        getprocessviewcolumns.getProcessViewColumns
                (accessKey, secretKey, url, accessToken, "API230JAVAPWF_KEY");*/

        //  Query Process Instance: query the list of process instances.
/*        QueryProcessInstance queryprocessinstance = new QueryProcessInstance();

        long startedBefore = 0L;
        long startedAfter = 0L;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
             startedBefore = df.parse("2022-03-22 14:30:50").getTime();
             startedAfter = df.parse("2022-03-22 13:35:50").getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Query Process Instance: setting parameters
        Map<String, Object> queryProcessInstanceParams = new HashMap<>();
        // Query Process Instance: setting processStatus (InProgress, completed, terminated)
        queryProcessInstanceParams.put("processStatus", "inProgress");
        // Query Process Instance: setting optional parameters
        queryProcessInstanceParams.put("processName", "API230JAVA_ProcessWithForm");
        //queryProcessInstanceParams.put("processInstanceId", "f381c8fe-a911-11ec-ad0f-8e1ac2659f4c");
        //queryProcessInstanceParams.put("startedBefore", startedBefore);
        //queryProcessInstanceParams.put("startedAfter", startedAfter);
        //queryProcessInstanceParams.put("startBy", "u16473063753681521");

        //  No pagination
        queryprocessinstance.queryProcessInstance
                (accessKey, secretKey, url, accessToken, queryProcessInstanceParams);
        //  pagination type 1
        queryprocessinstance.queryProcessInstanceWithPagination
                (accessKey, secretKey, url, accessToken, queryProcessInstanceParams, 0, 4, "started", "ASC");
        queryprocessinstance.queryProcessInstanceWithPagination
                (accessKey, secretKey, url, accessToken, queryProcessInstanceParams, 0, 4, "started", "DESC");
        //  pagination type 2
        queryprocessinstance.queryProcessInstanceWithPagination
                (accessKey, secretKey, url, accessToken, queryProcessInstanceParams, 0, 4, "started", "ASC", "0");
        queryprocessinstance.queryProcessInstanceWithPagination
                (accessKey, secretKey, url, accessToken, queryProcessInstanceParams, 0, 4, "started", "DESC", "0");*/


        //  Query Process Instance By View
/*        QueryProcessInstanceByView queryprocessinstancebyview = new QueryProcessInstanceByView();

        //  Query Process Instance By View: Filter result by selected column value.
        //  issues: unsure how to filter numerical data
        JSONObject DisplayViewColumnQueryRepresentation = new JSONObject();
            DisplayViewColumnQueryRepresentation.put("id", "adf38f2f1a9a211ecad0f8e1ac2659f4c");
        DisplayViewColumnQueryRepresentation.put("filter", "inProgress");
        JSONArray DisplayViewColumnQueryRepresentationArray = new JSONArray();
        DisplayViewColumnQueryRepresentationArray.add(DisplayViewColumnQueryRepresentation);

        // Query Process Instance By View: setting parameters
        Map<String, Object> queryProcessByViewInstanceParams = new HashMap<>();
        queryProcessByViewInstanceParams.put("columns", DisplayViewColumnQueryRepresentationArray);

        //  No pagination.
        queryprocessinstancebyview.queryProcessInstanceByView
                (accessKey, secretKey, url, accessToken, "API230JAVAPWF_KEY", queryProcessByViewInstanceParams);
        //  pagination type 1
        queryprocessinstancebyview.queryProcessInstanceByViewWithPagination
                (accessKey, secretKey, url, accessToken, "API230JAVAPWF_KEY", queryProcessByViewInstanceParams,
                0, 4, "started", "ASC");
        queryprocessinstancebyview.queryProcessInstanceByViewWithPagination
                (accessKey, secretKey, url, accessToken, "API230JAVAPWF_KEY", queryProcessByViewInstanceParams,
                0, 4, "started", "DESC");
        //  pagination type 2
        queryprocessinstancebyview.queryProcessInstanceByViewWithPagination
                (accessKey, secretKey, url, accessToken, "API230JAVAPWF_KEY", queryProcessByViewInstanceParams,
                0, 4, "started", "ASC", "0");
        queryprocessinstancebyview.queryProcessInstanceByViewWithPagination
                (accessKey, secretKey, url, accessToken, "API230JAVAPWF_KEY", queryProcessByViewInstanceParams,
                0, 4, "started", "DESC", "0");*/

        // Start Process Instance
/*        StartProcessInstance startprocessinstance = new StartProcessInstance();
        Map<String, Object> startProcessInstanceParams = new HashMap<>();
        Map<String, Object> valuesMap = new HashMap<>();

        // Start Process Instance: Mandatory Parameters
        startProcessInstanceParams.put("processDefinitionId", "e6322ef1-a9a1-11ec-8df5-120e04f331d8");
        File f = new File("UploadFileSample.txt");
        valuesMap.put("SingleLineTextBoxVariableName", "yourValueHere");
        valuesMap.put("MultilineTextBox", "yourValueHere");
        valuesMap.put("FileUploadVariableName", f);
        valuesMap.put("SwitchVariableName", true);
        valuesMap.put("StaticDropdownVariableName", "DefaultKey2");
        valuesMap.put("TimePickerVariableName", "13:31:02");
        valuesMap.put("DateTimePickerVariableName", "2022-03-22 13:32:03");
        valuesMap.put("TimeRangePickerVariableName", "2022-03-22 13:31:22~2022-03-23 13:31:22");
        valuesMap.put("ProductDropdownVariableName", "java_sim_product1");
        valuesMap.put("FirmwareDropdownVariableName", "java_sim_FW");
        valuesMap.put("FirmwareVersionDropdownVariableName", "1.1");
        valuesMap.put("DeviceDropdownVariableName", "java_sim_dev1");

        startProcessInstanceParams.put("values", valuesMap);
        // Start Process Instance: Optional Parameters
        startProcessInstanceParams.put("name", "API230JAVA_ProcessWithForm");
        //startProcessInstanceParams.put("formId", "formkey");
        startProcessInstanceParams.put("outcome", "YourFormActionKey");

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
        gettask.getTask(accessKey, secretKey, url, accessToken, "4c40da46-a9eb-11ec-ad0f-8e1ac2659f4c");*/

        // Query Task
/*       QueryTask querytask = new QueryTask();

        // Query Task: Setting parameters
        HashMap<String, Object> queryTaskParametersMap = new HashMap<>();
        // Query Task: Setting parameters - mandatory parameters
        queryTaskParametersMap.put("taskStatus", "unclaimed");
        // Query Task: Setting parameters - optional parameters
        //queryTaskParametersMap.put("processInstanceId", "4c3fefde-a9eb-11ec-ad0f-8e1ac2659f4c");
        queryTaskParametersMap.put("processName", "API230JAVA_ProcessWithForm");
        queryTaskParametersMap.put("taskName", "YourTaskName");

        // No pagination.
        querytask.queryTask(accessKey, secretKey, url, accessToken, queryTaskParametersMap);
        // Pagination type 1
        querytask.queryTaskWithPagination
                (accessKey, secretKey, url, accessToken, queryTaskParametersMap, 0, 4, "createdTime", "ASC");
        querytask.queryTaskWithPagination
                (accessKey, secretKey, url, accessToken, queryTaskParametersMap, 0, 4, "createdTime", "DESC");
        // Pagination type 2
        querytask.queryTaskWithPagination
                (accessKey, secretKey, url, accessToken, queryTaskParametersMap, 0, 4, "createdTime", "ASC", "0");
        querytask.queryTaskWithPagination
                (accessKey, secretKey, url, accessToken, queryTaskParametersMap, 0, 4, "createdTime", "DESC", "0");*/

        // claim task
/*        ClaimTask claimTask = new ClaimTask();
        claimTask.claimTask(accessKey, secretKey, url, accessToken, "09623035-a8fb-11ec-ad0f-8e1ac2659f4c");*/

        // Complete Task
/*        CompleteTask completetask = new CompleteTask();
        HashMap<String, Object> completeTaskParams = new HashMap<>();
        HashMap<String, Object> values = new HashMap<>();

        File f = new File("UploadFileSample.txt");
        values.put("SingleLineTextBoxVariableName", "yourValueHere");
        values.put("MultilineTextBox", "yourValueHere");
        values.put("FileUploadVariableName", f);
        values.put("SwitchVariableName", true);
        values.put("StaticDropdownVariableName", "DefaultKey2");
        values.put("TimePickerVariableName", "13:31:02");
        values.put("DateTimePickerVariableName", "2022-03-22 13:32:03");
        values.put("TimeRangePickerVariableName", "2022-03-22 13:31:22~2022-03-23 13:31:22");
        values.put("ProductDropdownVariableName", "java_sim_product1");
        values.put("FirmwareDropdownVariableName", "java_sim_FW");
        values.put("FirmwareVersionDropdownVariableName", "1.1");
        values.put("DeviceDropdownVariableName", "java_sim_dev1");

        //completeTaskParams.put("formId", "formkey");
        completeTaskParams.put("values", values);
        completeTaskParams.put("outcome", "YourFormActionKey");

        completetask.completeTask
                (accessKey, secretKey, url, accessToken, "4c40da46-a9eb-11ec-ad0f-8e1ac2659f4c", completeTaskParams);*/

        // Claim And Complete Task
/*
       ClaimAndCompleteTask claimandcompletetask = new ClaimAndCompleteTask();

        HashMap<String, Object> claimAndCompleteTaskParams = new HashMap<>();
        HashMap<String, Object> claimAndCompleteValues = new HashMap<>();

        File f = new File("UploadFileSample.txt");
        claimAndCompleteValues.put("SingleLineTextBoxVariableName", "yourValueHere");
        claimAndCompleteValues.put("MultilineTextBox", "yourValueHere");
        claimAndCompleteValues.put("FileUploadVariableName", f);
        claimAndCompleteValues.put("SwitchVariableName", true);
        claimAndCompleteValues.put("StaticDropdownVariableName", "DefaultKey2");
        claimAndCompleteValues.put("TimePickerVariableName", "13:31:02");
        claimAndCompleteValues.put("DateTimePickerVariableName", "2022-03-22 13:32:03");
        claimAndCompleteValues.put("TimeRangePickerVariableName", "2022-03-22 13:31:22~2022-03-23 13:31:22");
        claimAndCompleteValues.put("ProductDropdownVariableName", "java_sim_product1");
        claimAndCompleteValues.put("FirmwareDropdownVariableName", "java_sim_FW");
        claimAndCompleteValues.put("FirmwareVersionDropdownVariableName", "1.1");
        claimAndCompleteValues.put("DeviceDropdownVariableName", "java_sim_dev1");

        //completeTaskParams.put("formId", "formkey");
        claimAndCompleteTaskParams.put("values", claimAndCompleteValues);
        claimAndCompleteTaskParams.put("outcome", "YourFormActionKey");

        claimandcompletetask.claimAndCompleteTask
                (accessKey, secretKey, url, accessToken, "484a641c-a9f1-11ec-ad0f-8e1ac2659f4c", claimAndCompleteTaskParams);
*/


    }
}
