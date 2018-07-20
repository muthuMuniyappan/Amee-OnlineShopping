package com.niit.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.onlineshopping.service.CartService;

@Controller
@RequestMapping(value="/cart")
public class CartController {
	
	private final static Logger logger= LoggerFactory.getLogger(CartController.class); 
	
	@Autowired
	private CartService cartService;
	
	 @RequestMapping(value="/show")
	 public ModelAndView showCart(@RequestParam(name= "result", required=false) String result) {
		 
		 ModelAndView mv= new ModelAndView("page");
		 
		 
		 if(result != null) {
			 
			 switch(result) {
			 
			 case "updated":
				 mv.addObject("message", "CartLine has been updated successfully!");
				 break;
				 
			 case "added":
				 mv.addObject("message", "CartLine has been added successfully!");
				 break;
				 
			 case "deleted":
				 mv.addObject("message", "CartLine has been deleted successfully!");
				 break;
				 
			 case "maximum":
				 mv.addObject("message", "CartLine has reahed the maximum count!");
				 break;
				 
			 case "modified":
					mv.addObject("message", "One or more items inside cart has been modified!");
					break;
				 
			 case "unavailable":
				 mv.addObject("message", "Product quantity is not available!");
				 break;
				 
			 case "error":
				 mv.addObject("message", "Something went wrong!");
				 break;			 
			 
			 }		 
			 
		 }
		 else {
				String response = cartService.validateCartLine();
				if(response.equals("result=modified")) {					
					mv.addObject("message", "One or more items inside cart has been modified!");
				}
			}		
		 	
		 	mv.addObject("title", "User Cart");
		 	mv.addObject("userClickShowCart", true);
			mv.addObject("cartLines", cartService.getCartLines());
			return mv;			
		}
	 
	 
	 @RequestMapping(value="/{cartLineId}/update")
	 public String updateCart(@PathVariable int cartLineId,@RequestParam int count) {
		 
		 String response= cartService.manageCartLine(cartLineId, count);		 
		 return "redirect:/cart/show?"+response;	 
	 }
	 
	 
	 @RequestMapping(value="/{cartLineId}/delete")
	 public String deleteCart(@PathVariable int cartLineId) {
		 
		 String response= cartService.deleteCartLine(cartLineId);		 
		 return "redirect:/cart/show?"+response;	 
	 }
	 
	 
	 @RequestMapping(value="/add/{productId}/product")
	 public String addCart(@PathVariable int productId) {
		 
		 String response= cartService.addCartLine(productId);		 
		 return "redirect:/cart/show?"+response;	 
	 }
	 
	 
	 /* after validating it redirect to checkout
		 * if result received is success proceed to checkout 
		 * else display the message to the user about the changes in cart page
		 * */	
		@RequestMapping(value="/validate")
		public String validateCart() {	
			String response = cartService.validateCartLine();
			if(!response.equals("result=success")) {
				return "redirect:/cart/show?"+response;
			}
			else {
				return "redirect:/cart/checkout";
			}
		}		 
}
