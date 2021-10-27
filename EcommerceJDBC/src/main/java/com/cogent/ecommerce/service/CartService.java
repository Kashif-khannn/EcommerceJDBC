package com.cogent.ecommerce.service;

import java.util.Optional;

import com.cogent.ecommerce.model.Cart;

public interface CartService {
	public String addCart(Cart cart);
	public void deleteAll();
	public String deleteCartById(String cartId);
	public Optional<Cart> getCartById(String cartId);
}
