 package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.dto.Address;
import com.niit.shoppingbackend.dto.User;

public interface UserDAO {
	
	//add an user
	User getByEmail(String email);
	User get(int id);
	
	boolean addUser(User user);	
	
	/* Alternative*/
	//--------------
	//Address getBillingAddress(User user);
	//List<Address> listShippingAddresses(User user);
		
	//add and update a new Address
	Address getAddress(int addressId);		
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	Address getBillingAddress(int userId);
	List<Address> listShippingAddresses(int userId);

	


		
 
}
