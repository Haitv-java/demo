package com.aptech.ishop.entity;

import java.io.Serializable;
import java.util.Scanner;

import com.aptech.ishop.service.ICategories;

public class Categories implements ICategories, Serializable {
	private int catalogID;
	private String catalogName;
	private String decriptions;
	private boolean catalogStatus;
	private int parentID;
	
	public Categories() {
		super();
	}

	public Categories(int catalogID, String catalogName, String decriptions, boolean catalogStatus, int parentID) {
		super();
		this.catalogID = catalogID;
		this.catalogName = catalogName;
		this.decriptions = decriptions;
		this.catalogStatus = catalogStatus;
		this.parentID = parentID;
	}

	public int getCatalogID() {
		return catalogID;
	}

	public void setCatalogID(int catalogID) {
		this.catalogID = catalogID;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public String getDecriptions() {
		return decriptions;
	}

	public void setDecriptions(String decriptions) {
		this.decriptions = decriptions;
	}

	public boolean isCatalogStatus() {
		return catalogStatus;
	}

	public void setCatalogStatus(boolean catalogStatus) {
		this.catalogStatus = catalogStatus;
	}

	public int getParentID() {
		return parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}

	@Override
	public void inputData() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap ten danh muc");
		do {
			try {
				this.catalogName = sc.nextLine();
				if(catalogName.length() >= 6 && catalogName.length() <= 30) {
					break;
				}else {
					System.out.println("Nhap lai ten danh muc");
				}
			} catch (Exception e) {
				System.out.println("Ten danh muc phai la mot chuoi ky tu");
			}
		} while (true);
		
		System.out.println("Nhap mo ta danh muc");
		do {
			try {
				this.decriptions = sc.nextLine();
				if(decriptions != null) {
					break;
				}else {
					System.out.println("Vui long nhap mo ta");
				}
			} catch (Exception e) {
				System.out.println("Nhap lai mo ta danh muc");
			}
		} while (true);
		
		System.out.println("Nhap trang thai danh muc");
		do {
			try {
				this.catalogStatus = sc.nextBoolean();
				break;
			} catch (Exception e) {
				System.out.println("Trang thai nhap vao khong hop le, vui long nhap lai");
				sc.next();
			}
		} while (true);
		
		System.out.println("Nhap ma danh muc cha");
		do {
			try {
				this.parentID = sc.nextInt();
				if(this.parentID >= 0 && this.parentID <=2) {
					break;
				}else {
					System.out.println("Danh muc cha chi quan ly toi da 3 cap danh muc, vui long nhap lai");
				}
			} catch (Exception e) {
				System.out.println("Ma danh muc khong phu hop, vui long nhap lai");
				sc.next();
			}
		} while (true);
	}

	@Override
	public void displayData() {
		String trangThai;
		if(this.isCatalogStatus() == true) {
			trangThai = "Hoat Dong";
		}else {
			trangThai = "Khong Hoat Dong";
		}
		System.out.printf("Ma danh muc: %d - Ten danh muc: %s\n", this.catalogID, this.catalogName);
		System.out.printf("Mo ta: %s\n", this.decriptions);
		System.out.printf("Danh muc cha: %d - Trang thai: %s\n", this.parentID, trangThai);
		
	}

}
