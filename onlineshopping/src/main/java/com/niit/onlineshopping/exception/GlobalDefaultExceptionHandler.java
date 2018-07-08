package com.niit.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {

		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "The page is not Constructed!!!");
		mv.addObject("errorDescription", "The page you looking for is not available now!!!");
		mv.addObject("title", "404 Error page!!!"); 
		 
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {

		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Product not available!!!");
		mv.addObject("errorDescription", "The product you looking for is not available right now!!!");
		mv.addObject("title", "Product unavailable!!!"); 
		 
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception e) {

		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Contact your Administrator!");
		
		// Only for Debug our application
		StringWriter sw= new StringWriter();
		PrintWriter pw= new PrintWriter(sw);
		
		e.printStackTrace(pw);
		
		mv.addObject("errorDescription", sw.toString() );
		mv.addObject("title", "Error!"); 
		 
		return mv;
	}
	
	

}
