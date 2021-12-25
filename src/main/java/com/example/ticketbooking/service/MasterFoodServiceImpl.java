package com.example.ticketbooking.service;

import com.example.ticketbooking.dto.MasterFoodDTO;
import com.example.ticketbooking.model.MasterFood;
import com.example.ticketbooking.repository.MasterFoodRepository;
import com.example.ticketbooking.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MasterFoodServiceImpl implements MasterFoodService{

    @Autowired
    MasterFoodRepository masterFoodRepository;

    @Override
    public BaseResponse savefood(MasterFoodDTO masterFoodDTO) {
        BaseResponse baseResponse = new BaseResponse();
        MasterFood masterFood = new MasterFood();
        masterFood.setFoodname(masterFoodDTO.getFoodname());
        masterFood.setStatus(masterFoodDTO.getStatus());
        masterFood.setPrice(masterFoodDTO.getPrice());
        masterFood.setDate(masterFoodDTO.getDate());
        masterFood.setQty(masterFoodDTO.getQty());
        masterFoodRepository.save(masterFood);
         return baseResponse.setMessage("save suceesfully");

    }



}
