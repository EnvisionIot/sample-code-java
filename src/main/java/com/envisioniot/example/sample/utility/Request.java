package com.envisioniot.example.sample.utility;

import com.envision.apim.poseidon.request.PoseidonRequest;

import java.util.HashMap;
import java.util.Map;

public class Request extends PoseidonRequest {

    public Request setQueryParam(String key, Object value){
        queryEncodeParams().put(key, value);
        return this;
    }

    public Request setBodyParams(String key, Object value) {
        bodyParams().put(key, value);
        return this;
    }

    public Request setBodyParams(Map<String, Object> bodyPara){
        bodyParams().putAll(bodyPara);
        return this;
    }

    public Request setBodyParams(HashMap<String, Object> bodyParamsMap) {
        bodyParams().putAll(bodyParamsMap);
        return this;
    }

    public Request setFormParam(String key, String value){
        formParams().put(key, value);
        return this;
    }

    public Request setHeaderParam(String key, String value){
        headerParams().put(key, value);
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
