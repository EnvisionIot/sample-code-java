/**
 * Copyright (C), 2015-2022, Envision
 * FileName: GetOrganizationList
 * Author:   xibin.song
 * Date:     3/8/2022 9:52 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.appportal.userandorg;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envision.app.portal.sdk.request.StructuresAppendRequest;
import com.envision.app.portal.sdk.response.Response;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 3/8/2022
 * @since 1.0.0
 */

public class AssignOrganizationStructures {
    public void assignOrganizationStructures(String accessKey, String secretKey, String orgId, String url) {
        ArrayList<String> StructureIds = new ArrayList<>();
        StructureIds.add("sg16000557456141");
        StructureIds.add("sg16256613934031600");
        StructuresAppendRequest structuresAppendRequest = new StructuresAppendRequest(orgId, "u16466203656561425",StructureIds);
        Response response = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url).getResponse(structuresAppendRequest, Response.class);
    }
}
