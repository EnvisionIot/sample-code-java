package com.envisioniot.example.sample.connection.devicedata;


public class ConnectionDeviceDataApp {
    public void connectionDeviceDataAppGeneral(String accessKey, String secretKey, String orgId, String url) {

        // Ensure that you have the appropriate model(s), product(s), device(s), command(s), event(s) set-up.
        // note: modelId is viewable on enOS at IoT hub/Models,
        // productKey is viewable on enOS at IoT hub/Device Management/Products/View,
        // deviceKey and assetId are viewable on enOS at IoT hub/Device Assets/View,
        // eventID is viewable on enOS at IoT hub/Device Assets/View/Commands

        //ppe1
        //device sw1
//        String productKey = "X4NsMpuQ";
//        String deviceKey = "7N7OBODI5I";
//        String assetId = "vQuU4XJY";

       //sub device  sw_sub_device
//        String productKey = "X4NsMpuQ";
//        String deviceKey = "WzMViORRYI";
//        String assetId = "TONj0pGl";

        //alpha1
        //device swrr100
//        String productKey = "SAQkLuii";
//        String deviceKey = "y9ayRKQSlk";
//        String assetId = "1531p2vJ";

        //sub device  sw_sub_device
//        String productKey = "SAQkLuii";
//        String deviceKey = "rQmJpt9xND";
//        String assetId = "wW6y8Q5w";

        //alpha1
//        //test rule
//        String productKey = "fnITVbTQ";
//        String deviceKey = "v1OhmZKWDc";
//        String assetId = "rf18mBEj";


        //beta1
        //device swrr
        String productKey = "KAP1GHdU";
        String deviceKey = "pIA86DynHf";
        String assetId = "qeieYSts";

        //sub device  sw_sub_device
//        String productKey = "KAP1GHdU";
//        String deviceKey = "zKwncaIbWM";
//        String assetId = "Ub86XgyL";


        //beta1
        //test rule
//        String productKey = "LzmNo7Uo";
//        String deviceKey = "mYLKyEobck";
//        String assetId = "izmAwKDo";





        /*//String eventId = "202201129fba478d083db14a85439be769ad22b3";


        // Send two setMeasurementPoint command (Device is inactive)
        // Alternative
        SetMeasurementPoint setmeasurementpoint = new SetMeasurementPoint();
        String commandId = setmeasurementpoint.SetMeasurementPoint_assetId(accessKey, secretKey, orgId, url, assetId);
        String commandId2 = setmeasurementpoint.SetMeasurementPoint_Keys(accessKey, secretKey, orgId, url, productKey, deviceKey);

/*
        // Cancel both commands (Command has to be of status 'Created')
        // The cancellation may take some time to work.
        CancelCommand cancelcommand = new CancelCommand();
        cancelcommand.cancelCommand_assetId(accessKey,secretKey,orgId,url, assetId, commandId);
        cancelcommand.cancelCommand_Keys(accessKey,secretKey,orgId,url,productKey,deviceKey,commandId2);
*/
        // Get command information (based on commandId).
//        String commandId = "63b40518aa9f792e6b0a942c";
//        GetCommand getcommand = new GetCommand();
//        getcommand.getCommand_assetId(accessKey, secretKey, orgId, url, assetId, commandId);
//        getcommand.getCommand_Keys(accessKey, secretKey, orgId, url, productKey, deviceKey, commandId2);

/*
        // Send two getLatestMeasurementPoint commands
        GetLatestMeasurementPoints getlatestmeasurementpoints = new GetLatestMeasurementPoints();
        getlatestmeasurementpoints.getLatestMeasurementPoints_assetId(accessKey,secretKey,orgId,url, assetId);
        getlatestmeasurementpoints.getLatestMeasurementPoints_keys(accessKey,secretKey,orgId,url, productKey,deviceKey);

        // Search for a command.
        SearchCommand searchcommand = new SearchCommand();

        searchcommand.searchCommand_state_assetId(accessKey, secretKey, orgId, url, assetId);
        searchcommand.searchCommand_commandName_default_assetId(accessKey, secretKey, orgId, url, assetId);
        searchcommand.searchCommand_commandName_locale_assetId(accessKey, secretKey, orgId, url, assetId);
        searchcommand.searchCommand_createTime_assetId(accessKey, secretKey, orgId, url, assetId);
        searchcommand.searchCommand_state_Keys(accessKey, secretKey, orgId, url, productKey, deviceKey);
        searchcommand.searchCommand_commandName_default_Keys(accessKey, secretKey, orgId, url, productKey, deviceKey);
        searchcommand.searchCommand_commandName_locale_Keys(accessKey, secretKey, orgId, url, productKey, deviceKey);
        searchcommand.searchCommand_createTime_Keys(accessKey, secretKey, orgId, url, productKey, deviceKey);

*/
        // Invoke a service.
        InvokeService invokeService = new InvokeService();
        invokeService.invokeService_Keys(accessKey,secretKey,orgId,url,productKey,deviceKey);
//        invokeService.invokeService_assetId(accessKey,secretKey,orgId,url,assetId);

/*
        // Search for an event.
        SearchEvent searchevent = new SearchEvent();
        searchevent.searchEvent_tslEventKey(accessKey, secretKey, orgId, url);
        searchevent.searchEvent_tslEventType(accessKey, secretKey, orgId, url);
        searchevent.searchEvent_productDeviceKey(accessKey, secretKey, orgId, url);
        searchevent.searchEvent_assetId(accessKey, secretKey, orgId, url);
        searchevent.searchEvent_startEndTime(accessKey, secretKey, orgId, url);


        // Get an event.
        GetEvent getevent = new GetEvent();
        getevent.getEvent(accessKey, secretKey, orgId, url, eventId);
*/


/*        // Download a file
        DownloadFile downloadfile = new DownloadFile();
        // device 1
        downloadfile.downloadFile_assetId(accessKey,secretKey,orgId,url,assetId, fileUri1);
        downloadfile.downloadFile_keys(accessKey,secretKey,orgId,url,productKey,deviceKey, fileUri1);*/



        // Delete a file
//        DeleteFile deletefile = new DeleteFile();
//        String fileUri1 = "enos-connect://29846b2932800000.txt";
//        String fileUri2 = "enos-connect://2981a9350f000000.txt";
//        deletefile.deleteFile_assetId(accessKey,secretKey,orgId,url,assetId, fileUri1);
//        deletefile.deleteFile_keys(accessKey,secretKey,orgId,url,productKey,deviceKey, fileUri2);
    }

}
