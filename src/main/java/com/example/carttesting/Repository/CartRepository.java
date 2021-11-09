package com.example.carttesting.Repository;

import com.example.carttesting.Models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer>{
}
