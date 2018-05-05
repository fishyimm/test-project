package com.example.demo;

import java.util.UUID;

import org.h2.jdbc.JdbcSQLException;
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

import com.example.demo.bean.req.RegisterReq;
import com.example.demo.entity.Register;
import com.example.demo.repository.RegisterRepository;
import com.example.demo.service.RegisterService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {DemoApplication.class}, webEnvironment = WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class TestRegister {

	@Autowired
	RegisterRepository registerRepository;
	
	@Autowired
	RegisterService registerService;
		
	@Test(expected = Exception.class)
	public void test1RegisterNull() throws Exception {
		registerService.register(null);
	}
	
	@Test(expected = Exception.class)
	public void test2RegisterAddWrongEmailFormat() throws Exception {
		RegisterReq registerReq = new RegisterReq();
		registerReq.setEmail("adsf");
		registerReq.setPassword("asd");
		registerService.register(registerReq);
	}
	
	@Test(expected = Exception.class)
	public void test3RegisterAddWrongLengthPassword() throws Exception {
		RegisterReq registerReq = new RegisterReq();
		registerReq.setEmail("aaa@hotmail.com");
		registerReq.setPassword("asd");
		registerService.register(registerReq);
	}
	
	@Test(expected = Exception.class)
	public void test4RegisterAddWrongLengthPassword() throws Exception {
		RegisterReq registerReq = new RegisterReq();
		registerReq.setEmail("aaa@hotmail.com");
		registerReq.setPassword("");
		registerService.register(registerReq);
	}
	
	@Test(expected = Exception.class)
	public void test5RegisterAddWrongLengthPassword() throws Exception {
		RegisterReq registerReq = new RegisterReq();
		registerReq.setEmail("aaa@hotmail.com");
		registerReq.setPassword("123456789123456789");
		registerService.register(registerReq);
		
	}
	
	@Test(expected = Exception.class)
	public void test6RegisterDupEmail() throws Exception {
		RegisterReq registerReq = new RegisterReq();
		registerReq.setEmail("b@hotmail.com");
		registerReq.setPassword("123456789");
		registerService.register(registerReq);
	}
	
	@Test
	public void test7RegisterSuccess() throws Exception {
		RegisterReq registerReq = new RegisterReq();
		registerReq.setEmail(UUID.randomUUID().toString() +"b@hotmail.com");
		registerReq.setPassword("123456789");
		Register register =  registerService.register(registerReq);
		System.out.println("register = " + register.toString());
		Assert.assertNotNull("register should not be null", register);
	}
}
