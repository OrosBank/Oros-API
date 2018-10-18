package org.apache.fineract.models;

public class DebitCreditResponse {
	private Long officeId;
	private Long clientId;
	private Long savingsId;
	private Long resourceId;
	private String transactionId;
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public Long getOfficeId() {
		return officeId;
	}
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public Long getSavingsId() {
		return savingsId;
	}
	public void setSavingsId(Long savingsId) {
		this.savingsId = savingsId;
	}
	public Long getResourceId() {
		return resourceId;
	}
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
}
