package com.example.ticketbooking.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="price")
    private Long price;
    @Column(name="seat_no")
    private String seatNo;
    @Column(name="booking_status")
    private Boolean bookingStatus;
    @Column(name="booking_date")
    private Date bookingDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public Boolean getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(Boolean bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
