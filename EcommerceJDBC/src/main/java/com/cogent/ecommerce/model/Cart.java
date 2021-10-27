package com.cogent.ecommerce.model;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	private String cartId;
	private String userId;
	private String invId;
	private String productId;
	private String productQty;
	private double totalPrice;
	
	

	}


