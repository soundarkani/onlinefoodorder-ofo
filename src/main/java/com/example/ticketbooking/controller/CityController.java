package com.example.ticketbooking.controller;

import com.example.ticketbooking.dto.CityDTO;
import com.example.ticketbooking.response.BaseResponse;
import com.example.ticketbooking.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("city")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("createCity")
    public BaseResponse createCity(@RequestBody CityDTO cityDTO){
        return cityService.createCity(cityDTO);
    }

    @PostMapping("upadteCity")
    public BaseResponse updateCity(@RequestBody CityDTO cityDTO, @RequestParam("id") Long id){
        return cityService.updateCity(cityDTO,id);
    }
}
