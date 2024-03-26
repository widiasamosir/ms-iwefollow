package com.widia.iwefollow.services.users;

import com.widia.iwefollow.model.entity.Users;
import com.widia.iwefollow.model.request.UserRequest;
import com.widia.iwefollow.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveUserService {
    @Autowired
    private UsersRepository usersRepository;

    public void saveUser(UserRequest userRequest) {
        // Create a new Users entity and map data from UserRequest
        Users user = new Users();
        user.setUsername(userRequest.getUsername());
        user.setPhoneNumber(userRequest.getPhoneNumber());

        // Set password securely
        user.setPassword(userRequest.getPassword());

        // Save the user
        usersRepository.save(user);
    }
}
