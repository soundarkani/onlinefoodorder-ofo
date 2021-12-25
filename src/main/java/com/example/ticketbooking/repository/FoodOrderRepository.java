package com.example.ticketbooking.repository;

import com.example.ticketbooking.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder,Long> {
}
