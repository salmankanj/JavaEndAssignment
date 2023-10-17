package com.endasssignment.javaendassignment.Model;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Base64;

public class User {
    private String username;
    private String password;
    private LocalDate dateOfBirth;
    private String hashedPassword;
    private byte[] salt;


    public enum Role {
        Sales,
        Manager
    }

    private Role userRole;

    public User(String username, String password, LocalDate dateOfBirth, Role role) {
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.salt = generateSalt();
        this.hashedPassword = hashPassword(password, salt);
        this.userRole = role;
    }
    private byte[] generateSalt() {
        byte[] salt = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);
        return salt;
    }

    private String hashPassword(String password, byte[] salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedPasswordBytes = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedPasswordBytes);
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
            return null;
        }
    }

    public String getUsername() {
        return username;
    }
    public boolean verifyPassword(String inputPassword) {
        String hashedInputPassword = hashPassword(inputPassword, this.salt);
        assert hashedInputPassword != null;
        return hashedInputPassword.equals(this.hashedPassword);
    }

    public String getUserRole() {
        return userRole.toString();
    }
}
