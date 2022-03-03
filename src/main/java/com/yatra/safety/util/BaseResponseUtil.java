package com.yatra.safety.util;


import com.yatra.safety.response.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class BaseResponseUtil {

    public BaseResponse setBaseResponse(Object returnObject, String statusCode,
                                        String responseMessage) {

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResponse(returnObject);
        baseResponse.setCode(statusCode);
        baseResponse.setMessage(responseMessage);
        return baseResponse;

    }
}