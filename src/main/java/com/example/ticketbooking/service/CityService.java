package com.example.ticketbooking.service;

import com.example.ticketbooking.dto.CityDTO;
import com.example.ticketbooking.response.BaseResponse;

public interface CityService {

    BaseResponse createCity(CityDTO cityDTO);

    BaseResponse updateCity(CityDTO cityDTO,Long id);

}
