package com.aptech.ishop.entity;

import com.aptech.ishop.validate.ProductValidate;

import java.util.Scanner;

import static com.aptech.ishop.utils.Constant.*;

public class Product implements IProduct {
	private String productID;
	private String productName;
	private String title;
	private float importPrice;
	private float exportPrice;
	private float profit;
	private String descriptions;
	private boolean productStatus;

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getImportPrice() {
		return importPrice;
	}

	public float getExportPrice() {
		return exportPrice;
	}

	public float getProfit() {
		return profit;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public boolean isProductStatus() {
		return productStatus;
	}

	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public void inputData(Product product, Scanner sc) {
		this.productID = formInputText(sc, PRODUCT_ID, product);
		this.productName = formInputText(sc, PRODUCT_NAME, product);
		this.title = formInputText(sc, PRODUCT_TITLE, product);
		this.descriptions = formInputText(sc, PRODUCT_DESCRIPTION, product);
		this.importPrice = formInputNumber(sc, PRODUCT_PRICE_IMPORT, product);
		this.exportPrice = formInputNumber(sc, PRODUCT_PRICE_EXPORT, product);
		this.productStatus = formInputBoolean(sc, PRODUCT_STATUS);
	}

	public String formInputText(Scanner scanner, String field, Product product) {
		System.out.println(field);
		String value;
		do {
			try {
				value = scanner.nextLine();
				if (ProductValidate.inputValid(field, value, product)) break;
			} catch (Exception e) {
				System.out.println("Nhap lai" + field);
			}
		} while (true);
		return value;
	}

	public float formInputNumber(Scanner scanner, String field, Product product) {
		System.out.println(field);
		float value;
		do {
			try {
				scanner.nextLine();
				value = scanner.nextFloat();
				scanner.nextLine();
				if (ProductValidate.inputValid(field, String.valueOf(value), product)) break;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Nhap lai " + field);
			}
		} while (true);
		return value;
	}

	public boolean formInputBoolean(Scanner scanner, String field) {
		System.out.println(field);
		boolean value;
		do {
			try {
				value = scanner.nextBoolean();
				break;
			} catch (Exception e) {
				System.out.println("Trang thai san pham khong hop le, vui long nhap lai");
				scanner.next();
			}
		} while (true);
		return value;
	}

	@Override
	public void calProfit(Product product) {
		this.profit = (product.getExportPrice() - product.getImportPrice());
	}

	@Override
	public void displayData(Product product) {
		if (product == null) return;
		String status;
		if(this.productStatus) {
			status = "Hoat dong";
		}else {
			status = "Khong hoat dong";
		}
		System.out.printf("Ma san pham: %s - Ten san pham: %s\n", product.getProductID(), product.getProductName());
		System.out.printf("Tieu de san pham: %s\n", product.getDescriptions());
		System.out.printf("Gia nhap san pham: %f - Gia ban sam pham: %f\n", product.getImportPrice(), product.getExportPrice());
		System.out.printf("Loi nhuan san pham: %f\n", product.getProfit());
		System.out.printf("Mo ta san pham: %s - Trang thai: %s\n", product.getDescriptions(), status);
	}
}
