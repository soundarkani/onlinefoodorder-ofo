package com.example.ticketbooking.service;

import com.example.ticketbooking.dto.UserDTO;
import com.example.ticketbooking.model.Users;
import com.example.ticketbooking.response.BaseResponse;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    BaseResponse updateUser(UserDTO userDTO,Long userId);

    UserDTO getBySingleUser(Long id);
}
