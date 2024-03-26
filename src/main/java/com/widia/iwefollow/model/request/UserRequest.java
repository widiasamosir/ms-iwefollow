package com.widia.iwefollow.model.request;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String phoneNumber;
    private String password;
    private String groupId;
}
