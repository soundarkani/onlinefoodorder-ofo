package com.example.ticketbooking.repository;

import com.example.ticketbooking.model.MasterFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterFoodRepository extends JpaRepository<MasterFood,Long> {

}
