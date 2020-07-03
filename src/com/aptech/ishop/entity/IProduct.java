package com.aptech.ishop.entity;

import java.util.List;
import java.util.Scanner;

public interface IProduct {
	void displayData(Product product);
	void calProfit(Product product);
	void inputData(Product product, Scanner scanner);
}
