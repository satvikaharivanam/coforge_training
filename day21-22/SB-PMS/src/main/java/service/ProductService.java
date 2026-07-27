package com.coforge.pms.service;

import java.util.List;
import java.util.Optional;

import com.coforge.pms.dto.SupplierDTO;
import com.coforge.pms.model.Product;

public interface ProductService {

	boolean saveProduct(Product product) ;

	boolean updateProduct(int pid, Product product) ;

	boolean deleteProduct(int pid) ;

	Optional<Product> findProductById(int pid);

	List<Product> findProducts();

	List<Product> findProductByName(String pname);

	boolean deleteProductByName(String pname) ;

	String getInfo();

	SupplierDTO findSupplierById(int supplierId);

	List<SupplierDTO> findAllSuppliers();

}
