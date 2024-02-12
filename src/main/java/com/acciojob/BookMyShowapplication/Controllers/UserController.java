package com.acciojob.BookMyShowapplication.Controllers;

import com.acciojob.BookMyShowapplication.Requests.AddUserRequest;
import com.acciojob.BookMyShowapplication.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    private String addUser(@RequestBody AddUserRequest userRequest){
        String result = userService.addUser(userRequest);
        return result;
    }
}
