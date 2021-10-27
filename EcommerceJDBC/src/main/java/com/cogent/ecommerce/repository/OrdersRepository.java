package com.cogent.ecommerce.repository;

import java.util.Optional;

import com.cogent.ecommerce.model.Orders;

public interface OrdersRepository {
	public String addOrder(Orders order);
	public void deleteAll();
	public boolean isOrderExists(String orderId);
	public Optional<String> deleteOrderById(String orderId);
	public Orders getOrderById(String orderId);
	

}
