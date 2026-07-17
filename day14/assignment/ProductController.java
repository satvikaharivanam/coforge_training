package com.coforge.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.coforge.pms.model.Product;
import com.coforge.pms.service.ProductService;

@Controller 
public class ProductController {
	
	@Autowired 
	private ProductService service;
	@RequestMapping("home")
	public ModelAndView loadHomePage() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ProductHome");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "product", params = "insert")
	public ModelAndView addProduct(@ModelAttribute Product product) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ProductHome");
		
		boolean status = service.addProduct(product);
		String result = "";
		if(status){
			result = "SUCCESS : Product Registered";
		}else {
			result = "FAIL : Product Not Registered";
		}
		
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "product", params = "update")
	public ModelAndView updateProduct(@ModelAttribute Product product) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ProductHome");
		
		boolean status = service.updateProduct(product);
		String result = "";
		if(status){
			result = "SUCCESS : Product Updated";
		}else {
			result = "FAIL : Product Not Updated";
		}
		
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "product", params = "delete")
	public ModelAndView deleteProduct(@RequestParam int pid) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ProductHome");
		
		boolean status = service.deleteProduct(pid);
		String result = "";
		if(status){
			result = "SUCCESS : Product Deleted";
		}else {
			result = "FAIL : Product Not Deleted";
		}
		
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "product", params = "find")
	public ModelAndView findProduct(@RequestParam int pid) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ProductHome");
		
		Product product = service.findProduct(pid);
		String result = "";
		if(product!=null){
			result = product.toString();
		}else {
			result = "FAIL : Product Not Found";
		}
		
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "product", params = "findAll")
	public ModelAndView findAllProduct() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ProductHome");
		
		List<Product> products = service.findAllProduct();
		String result = "";
		if(products!=null){
			result = products.toString();
		}else {
			result = "FAIL : Products Not Found";
		}
		
		mv.addObject("result", result);
		return mv;
	}
	
	
	
	
}
