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

	public void setTitle(String title) {
		this.title = title;
	}

	public void setImportPrice(float importPrice) {
		this.importPrice = importPrice;
	}

	public void setExportPrice(float exportPrice) {
		this.exportPrice = exportPrice;
	}

	public void setProfit(float profit) {
		this.profit = profit;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
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

	public boolean getProductStatus() {
		return this.productStatus;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public void inputData(Product product, Scanner sc, Product existProduct) {
		product.setProductID(formInputText(sc, PRODUCT_ID, existProduct));
		product.setProductName(formInputText(sc, PRODUCT_NAME, existProduct));
		product.setTitle(formInputText(sc, PRODUCT_TITLE, product));
		product.setDescriptions(formInputText(sc, PRODUCT_DESCRIPTION, product));
		product.setImportPrice(formInputNumber(sc, PRODUCT_PRICE_IMPORT, product));
		product.setExportPrice(formInputNumber(sc, PRODUCT_PRICE_EXPORT, product));
		formInputBoolean(sc, PRODUCT_STATUS, product);
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
				value = Float.parseFloat(scanner.nextLine());
				if (ProductValidate.inputValid(field, String.valueOf(value), product)) break;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Nhap lai " + field);
			}
		} while (true);
		return value;
	}

	public void formInputBoolean(Scanner scanner, String field, Product product) {
		System.out.println(field);
		do {
			String status = scanner.nextLine();
			if (status.equalsIgnoreCase("true") || status.equalsIgnoreCase("false")) {
				if (status.equalsIgnoreCase("true")) {
					product.setProductStatus(true);
				}
				return;
			} else {
				System.out.println("Trang thai san pham khong hop le, vui long nhap lai");
			}
		} while (true);
	}

	@Override
	public void calProfit(Product product) {
		this.profit = (product.getExportPrice() - product.getImportPrice());
	}

	@Override
	public void displayData(Product product) {
		if (product == null) return;
		String status;
		if(product.getProductStatus()) {
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
