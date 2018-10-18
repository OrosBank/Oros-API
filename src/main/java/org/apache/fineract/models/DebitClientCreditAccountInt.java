package org.apache.fineract.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DebitClientCreditAccountInt {
	private Double amount;
	
	private String locale;
	
	private String dateFormat;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd MMMM yyyy",locale = "en_GB",timezone ="Africa/Lagos")
	private Date transactionDate;
	
	private String chargeId;
	
	private String amt;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd MMMM yyyy",locale = "en_GB",timezone ="Africa/Lagos")
	private Date dueDate;

	public String getChargeId() {
		return chargeId;
	}

	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	/*@SuppressWarnings("null")
	public DebitCreditTransaction strTran(String chargeId,String dateFormat,String locale,String amt,Date dueDate) {
		DebitCreditTransaction resp = null;
		resp.setAmount(amt);
		resp.setChargeId(chargeId);
		resp.setDateFormat(dateFormat);
		resp.setLocale(locale);
		resp.setDueDate(dueDate);
		//this.chargeId = chargeId;
		//this.dateFormat = dateFormat;
		//this.locale = locale;
		//this.amt = amt;
		//this.dueDate = dueDate;		
		return resp;
	}
	public DebitClientCreditAccountInt(String dateFormat,String locale,Double amount,Date transactionDate) {
		this.dateFormat = dateFormat;
		this.locale = locale;
		this.amount = amount;
		this.transactionDate = transactionDate;		
	}*/
}
