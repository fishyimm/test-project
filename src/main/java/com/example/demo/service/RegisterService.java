package com.example.demo.service;

import com.example.demo.bean.req.RegisterReq;
import com.example.demo.entity.Register;
import com.example.demo.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;

@Service
public class RegisterService {

	public static final String FORMAT_EMAIL = "([a-zA-Z0-9_-])+(@)+([a-zA-Z])+([.])+([a-zA-Z]{2,4})";
	
	@Autowired
	RegisterRepository registerRepository;
	
	public Register register(RegisterReq registerReq) throws Exception {
		boolean isValidateSuccess = validateBody(registerReq);
		
		if(isValidateSuccess) {
			Date now = new Date();
			Register register = new Register();
			register.setEmail(registerReq.getEmail());
			register.setPassword(Base64.getEncoder().encodeToString(registerReq.getPassword().getBytes()));// need to encrypt 
			
			register.setStatus(true);
			
			register.setCreateBy("system");
			register.setUpdateBy("system");
			
			register.setCreateDate(now);
			register.setUpdateDate(now);
			
			Register resRegister = registerRepository.save(register);
			return resRegister;
		} else {
			return null;
		}
		
	}
	
	private boolean validateBody(RegisterReq registerReq) throws Exception {
		
		if(registerReq == null) {
			System.out.println("RegisterReq could not be null");
			throw new Exception("RegisterReq could not be null");
		}
		if(validateEmail(registerReq) && validatePassword(registerReq)) {
			return true;
		}
		return false;
	}
	
	private boolean validateEmail(RegisterReq registerReq) throws Exception {
		if(registerReq.getEmail() == null || registerReq.getEmail().isEmpty()) {
			System.out.println("email could not be null or empty");
			throw new Exception("email could not be null or empty");
		}
		
		if(!registerReq.getEmail().matches(FORMAT_EMAIL)) {
			System.out.println("email wrong format please try again");
			throw new Exception("email wrong format please try again");
		}
		
		return true;
	}
	
	private boolean validatePassword(RegisterReq registerReq) throws Exception {
		if(registerReq.getPassword() == null || registerReq.getPassword().isEmpty()) {
			System.out.println("password could not be null or empty");
			throw new Exception("password could not be null or empty");
		}
		
		if(registerReq.getPassword().length() == 0 || registerReq.getPassword().length() < 8 || registerReq.getPassword().length() > 15) {
			System.out.println("password length should be 8 - 15");
			throw new Exception("password length should be 8 - 15 ");
		}
		
		return true;
	}
}
