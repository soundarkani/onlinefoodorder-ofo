package com.example.ticketbooking.repository;

import com.example.ticketbooking.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City , Long> {

    @Query("select c from City as c where c.id = :id")
    City getByCityId(@Param("id") Long id);
}
