package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user)
    {

      User newUser = (User) userRepository.save(user);
      return newUser;
    }

    public List<User> getAllUser()
    {
        return (List<User>)userRepository.findAll();
    }

}
