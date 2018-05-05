package com.example.demo.bean.req;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class CreditCardReq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2251560642811190352L;
	@ApiModelProperty(required = true, example = "1234567891234567", position = 1)
	private String creditCardNo;
	@ApiModelProperty(required = true, example = "asdasdasd", position = 2)
	private String cardHolder;
	@ApiModelProperty(required = true, example = "05/21", position = 3)
	private String cardExpireDate;
	@ApiModelProperty(required = true, example = "1", position = 4)
	private Long cusId;
		
	public String getCardHolder() {
		return cardHolder;
	}
	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}
	public String getCardExpireDate() {
		return cardExpireDate;
	}
	public void setCardExpireDate(String cardExpireDate) {
		this.cardExpireDate = cardExpireDate;
	}
	public String getCreditCardNo() {
		return creditCardNo;
	}
	public void setCreditCardNo(String creditCardNo) {
		this.creditCardNo = creditCardNo;
	}
	public Long getCusId() {
		return cusId;
	}
	public void setCusId(Long cusId) {
		this.cusId = cusId;
	}
	@Override
	public String toString() {
		return "CreditCardReq [creditCardNo=" + creditCardNo + ", cardHolder=" + cardHolder + ", cardExpireDate="
				+ cardExpireDate + ", cusId=" + cusId + "]";
	}

}
