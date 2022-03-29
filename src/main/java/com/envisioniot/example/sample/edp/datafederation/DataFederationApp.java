package com.envisioniot.example.sample.edp.datafederation;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataFederationApp {
    public void dataFederationAppGeneral(String accessKey, String secretKey, String orgId, String url) {

        // List Channels
/*        ListChannels listchannels = new ListChannels();
        // List Channels: READ, for querying data from storage systems.
        listchannels.listChannels(accessKey, secretKey, orgId, url, "READ");
        // List Channels: WRITE, for writing data to storage systems.
        listchannels.listChannels(accessKey, secretKey, orgId, url, "WRITE");
        // List Channels: If not specified, lists all the channels to which the application is authorized.
        listchannels.listChannels(accessKey, secretKey, orgId, url, "");*/

        // Read Data
/*        ReadData readData = new ReadData();
        // Read Data: SQL query for getting data from storage systems.
        readData.readData(accessKey, secretKey, orgId, url, "ch-28b1b7",
                "SELECT orgid, value FROM demo.db_demomanager.smart_battery_data where measurepoints = 'temp_before'");
        // Read Data: (Optional) For channels with cross-source analysis disabled, specify the alias of the data source.
        readData.readDataWithSource(accessKey, secretKey, orgId, url, "ch-28b1b7", "demo",
                "SELECT orgid, value FROM demo.db_demomanager.smart_battery_data where measurepoints = 'temp_before'");
        // Read Data: (Optional) Specify the priority of the data query job. Options are Hot, Warm, and Cold.
        readData.readDataWithQueue(accessKey, secretKey, orgId, url, "ch-28b1b7","Warm",
                "SELECT orgid, value FROM demo.db_demomanager.smart_battery_data where measurepoints = 'temp_before'");
        // Read Data: (Optional) Reserved parameter for specifying the format of returned JSON.
        readData.readDataWithItemFormat(accessKey, secretKey, orgId, url, "ch-28b1b7","1",
                "SELECT orgid, value FROM demo.db_demomanager.smart_battery_data where measurepoints = 'temp_before'");*/

        // List Jobs
/*        ListJobs listJobs = new ListJobs();
        listJobs.listJobs(accessKey, secretKey, orgId, url, "ch-16637e");*/

        // Get Jobs Details
/*        GetJobDetails getjobdetails = new GetJobDetails();
        getjobdetails.getJobDetails
                (accessKey, secretKey, orgId, url, "ch-28b1b7","1de0ddb2-fb3a-24a2-7779-f3236f5d67a1");*/

/*        // Write data
        Map<String, Object> data = new HashMap<>();
        data.put("table", "employees");
        List<Map<String, Object>> line = new ArrayList<>();

        Map<String, Object> temp = new HashMap<>();
        temp.put("emp_no", "599999");
        temp.put("birth_date", "2000-01-01 00:00:00");
        temp.put("first_name", "Yitsuko");
        temp.put("last_name", "Muzuki");
        temp.put("gender", "F");
        temp.put("hire_date", "2022-01-01 00:00:00");

        //temp.put("quality", "null");
        line.add(temp);
        data.put("lines", line);


       WriteMessage writemessage = new WriteMessage();
        writemessage.writeMessage
                (accessKey, secretKey, orgId, url, "ch-16637e", "employees", JSONObject.toJSONString(data), true);*/

/*        // Write Chunk File
        WriteChunkFile writechunkfile = new WriteChunkFile();
        int totalSize = 0;
        int chunkSize = 0;
        int chunkOffset = 0;

        writechunkfile.writeChunkFile
                (accessKey, secretKey, orgId, url,
                "yourChannelIdHere", "yourDataSourceNameHere", "yourFileNameHere",
                 totalSize, chunkOffset, chunkSize, "chunkData");*/

        // Operate Channel
/*        OperateChannel operatechannel = new OperateChannel();
        // Defining resources (Optional)
        Map<String, Object> resource = new HashMap<>();
        resource.put("resourceId", "federation_6ahw26");
        resource.put("resourceConfig", "2");
        resource.put("ifMultiResourceAnalysis", false);
        // Operate channel: read channel (start: starting the channel; stop: stopping the channel)
        operatechannel.operateChannel(accessKey, secretKey, orgId, url, "ch-625833",resource, "start");
        operatechannel.operateChannel(accessKey, secretKey, orgId, url, "ch-625833",null, "stop");
        // Operate channel: write channel (start: starting the channel; stop: stopping the channel)
        operatechannel.operateChannel(accessKey, secretKey, orgId, url, "ch-28b1b7",null, "start");
        operatechannel.operateChannel(accessKey, secretKey, orgId, url, "ch-28b1b7",null, "stop");*/

        // Download Request
        // File struct
        Map<String, Object> files = new HashMap<>();
        files.put("split", true);
        files.put("encoding", "utf-8");
        files.put("delimiter", ",");
        List<String> fileHeaders = new ArrayList<>();
        fileHeaders.add("c1");
        fileHeaders.add("c2");
        fileHeaders.add("c3");
        files.put("fileHeader", fileHeaders);
        Map<String, String> fileRename = new HashMap<>();
        fileRename.put("1", "group1");
        fileRename.put("2", "group2");
        fileRename.put("3", "group3");
        files.put("fileRename", fileRename);

        CreateDownloadRequest createdownloadrequest = new CreateDownloadRequest();
        String sqlStatement = "SELECT * FROM db_demomanager.employee";
        createdownloadrequest.createDownloadRequest
                (accessKey, secretKey, orgId, url, "ch-e98adc", "createDownloadRequest", "hive_enos", sqlStatement, "yourFilePackageName");

        createdownloadrequest.createDownloadRequestWithFileStruct
                (accessKey, secretKey, orgId, url, "ch-e98adc", "createDownloadRequestWithFileStruct", "hive_enos", sqlStatement, "yourFilePackageName", files);

        createdownloadrequest.createDownloadRequestWithCallbackURL
                (accessKey, secretKey, orgId, url, "ch-e98adc", "createDownloadRequestWithCallbackURL", "hive_enos", sqlStatement, "yourFilePackageName", null, "http://localhost:8080");

        createdownloadrequest.createDownloadRequestWithSelfDefineQueuePara
                (accessKey, secretKey, orgId, url, "ch-e98adc", "createDownloadRequestWithSelfDefineQueuePara",
                        "hive_enos", sqlStatement, "yourFilePackageName", null, "http://localhost:8080", "set mapreduce.map.memory.mb=1024;set mapreduce.reduce.memory.mb=2048");



        // Get Download status
/*        GetDownloadStatus getdownloadstatus = new GetDownloadStatus();
        getdownloadstatus.getDownloadStatus(accessKey, secretKey, orgId, url, "ch-e98adc", "4b117074654e41989f892d4dc26b9119");*/

        // Cancel Download
/*       CancelDownload canceldownload = new CancelDownload();
        canceldownload.cancelDownload(accessKey, secretKey, orgId, url, "ch-e98adc", "61a6c568e6dd4711a30ee713d6a397cf");*/




    }
}
