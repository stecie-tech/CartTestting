package com.example.carttesting.Service;

import com.example.carttesting.Models.Cart;
import com.example.carttesting.Repository.CartRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CartService {
    CartRepository cartRepository;

    public List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }

    public Cart createCart(Integer id, Long price){
        Cart cart = new Cart(id, price);

        return cartRepository.save(cart);
    }

    public void deleteCart(Integer id){
        cartRepository.findById(id)
                .orElseThrow( ()->new RuntimeException("Cart not found with id"+ id));
        cartRepository.deleteById(id);

        CalculatorServiceImple calculatorServiceImple = new CalculatorServiceImple();


    }

    public Cart updateCart(Integer id, Cart cart){
        cartRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Cart not found with id"+ id));

        cart.setId(id);

        CalculatorServiceImple calculatorServiceImple = new CalculatorServiceImple();

        return cartRepository.save(cart);

    }

    public Cart detailCart(Integer id){
        return cartRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Cart with id "+id+ " not found!"));
    }
}
