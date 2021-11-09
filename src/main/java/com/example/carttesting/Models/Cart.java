package com.example.carttesting.Models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {
    @Id
    private Integer id;

    private Long price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Cart() {
    }

    public Cart(Long price) {
       this.price=price;
    }

    public Cart(Integer id, Long price) {
        this.id = id;
        this.price = price;
    }

}








