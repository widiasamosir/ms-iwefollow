package com.widia.iwefollow.services.users;

import com.widia.iwefollow.model.entity.Users;
import com.widia.iwefollow.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private UsersRepository usersRepository;

    public boolean authenticate(String username, String password) {
        Users user = usersRepository.findByUsername(username);
        if (user != null) {
            // Verify the provided password against the stored password
            return user.verifyPassword(password);
        }
        return false;
    }
}
