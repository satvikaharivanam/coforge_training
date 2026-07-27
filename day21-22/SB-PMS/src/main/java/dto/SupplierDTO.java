package com.coforge.pms.dto;

public class SupplierDTO {
	
	private int supplierId;

	private String supplierName;

	private String city;

	public SupplierDTO() {
		super();
	}

	public SupplierDTO( int supplierId,  String supplierName,  String city) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.city = city;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", city=" + city + "]";
	}
	
	
	
	
	
}
