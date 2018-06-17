package com.example.demo.service;

import com.example.demo.bean.req.CreditCardReq;
import com.example.demo.entity.CreditCard;
import com.example.demo.entity.Register;
import com.example.demo.repository.CreditCardRepository;
import com.example.demo.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CreditCardService {

	public static final String FORMAT_CARD_EXPIRE_DATE = "([0-9]{2})/([0-9]{2})";
	public static final String FORMAT_CARD_NO = "([0-9]){16}";
	
	@Autowired
	CreditCardRepository creditCardRepository;
	
	@Autowired
	RegisterRepository registerRepository;
	
	public CreditCard addCard(CreditCardReq creditCardReq) throws Exception {
		boolean isValidateSuccess = validateBody(creditCardReq);
		boolean isValidateExistSuccess = validateExisting(creditCardReq);
		
		if(isValidateSuccess && isValidateExistSuccess) {
			Date now = new Date();
			CreditCard creditCard = new CreditCard();
			creditCard.setCardExpireDate(creditCardReq.getCardExpireDate());
			creditCard.setCardHolder(creditCardReq.getCardHolder());
			creditCard.setCreditCardNo(creditCardReq.getCreditCardNo());
			creditCard.setCusId(creditCardReq.getCusId());
			creditCard.setStatus(true);
			
			creditCard.setCreateBy("system");
			creditCard.setUpdateBy("system");
			
			creditCard.setCreateDate(now);
			creditCard.setUpdateDate(now);
			
			CreditCard rescreditCard = creditCardRepository.save(creditCard);
			return rescreditCard;
		} else {
			return null;
		}
		
	}
	
	private boolean validateBody(CreditCardReq creditCardReq) throws Exception {
		
		if(creditCardReq == null) {
			System.out.println("CreditCardReq could not be null");
			throw new Exception("CreditCardReq could not be null");
		}
		if(validateCardNo(creditCardReq) && validateCardHolder(creditCardReq) && validateCardExpireDate(creditCardReq)) {
			return true;
		}
		
		return false;
		
	}
	
	private boolean validateCardNo(CreditCardReq creditCardReq) throws Exception {
		if(creditCardReq.getCreditCardNo() == null || creditCardReq.getCreditCardNo().isEmpty()) {
			System.out.println("cardNo could not be null or empty");
			throw new Exception("cardNo could not be null or empty");
		}
		
		if(creditCardReq.getCreditCardNo().length() != 16) {
			System.out.println("cardNo length should be 16 digits");
			throw new Exception("cardNo length should be 16 digits");
		}
		
		if(!creditCardReq.getCreditCardNo().matches(FORMAT_CARD_NO)) {
			System.out.println("cardNo should be number");
			throw new Exception("cardNo should be number");
		}
		
		return true;		
	}
	
	private boolean validateCardExpireDate(CreditCardReq creditCardReq) throws Exception {
		if(creditCardReq.getCardExpireDate() == null || creditCardReq.getCardExpireDate().isEmpty()) {
			System.out.println("cardExpireDate could not be null or empty");
			throw new Exception("cardExpireDate could not be null or empty");
		}
		if(!creditCardReq.getCardExpireDate().matches(FORMAT_CARD_EXPIRE_DATE)) {
			System.out.println("cardExpireDate wrong format please try again" + FORMAT_CARD_EXPIRE_DATE);
			throw new Exception("cardExpireDate wrong format please try again");
		}
		
		
		return true;
	}
	
	private boolean validateCardHolder(CreditCardReq creditCardReq) throws Exception {
		if(creditCardReq.getCardHolder() == null || creditCardReq.getCardHolder().isEmpty()) {
			System.out.println("cardHolder could not be null or empty");
			throw new Exception("cardHolder could not be null or empty");
		}
		
		return true;
	}
	
	private boolean validateExisting(CreditCardReq creditCardReq) throws Exception {
		Register foundRegister = registerRepository.findOne(creditCardReq.getCusId());
		if(foundRegister == null) {
			throw new Exception("could not find any registration from this cus id");
		}
		
		return true;
	}
}
