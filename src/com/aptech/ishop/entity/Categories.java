package com.aptech.ishop.entity;

import java.util.Scanner;

public class Categories implements ICategories {
	private int catalogID;
	private String catalogName;
	private String descriptions;
	private boolean catalogStatus;
	private int parentID;
	
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

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
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
	public void insertData(Categories categories) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Nhap ten danh muc");
		do {
			try {
				categories.setCatalogName(sc.nextLine());
				if (categories.getCatalogName().length() >= 6 && categories.getCatalogName().length() <= 30) {
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
				categories.setDescriptions(sc.nextLine());
				if(categories.getDescriptions() != null) {
					break;
				}else {
					System.out.println("Vui long nhap mo ta");
				}
			} catch (Exception e) {
				System.out.println("Nhap lai mo ta danh muc");
			}
		} while(true);

		System.out.println("Nhap trang thai danh muc");
		do {
			try {
				categories.setCatalogStatus(sc.nextBoolean());
				break;
			} catch (Exception e) {
				System.out.println("Trang thai nhap vao khong hop le, vui long nhap lai");
				sc.next();
			}
		} while (true);

		System.out.println("Nhap ma danh muc cha");
		do {
			try {
				categories.setParentID(sc.nextInt());
				if(categories.getParentID() >= 0 && categories.getParentID() <=2) {
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
	public void displayData(Categories categories) {
		String trangThai;
		if(categories.isCatalogStatus()) {
			trangThai = "Hoat Dong";
		}else {
			trangThai = "Khong Hoat Dong";
		}
		System.out.printf("Ma danh muc: %d - Ten danh muc: %s\n", categories.getCatalogID(), categories.getCatalogName());
		System.out.printf("Mo ta: %s\n", categories.getDescriptions());
		System.out.printf("Danh muc cha: %d - Trang thai: %s\n", categories.getParentID(), trangThai);

	}
}
