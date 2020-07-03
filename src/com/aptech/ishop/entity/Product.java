package com.aptech.ishop.entity;

import java.io.Serializable;
import java.util.Scanner;

import com.aptech.ishop.service.IProduct;

public class Product implements IProduct, Serializable {
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

	@Override
	public void inputData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Tieu de san pham");
		do {
			try {
				this.title = sc.nextLine();
				if(title.length() >= 6 && title.length() <= 30) {
					break;
				}else {
					System.out.println("Tieu de danh muc phai nhieu hon 6 va be hon 30 ky tu");
				}
			} catch (Exception e) {
				System.out.println("Nhap lai tieu de san pham");
			}
		} while (true);
		
		System.out.println("Nhap gia san pham");
		do {
			try {
				this.importPrice = Float.parseFloat(sc.nextLine());
				if(this.importPrice > 0) {
					break;
				}else {
					System.out.println("Gia nhap phai lon hon 0, vui long nhap lai");
				}
			} catch (Exception e) {
				System.out.println("Gia nhap san pham khong hop le, vui long nhap lai");
			}
		} while (true);
		
		System.out.println("Nhap gia ban san pham");
		do {
			try {
				this.exportPrice = Float.parseFloat(sc.nextLine());
				if(this.exportPrice >= (MIN_INTEREST_RATE * this.importPrice + this.importPrice) ) {
					break;
				}else {
					System.out.println("Gia ban san pham phai co gia tri lon hon gia ban it nhat la MIN_INTEREST_RATE lan ");
				}
			} catch (Exception e) {
				System.out.println("Gia ban san pham khong hop le, vui long nhap lai");
			}
		} while (true);
		System.out.println("Nhap mo ta san pham");
		do {
			try {
				this.decriptions = sc.nextLine();
				if(this.decriptions != null) {
					break;
				}else {
					System.out.println("Mo ta san pham khong duoc de trong, vui long nhap lai");
				}
			} catch (Exception e) {
				System.out.println("Mo ta san pham khong hop le, vui long nhap lai");
			}
		} while (true);
		System.out.println("Nhap trang thai san pham");
		do {
			try {
			this.productStatus = sc.nextBoolean();
			break;
		} catch (Exception e) {
			System.out.println("Trang thai san pham khong hop le, vui long nhap lai");
			sc.next();
		}
		} while (true);
	}
	

	@Override
	public void displayData() {
		String trangThai;
		if(productStatus == true) {
			trangThai = "Hoat dong";
		}else {
			trangThai = "Khong hoat dong";
		}
		System.out.printf("Ma san pham: %d - Ten san pham: %s\n", this.productID, this.productName );
		System.out.printf("Tieu de san pham: %s\n", this.decriptions);
		System.out.printf("Gia nhap san pham: %f - Gia ban sam pham: %f\n", this.importPrice, this.exportPrice);
		System.out.printf("Loi nhuan san pham: %f\n", this.profit);
		System.out.printf("Mo ta san pham: %s - Trang thai: %s\n", this.decriptions, trangThai);
	}

	@Override
	public void calProfit() {
		this.profit = this.exportPrice - this.importPrice;
	}

}
