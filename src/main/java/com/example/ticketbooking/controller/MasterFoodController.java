package com.example.ticketbooking.controller;

import com.example.ticketbooking.dto.MasterFoodDTO;
import com.example.ticketbooking.response.BaseResponse;
import com.example.ticketbooking.service.MasterFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("food")
public class MasterFoodController {

    @Autowired
    MasterFoodService masterFoodService;

    @RequestMapping("/save")
    public BaseResponse saveFood(@RequestBody MasterFoodDTO masterFoodDTO){
        return masterFoodService.savefood(masterFoodDTO);

    }
}
