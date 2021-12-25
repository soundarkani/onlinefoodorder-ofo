package com.example.ticketbooking.controller;

import com.example.ticketbooking.dto.BookingDTO;
import com.example.ticketbooking.response.BaseResponse;
import com.example.ticketbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("newBooking")
    public BaseResponse createBooking(@RequestBody BookingDTO bookingDTO){
        return bookingService.createBooking(bookingDTO);
    }
}
