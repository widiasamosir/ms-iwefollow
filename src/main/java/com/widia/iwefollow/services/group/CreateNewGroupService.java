package com.widia.iwefollow.services.group;

import com.widia.iwefollow.model.entity.Group;
import com.widia.iwefollow.model.request.GroupRequest;
import com.widia.iwefollow.repository.GroupRepository;
import com.widia.iwefollow.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateNewGroupService {
    @Autowired
    private GroupRepository groupRepository;
    public void execute(GroupRequest groupRequest){
        Group group = new Group();
        group.setGroupName(groupRequest.getGroupName());
        group.setGroupLead(groupRequest.getGroupLead());
        group.setPeriod(groupRequest.getPeriod());
        group.setYear(groupRequest.getYear());
        group.setIsActive(Constants.GroupActive.ACTIVE.getValue());
        groupRepository.save(group);
    }
}
