package com.example.ticketbooking.service;

import com.example.ticketbooking.dto.BookingDTO;
import com.example.ticketbooking.model.Booking;
import com.example.ticketbooking.model.Users;
import com.example.ticketbooking.repository.BookingRepository;
import com.example.ticketbooking.repository.UserRepository;
import com.example.ticketbooking.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public BaseResponse createBooking(BookingDTO bookingDTO) {
        BaseResponse response = new BaseResponse();
        Optional<Users> users = userRepository.findById(bookingDTO.getUserId());
        if(users.isPresent()) {
            Booking booking = new Booking();
            Booking seatStatus = bookingRepository.findByseatNoAndBookingDateAndBookingStatusTrue(bookingDTO.getSeatNo(),bookingDTO.getBookingDate());
            if(seatStatus == null){
                booking.setBookingDate(bookingDTO.getBookingDate());
                booking.setBookingStatus(Boolean.TRUE);
                booking.setPrice(bookingDTO.getPrice());
                booking.setSeatNo(bookingDTO.getSeatNo());
                booking.setUsers(users.get());
                bookingRepository.save(booking);
                response.setStatus("success");
                response.setMessage("your seat is booked successfully");
            }else{
                response.setStatus("sorry");
                response.setMessage("seat is already booked");
            }
        }else{
            response.setStatus("failed");
            response.setMessage("please register");
        }
        return response;
    }
}
