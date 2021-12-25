package com.example.ticketbooking.service;

import com.example.ticketbooking.dto.FoodOrderDTO;
import com.example.ticketbooking.response.BaseResponse;

public interface FoodOrderService {

    BaseResponse orderFood(FoodOrderDTO foodOrderDTO);

    BaseResponse orderFoodByUserId(Long id);


}
