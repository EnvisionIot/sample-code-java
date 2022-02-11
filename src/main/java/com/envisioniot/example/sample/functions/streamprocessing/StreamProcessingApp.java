package com.envisioniot.example.sample.functions.streamprocessing;
public class StreamProcessingApp {

    public void streamProcessingAppGeneral(String accessKey, String secretKey, String orgId, String url) {
        GetStageState getstatestate = new GetStageState();
        getstatestate.getStageState(accessKey, secretKey, orgId, url,
                "ade78e6a-0df6-4312-9afd-574959278286",
                "LatePointTagger_01",
                "ChahG3d9",
                "temp"
        );
         //"test_raw,test_5min"
    }
}

