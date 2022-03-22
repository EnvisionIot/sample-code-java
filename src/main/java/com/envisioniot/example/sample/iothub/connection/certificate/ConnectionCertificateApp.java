package com.envisioniot.example.sample.iothub.connection.certificate;

public class ConnectionCertificateApp {
    public void connectionCertificateAppGeneral(String accessKey, String secretKey, String orgId, String url){

        ApplyCertificate cert =  new ApplyCertificate();
        cert.ApplyCertificate(accessKey, secretKey, orgId, url);
        RenewCertificate cert2 =  new RenewCertificate();
        cert2.renewCertificate(accessKey, secretKey, orgId, url);
        RevokeCertificate cert3 =  new RevokeCertificate();
        cert3.revokeCertificate(accessKey, secretKey, orgId, url);
        ApplyCertificate cert_1 =  new ApplyCertificate();
        cert_1.ApplyCertificate(accessKey, secretKey, orgId, url);
        ListCertificate  cert4 =  new ListCertificate();
        cert4.listCertificate(accessKey, secretKey, orgId, url);
    }
}
