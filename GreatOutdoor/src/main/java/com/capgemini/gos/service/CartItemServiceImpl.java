package com.capgemini.gos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.gos.dao.CartItemRepository;
import com.capgemini.gos.entity.CartItem;
import com.capgemini.gos.exceptions.CartItemException;



@Service
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	private CartItemRepository repo; 
	
	CartItem result=new CartItem();
	private CartItem of(CartItem source) {
		CartItem result=null;
		if(source!=null) {
			result = new CartItem();
			result.setCartId(source.getCartId());
			result.setProductId(source.getProductId());
			result.setUserId(source.getUserId());
			result.setQuantity(source.getQuantity());
			result.setCartItemPrice(source.getCartItemPrice());
		}
		return result;
	}
   
		
	@Override
	public List<CartItem> getCartItemsByUserId(String userId) {
		
		return repo.findAllByUserId(userId).stream().map((entity)->of(entity)).collect(Collectors.toList());
	}

	@Override
	public CartItem addToCart(CartItem cartItem) throws CartItemException{
		if(cartItem!=null) {
			if(repo.getCartByProductIdAnduserId(cartItem.getProductId(), cartItem.getUserId()).isPresent()){
				throw new CartItemException("Product is already exist in cart.");
			}
			else {
				cartItem=of(repo.save(of(cartItem)));
			}
		}
		return cartItem;
	}
	
	@Override
	public void updateQty(CartItem item) throws CartItemException{
		if(!repo.findById(item.getCartId()).isPresent()) {
			throw new CartItemException("Product is not exist in cart.");
		}
		else {
			repo.updateQtyByCartId(item.getCartId(), item.getCartItemPrice(), item.getQuantity());
		}
		
		
	}
	@Override
	public void removeCartItemsByUserIdAndCartId(String userId, long cartId) throws  CartItemException{
		if(!(repo.existsById(cartId))){
			throw new CartItemException("Product is not exist in cart.");
		}
		else {
			repo.deleteCartByIdAndUserId(userId, cartId);
		}
		
		
	}
	@Override
	public void removeAllCartByUserId(String userId) throws CartItemException {
		if(!(repo.existsById(userId))) {
			throw new CartItemException("product is not exit in cart");
		}
		else {
			repo.deleteAllCartByUserId(userId);
		}
	}
	
		@Override
			public List<CartItem> viewCartItems() {
	
			return repo.findAll();
		}


		@Override
		public void deleteCartItem(long cartId) {
	
			repo.deleteById(cartId);
		}


}
