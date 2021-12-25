package com.example.ticketbooking.repository;

import com.example.ticketbooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface BookingRepository extends JpaRepository<Booking , Long> {

    Booking findByseatNoAndBookingDateAndBookingStatusTrue(String seatNo, Date bookingDate);
}
