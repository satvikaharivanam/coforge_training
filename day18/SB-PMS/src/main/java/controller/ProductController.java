package com.coforge.pms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.pms.exception.InvalidProductObjectException;
import com.coforge.pms.exception.ProductNotFoundException;
import com.coforge.pms.model.Product;
import com.coforge.pms.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/pms")
public class ProductController {

	private ProductService service;
	private Environment environment;
	
	
	
	public ProductController(ProductService service, Environment environment) {
		super();
		this.service = service;
		this.environment = environment;
	}



	@PostMapping("/products")
	public ResponseEntity<?> saveProduct(@Valid @RequestBody Product product){
		
		ResponseEntity<?> responseEntity = null;
//		try {
			boolean status = service.saveProduct(product);
			if(status) {
				responseEntity = new ResponseEntity<>(environment.getProperty("pms.save.successInsert"),HttpStatus.CREATED);
//			}
//		} catch (InvalidProductObjectException e) {
//			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	@PutMapping("/products/{pid}")
	public ResponseEntity<?> updateProduct( @PathVariable("pid") int pid,@Valid @RequestBody Product product){
		
		ResponseEntity<?> responseEntity = null;
//		try {
			boolean status = service.updateProduct(pid,product);
			if(status) {
				responseEntity = new ResponseEntity<>(environment.getProperty("pms.save.successUpdate"),HttpStatus.OK);
			}
//		} catch (InvalidProductObjectException e) {
//			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
//		} catch (ProductNotFoundException e) {
//			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
//		} catch (Exception e) {
//			responseEntity = new ResponseEntity<>(environment.getProperty("pms.db.fail"),HttpStatus.BAD_REQUEST);
//		}
		
		return responseEntity;
	}
	
	@DeleteMapping("/products/{pid}")
	public ResponseEntity<?> deleteProduct(@PathVariable("pid") int pid){
		
		ResponseEntity<?> responseEntity = null;
//		try {
			boolean status = service.deleteProduct(pid);
			if(status) {
				responseEntity = new ResponseEntity<>(environment.getProperty("pms.delete.successDelete"),HttpStatus.OK);
			}
//		} catch (InvalidProductObjectException e) {
//			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
//		} catch (ProductNotFoundException e) {
//			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
//		} catch (Exception e) {
//			responseEntity = new ResponseEntity<>(environment.getProperty("pms.db.fail"),HttpStatus.BAD_REQUEST);
//		}
		
		return responseEntity;
	}
	
	@GetMapping("/products/{pid}")
	public ResponseEntity<?> findProductById(@PathVariable("pid") int pid){
		
		ResponseEntity<?> responseEntity = null;
//		try {
			Optional<Product> product = service.findProductById(pid);
			if(product.get()!=null) {
				responseEntity = new ResponseEntity<>(product.get(),HttpStatus.OK);
			}
//		} catch (InvalidProductObjectException e) {
//			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
//		} catch (ProductNotFoundException e) {
//			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
//		} catch (Exception e) {
//			responseEntity = new ResponseEntity<>(environment.getProperty("pms.db.fail"),HttpStatus.BAD_REQUEST);
//		}
		
		return responseEntity;
	}
	
	@GetMapping("/products")
	public ResponseEntity<?> findProducts(){
		
		ResponseEntity<?> responseEntity = null;
//		try {
			List<Product> products = service.findProducts();
			if(!products.isEmpty()) {
				responseEntity = new ResponseEntity<>(products,HttpStatus.OK);
			}
//		} catch (InvalidProductObjectException e) {
//			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
//		} catch (ProductNotFoundException e) {
//			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
//		} catch (Exception e) {
//			responseEntity = new ResponseEntity<>(environment.getProperty("pms.db.fail"),HttpStatus.BAD_REQUEST);
//		}
		
		return responseEntity;
	}
	
	@GetMapping("/products/pname/{pname}")
	public ResponseEntity<?> findProductByName(@PathVariable("pname") String pname){
		
		ResponseEntity<?> responseEntity = null;
//		try {
			List<Product> products = service.findProductByName(pname);
			if(!products.isEmpty()) {
				responseEntity = new ResponseEntity<>(products,HttpStatus.OK);
			}
//		} catch (InvalidProductObjectException e) {
//			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
//		} catch (ProductNotFoundException e) {
//			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
//		} catch (Exception e) {
//			responseEntity = new ResponseEntity<>(environment.getProperty("pms.db.fail"),HttpStatus.BAD_REQUEST);
//		}
		
		return responseEntity;
	}
	
	@DeleteMapping("/products/pname/{pname}")
	public ResponseEntity<?> deleteProductByName(@PathVariable("pname") String pname){
		
		ResponseEntity<?> responseEntity = null;
//		try {
			boolean status = service.deleteProductByName(pname);
			if(status) {
				responseEntity = new ResponseEntity<>(environment.getProperty("pms.delete.successDelete"),HttpStatus.OK);
			}
//		} catch (InvalidProductObjectException e) {
//			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
//		} catch (ProductNotFoundException e) {
//			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
//		} catch (Exception e) {
//			responseEntity = new ResponseEntity<>(environment.getProperty("pms.db.fail"),HttpStatus.BAD_REQUEST);
//		}
		
		return responseEntity;
	}
	@GetMapping("/products/info")
	public ResponseEntity<?> getInfo(){
		
		ResponseEntity<?> responseEntity = null;
//		try {
			String info = service.getInfo();
//			if(!products.isEmpty()) {
				responseEntity = new ResponseEntity<>(info,HttpStatus.OK);
//			}
//		} catch (InvalidProductObjectException e) {
//			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
//		} catch (ProductNotFoundException e) {
//			responseEntity = new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
//		} catch (Exception e) {
//			responseEntity = new ResponseEntity<>(environment.getProperty("pms.db.fail"),HttpStatus.BAD_REQUEST);
//		}
		
		return responseEntity;
	}
	
}
