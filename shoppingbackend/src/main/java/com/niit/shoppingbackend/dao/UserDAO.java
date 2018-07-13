 package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.dto.Address;
import com.niit.shoppingbackend.dto.Cart;
import com.niit.shoppingbackend.dto.User;

public interface UserDAO {
	
	//add an user
	boolean addUser(User user);
	
	User getByEmail(String email);
	
	//add an Address
	boolean addAddress(Address address);
	/* Alternative*/
	//--------------
	//Address getBillingAddress(User userId);
	//List<Address> listShippingAddresses(User userId);
	
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);
	
	//add a Cart
	boolean updateCart(Cart cart);
 
}