 package com.niit.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.dto.Address;
import com.niit.shoppingbackend.dto.Cart;
import com.niit.shoppingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user=null;
	private Address address=null;
	private Cart cart=null;
	
	
	@BeforeClass
	public static void init() {
		context =new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingbackend");
		context.refresh();
		
		userDAO= (UserDAO) context.getBean("userDAO");
		
	}
	
	/*@Test
	public void testAdd() {
		 
		user = new User();		
		user.setFirstName("muthu");
		user.setLastName("Amee");
		user.setEmail("mAmee@gmail.com");
		user.setContactNumber("0123456789");
		user.setRole("USER");
		user.setPassword("123");
		
		//add user
		assertEquals("Failed to add User", true, userDAO.addUser(user));
		 
		address= new Address();
		address.setAddressLineOne("51/32, NTP Street, Sundakkamuthur");
		address.setAddressLineTwo("Nearby Kamatchiyamman Temple");
		address.setCity("Coimbatore");
		address.setState("Tamil Nadu");
		address.setCountry("India");
		address.setPostalCode("641010");
		address.setBilling(true);
		
		// like the user with the address using user Id
		address.setUserId(user.getId());
		
		//add address
		assertEquals("Failed to add Billing Address", true, userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")) {
			
			//create a cart for this user
			cart= new Cart();
			cart.setUser(user);
	
			
			// add a cart
			assertEquals("Failed to add Cart", true, userDAO.addCart(cart));
			
			//create the shipping address 
			address= new Address();
			address.setAddressLineOne("245, Nethaji Nagar,Perur");
			address.setAddressLineTwo("Behind Perur Temple");
			address.setCity("Coimbatore");
			address.setState("Tamil Nadu");
			address.setCountry("India");
			address.setPostalCode("641012");
			//set shipping as true
			address.setShipping(true);
 			
			//link the user with shipping address with userId
			address.setUserId(user.getId());
			
			// add a shipping Address
			assertEquals("Failed to add Shipping Address", true, userDAO.addAddress(address));
			
		}
	}*/
	
	
	/*@Test
	public void testAdd() {
		 
		user = new User();		
		user.setFirstName("muthu");
		user.setLastName("Amee");
		user.setEmail("mAmee@gmail.com");
		user.setContactNumber("0123456789");
		user.setRole("USER");
		user.setPassword("123");		 
		
		if(user.getRole().equals("USER")) {
			
			//create a cart for this user 
			cart= new Cart();
			cart.setUser(user); 	
			
			//attach the cart with the user
			user.setCart(cart);
		}
		
		//add user
		assertEquals("Failed to add User", true, userDAO.addUser(user));

	}*/
	
	
	/*@Test
	public void testUpdateCart() {
		
		//fetch the user by its email
		user= userDAO.getByEmail("mAmee@gmail.com");
		
		//get the cart of the user
		cart=user.getCart();
		
		cart.setGrandTotal(6500.00);
		cart.setCartLines(2);
		
		assertEquals("Failed to update cart",true, userDAO.updateCart(cart));		
	}*/
	
	
	/*@Test
	public void testAddAdress() {
		
		// need to add an user
		
		user = new User();		
		user.setFirstName("muthu");
		user.setLastName("Amee");
		user.setEmail("mAmee@gmail.com");
		user.setContactNumber("0123456789");
		user.setRole("USER");
		user.setPassword("123");
		
		//add user
		assertEquals("Failed to add User", true, userDAO.addUser(user));		
		
		// going to add an address
		address= new Address();
		address.setAddressLineOne("51/32, NTP Street, Sundakkamuthur");
		address.setAddressLineTwo("Nearby Kamatchiyamman Temple");
		address.setCity("Coimbatore");
		address.setState("Tamil Nadu");
		address.setCountry("India");
		address.setPostalCode("641010");
		address.setBilling(true);	
		 
		//attaching user to the address
		address.setUser(user);		
		
		assertEquals("Failed to add address", true, userDAO.addAddress(address));
		
		//also going  to add the shipping address
		address= new Address();
		address.setAddressLineOne("245, Nethaji Nagar,Perur");
		address.setAddressLineTwo("Behind Perur Temple");
		address.setCity("Coimbatore");
		address.setState("Tamil Nadu");
		address.setCountry("India");
		address.setPostalCode("641012");
		//set shipping as true
		address.setShipping(true);
		
		//attaching user to the address
		address.setUser(user);		
				
		assertEquals("Failed to add Shipping", true, userDAO.addAddress(address));	
		
	}*/
	
	
	/*@Test
	public void testAddAddress() {
		
		user = userDAO.getByEmail("mAmee@gmail.com");
		
		address= new Address();
		address.setAddressLineOne("245, Nethaji Nagar,Perur");
		address.setAddressLineTwo("Behind Perur Temple");
		address.setCity("Calicut");
		address.setState("Kerala");
		address.setCountry("India");
		address.setPostalCode("634332");
		//set shipping as true
		address.setShipping(true);
		
		//attaching user to the address
		address.setUser(user);		
				
		assertEquals("Failed to add Shipping", true, userDAO.addAddress(address));			
	}*/
	
	/*@Test 
	public void testGetAddresses() {
		
		user=userDAO.getByEmail("mAmee@gmail.com");
		
		assertEquals("Failed to fetch the list of Addresses and size does not match",2,
						userDAO.listShippingAddresses(user.getId()).size());
		
		assertEquals("Failed to feych the Billing Addresses and size does not match","Coimbatore",
				userDAO.getBillingAddress(user.getId()).getCity());
	}*/
}
 