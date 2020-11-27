package com.capgemini.gos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.gos.entity.Product;
import com.capgemini.gos.entity.Wishlist;
import com.capgemini.gos.exceptions.ProductDoesNotExistException;
import com.capgemini.gos.service.WishlistService;


@RestController
@CrossOrigin("http://localhost:4200")
public class WishlistController {

	
	@Autowired
	private WishlistService wishlistService;

	
	public WishlistController(WishlistService wishlistService) {
		this.wishlistService = wishlistService;
	}
	
	@GetMapping("/add/{productId}")
	public Optional<Product> addtoWhistList(@PathVariable int productId) throws ProductDoesNotExistException 
	{
		System.out.println(productId);
		return wishlistService.addProduct(productId);
	}
	
	
	@GetMapping("/list")
	public List<Product> ProductList() {
		
		return wishlistService.productList();
	}
	
	@GetMapping("/viewwishlist")
	public List<Wishlist> viewWishList() {
		
		return wishlistService.viewWishList();
	}
	
	
	
	
}
