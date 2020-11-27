package com.capgemini.gos.service;

import java.util.List;

import com.capgemini.gos.entity.CartItem;
import com.capgemini.gos.exceptions.CartItemException;


public interface CartItemService {
	
	
	public List<CartItem> getCartItemsByUserId(String userId);
	public CartItem addToCart(CartItem cartitem) throws CartItemException;
	public void updateQty(CartItem cartitem) throws CartItemException;
	public void removeCartItemsByUserIdAndCartId(String userId,long cartId) throws CartItemException;
	public void removeAllCartByUserId(String userId) throws CartItemException;
	public List<CartItem> viewCartItems();
	public void deleteCartItem(long cartId);
}
