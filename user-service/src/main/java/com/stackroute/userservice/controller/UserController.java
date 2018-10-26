package com.stackroute.userservice.controller;

import com.stackroute.userservice.service.UserService;
import com.stackroute.userservice.service.UserServiceImpl;
import com.stackroute.userservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")

public class UserController {

    private UserService userService;
//@Autowired ikkada setter will not be able to have a clarity e object pettalo
   /* public void setUserService(UserService userService) {
        this.userService = userService;
    } */

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @PostMapping("user")
    public ResponseEntity<?> save(@RequestBody User user) // whatever the jason is coming map it to my user object if the json contains same properties as user.jaav then it will work otherwise dobbey antadi

    {
        //pass to service layer
        //so autowired is used

        User user2 =userService.addUser(user);
        ResponseEntity responseEntity= new ResponseEntity<User>(user2, HttpStatus.OK);
        // return response enntity object //pass the user2 obj create here

        return responseEntity;
    }
    @GetMapping("user")

    public ResponseEntity<?> GetAllUser()
    {
        List<User> userList;
        userList = userService.getAllUser();
        ResponseEntity responseEntity = new ResponseEntity<List<User>>(userList,HttpStatus.OK);
        return responseEntity;
    }

}
