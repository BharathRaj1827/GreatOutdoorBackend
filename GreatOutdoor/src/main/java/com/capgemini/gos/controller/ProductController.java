package com.capgemini.gos.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.gos.dao.ProductRepository;
import com.capgemini.gos.entity.Product;

import com.capgemini.gos.exceptions.ProductConstants;

import com.capgemini.gos.exceptions.ProductNotFoundException;
import com.capgemini.gos.service.ProductServiceImpl;
@RestController
@RequestMapping("/product")
@CrossOrigin("http://localhost:4200")
public class ProductController {
	@Autowired
	ProductServiceImpl service;
	@Autowired
	ProductRepository repo;
	Product product=new Product();
	
	//Create Product
	@PostMapping("/add") //to add a show 
	public ResponseEntity<String> addProduct(@RequestBody  Product product)  throws ProductNotFoundException{
		Product productlist=service.addProduct(product);
			return new ResponseEntity<String>("Product added succesfully",new HttpHeaders(),HttpStatus.OK);
		}
	
		@GetMapping("/GetProduct/{id}")
		private ResponseEntity<Optional<Product>>getProductById(@PathVariable("id")String id)  throws ProductNotFoundException {
			Optional<Product>product=service.getProductById( id);
				return new ResponseEntity<>(product,new HttpHeaders(),HttpStatus.OK);
		}
		
		// Get All Products Data
		@GetMapping("/GetAllProducts")
		public List<Product> getAll() throws ProductNotFoundException {
			List<Product> productlist=repo.findAll();
			if(productlist.isEmpty())
				throw new ProductNotFoundException(ProductConstants.EMPTY_RECORD);
			
			return productlist;
		}
		// Updating Product data
				@PutMapping("/UpdateProduct")
				public ResponseEntity<String> updateProduct(@RequestBody Product t)throws ProductNotFoundException {
					Product product=service.updateProduct(t);
			return new ResponseEntity<String>("Product Updated successfully",new HttpHeaders(),HttpStatus.OK);
			}	
		
				// Deleting Product
				@DeleteMapping("/DeleteProduct/{id}")
				private ResponseEntity<String> deleteProduct(@PathVariable("id") String id) throws ProductNotFoundException {
					String product=service.deleteProduct(id);
					return new ResponseEntity<String>(" Product Deleted successfully",new HttpHeaders(),HttpStatus.OK);
				}

				@GetMapping("/searchproductbyproductCategory/{productCategory}")
				public ResponseEntity<List<Product>>searchProductByProductCategory(@PathVariable String productCategory) throws ProductNotFoundException {
					List<Product>search=service.searchProductByProductCategory(productCategory);
					return new ResponseEntity<>(search, HttpStatus.OK);
				}
				@GetMapping("/searchproductbyproductName/{productName}")
				public ResponseEntity<List<Product>>searchProductByProductName(@PathVariable String productName) throws ProductNotFoundException {
					List<Product>search=service.searchProductByProductName(productName);
					return new ResponseEntity<>(search, HttpStatus.OK);
				}
				@GetMapping("/FilterProducts/{minPrice}/{maxPrice}")
				public ResponseEntity<List<Product>> searchProduct(@PathVariable double minPrice, @PathVariable double maxPrice)throws ProductNotFoundException {
					List<Product> filterList = service.filterProduct(minPrice, maxPrice);
					return new ResponseEntity<>(filterList, HttpStatus.OK);

				}

				
				
				
				
				
		
				
				
				
				
				
				
				
				
				
				
		/*@ExceptionHandler(IdAlreadyExistsException.class)
		public ResponseEntity<String> alreadyExists(IdAlreadyExistsException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
		@ExceptionHandler(IdNotFoundException.class)
		public ResponseEntity<String> userNotFound(IdNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}*/

	}


