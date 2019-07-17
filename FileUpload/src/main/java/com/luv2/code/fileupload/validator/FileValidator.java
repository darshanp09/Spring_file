package com.luv2.code.fileupload.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.luv2.code.fileupload.model.FileUpload;

@Component
public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return FileUpload.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		FileUpload fileupload = (FileUpload) target;
		
		CommonsMultipartFile[] commonsMultipartFiles =fileupload.getFiles();
		
		for(CommonsMultipartFile multipartFile :commonsMultipartFiles) {
			if(multipartFile.getSize()==0) {
				errors.rejectValue("files", "missing.file");
			}
		}
	}

}
