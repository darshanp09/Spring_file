package com.luv2.code.fileupload.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.luv2.code.fileupload.model.FileUpload;
import com.luv2.code.fileupload.validator.FileValidator;

@Controller
@RequestMapping("/")
public class upLaodController {
	@Autowired
	FileValidator fileValidator;
	
	@GetMapping("/uploadPage")
	public ModelAndView uploadPage() {
		ModelAndView model = new ModelAndView("upload_page");
		model.addObject("fileUpload",new FileUpload());
		return model;
	}
	
	@PostMapping("/upload")
	public ModelAndView upload(@ModelAttribute("fileUpload") FileUpload fileUpload,BindingResult result) throws IOException {
		fileValidator.validate(fileUpload, result);
		if(result.hasErrors()) {
			return new ModelAndView("upload_page");
		}
		
		return new ModelAndView("success","fileName",processUpload(fileUpload));
		
	}
	
	private List<String> processUpload(FileUpload files) throws IOException{
		
		List<String> fileName= new ArrayList<String>();
		
		 CommonsMultipartFile[] commonsMultipartFiles =files.getFiles();
		 
		 for(CommonsMultipartFile multipartFile:commonsMultipartFiles) {
			 FileCopyUtils.copy(multipartFile.getBytes(), new File("/Users/swaminarayan/Documents/workspace-sts-3.9.7.RELEASE/FileUpload/src/main/resources/images"+multipartFile.getOriginalFilename()));
			 fileName.add(multipartFile.getOriginalFilename());
		 }
		return fileName;
	}

}
