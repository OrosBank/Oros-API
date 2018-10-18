package org.apache.fineract.models;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ChargeTransaction {
	private String debitAccount;
	private double amount;
	private String creditAccount;
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private String transactionDate;
	
	public String getDebitAccount() {
		return debitAccount;
	}
	public void setDebitAccount(String debitAccount) {
		this.debitAccount = debitAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCreditAccount() {
		return creditAccount;
	}
	public void setCreditAccount(String creditAccount) {
		this.creditAccount = creditAccount;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

}
