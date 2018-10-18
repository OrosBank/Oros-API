package org.apache.fineract.models;

public class Savingsaccount {
	private String accountNo;
	private Long clientId;
	private String clientName;
	private String savingsProductName;
	private String fieldOfficerName;
	private Summary summary;
	
	public Summary getSummary() {
		return summary;
	}
	public void setSummary(Summary summary) {
		this.summary = summary;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getSavingsProductName() {
		return savingsProductName;
	}
	public void setSavingsProductName(String savingsProductName) {
		this.savingsProductName = savingsProductName;
	}
	public String getFieldOfficerName() {
		return fieldOfficerName;
	}
	public void setFieldOfficerName(String fieldOfficerName) {
		this.fieldOfficerName = fieldOfficerName;
	}
		 @Override
	    public String toString() {
	        return "Savingsaccount{" +
	                "accountNo =" + accountNo +
	                ", clientId ='" + clientId + '\'' +
	                ", clientName ='" + clientName + '\'' +
	                ", savingsProductName ='" + savingsProductName + '\'' +
	                ", fieldOfficerName ='" + fieldOfficerName + '\'' +
	                ", summary ='" + summary + '\'' +
	                
	                '}';
	    }
}
