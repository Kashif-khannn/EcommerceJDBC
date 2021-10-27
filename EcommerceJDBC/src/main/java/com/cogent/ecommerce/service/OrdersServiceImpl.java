package com.cogent.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.ecommerce.model.Orders;
import com.cogent.ecommerce.repository.OrdersRepository;
@Service
public class OrdersServiceImpl implements OrdersService{
	
	@Autowired
	OrdersRepository ordersRepository;
	@Override
	public String addOrder(Orders order) {
		// TODO Auto-generated method stub
		return ordersRepository.addOrder(order);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		ordersRepository.deleteAll();
		
	}

	@Override
	public boolean isOrderExists(String orderId) {
		// TODO Auto-generated method stub
		return ordersRepository.isOrderExists(orderId);
	}

	@Override
	public Optional<String> deleteOrderById(String orderId) {
		// TODO Auto-generated method stub
		return ordersRepository.deleteOrderById(orderId) ;
	}

	@Override
	public Orders getOrderById(String orderId) {
		// TODO Auto-generated method stub
		return ordersRepository.getOrderById(orderId);
	}

}
