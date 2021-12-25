package com.example.ticketbooking.controller;

import com.example.ticketbooking.dto.FoodOrderDTO;
import com.example.ticketbooking.response.BaseResponse;
import com.example.ticketbooking.service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class FoodOrderController {

    @Autowired
    private FoodOrderService foodOrderService;

    @PostMapping("orderfood")
    public BaseResponse saveOrder(@RequestBody FoodOrderDTO foodOrderDTO){
        return foodOrderService.orderFood(foodOrderDTO);
    }

    @GetMapping("food")
    public BaseResponse getOrder(@RequestParam ("id") Long id){
        return foodOrderService.orderFoodByUserId(id);
    }
}
