package com.example.carttesting.Controllers;

import com.example.carttesting.Models.Cart;
import com.example.carttesting.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class CartController {
    @Autowired
    CartService cartService;

   @GetMapping("/get-all")
    public List<Cart> getAll(){
        return cartService.getAllCarts();
    }

    @PostMapping("/add-cart")
    public Cart addStudent(@RequestBody Cart cart){
        return cartService.createCart(cart.getId(), cart.getPrice());
    }
}
