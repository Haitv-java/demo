package com.aptech.ishop.entity;

public class Product {
	private String productID;
	private String productName;
	private String title;
	private float importPrice;
	private float exportPrice;
	private float profit;
	private String decriptions;
	private boolean productStatus;
	private Categories catalog;
	
	public Product() {
		super();
	}

	public Product(String productID, String productName, String title, float importPrice, float exportPrice,
			float profit, String decriptions, boolean productStatus, Categories catalog) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.title = title;
		this.importPrice = importPrice;
		this.exportPrice = exportPrice;
		this.profit = profit;
		this.decriptions = decriptions;
		this.productStatus = productStatus;
		this.catalog = catalog;
	}

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getImportPrice() {
		return importPrice;
	}

	public void setImportPrice(float importPrice) {
		this.importPrice = importPrice;
	}

	public float getExportPrice() {
		return exportPrice;
	}

	public void setExportPrice(float exportPrice) {
		this.exportPrice = exportPrice;
	}

	public float getProfit() {
		return profit;
	}

	public void setProfit(float profit) {
		this.profit = profit;
	}

	public String getDecriptions() {
		return decriptions;
	}

	public void setDecriptions(String decriptions) {
		this.decriptions = decriptions;
	}

	public boolean isProductStatus() {
		return productStatus;
	}

	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}

	public Categories getCatalog() {
		return catalog;
	}

	public void setCatalog(Categories catalog) {
		this.catalog = catalog;
	}
}
