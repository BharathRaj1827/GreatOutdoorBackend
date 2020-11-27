package com.capgemini.gos.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.gos.entity.Product;
import com.capgemini.gos.exceptions.ProductNotFoundException;



public interface ProductService {
	
	public  Product addProduct(Product prod) throws ProductNotFoundException;
	public Optional<Product> getProductById(String id) throws ProductNotFoundException;
	public List<Product> searchProductByProductCategory(String productCategory)  throws ProductNotFoundException;
	public List<Product> searchProductByProductName(String productName) throws ProductNotFoundException;
	public List<Product> getAll()  throws ProductNotFoundException;
	public Product updateProduct(Product prod) throws ProductNotFoundException;
	public String deleteProduct(String id) throws ProductNotFoundException;
	public List<Product> filterProduct(double minPrice, double maxPrice)throws ProductNotFoundException;
	
	}
