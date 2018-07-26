package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.dto.Cart;
import com.niit.shoppingbackend.dto.CartLine;
import com.niit.shoppingbackend.dto.OrderDetail;

public interface CartLineDAO {
	
	// the common methods
		public List<CartLine> list(int cartId);
	public CartLine get(int id);	
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	
	// other business method to related to CartLines based on cartId and productId
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId, int productId);		
		
	// updating the cart
	boolean updateCart(Cart cart);	
	
	// adding order details
	boolean addOrderDetail(OrderDetail orderDetail);

	
}


