package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;

import java.util.List;

public interface UserService {

    public User addUser(User user);

    public List<User> getAllUser();

}
