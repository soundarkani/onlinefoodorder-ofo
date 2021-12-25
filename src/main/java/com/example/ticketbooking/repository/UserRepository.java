package com.example.ticketbooking.repository;

import com.example.ticketbooking.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users , Long> {

}
