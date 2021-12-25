package com.example.ticketbooking.service;

import com.example.ticketbooking.dto.FoodOrderDTO;
import com.example.ticketbooking.model.FoodOrder;
import com.example.ticketbooking.model.MasterFood;
import com.example.ticketbooking.model.Users;
import com.example.ticketbooking.repository.FoodOrderRepository;
import com.example.ticketbooking.repository.MasterFoodRepository;
import com.example.ticketbooking.repository.UserRepository;
import com.example.ticketbooking.response.BaseResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoodOrderImpl implements  FoodOrderService{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FoodOrderRepository foodOrderRepository;

    @Autowired
    private MasterFoodRepository masterFoodRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public BaseResponse orderFood(FoodOrderDTO foodOrderDTO) {

        BaseResponse response = new BaseResponse();
        Optional<Users> dbUsers = null;
        Optional<MasterFood> dbMasterFood = null;
        Double foodPrice = null;

        if(foodOrderDTO.getUserDTO() != null){
            dbUsers = userRepository.findById(foodOrderDTO.getUserDTO().getId());
        }

        if(foodOrderDTO.getMasterFoodDTO() != null){
            dbMasterFood = masterFoodRepository.findById(foodOrderDTO.getMasterFoodDTO().getId());
        }

        FoodOrder foodOrder = new FoodOrder();
        if(dbUsers.isPresent()) {
            foodOrder.setUsers(dbUsers.get());
        }

        if(dbMasterFood.isPresent()){
            foodOrder.setMasterFoods(dbMasterFood.get());
            foodPrice = dbMasterFood.get().getPrice() * foodOrderDTO.getQuantity();
        }

        foodOrder.setQuantity(foodOrderDTO.getQuantity());
        foodOrder.setPrice(foodPrice);
        FoodOrder dbFoodOrder = foodOrderRepository.save(foodOrder);

        FoodOrderDTO foodOrderDTO1 = modelMapper.map(dbFoodOrder , FoodOrderDTO.class);
        response.setStatus("success");
        response.setMessage("your food was ordered");
        response.setData(foodOrderDTO1);

        return response;
    }

    @Override
    public BaseResponse orderFoodByUserId(Long id) {
        BaseResponse response = new BaseResponse();

        Optional<FoodOrder> getOrder = foodOrderRepository.findById(id);
        if(getOrder.isPresent()){
            response.setStatus("success");
            response.setMessage("your food");
            response.setData(getOrder.get());
        }else{
            response.setStatus("failed");
            response.setMessage("please enter valid order id::"+id);
        }
        return response;
    }
}
