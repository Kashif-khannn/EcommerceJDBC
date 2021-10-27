package com.cogent.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catalog {
	private String productId;
	private String productName;
	private String catId;
	private String productDescription;
	private String productImage;
	
}