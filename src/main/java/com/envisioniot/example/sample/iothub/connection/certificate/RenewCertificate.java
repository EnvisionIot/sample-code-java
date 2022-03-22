package com.envisioniot.example.sample.iothub.connection.certificate;

import com.envision.apim.poseidon.config.PConfig;
import com.envision.apim.poseidon.core.Poseidon;
import com.envisioniot.enos.connect_service.v2_1.cert.RenewCertificateRequest;
import com.envisioniot.enos.connect_service.v2_1.cert.RenewCertificateResponse;

public class RenewCertificate {

    public void renewCertificate(String accessKey, String secretKey, String orgId, String url) {
        String yourProductKey = "qvO9qxEV";
        String yourDeviceKey = "KoLX5HGobx";
        String yourAssetId = "LbOOKFet";

        String newCert = "-----BEGIN NEW CERTIFICATE REQUEST-----\n" +
                "MIICwTCCAakCAQAwfDELMAkGA1UEBhMCQ04xETAPBgNVBAgMCFNoYW5naGFpMREw\n" +
                "DwYDVQQHDAhTaGFuZ2hhaTENMAsGA1UECgwERW5PUzERMA8GA1UEAwwITVJtSXl6\n" +
                "UFcxDTALBgNVBAsMBEVuT1MxFjAUBgkqhkiG9w0BCQEWBzREbmIxVDEwggEiMA0G\n" +
                "CSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQC+dU5jLAu7Kb88hONou6PycTnv9+3/\n" +
                "FFPaHm5I8vPfhh0QL6TcunKpm97Dyds1yHgMCqVT+gWgO4MHFz8TiIb9JKRjHn/6\n" +
                "kFea1ccZU9nYGuv+yMGqa340NjN/vP+XpjXm6Xkqw7ujehhNoBuKJZh6+uXlf2yw\n" +
                "1gTP9vWJTc7cuiky2jgKl6/47iKEmIMT1xpHVDp16LWX08/aamJESPJ171RFFxf/\n" +
                "6z2taiK/z7McXFRHk+SdYGN0iTNZQqoFKi3S9S8FvkLBQF8gHOytZdpnSz6SZwW0\n" +
                "DJUv8VGFWQYOVU67BzVR59s0CVM9IdAHntjXm2t3BF0A9kKZa6VDzHpxAgMBAAGg\n" +
                "ADANBgkqhkiG9w0BAQsFAAOCAQEASGPYV0t4zPT3XA42SKqNzNEiYvB550/6Vh1y\n" +
                "mxD+mQXeyvkZn5OcxtuzrgD7aBVRcT/j+tK4XP8s+ODYiM+VSrqLs+a5ZGmOhHHf\n" +
                "36MdmAK8I/dNyHZBiTf+GI5ibul2vaSpYYUwarzMu0azT6+d2qiUl7TqVVIGo4+P\n" +
                "PSRp+V+9e4RJ/TKUjAToBazz154tXU5psVmQ1Ac9oF7Y/9AvGTtusLUDHCu3T45J\n" +
                "QiwAUsMkSla5HCZEftNV8uC+BR6GktfFGLv3Gx+havoBsi82OPDUbBBtKgbiIQyq\n" +
                "bslaLc4GkDZTZPz4st7/ChYOZVJNxz2CAx1JU4VAfjonqChzbw==\n" +
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
