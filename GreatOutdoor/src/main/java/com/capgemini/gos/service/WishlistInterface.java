package com.capgemini.gos.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.gos.entity.Product;
import com.capgemini.gos.entity.Wishlist;
import com.capgemini.gos.exceptions.ProductDoesNotExistException;


public interface WishlistInterface {

	public Optional<Product> addProduct(int productId) throws ProductDoesNotExistException ;

		
	
	public List<Product> productList();
		
	public List<Wishlist> viewWishList();

}
