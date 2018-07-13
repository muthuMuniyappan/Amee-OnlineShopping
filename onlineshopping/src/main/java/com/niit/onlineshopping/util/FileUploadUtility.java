package com.niit.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	
	private static final String ABS_PATH="E:\\OnlineShopping\\S190032-33\\OnlineShopping\\Amee-OnlineShopping\\onlineshopping\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH="";
	
	private static final Logger logger=LoggerFactory.getLogger(FileUploadUtility.class);
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		
		 //getting real path
		REAL_PATH=request.getSession().getServletContext().getRealPath("/assets/images/");
		
		logger.info(REAL_PATH);
		
		// to make sure all the directories exists
		// if doesn't create any directories please create the directories
		if(!new File(ABS_PATH).exists()) {
			// create new directories
			new File(ABS_PATH).mkdirs();			
		}
		
		if(!new File(REAL_PATH).exists()) {
			// create new directories
			new File(REAL_PATH).mkdirs();			
		}
		
		try {
			//Server Upload
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			//project directories upload
			file.transferTo(new File(ABS_PATH + code + ".jpg"));			
		}
		catch(IOException e) {
			
			
		}
				
		
		
	}
	
	
	

}
