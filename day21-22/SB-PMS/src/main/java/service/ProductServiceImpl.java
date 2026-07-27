package com.coforge.pms.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.pms.dto.SupplierDTO;
import com.coforge.pms.exception.InvalidProductObjectException;
import com.coforge.pms.exception.ProductNotFoundException;
import com.coforge.pms.model.Product;
import com.coforge.pms.repo.ProductRepo;
import com.coforge.pms.service.client.SupplierClient;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepo repo;
	private Environment environment;
	private SupplierClient client;
	
	@Autowired
	public ProductServiceImpl(ProductRepo repo, Environment environment,SupplierClient client) {
		super();
		this.repo = repo;
		this.environment = environment;
		this.client = client;
	}


	@Override
	public boolean saveProduct(Product product) {
//		if(product!= null 
//				&& product.getPid() >0 
//				&& product.getPname()!=null 
//				&& product.getPrice() > 0 
//				&& product.getQuantity() > 0 ) {
			repo.save(product);
			return true;
			
//		} else throw new InvalidProductObjectException();
				
	}


	@Override
	public boolean updateProduct(int pid, Product product) {
//		if(pid> 0 && product!= null 
//				&& product.getPid() >0 
//				&& product.getPname()!=null 
//				&& product.getPrice() > 0 
//				&& product.getQuantity() > 0 ) {
			if(!repo.existsById(pid)) throw new ProductNotFoundException(environment.getProperty("pms.invalid.pms-notfound"));
			repo.save(product);
			
			return true;
			
//		} else throw new InvalidProductObjectException();
		
	}


	@Override
	public boolean deleteProduct(int pid) {
//		if(pid>0) {
			if(!repo.existsById(pid)) throw new ProductNotFoundException(environment.getProperty("pms.invalid.pms-notfound"));
			repo.deleteById(pid);
			return true;
			
//		} else throw new InvalidProductObjectException();
		
	}


	@Override
	public Optional<Product> findProductById(int pid)  {
//		if(pid>0) {
			if(!repo.existsById(pid)) throw new ProductNotFoundException(environment.getProperty("pms.invalid.pms-notfound"));
			Optional<Product> product = repo.findById(pid);
			return product;
//		} else throw new InvalidProductObjectException();
		
		
	}


	@Override
	public List<Product> findProducts() {
		List<Product> products = (List<Product>) repo.findAll();
		return products;
	}


	@Override
	public List<Product> findProductByName(String pname) {
		List<Product> products = null;
//		if(pname!=null) {
			 products = repo.findByPname(pname);
		
		if(products.isEmpty()) throw new ProductNotFoundException(environment.getProperty("pms.invalid.pms-notfound"));
//		}
//		
//		else throw new InvalidProductObjectException();
		
		return products;
		
	}


	@Override
	@Transactional
	public boolean deleteProductByName(String pname) {
//		if(pname!=null) {
			int n = repo.deleteByPname(pname);
			if(n==0) throw new ProductNotFoundException(environment.getProperty("pms.invalid.pms-notfound"));
			return true;
//		}
//		else throw new InvalidProductObjectException();
	}


	@Override
	public String getInfo() {
		String info = repo.getInfo();
		return info;
		
	}


	@Override
	public SupplierDTO findSupplierById(int supplierId) {
		SupplierDTO supplier = client.getDepartmentById(supplierId);
		return supplier;
	}


	@Override
	public List<SupplierDTO> findAllSuppliers() {
		List<SupplierDTO> suppliers = client.getAllSuppliers();
		return suppliers;
	}

}
