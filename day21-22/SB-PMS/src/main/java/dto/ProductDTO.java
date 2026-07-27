package com.coforge.pms.dto;

import com.coforge.pms.model.Product;

public class ProductDTO {

	Product product;
	SupplierDTO supplier;

	public ProductDTO() {
		super();
	}

	public ProductDTO(Product product, SupplierDTO supplier) {
		super();
		this.product = product;
		this.supplier = supplier;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public SupplierDTO getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierDTO supplier) {
		this.supplier = supplier;
	}

}
