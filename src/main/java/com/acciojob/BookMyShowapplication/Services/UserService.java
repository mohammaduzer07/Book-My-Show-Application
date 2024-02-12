package com.acciojob.BookMyShowapplication.Services;

import com.acciojob.BookMyShowapplication.Entities.User;
import com.acciojob.BookMyShowapplication.Repository.UserRepository;
import com.acciojob.BookMyShowapplication.Requests.AddUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public String addUser(AddUserRequest userRequest){

        User user = User.builder()
                .name(userRequest.getName())
                .emailId(userRequest.getEmailId())
                .build();

        userRepository.save(user);
        return "User has been saved to the DB";

    }
}
