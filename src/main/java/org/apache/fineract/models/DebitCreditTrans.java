package org.apache.fineract.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DebitCreditTrans {
    private Double amount;
	
	private String locale;
	
	private String dateFormat;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd MMMM yyyy",locale = "en_GB",timezone ="Africa/Lagos")
	private Date transactionDate;

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

}
