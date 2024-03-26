package com.widia.iwefollow.model.request;

import lombok.Data;

@Data
public class GroupRequest {
    private String groupName;
    private String groupLead;
    private Integer period;
    private Integer year;
    private Integer isActive;
}
