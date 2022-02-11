package com.envisioniot.example.sample.functions.streamprocessing;

import com.envision.apim.poseidon.request.PoseidonRequest;

public class StreamRequest extends PoseidonRequest {

    public void setBodyParams(String key, Object value) {
        bodyParams().put(key, value);
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
