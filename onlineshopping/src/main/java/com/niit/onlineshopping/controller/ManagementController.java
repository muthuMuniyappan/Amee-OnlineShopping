package com.niit.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niit.onlineshopping.util.FileUploadUtility;
import com.niit.onlineshopping.validator.ProductValidator;
import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dto.Category;
import com.niit.shoppingbackend.dto.Product;

@Controller
@RequestMapping(value="/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger= LoggerFactory.getLogger(ManagementController.class); 
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation) {
		
		ModelAndView mv= new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		Product nProduct= new Product();
		
		//set few of fields
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product", nProduct);
		
		if(operation!=null) {
			if(operation.equals("product")) {
				mv.addObject("message", "Product Submitted Successfully!");
			}
			else if(operation.equals("category")){
				mv.addObject("message", "Category Submitted Successfully!");
			}
		}			
		return mv;	
	}
	
	
	@RequestMapping(value = "/{id}/product", method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		//fetch the product from the database
		Product nProduct= productDAO.get(id);
		//set the product fetch from database
		mv.addObject("product", nProduct);		

		return mv;
	}
	
	
	
	// Handling product Submission
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results,
			Model model, HttpServletRequest request) {

		if (mProduct.getId() == 0) {
			new ProductValidator().validate(mProduct, results);
		} else {
			if (!mProduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(mProduct, results);
			}
		}
		// check if there are any error
		if (results.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Product");
			model.addAttribute("message", "Validation failed for Product Submission!");

			return "page";
		}

		logger.info(mProduct.toString());

		
		if(mProduct.getId()==0) {
		// Create a new Product record if id is 0
		productDAO.add(mProduct);
		}
		else {
		// update the  Product record if id is not 0
		productDAO.update(mProduct);
		}
		
		if (!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}

		return "redirect:/manage/products?operation=product";
	}
	
	@RequestMapping(value= "/product/{id}/activation", method=RequestMethod.GET)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {	
		//is going to fetch the product from the database
		Product product= productDAO.get(id);
		boolean isActive= product.isActive();
		//activate and deactivate based on the value of activate field 
		product.setActive(!product.isActive());
		// updating the product
		productDAO.update(product);		
		 
		return (isActive)? "You have successfully deactivated the product with id" + product.getId()  
						: "You have successfully activated the product with id" + product.getId(); 
	}
	
	
	// to handle category submission
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category) {
		//adding new category
		categoryDAO.add(category);
		
		return "redirect:/manage/products?operation=category";
	}
	
		
	
	
	// Returning categories to all the request mapping 
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryDAO.list();
	}
	
	@ModelAttribute("category")
	public  Category getCategory() {
		return new Category();
	}

}
