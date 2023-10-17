package com.endasssignment.javaendassignment.Service;

import com.endasssignment.javaendassignment.Database.Database;
import com.endasssignment.javaendassignment.Model.Exceptions;
import com.endasssignment.javaendassignment.Model.User;

public class UserService {
    private final Database database;

    public UserService(Database database) {
        this.database = database;
    }

    public User getUserByUsername(String username) {
        return database.users.get(username);
    }

    public boolean authenticate(String username, String password) throws Exceptions.UserNotFoundException, Exceptions.InvalidPasswordException {
        User user = getUserByUsername(username);
        if (user == null) {
            throw new Exceptions.UserNotFoundException("User not found.");
        }
        if (!user.verifyPassword(password)) {
            throw new Exceptions.InvalidPasswordException("Invalid password.");
        }
        return true;
    }

}
