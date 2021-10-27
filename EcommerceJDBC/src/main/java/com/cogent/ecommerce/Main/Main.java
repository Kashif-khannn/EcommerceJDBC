package com.cogent.ecommerce.Main;

import com.cogent.ecommerce.service.CartService;
import com.cogent.ecommerce.service.CartServiceImpl;
import com.cogent.ecommerce.utils.DBUtils;


public class Main {

	public static void main(String[] args) {
		DBUtils dbUtils = DBUtils.getInstance();
		CartService cartService = CartServiceImpl.getInstance();
		

	}

}
