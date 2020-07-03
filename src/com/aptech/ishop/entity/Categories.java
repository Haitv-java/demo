package com.aptech.ishop.entity;

public class Categories {
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
}
