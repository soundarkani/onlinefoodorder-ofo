package com.example.ticketbooking.service;

import com.example.ticketbooking.dto.MasterFoodDTO;
import com.example.ticketbooking.model.MasterFood;
import com.example.ticketbooking.response.BaseResponse;

public interface MasterFoodService {

    BaseResponse savefood(MasterFoodDTO masterFoodDTO);

}
