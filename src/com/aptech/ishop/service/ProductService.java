package com.aptech.ishop.service;

import com.aptech.ishop.entity.Product;
import com.aptech.ishop.model.ProductRequest;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public interface ProductService {
	void createProduct(List<ProductRequest> request);
	void calProfit();
	void updateInfoProduct(ProductRequest request);
	void findByName(String productName);
	void sortProfit();
	void sortExportPrice();
	void updateProductStatus(String productId);
	void getAllProducts();
}
