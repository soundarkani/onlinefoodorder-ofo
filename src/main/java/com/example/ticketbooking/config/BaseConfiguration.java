package com.example.ticketbooking.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BaseConfiguration {
    //Bean creation
    @Bean
    public ModelMapper getModuleMapper(){
        return new ModelMapper();
    }

}
