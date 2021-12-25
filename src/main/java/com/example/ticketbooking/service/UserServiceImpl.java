package com.example.ticketbooking.service;

import com.example.ticketbooking.dto.CityDTO;
import com.example.ticketbooking.dto.UserDTO;
import com.example.ticketbooking.model.City;
import com.example.ticketbooking.model.Users;
import com.example.ticketbooking.repository.CityRepository;
import com.example.ticketbooking.repository.UserRepository;
import com.example.ticketbooking.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CityRepository cityRepository;


    @Override
    public UserDTO createUser(UserDTO userDTO) {
        Users users = new Users();
        users.setUserName(userDTO.getUserName());
        users.setPassword(userDTO.getPassword());
        users.setEmail(userDTO.getEmail());
        users.setMobileNo(userDTO.getMobileNo());
        users.setStatus(Boolean.TRUE);
        users.setCreatedAt(new Date());
        Optional<City> city = cityRepository.findById(userDTO.getCityDTO().getId());
        users.setCity(city.get());
        userRepository.save(users);
        return userDTO;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOs = new ArrayList<>();
        List<Users> users = userRepository.findAll();
        users.stream().forEach(user -> {
            UserDTO userDTO = new UserDTO();
            CityDTO cityDTO = new CityDTO();
            userDTO.setUserName(user.getUserName());
            userDTO.setPassword(user.getPassword());
            userDTO.setEmail(user.getEmail());
            userDTO.setMobileNo(user.getMobileNo());
            cityDTO.setId(user.getCity().getId());
            cityDTO.setCityName(user.getCity().getCityName());
            userDTO.setCityDTO(cityDTO);
            userDTOs.add(userDTO);
        });
        return userDTOs;
    }

    @Override
    public BaseResponse updateUser(UserDTO userDTO,Long userId) {
        BaseResponse response = new BaseResponse();
        Optional<Users> users = userRepository.findById(userId);
        if(users.isPresent()){
            users.get().setUserName(userDTO.getUserName());
            users.get().setPassword(userDTO.getPassword());
            users.get().setEmail(userDTO.getEmail());
            users.get().setMobileNo(userDTO.getMobileNo());
            if(userDTO.getCityDTO().getId() != null){
                City city = cityRepository.getByCityId(userDTO.getCityDTO().getId());
                users.get().setCity(city);
            }
            userRepository.save(users.get());
            response.setStatus("success");
            response.setMessage("user upadted successfully");
            response.setData(users.get());
        }else{
            response.setStatus("failed");
            response.setMessage("please provide valid user");
        }
        return response;
    }

    @Override
    public UserDTO getBySingleUser(Long id) {
        UserDTO userDTO = new UserDTO();
        CityDTO cityDTO = new CityDTO();
        Optional<Users> users = userRepository.findById(id);
        if(users.isPresent()){
            userDTO.setUserName(users.get().getUserName());
            userDTO.setPassword(users.get().getPassword());
            userDTO.setEmail(users.get().getEmail());
            userDTO.setMobileNo(users.get().getMobileNo());
            cityDTO.setId(users.get().getCity().getId());
            cityDTO.setCityName(users.get().getCity().getCityName());
            userDTO.setCityDTO(cityDTO);
        }
        return userDTO;
    }
}
