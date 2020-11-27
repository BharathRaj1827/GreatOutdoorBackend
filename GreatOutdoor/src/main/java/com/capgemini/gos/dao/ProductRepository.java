package com.capgemini.gos.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.gos.entity.Product;



public interface ProductRepository extends JpaRepository<Product, Integer>{
	@Query("Select p from Product p where p.productCategory=?1")
	List<Product> searchProduct(String productCategory);

	@Query("Select p from Product p where p.price >=?1 and p.price<=?2")
	List<Product> filterProduct(double minPrice, double maxPrice);

	Optional<Product> findById(String id);
	void deleteById(String id);
	@Query("Select p from Product p where p.productCategory=?1")
	List<Product> searchProductByProductCategory(String productCategory);
	
	@Query("Select p from Product p where p.productName=?1")
	List<Product> searchProductByProductName(String productName);

	

	

	



}
