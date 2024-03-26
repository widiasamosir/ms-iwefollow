package com.widia.iwefollow.repository;

import com.widia.iwefollow.model.entity.Users;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepositoryImplementation<Users,Long>, JpaSpecificationExecutor<Users> {
    Users findByUsername(String username);
    Optional<Users> findById(Long id);
    boolean existsByUsername(String username);

}
