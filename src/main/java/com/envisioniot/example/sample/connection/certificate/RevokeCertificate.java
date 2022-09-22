package com.envisioniot.example.sample.connection.certificate;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.cert.*;

public class RevokeCertificate {

    public void revokeCertificate(String accessKey, String secretKey, String orgId, String url) {
        String yourProductKey = "qvO9qxEV";
        String yourDeviceKey = "KoLX5HGobx";
        String yourAssetId = "LbOOKFet";

        // data from the response of create/update certificate.
        Integer certSn = 54145;
        RevokeCertificateRequest request = new RevokeCertificateRequest();
        /*
         * Use one of the following methods to identify a device：
         * ASSET_ID
         * PRODUCT_KEY + DEVICE_KEY
         */
        request.setAssetId(yourAssetId);
        request.setProductKey(yourProductKey);
        request.setDeviceKey(yourDeviceKey);
        request.setCertSn(certSn);
        request.setOrgId(orgId);
        request.setReason(RevokeReason.UNSPECIFIED);
        RevokeCertificatesResponse certRsp = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, RevokeCertificatesResponse.class);
        if (certRsp.success()) {
            System.out.println("Certificate revoked.");
        }
    }
}
