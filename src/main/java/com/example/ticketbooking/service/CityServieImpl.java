package com.example.ticketbooking.service;

import com.example.ticketbooking.dto.CityDTO;
import com.example.ticketbooking.model.City;
import com.example.ticketbooking.repository.CityRepository;
import com.example.ticketbooking.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CityServieImpl implements CityService{

    @Autowired
    private CityRepository cityRepository;

    @Override
    public BaseResponse createCity(CityDTO cityDTO) {
        BaseResponse response = new BaseResponse();
        City city = new City();
        city.setCityName(cityDTO.getCityName());
        city.setStatus(Boolean.TRUE);
        city.setCreatedAt(new Date());
        cityRepository.save(city);
        response.setStatus("success");
        response.setMessage("city created");
        response.setData(city);
        return response;
    }

    @Override
    public BaseResponse updateCity(CityDTO cityDTO, Long id) {
        BaseResponse response = new BaseResponse();
        if(id != null){
            City city = cityRepository.getByCityId(id);
            if(city != null) {
                if (city != null) {
                    if (cityDTO.getCityName() != null) {
                        city.setCityName(cityDTO.getCityName());
                    }
                    if (cityDTO.getStatus() != null) {
                        city.setStatus(cityDTO.getStatus());
                    }
                    cityRepository.save(city);
                }
                response.setStatus("success");
                response.setMessage("city updated");
                response.setData(city);
            }else{
                response.setStatus("failed");
                response.setMessage("please provide valid city id"+":"+id);
            }
        }else{
            response.setStatus("failed");
            response.setMessage("please provide any city id");
        }
        return response;
    }
}
