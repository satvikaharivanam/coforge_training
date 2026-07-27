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

import com.coforge.pms.dto.ProductDTO;
import com.coforge.pms.dto.SupplierDTO;
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
	
	@GetMapping("/products/suppliers/{supplierId}")
	public ResponseEntity<?> findSupplierById(@PathVariable int supplierId){
		ResponseEntity<?> responseEntity = null;
		SupplierDTO supplier = service.findSupplierById(supplierId);
		if(supplier!=null)
			responseEntity = new ResponseEntity<>(supplier,HttpStatus.OK);
		else 
			responseEntity = new ResponseEntity<>("No supplier found",HttpStatus.BAD_REQUEST);
 		return responseEntity;
	}
	
	@GetMapping("/products/suppliers")
	public ResponseEntity<?> findAllSuppliers(){
		ResponseEntity<?> responseEntity = null;
		List<SupplierDTO> suppliers = service.findAllSuppliers();
		if(!suppliers.isEmpty())
			responseEntity = new ResponseEntity<>(suppliers,HttpStatus.OK);
		else 
			responseEntity = new ResponseEntity<>("No suppliers found",HttpStatus.BAD_REQUEST);
 		return responseEntity;
	}
	
	@GetMapping("/products/{pid}/suppliers")
	public ResponseEntity<?> findAllSuppliersById(@PathVariable int pid){
		ResponseEntity<?> responseEntity = null;
		
		Product product = service.findProductById(pid).get();
		SupplierDTO supplier = service.findSupplierById(product.getSupplierId());
//		ProductDTO productDto = new ProductDTO();
//		productDto.setProduct(product);
//		productDto.setSupplier(supplier);
		ProductDTO productDTO = new ProductDTO(product,supplier);
		responseEntity = new ResponseEntity<>(productDTO,HttpStatus.OK);
 		return responseEntity;
	}
	
}
