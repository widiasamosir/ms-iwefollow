package com.widia.iwefollow.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "password")
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false, updatable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date", nullable = false)
    private Date updatedDate;
    public void setPassword(String password) {
        // Hash the password before storing it
        // You can use libraries like BCrypt or PBKDF2 for password hashing
        this.password = hashPassword(password);
    }

    public boolean verifyPassword(String candidatePassword) {
        // Compare candidate password with the hashed password
        // You need to implement this method based on the hashing algorithm used
        return verifyHash(candidatePassword, this.password);
    }

    // Hash the password using a secure hashing algorithm (e.g., BCrypt)
    private String hashPassword(String password) {
        // You can use libraries like BCrypt to hash the password
        // Example using BCrypt:
        // return BCrypt.hashpw(password, BCrypt.gensalt());
        return password; // For demonstration, replace this with actual hashing code
    }

    // Verify if the candidate password matches the hashed password
    private boolean verifyHash(String candidatePassword, String hashedPassword) {
        // You need to implement the logic to verify the hashed password
        // Example using BCrypt:
        // return BCrypt.checkpw(candidatePassword, hashedPassword);
        return candidatePassword.equals(hashedPassword); // For demonstration, replace this with actual verification code
    }
}
