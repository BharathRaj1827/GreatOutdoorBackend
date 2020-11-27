package com.capgemini.gos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.gos.entity.Wishlist;





@Repository
public interface WishlistRepository extends JpaRepository<Wishlist,Integer> {

}
