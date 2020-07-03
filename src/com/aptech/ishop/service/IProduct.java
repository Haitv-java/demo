package com.aptech.ishop.service;

import com.aptech.ishop.entity.Product;

import java.util.List;
import java.util.Scanner;

public interface IProduct {
	float MIN_INTEREST_RATE = (float) 0.2;
	void inputData(Scanner sc, List<Product> productList);
	void displayData();
	void calProfit(List<Product> productList);
	void updateInfoProduct(Scanner sc, List<Product> productList);
	void findByName(Scanner sc, List<Product> productList);
	void sortProfit(List<Product> productList);
	void sortExportPrice(List<Product> productList);
	void updateProductStatus(Scanner sc, List<Product> productList);
}
