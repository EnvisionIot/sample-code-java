package com.envisioniot.example.sample.edp.streamprocessing;
public class StreamProcessingApp {

    public void streamProcessingAppGeneral(String accessKey, String secretKey, String orgId, String url) {
/*        GetStageState getstatestate = new GetStageState();
        getstatestate.getStageState(accessKey, secretKey, orgId, url,
                "ade78e6a-0df6-4312-9afd-574959278286",
                "LatePointTagger_01",
                "ChahG3d9",
                "temp"q
        );
       ListPipelines listpipelines = new ListPipelines();
       listpipelines.listPipelines(accessKey, secretKey, orgId, url);
       GetPipelineDetails   getpipelinedetails = new GetPipelineDetails();
       getpipelinedetails.getPipelineDetails(accessKey, secretKey, orgId, url, "070a2e7b-40ba-4da7-ae63-0cec754fad84");*/

       /*SavePipeline savepipeline = new SavePipeline();
       savepipeline.savePipeline(accessKey, secretKey, orgId, url, "070a2e7b-40ba-4da7-ae63-0cec754fad84");*/

/*       ReleasePipeline releasepipeline = new ReleasePipeline();
       releasepipeline.ReleasePipeline(accessKey, secretKey, orgId, url, "070a2e7b-40ba-4da7-ae63-0cec754fad84");*/

       /*StartPipeline startpipeline = new StartPipeline();
       startpipeline.startPipeline(accessKey, secretKey, orgId, url, "070a2e7b-40ba-4da7-ae63-0cec754fad84");*/

/*       PausePipeline pausepipeline = new PausePipeline();
        pausepipeline.pausePipeline(accessKey, secretKey, orgId, url,  "070a2e7b-40ba-4da7-ae63-0cec754fad84");*/

/*        StopPipeline stoppipeline = new StopPipeline();
        stoppipeline.stopPipeline(accessKey, secretKey, orgId, url, "070a2e7b-40ba-4da7-ae63-0cec754fad84");*/

/*        GetPipelineOffsetLag getpipelineoffsetlag = new GetPipelineOffsetLag();
        getpipelineoffsetlag.getPipelineOffsetLag(accessKey, secretKey, orgId, url, "ade78e6a-0df6-4312-9afd-574959278286");*/

        ResetPipelineOffset resetpipelineoffset = new ResetPipelineOffset();
        resetpipelineoffset.resetPipelineOffset(accessKey, secretKey, orgId, url, "ade78e6a-0df6-4312-9afd-574959278286");

    }
}

