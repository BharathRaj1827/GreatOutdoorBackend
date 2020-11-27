package com.capgemini.gos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.gos.entity.CartItem;
import com.capgemini.gos.exceptions.CartItemException;
import com.capgemini.gos.service.CartItemService;



@RestController
@RequestMapping("/cart")
@CrossOrigin("http://localhost:4200")
public class CartItemController {
	
	@Autowired
	CartItemService cartItemService;
	
	@PostMapping("/addToCart")
	public ResponseEntity<CartItem> addToCart(@RequestBody CartItem cartitem) throws CartItemException{
		cartitem=cartItemService.addToCart(cartitem);
		return new ResponseEntity<>(cartitem,HttpStatus.OK);
	}
	
	@PutMapping("/updateCartItem")
	public ResponseEntity<CartItem> updateToCart(@RequestBody CartItem cartitem) throws CartItemException{
		cartItemService.updateQty(cartitem);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getCartItemsByUserId/{userId}")
	public ResponseEntity<List<CartItem>> getCartItemByUserName(@PathVariable("userId")String userId){
		ResponseEntity<List<CartItem>> response=null;
		List<CartItem> cartItemList=cartItemService.getCartItemsByUserId(userId);
		if(cartItemList==null) {
			 response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		else {
			response=new ResponseEntity<>(cartItemList,HttpStatus.OK);
		}
		return  response;
	}
	
	@DeleteMapping("/removeProductFromCart/{userId}/{cartId}")
	public ResponseEntity<CartItem> deletCartItemsByUserNameAndProductId(@PathVariable("userId") String userId,@PathVariable("cartId") long cartId){
		try {
			cartItemService.removeCartItemsByUserIdAndCartId(userId, cartId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception ex){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	
	}
	
	@GetMapping(value="/getAllCartItems",produces="application/json")
	public List <CartItem> viewAddress()
	{
		return cartItemService.viewCartItems();	
	}
	
	@DeleteMapping("/deleteCartItem/{cartId}")
	public String deleteCartItem(@PathVariable("cartId") long cartId)
	{
		cartItemService.deleteCartItem(cartId);
		return "Cart Item  removed successfully";
	}
	
	@DeleteMapping("/removeProductFromCart/{userId}")
	public ResponseEntity<CartItem> deleteCartByUserName(@PathVariable("userId") String userId) {
		try {

			cartItemService.removeAllCartByUserId(userId);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}		
   }

	
	
	
}
