package com.niit.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.onlineshopping.exception.ProductNotFoundException;
import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dto.Category;
import com.niit.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger= LoggerFactory.getLogger(PageController.class);

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		logger.info("Inside pageController index method!- INFO");
		logger.debug("Inside pageController index method!- DEBUG");

		// passing list of categories
		mv.addObject("categories", categoryDAO.list());

		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	/*
	 * Methods to load all products based on categories
	 */

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");

		// passing list of categories
		mv.addObject("categories", categoryDAO.list());

		mv.addObject("userClickAllProducts", true); 
		return mv;
	}
	
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id)  {

		ModelAndView mv = new ModelAndView("page");
		
		// From categoryDAO to fetch the single category
		Category category= null;
		
		category= categoryDAO.get(id);
		 
		mv.addObject("title", category.getName());

		// passing list of categories
		mv.addObject("categories", categoryDAO.list());
		
		//passing a single category
		mv.addObject("category", category);

		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
	/*
	 * View a Single product
	 */
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		
		ModelAndView mv= new ModelAndView("page");
		
		Product product= productDAO.get(id);
		
		if(product==null) throw new ProductNotFoundException(); 
		
		//Updating a view count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct", true);
		return mv;		
	}
	
	/*having similar mapping to our flow id*/
	@RequestMapping(value = { "/register" })
	public ModelAndView register() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		
		return mv;
	}
	
	//Login
	
	@RequestMapping(value = { "/login" })
	public ModelAndView login(@RequestParam(name="error", required= false) String error ) {

		ModelAndView mv = new ModelAndView("login");
		
		if(error!= null) {
			mv.addObject("message", "Invalid Username and Password");
		}
		mv.addObject("title", "Login");		
		return mv;
	}

}
