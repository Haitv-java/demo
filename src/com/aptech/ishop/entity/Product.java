package com.aptech.ishop.entity;

import com.aptech.ishop.model.ProductRequest;

import java.io.Serializable;

public class Product implements IProduct, Serializable {
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
	public Product inputData(ProductRequest request) {
		Product product = new Product();
		product.setProductID(request.getProductID());
		product.setProductName(request.getProductName());
		product.setTitle(request.getTitle());
		product.setDescriptions(request.getDescriptions());
		product.setImportPrice(request.getImportPrice());
		product.setExportPrice(request.getExportPrice());
		product.setProductStatus(request.getProductStatus());

		return product;
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

	@Override
	public String toString() {
		return "Product{" +
				"productID='" + productID + '\'' +
				", productName='" + productName + '\'' +
				", title='" + title + '\'' +
				", importPrice=" + importPrice +
				", exportPrice=" + exportPrice +
				", profit=" + profit +
				", descriptions='" + descriptions + '\'' +
				", productStatus=" + productStatus +
				'}';
	}
}
