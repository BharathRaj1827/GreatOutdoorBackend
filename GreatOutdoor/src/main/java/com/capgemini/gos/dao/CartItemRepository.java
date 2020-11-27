package com.capgemini.gos.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.gos.entity.CartItem;


@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Serializable> {
	
	@Query("Select sum(c.cartItemPrice) FROM CartItem c WHERE c.userId=:user_id")
	double getTotalAmountByUserId(@Param("user_id") String userId);
	
	@Query("update CartItem addCart set addCart.quantity=:qty,addCart.cartItemPrice=:price WHERE addCart.cartId=:cart_id")
	void updateQtyByCartId(@Param("cart_id") long cartId, @Param("price") double cartItemPrice,@Param("qty") long quantity);
	
	@Query("Select addCart  FROM CartItem addCart WHERE addCart.productId= :product_id and addCart.userId=:user_id")
	Optional<CartItem> getCartByProductIdAnduserId(@Param("product_id") String productId,@Param("user_id") String userId);
	
	
	@Query("DELETE  FROM CartItem c WHERE c.cartId =:cart_id   and c.userId=:user_id")
	void deleteCartByIdAndUserId(@Param("user_id")String userId,@Param("cart_id")long cartId);
	
	
	@Query("DELETE  FROM CartItem c WHERE   c.userId=:user_id")
	void deleteAllCartByUserId(@Param("user_id")String userId);

	public List<CartItem> findAllByUserId(String userId);

	/*@Query("Select addCart FROM CartItem addCart WHERE addCart.userId=:user_id")
	Optional<CartItem> getCartItemsByUserId(@Param("user_id") String userId);*/
	

	

}
