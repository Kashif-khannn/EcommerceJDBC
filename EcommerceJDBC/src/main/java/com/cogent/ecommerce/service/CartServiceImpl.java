package com.cogent.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.ecommerce.model.Cart;
import com.cogent.ecommerce.repository.CartRepository;
@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartRepository cartRepository;

	@Override
	public String addCart(Cart cart) {
	
		return cartRepository.addCart(cart);
	}

	@Override
	public void deleteAll() {
		
		
	}

	@Override
	public String deleteCartById(String cartId) {

		return cartRepository.deleteCartById(cartId);
	}

	@Override
	public Optional<Cart> getCartById(String cartId) {
	
		return cartRepository.getCartById(cartId);
	}

}
