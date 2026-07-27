package com.coforge.pms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.coforge.pms.model.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
	
	public List<Product> findByPname(String pname);
	public int deleteByPname(String pname);
	
	@Query("select count(*), sum(price) from Product")
	public String getInfo();
}
