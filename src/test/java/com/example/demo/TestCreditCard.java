package com.example.demo;

import com.example.demo.bean.req.CreditCardReq;
import com.example.demo.entity.CreditCard;
import com.example.demo.repository.CreditCardRepository;
import com.example.demo.service.CreditCardService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= {DemoApplication.class}, webEnvironment = WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class TestCreditCard {

	@Autowired
	CreditCardRepository creditCardRepository;
	
	@Autowired
	CreditCardService creditCardService;
	
	@Test(expected = Exception.class)
	public void test1CreditCardNull() throws Exception {
		creditCardService.addCard(null);
	}
	
	@Test(expected = Exception.class)
	public void test2CreditCardNoFail() throws Exception {
		CreditCardReq creditCardReq = new CreditCardReq();
		creditCardReq.setCreditCardNo("");
		creditCardService.addCard(creditCardReq);
	}
	
	@Test(expected = Exception.class)
	public void test3CreditCardNoFail() throws Exception {
		CreditCardReq creditCardReq = new CreditCardReq();
		creditCardReq.setCreditCardNo("asdasdasdasdasda");
		creditCardService.addCard(creditCardReq);
	}
	
	@Test(expected = Exception.class)
	public void test4CreditCardHolderFail() throws Exception {
		CreditCardReq creditCardReq = new CreditCardReq();
		creditCardReq.setCreditCardNo("1234567891234567");
		creditCardReq.setCardHolder("");
		creditCardService.addCard(creditCardReq);
	}
	
	@Test(expected = Exception.class)
	public void test5CreditCardExpireEmpty() throws Exception {
		CreditCardReq creditCardReq = new CreditCardReq();
		creditCardReq.setCreditCardNo("1234567891234567");
		creditCardReq.setCardHolder("aaaaaa");
		creditCardReq.setCardExpireDate("");
		creditCardService.addCard(creditCardReq);
	}
	
	@Test(expected = Exception.class)
	public void test6CreditCardExpireFail() throws Exception {
		CreditCardReq creditCardReq = new CreditCardReq();
		creditCardReq.setCreditCardNo("1234567891234567");
		creditCardReq.setCardHolder("aaaaaa");
		creditCardReq.setCardExpireDate("111");
		creditCardService.addCard(creditCardReq);
	}
	
	@Test
	public void test7CreditCardSuccess() throws Exception {
		CreditCardReq creditCardReq = new CreditCardReq();
		creditCardReq.setCreditCardNo("1234567891234567");
		creditCardReq.setCardHolder("aaaaaa");
		creditCardReq.setCardExpireDate("05/18");
		CreditCard creditCard = creditCardService.addCard(creditCardReq);
		Assert.assertNotNull("creditCard should not be null", creditCard);
	}
	
	@Test
	public void test8FormatCardExpire() throws Exception {
		boolean result = "01/18".matches("([0-9]{2})/([0-9]{2})");
		System.out.println("result= " + result);
	}
	
	
}
