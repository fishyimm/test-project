package com.example.demo.entity;

import java.util.Date;

@Entity
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cardHolder;
	private String cardExpireDate;
	private String creditCardNo;
	private boolean status;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	private String createBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	
	private String updateBy;

	private Long cusId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Long getCusId() {
		return cusId;
	}

	public void setCusId(Long cusId) {
		this.cusId = cusId;
	}

	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", cardHolder=" + cardHolder + ", cardExpireDate=" + cardExpireDate
				+ ", creditCardNo=" + creditCardNo + ", status=" + status + ", createDate=" + createDate + ", createBy="
				+ createBy + ", updateDate=" + updateDate + ", updateBy=" + updateBy + ", cusId=" + cusId + "]";
	}
	
	
}
