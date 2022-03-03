package com.yatra.safety.response;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BaseResponse {

    private Object response;
    private String message;
    private String code;

}
