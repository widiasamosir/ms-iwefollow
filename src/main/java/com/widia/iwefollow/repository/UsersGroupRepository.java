package com.widia.iwefollow.repository;

import com.widia.iwefollow.model.entity.UsersGroup;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersGroupRepository extends JpaRepositoryImplementation<UsersGroup,Long>, JpaSpecificationExecutor<UsersGroup> {
}
