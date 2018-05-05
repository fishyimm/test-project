package com.example.demo.controller;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.req.RegisterReq;
import com.example.demo.entity.Register;
import com.example.demo.service.RegisterService;

@RestController
public class RegisterController {

	@Autowired
	RegisterService registerService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Register register(@RequestBody RegisterReq requestBody, 
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		try {
			Register register = registerService.register(requestBody);
			return register;
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
			System.out.println("" + e);
		}
		
		return null;
	}
}
