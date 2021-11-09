package com.example.carttesting.Services;


import com.example.carttesting.Models.Cart;
import com.example.carttesting.Repository.CartRepository;
import com.example.carttesting.Service.CartService;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class CartServiceTest {
    @Mock
    CartRepository cartRepository;

    @InjectMocks
    CartService cartService;


    @Test
    public void returnCarts(){
        when(cartRepository.findAll()).thenReturn(Arrays.asList(new Cart(1, 1000L),new Cart(2, 2000L)));
        assertEquals(Optional.of(1000L),cartService.getAllCarts().get(0).getPrice());
    }

    @Test
    public  void createCart(){
        when(cartRepository.save(ArgumentMatchers.any(Cart.class))).thenReturn(new Cart(1, 100000L));
        assertEquals(100000L, cartService.createCart(1, 500L) );
    }
    @Test
    public void deleteCart(){

        Cart crt = new Cart(4,1000L);
        when(cartRepository.findById(crt.getId())).thenReturn(Optional.of(crt));

        cartService.deleteCart(crt.getId());

        verify(cartRepository).deleteById(crt.getId());

    }

    @Test
    public void updateCart(){
        Cart crt = new Cart(1,10L);
        Cart newCrt = new Cart(1,10000L);
        given(cartRepository.findById(crt.getId())).willReturn(Optional.of(crt));

        cartService.updateCart(crt.getId(),newCrt);
        verify(cartRepository).save(newCrt);
        verify(cartRepository).findById(crt.getId());

    }

    @Test
    public void returnCart(){
        Cart cart = new Cart();
        cart.setId(2);

        when(cartRepository.findById(cart.getId())).thenReturn(Optional.of(cart));

        Cart expected = cartService.detailCart(cart.getId());

        assertThat(expected).isSameAs(cart);

        verify(cartRepository).findById(cart.getId());
    }


}
