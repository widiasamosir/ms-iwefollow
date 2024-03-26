package com.widia.iwefollow.repository;

import com.widia.iwefollow.model.entity.Group;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepositoryImplementation<Group,Long>, JpaSpecificationExecutor<Group> {
}
