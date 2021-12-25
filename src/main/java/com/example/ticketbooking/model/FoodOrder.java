package com.example.ticketbooking.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="food_order")
public class FoodOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "user_id_fk")
    private Users users;
    @ManyToOne
    @JoinColumn(name = "master_food_id_fk")
    private MasterFood masterFoods;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public MasterFood getMasterFoods() {
        return masterFoods;
    }

    public void setMasterFoods(MasterFood masterFoods) {
        this.masterFoods = masterFoods;
    }
}
