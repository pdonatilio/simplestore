package com.pdonatilio.simplestore.domain;

import javax.persistence.Entity;

import com.pdonatilio.simplestore.domain.enums.PaymentState;

@Entity
public class CardPayment extends Payment{
	private static final long serialVersionUID = 1L;
	
	private Integer installmentNumbers;
	
	public CardPayment() {
	}

	public CardPayment(Integer id, PaymentState paymentState, PurchaseOrder order, Integer installmentNumbers) {
		super(id, paymentState, order);
		this.installmentNumbers = installmentNumbers;
	}

	public Integer getInstallmentNumbers() {
		return installmentNumbers;
	}

	public void setInstallmentNumbers(Integer installmentNumbers) {
		this.installmentNumbers = installmentNumbers;
	}
}
