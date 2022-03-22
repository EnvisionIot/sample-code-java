package com.envisioniot.example.sample.utility;

import com.envision.apim.poseidon.request.PoseidonRequest;

public class Request extends PoseidonRequest {

    public Request setQueryParam(String key, Object value){
        queryEncodeParams().put(key, value);
        return this;
    }

    public Request setBodyParams(String key, Object value) {
        bodyParams().put(key, value);
        return this;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    private String method;

    @Override
    public String baseUri() {
        return "";
    }

    @Override
    public String method() {
        return method;
    }
}
