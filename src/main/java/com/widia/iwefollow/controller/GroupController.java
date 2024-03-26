package com.widia.iwefollow.controller;

import com.widia.iwefollow.model.request.GroupRequest;
import com.widia.iwefollow.model.request.UserGroupRequest;
import com.widia.iwefollow.services.group.CreateNewGroupService;
import com.widia.iwefollow.services.group.UpdateUserGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("group")
public class GroupController {
    @Autowired
    private CreateNewGroupService createNewGroupService;
    @Autowired
    private UpdateUserGroupService updateUserGroupService;

    @PostMapping("/v1/register")
    public ResponseEntity<String> saveNewGroup(@RequestBody GroupRequest groupRequest) {
        try {
            createNewGroupService.execute(groupRequest);
            log.info("User registered successfully: {}", groupRequest.getGroupName());
            return ResponseEntity.ok("Group registered successfully");
        } catch (Exception e) {
            log.error("Error registering Group: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering Group");
        }
    }

    @PostMapping("/v1/map-user-group")
    public ResponseEntity<String> saveNewGroup(@RequestBody UserGroupRequest userGroupRequest) {
        try {
            updateUserGroupService.execute(userGroupRequest);
            return ResponseEntity.ok("Group and User mapped successfully");
        } catch (Exception e) {
            log.error("Error Group and User mapped: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Group and User mapped");
        }
    }
}
