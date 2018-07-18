package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.dto.Cart;
import com.niit.shoppingbackend.dto.CartLine;
import com.niit.shoppingbackend.dto.OrderDetail;

public interface CartLineDAO {
	
	// the common methods
	public CartLine get(int id);
	public boolean add(CartLine cartLine);	
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);
	
	// other business method to related to the cart lines
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId, int productId);
	
	//update a Cart
	boolean updateCart(Cart cart);
	
	//adding orderDetails
	boolean addOrderDetail(OrderDetail orderDetail);

}
