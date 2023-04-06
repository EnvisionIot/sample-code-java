package com.envisioniot.example.sample.connection.certificate;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.cert.ListCertificatesRequest;
import com.envisioniot.enos.connect_service.v2_1.cert.ListCertificatesResponse;
import com.envisioniot.enos.connect_service.vo.CertificateInfo;

import java.util.List;

public class ListCertificate {

    public void listCertificate(String accessKey, String secretKey, String orgId, String url) {
        String yourProductKey = "pk";
        String yourDeviceKey = "dk";
        String yourAssetId = "assetId";

        ListCertificatesRequest listCertificatesRequest = new ListCertificatesRequest();
        listCertificatesRequest.setOrgId(orgId);
        //Optional
        listCertificatesRequest.setAssetId(yourAssetId);
        /*listCertificatesRequest.setProductKey(yourProductKey);
        listCertificatesRequest.setDeviceKey(yourDeviceKey);*/

        ListCertificatesResponse certRsp = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(listCertificatesRequest, ListCertificatesResponse.class);
        List<CertificateInfo> certificateInfos = certRsp.getData();
        if (certificateInfos != null) {
            for (CertificateInfo certificateInfo : certificateInfos) {
                System.out.println(certificateInfo);
            }
        }
    }
}
