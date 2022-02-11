package com.envisioniot.example.sample.functions.connection.certificate;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.cert.ApplyCertificateRequest;
import com.envisioniot.enos.connect_service.v2_1.cert.ApplyCertificateResponse;

public class ApplyCertificate {

    public void ApplyCertificate(String accessKey, String secretKey, String orgId, String url) {
        String yourProductKey = "qvO9qxEV";
        String yourDeviceKey = "KoLX5HGobx";
        String yourAssetId = "LbOOKFet";

        ApplyCertificateRequest applyCertificateRequest = new ApplyCertificateRequest();
        String csr = "-----BEGIN NEW CERTIFICATE REQUEST-----\n" +
                "MIICwTCCAakCAQAwfDELMAkGA1UEBhMCQ04xETAPBgNVBAgMCFNoYW5naGFpMREw\n" +
                "DwYDVQQHDAhTaGFuZ2hhaTENMAsGA1UECgwERW5PUzERMA8GA1UEAwwITVJtSXl6\n" +
                "UFcxDTALBgNVBAsMBEVuT1MxFjAUBgkqhkiG9w0BCQEWBzREbmIxVDEwggEiMA0G\n" +
                "CSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCCRmPrs0ubuH2HeGT9kwB72/SuKWf3\n" +
                "WtWQ5csRWlSOullOQn2OUqdVPOcnZm2hQQ7WGDH3cvyD49CIeVF/a8jqzqbkrk/5\n" +
                "jINuu71tjMzRRZWym8KOmYbA2nO8Wdko8mebuYtcSpic7fByGRhGytsE2EU+TD0a\n" +
                "K1tSjMCME0ba9/ImU+q5ziI0YPRI2Pz2Sw08rpTxICocw/oGEqNbK0cYHMbQjEmQ\n" +
                "spa5MARGz3coGlRu8CsyGXwkUC6zJVxJxbNA7/VTc2PCRhS2SfjBOT226cSharH8\n" +
                "4VGywXN+YLaMUDFui2gb2E5tHFIzWD0X1qCWtDsbPIZhlPt7agsmPkLrAgMBAAGg\n" +
                "ADANBgkqhkiG9w0BAQsFAAOCAQEAVMv03+jwh/6H4+x+sQiu4qxQeBuNWagqVL/C\n" +
                "HEoyWkWOzeJHpMI59OLukHQ4QJi1IwBSB0TdWn1kfpb0ztNaYfKCR5mQLErNw9ee\n" +
                "01mEeG+3Lgmd4FRWvnNdL42kQ4GeDIkmpI/aEabMHjLwcFofzeZHRsaRyeetG5Bv\n" +
                "oGTOK1hFP4lS1p40aueHa3WNEw7z/QG2lNMz5+HPbEqJhe5AoQicMMFciZ+y1LZV\n" +
                "ZU72eVecirZPMsYOjjQ9+TLztfSLEPCZ60xA0QkTn4CFgoX8DvuzxP2uJeZ70Mch\n" +
                "Z58IqTZQkAWrTx7t4w3+rGBwQ/pkFXANd2NtYr9Mt50wIoMXzw==\n" +
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
