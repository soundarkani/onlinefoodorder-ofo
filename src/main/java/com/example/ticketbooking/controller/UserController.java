package com.example.ticketbooking.controller;

import com.example.ticketbooking.dto.UserDTO;
import com.example.ticketbooking.response.BaseResponse;
import com.example.ticketbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @GetMapping("/allUsers")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/updateUser")
    public BaseResponse updateUser(@RequestBody UserDTO userDTO,@RequestParam ("userId") Long userId){
        return userService.updateUser(userDTO,userId);
    }

    @GetMapping("/singleUser")
    public UserDTO getBySingleUser(@RequestParam("id") Long id){
        return userService.getBySingleUser(id);
    }
}
