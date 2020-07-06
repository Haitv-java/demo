package com.aptech.ishop.entity;

import com.aptech.ishop.model.ProductRequest;

public interface IProduct {
	void displayData(Product product);
	void calProfit(Product product);
	Product inputData(ProductRequest request);
}
