package com.envisioniot.example.sample.edp.tsdbpolicy;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.envisioniot.example.sample.edp.tsdbpolicy.v2_0.GetStoragePolicy;
import com.envisioniot.example.sample.edp.tsdbpolicy.v2_0.SaveStoragePolicy;
import com.envisioniot.example.sample.edp.tsdbpolicy.v2_1.*;

public class TSDBPolicyApp {
    public void tsdbPolicyAppGeneral(String accessKey, String secretKey, String orgId, String url) {

/*        // ModelIds can queried in multiples
        String modelIds = "demo_smartbattery_model_16,demo_lift_model";
        // Measurement Points can be queries in multiples.
        // note: Each list measurement point need not be present in every model for a query.
        String pointIds = "temperature,humidity";
        GetMeasurementPointTSDBMetadata getmeasurementptTSDB = new GetMeasurementPointTSDBMetadata();
        getmeasurementptTSDB.getMeasurementPointTSDBMetadata(accessKey, secretKey, orgId, url, modelIds, pointIds);*/

/*        GetStoragePolicy getstoragepolicy = new GetStoragePolicy();
        getstoragepolicy.getStoragePolicy(accessKey, secretKey, orgId, url, "96606c68-a720-419f-88e2-477c3bc5e4d7");*/

/*        GetStoragePolicyV2_1 getstoragepolicyV2_1 = new GetStoragePolicyV2_1();
        getstoragepolicyV2_1.getStoragePolicyV2_1(accessKey, secretKey, orgId, url, "96606c68-a720-419f-88e2-477c3bc5e4d7");*/


        //ORGID required
/*        GetUnformattedPolicy getUnformattedPolicy = new GetUnformattedPolicy();
        getUnformattedPolicy.getUnformattedPolicy(accessKey, secretKey, url, orgId);*/

/*        JSONArray models = new JSONArray();
        JSONObject model1 = new JSONObject();
        model1.put("modelId", "demo_smartbattery_model");
        model1.put("points", new String[]{"temperature"});
        JSONObject model2 = new JSONObject();
        model2.put("modelId", "demo_smartbattery_model_9");
        model2.put("points", new String[]{"temperature"});
        models.add(model1);
        models.add(model2);*/

/*        SaveStoragePolicy savestoragepolicy = new SaveStoragePolicy();
        savestoragepolicy.saveStoragePolicy(accessKey, secretKey, orgId, url,"96606c68-a720-419f-88e2-477c3bc5e4d7", models);*/

/*        JSONArray modelsV2_1 = new JSONArray();
        JSONObject model1 = new JSONObject();
        JSONObject model2 = new JSONObject();

        model1.put("modelId", "demo_smartbattery_model");
        model2.put("modelId", "demo_smartbattery_model_9");

        JSONArray pointsModel1 = new JSONArray();
        JSONArray pointsModel2 = new JSONArray();

        Point temperaturePoint = new Point("temperature");
        temperaturePoint.setSdt(new Point.Sdt(1.1f, 600, 1));
        temperaturePoint.setDb(new Point.Db(1.1f, 600, 1));
        pointsModel1.add(JSONObject.toJSON(temperaturePoint));

        pointsModel2.add(JSONObject.toJSON(temperaturePoint));

        model1.put("points", pointsModel1);
        model2.put("points", pointsModel2);

        modelsV2_1.add(model1);
        modelsV2_1.add(model2);

        SaveStoragePolicyV2_1 savestoragepolicyV2_1 = new SaveStoragePolicyV2_1();
        savestoragepolicyV2_1.saveStoragePolicyV2_1(accessKey, secretKey, orgId, url,"96606c68-a720-419f-88e2-477c3bc5e4d7", modelsV2_1);*/

      UpdateUnformattedPolicy updateunformatedpolicy = new UpdateUnformattedPolicy();
        updateunformatedpolicy.UpdateUnformattedPolicy(accessKey, secretKey, orgId, url, "a8555efe-a608-4dcd-945e-57aeffc10bf3");
    }
}
