package com.envisioniot.example.sample.functions.connection.devicedata;

import com.envisioniot.enos.connect_service.vo.DeviceCreateResult;
import com.envisioniot.enos.connect_service.vo.MeasurepointSetInfo;
import com.envisioniot.example.sample.functions.connection.device.CreateDevice;
import com.envisioniot.example.sample.functions.connection.device.DeleteDevice;
import com.envisioniot.example.sample.functions.connection.product.CreateProduct;
import com.envisioniot.example.sample.functions.connection.product.DeleteProduct;


public class ConnectionDeviceDataApp {
    public void connectionDeviceDataAppGeneral(String accessKey, String secretKey, String orgId, String url) {

        // Ensure that you have the appropriate model(s), product(s), device(s), command(s), event(s) set-up.
        String productKey = "98683knm";
        String deviceKey = "rGhMZ6daqj";
        String assetId = "szxpLiGi";
        String eventId = "202201129fba478d083db14a85439be769ad22b3";

        /*
        // Send two setMeasurementPoint command (Device is inactive)
        // Alternative
        SetMeasurementPoint setmeasurementpoint = new SetMeasurementPoint();
        String commandId = setmeasurementpoint.SetMeasurementPoint_assetId(accessKey, secretKey, orgId, url, assetId);
        String commandId2 = setmeasurementpoint.SetMeasurementPoint_Keys(accessKey, secretKey, orgId, url, productKey, deviceKey);

        // Cancel both commands (Command has to be of status 'Created')
        CancelCommand cancelcommand = new CancelCommand();
        cancelcommand.cancelCommand_assetId(accessKey,secretKey,orgId,url, assetId, commandId);
        cancelcommand.cancelCommand_Keys(accessKey,secretKey,orgId,url,productKey,deviceKey,commandId2);
        wait(5000);

        // Get command information (based on commandId).
        GetCommand getcommand = new GetCommand();
        getcommand.getCommand_assetId(accessKey, secretKey, orgId, url, assetId, commandId);
        getcommand.getCommand_Keys(accessKey, secretKey, orgId, url, productKey, deviceKey, commandId2);
        */

        /*
        // Send two getLatestMeasurementPoint commands
        GetLatestMeasurementPoints getlatestmeasurementpoints = new GetLatestMeasurementPoints();
        getlatestmeasurementpoints.getLatestMeasurementPoints_assetId(accessKey,secretKey,orgId,url, assetId);
        getlatestmeasurementpoints.getLatestMeasurementPoints_keys(accessKey,secretKey,orgId,url, productKey,deviceKey);
        */


        // Search for a command.
        /*
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

        /*
        // Invoke a service.
        InvokeService invokeService = new InvokeService();
        invokeService.invokeService_Keys(accessKey,secretKey,orgId,url,productKey,deviceKey);
        invokeService.invokeService_assetId(accessKey,secretKey,orgId,url,assetId);
         */

        /*
        // Search for an event.
        SearchEvent searchevent = new SearchEvent();
        searchevent.searchEvent_tslEventKey(accessKey, secretKey, orgId, url);
        searchevent.searchEvent_tslEventType(accessKey, secretKey, orgId, url);
        searchevent.searchEvent_productDeviceKey(accessKey, secretKey, orgId, url);
        searchevent.searchEvent_assetId(accessKey, secretKey, orgId, url);
        searchevent.searchEvent_startEndTime(accessKey, secretKey, orgId, url);
         */

        /*
        // Get an event.
        GetEvent getevent = new GetEvent();
        getevent.getEvent(accessKey, secretKey, orgId, url, eventId);
         */


        // Download a file
        DownloadFile downloadfile = new DownloadFile();
        //downloadfile.downloadFile_assetId(accessKey,secretKey,orgId,url,assetId);
        //downloadfile.downloadFile_keys(accessKey,secretKey,orgId,url,productKey,deviceKey);


        // Delete a file
        DeleteFile deletefile = new DeleteFile();
        //deletefile.deleteFile_assetId(accessKey,secretKey,orgId,url,assetId);
        deletefile.deleteFile_keys(accessKey,secretKey,orgId,url,productKey,deviceKey);
    }

    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
