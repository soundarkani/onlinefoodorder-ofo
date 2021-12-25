package com.example.ticketbooking.dto;

public class FoodOrderDTO {

    private Long id;
    private int quantity;
    private UserDTO userDTO;
    private MasterFoodDTO masterFoodDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public MasterFoodDTO getMasterFoodDTO() {
        return masterFoodDTO;
    }

    public void setMasterFoodDTO(MasterFoodDTO masterFoodDTO) {
        this.masterFoodDTO = masterFoodDTO;
    }
}
