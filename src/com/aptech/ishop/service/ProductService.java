package com.aptech.ishop.service;

import com.aptech.ishop.entity.Product;
import com.aptech.ishop.model.ProductRequest;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public interface ProductService {
	void save(List<ProductRequest> request);
	void calProfit(List<Product> productList);
	void updateInfoProduct(Scanner sc, List<Product> productList);
	void findByName(Scanner sc, List<Product> productList);
	void sortProfit(List<Product> productList);
	void sortExportPrice(List<Product> productList);
	void updateProductStatus(Scanner sc, List<Product> productList);
}
