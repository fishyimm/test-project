package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.req.CreditCardReq;
import com.example.demo.entity.CreditCard;
import com.example.demo.service.CreditCardService;

@RestController
public class CreditCardController {

	@Autowired
	CreditCardService creditCardService;

	@RequestMapping(value= "/addcard", method = RequestMethod.POST)
	public CreditCard addCard(@RequestBody CreditCardReq requestBody, 
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		try {
			CreditCard creditCard = creditCardService.addCard(requestBody);
			return creditCard;
		} catch (Exception e) {
			response.sendError(500, e.getMessage());
			System.out.println("" + e);
		}
		
		return null;
	}
	
}
