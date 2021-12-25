package com.example.ticketbooking.service;

import com.example.ticketbooking.dto.BookingDTO;
import com.example.ticketbooking.response.BaseResponse;

public interface BookingService {

    BaseResponse createBooking(BookingDTO bookingDTO);
}
