package com.capgemini.gos.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.gos.dao.ProductRepository;
import com.capgemini.gos.entity.Product;

import com.capgemini.gos.exceptions.ProductConstants;
import com.capgemini.gos.exceptions.ProductNotFoundException;

@Service
@Transactional

public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository repo;
	Product product=new Product();
	//private String productCatogery;

	@Override
	public  Product addProduct(Product prod) throws ProductNotFoundException {
		Optional<Product> productlist=repo.findById(prod.getId());
		if(productlist.isPresent())
			throw new ProductNotFoundException(ProductConstants.PRODUCT_ALREADY_EXISTS);
		product.setId(prod.getId());
		product.setPrice(prod.getPrice());
		product.setColour(prod.getColour());
		product.setDimensions(prod.getDimensions());
		product.setSpecifications(prod.getSpecifications());
		product.setManufacture(prod.getManufacture());
		product.setQuantity(prod.getQuantity());
		product.setProductCategory(prod.getProductCategory());
		product.setProductName(prod.getProductName());
		product.setRetailerId(prod.getRetailerId());
		
		return repo.save(product);
	}
	@Override
	public Optional<Product> getProductById(String id) throws ProductNotFoundException {
		Optional<Product> productlist=repo.findById(id);
		if(!productlist.isPresent())
			throw new ProductNotFoundException(ProductConstants.PRODUCT_ID_NOT_FOUND);
			
		else
		return productlist;
	}
	
	@Override
	public List<Product> searchProductByProductCategory(String productCategory)  throws ProductNotFoundException{
		List<Product> productlist=repo.searchProductByProductCategory(productCategory);
		if(productlist.isEmpty())
			throw new ProductNotFoundException(ProductConstants.PRODUCT_TYPE_NOT_FOUND);
		else
		return productlist;
	}
	
	
	@Override
	public List<Product> searchProductByProductName(String productName) throws ProductNotFoundException{
		List<Product> productlist=repo.searchProductByProductName(productName);
		if(productlist.isEmpty())
			throw new ProductNotFoundException(ProductConstants.PRODUCT_NAME_NOT_FOUND);
		else
		return productlist;
	}
	
	@Override
	public List<Product> getAll()  throws ProductNotFoundException {
		List<Product> productlist=repo.findAll();
		if(productlist.isEmpty())
			throw new ProductNotFoundException(ProductConstants.EMPTY_RECORD);
		else
		return productlist;
	}
		
	@Override
	public Product updateProduct(Product prod) throws ProductNotFoundException {
		Optional<Product> productlist=repo.findById(prod.getId());
		if(!productlist.isPresent())
			throw new ProductNotFoundException(ProductConstants.PRODUCT_ID_NOT_FOUND);
		product.setId(prod.getId());
		product.setPrice(prod.getPrice());
		product.setColour(prod.getColour());
		product.setDimensions(prod.getDimensions());
		product.setSpecifications(prod.getSpecifications());
		product.setManufacture(prod.getManufacture());
		product.setQuantity(prod.getQuantity());
		product.setProductCategory(prod.getProductCategory());
		product.setProductName(prod.getProductName());
		product.setRetailerId(prod.getRetailerId());
		
		return repo.save(product);
	}
	@Override
	public String deleteProduct(String id) throws ProductNotFoundException{
		Optional<Product> product=repo.findById(id);
		if(!product.isPresent())
			throw new ProductNotFoundException(ProductConstants.PRODUCT_ID_NOT_FOUND);
		else
			repo.deleteById(id);
			return "deleted successfully";
		}
	
	
	@Override
	public List<Product> filterProduct(double minPrice, double maxPrice) throws ProductNotFoundException{
		List<Product> filterProduct=repo.filterProduct(minPrice,  maxPrice);
		if(filterProduct.isEmpty())
			throw new ProductNotFoundException(ProductConstants.PRODUCT_NOT_FOUND);
		else
		return repo.filterProduct(minPrice,maxPrice);
	}

}
