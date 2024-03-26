package com.widia.iwefollow.model.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

@Builder
@Data
@ResponseBody
public class ResponseData {
    private Integer status;
    private Object data;
    private String message;
}
