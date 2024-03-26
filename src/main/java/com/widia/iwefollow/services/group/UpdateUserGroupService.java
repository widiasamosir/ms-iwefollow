package com.widia.iwefollow.services.group;

import com.widia.iwefollow.model.entity.Group;
import com.widia.iwefollow.model.entity.Users;
import com.widia.iwefollow.model.entity.UsersGroup;
import com.widia.iwefollow.model.request.UserGroupRequest;
import com.widia.iwefollow.repository.GroupRepository;
import com.widia.iwefollow.repository.UsersGroupRepository;
import com.widia.iwefollow.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserGroupService {
    @Autowired
    private UsersGroupRepository usersGroupRepository;

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private GroupRepository groupRepository;
    public void execute(UserGroupRequest userGroupRequest){
        Users users = usersRepository.findById(userGroupRequest.getUserId()).get();
        Group group = groupRepository.findById(userGroupRequest.getGroupId()).get();
        UsersGroup usersGroup = new UsersGroup();
        usersGroup.setUser(users);
        usersGroup.setGroup(group);
        usersGroupRepository.save(usersGroup);
    }
}
