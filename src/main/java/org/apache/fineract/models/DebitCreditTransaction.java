package org.apache.fineract.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DebitCreditTransaction {
  private String chargeId;
  private String dateFormat;
  private String locale;
  private String amount;
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd MMMM yyyy",locale = "en_GB",timezone ="Africa/Lagos")
  private Date dueDate;

  public String getChargeId() {
	return chargeId;
}
public void setChargeId(String chargeId) {
	this.chargeId = chargeId;
}
public String getDateFormat() {
	return dateFormat;
}
public void setDateFormat(String dateFormat) {
	this.dateFormat = dateFormat;
}
public String getLocale() {
	return locale;
}
public void setLocale(String locale) {
	this.locale = locale;
}
public String getAmount() {
	return amount;
}
public void setAmount(String amount) {
	this.amount = amount;
}
public Date getDueDate() {
	return dueDate;
}
public void setDueDate(Date dueDate) {
	this.dueDate = dueDate;
}
}
