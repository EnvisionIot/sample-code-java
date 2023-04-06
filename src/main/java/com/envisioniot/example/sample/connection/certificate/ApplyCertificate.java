package com.envisioniot.example.sample.connection.certificate;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.cert.ApplyCertificateRequest;
import com.envisioniot.enos.connect_service.v2_1.cert.ApplyCertificateResponse;

public class ApplyCertificate {

    public void ApplyCertificate(String accessKey, String secretKey, String orgId, String url) {
        String yourProductKey = "pk";
        String yourDeviceKey = "dk";
        String yourAssetId = "assetId";

        ApplyCertificateRequest applyCertificateRequest = new ApplyCertificateRequest();
        String csr = "-----BEGIN NEW CERTIFICATE REQUEST-----\n" +
                "xxxxxx\n" +
                "-----END NEW CERTIFICATE REQUEST-----\n";
        applyCertificateRequest.setCsr(csr);
        /*
         * Use one of the following methods to identify a device：
         * ASSET_ID
         * PRODUCT_KEY + DEVICE_KEY
         */
        applyCertificateRequest.setAssetId(yourAssetId);
        applyCertificateRequest.setProductKey(yourProductKey);
        applyCertificateRequest.setDeviceKey(yourDeviceKey);
        applyCertificateRequest.setValidDay(250);
        applyCertificateRequest.setOrgId(orgId);
        //default RSA
        applyCertificateRequest.setIssueAuthority("ECC");
        ApplyCertificateResponse certRsp = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(applyCertificateRequest, ApplyCertificateResponse.class);
    }
}
