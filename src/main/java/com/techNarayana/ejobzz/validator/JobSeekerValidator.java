package com.techNarayana.ejobzz.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.techNarayana.ejobzz.dto.JobseekerRegisterDTO;
import com.techNarayana.ejobzz.service.JobSeekerRegisterService;
import com.techNarayana.ejobzz.util.FormUtil;

@Component("jobSeekerValidator")
public class JobSeekerValidator implements Validator{
@Autowired
JobSeekerRegisterService jobService;
	@Override
	public boolean supports(Class<?> clazz) {
	
		return JobseekerRegisterDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "notValidUser");
		JobseekerRegisterDTO dto=(JobseekerRegisterDTO)obj;
				if(!FormUtil.isEmail(dto.getEmail()))
			errors.rejectValue("email", "notValidUser", "Enter Valid Email Ex: abc@gmail.com");
		if(!jobService.checkUser(dto.getEmail()))
			errors.rejectValue("email", "existsUsername", "Email already exists");
	
	}

}
