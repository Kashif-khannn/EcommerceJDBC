package com.cogent.ecommerce.repository;

import java.util.Optional;

import com.cogent.ecommerce.model.Cart;

public interface CartRepository {
	public String addCart(Cart cart);
	public void deleteAll();
	public String deleteCartById(String cartId);
	public Optional<Cart> getCartById(String cartId);
}
