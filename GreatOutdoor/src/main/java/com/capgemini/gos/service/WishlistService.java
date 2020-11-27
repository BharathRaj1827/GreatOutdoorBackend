package com.capgemini.gos.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.gos.dao.ProductRepository;
import com.capgemini.gos.dao.WishlistRepository;
import com.capgemini.gos.entity.Product;
import com.capgemini.gos.entity.Wishlist;
import com.capgemini.gos.exceptions.ProductDoesNotExistException;



@Service
@Transactional
public class WishlistService implements WishlistInterface {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private WishlistRepository wishlistRepository;
	
	public WishlistService(ProductRepository productRepository,WishlistRepository wishlistRepository) {
		this.productRepository = productRepository;
		this.wishlistRepository=wishlistRepository;

	}

	public Optional<Product> addProduct(int productId) throws ProductDoesNotExistException {

		Optional<Product> found;
		found = productRepository.findById(productId);
		if (found == null) {
			//System.out.println("Throw product not found exception");
			//return null;
			throw new ProductDoesNotExistException("product does not exists");
			
		} else {

			String productName = found.get().getProductName();
			Wishlist whistList = new Wishlist();
			whistList.setProductName(productName);
			wishlistRepository.save(whistList);
			return found;
		}
		}
		
	
	public List<Product> productList(){
		return productRepository.findAll();
	}
	
	public List<Wishlist> viewWishList(){
		
		return wishlistRepository.findAll();
	}
	
}
