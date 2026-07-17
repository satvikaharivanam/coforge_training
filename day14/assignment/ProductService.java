package com.coforge.pms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.coforge.pms.model.Product;


@Service
public class ProductService {
	
	private Map<Integer,Product> products = new HashMap<>();
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		
		if(products.containsKey((product.getPid()))) return false;
		
		products.put(product.getPid(),product);
		
		System.out.println(products);
		
		return true;
		
	}
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		
		if(products.containsKey(product.getPid())) {
			products.put(product.getPid(), product);
		}else return false;
		
		return true;
	}
	public boolean deleteProduct(int pid) {
		// TODO Auto-generated method stub
		
		if(products.containsKey(pid)) {
			products.remove(pid);
		} else return false;
		return true;
	}
	
	public Product findProduct(int pid) {
		// TODO Auto-generated method stub
		
		if(products.containsKey(pid)) return products.get(pid);
		
		return null;
	}
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		List<Product> Products = new ArrayList<>();
		
		for(int i:products.keySet()) {
			Products.add(products.get(i));
		}
		return Products;
	}
	
	
	

}
