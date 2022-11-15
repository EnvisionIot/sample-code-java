package com.envisioniot.example.sample.edp.tsdbdata;

import com.envisioniot.example.sample.edp.tsdbdata.v2_1.FilterLatestAssetData;
import com.envisioniot.example.sample.edp.tsdbdata.v2_1.GetAssetAIDataAggregationLogic;
import com.envisioniot.example.sample.edp.tsdbdata.v2_1.GetAssetAIRawData;

public class TSDBDataApp {
    public void tsdbDataAppGeneral(String accessKey, String secretKey, String orgId, String url) {

        // Ensure that you have the relevant asset(s) set up on enOS.
        String modelId = "demo_smartbattery_model_17";
        String productKey = "cPMzNSos";
        String asset1Id = "vilLVKqQ";
        String asset2Id = "aOxoZQfo";
        String asset3Id = "BHr1F9ox";
        String assetIds = "vilLVKqQ,aOxoZQfo,BHr1F9ox";

/*        String modelId = "demo_smartbattery_model_16";
        String productKey = "6echRsEn";
        String asset1Id = "uq32MEQT";
        String asset2Id = "aOxoZQfo";
        String asset3Id = "BHr1F9ox";*/

        FilterLatestAssetData filterlatestassestdata = new FilterLatestAssetData();
        filterlatestassestdata.filterLatestAssetData(accessKey, secretKey, orgId, url, modelId, asset1Id, "temperature", "nq", "1000");


        GetAssetAIDataAggregationLogic getassetaidata = new GetAssetAIDataAggregationLogic();

        String pointIdLogicMultiple = "count(temperature),avg(intMP),sum(floatMP),max(temperature),min(intMP),first(floatMP),last(temperature)";

        // startTime and endTime
        String startTime = "2022-02-17 00:00:00";
        String endTime = "2022-02-17 23:59:00";
        //String startTime = "2022-02-17T00:00:00+08:00";
        //String endTime = "2022-02-17T23:59:00+08:00";


        //Single asset
/*        getassetaidata.getAssetAIDataAggregationLogic
                (accessKey, secretKey, orgId, url, "vilLVKqQ", "count(temperature)", 10, startTime, endTime);
        getassetaidata.getAssetAIDataAggregationLogic
                (accessKey, secretKey, orgId, url, "vilLVKqQ", pointIdLogicMultiple, 10, startTime, endTime);

        //Multiple assets supported
        String assetIdMultiple = "vilLVKqQ,aOxoZQfo,BHr1F9ox";
        getassetaidata.getAssetAIDataAggregationLogic
                (accessKey, secretKey, orgId, url, assetIdMultiple, "avg(intMP)", 10, startTime, endTime);
        getassetaidata.getAssetAIDataAggregationLogic
                (accessKey, secretKey, orgId, url, assetIdMultiple, pointIdLogicMultiple, 10, startTime, endTime);*/

/*
        GetAssetAIRawData getassetairawdata = new GetAssetAIRawData();
        getassetairawdata.GetAssetAIRawData(accessKey,secretKey,orgId, url, modelId, "vilLVKqQ,aOxoZQfo,BHr1F9ox", "temperature,intMP,floatMP", startTime, endTime);*/









    }
}
