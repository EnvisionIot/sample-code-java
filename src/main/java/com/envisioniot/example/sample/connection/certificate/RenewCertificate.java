package com.envisioniot.example.sample.connection.certificate;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.cert.RenewCertificateRequest;
import com.envisioniot.enos.connect_service.v2_1.cert.RenewCertificateResponse;

public class RenewCertificate {

    public void renewCertificate(String accessKey, String secretKey, String orgId, String url) {
        String yourProductKey = "pk";
        String yourDeviceKey = "dk";
        String yourAssetId = "assetId1";

        String newCert = "-----BEGIN NEW CERTIFICATE REQUEST-----\n" +
                "xxxxxxxx\n" +
                "-----END NEW CERTIFICATE REQUEST-----";
        Integer certSn = 54144;
        RenewCertificateRequest request = new RenewCertificateRequest();
        request.setCertSn(certSn);
        request.setCsr(newCert);
        //validDay indicates the validity period of the certificate and is optional. If this parameter is not included in your code, the default validity period of the EnOS deployment will be used.
        request.setValidDay(220);

        /*
         * Use one of the following methods to identify a device:
         * ASSET_ID
         * PRODUCT_KEY + DEVICE_KEY
         */
        request.setAssetId(yourAssetId);
        request.setProductKey(yourProductKey);
        request.setDeviceKey(yourDeviceKey);
        request.setOrgId(orgId);
        RenewCertificateResponse certRsp = Poseidon.config(PConfig.init().appKey(accessKey).appSecret(secretKey).debug())
                .url(url)
                .getResponse(request, RenewCertificateResponse.class);
        System.out.println(certRsp.getData());
    }
}
