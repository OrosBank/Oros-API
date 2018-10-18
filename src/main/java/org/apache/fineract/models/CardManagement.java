package org.apache.fineract.models;

//import java.util.Date;

public class CardManagement {
	
	private String accountName;
	private String accountNumber;
	private String accountTypeName;
	private String accountType;
	private String accountStatus;
	private String gender;
	//private Date bod;
	private String birthday;
	private Long customerId;
	private String customerAddress;
	private String customerEmail;
	private String customerMobile;
	private String currency;
	private Long currencyCode;
	
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Long getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(Long currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountTypeName() {
		return accountTypeName;
	}
	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	/*public Date getBod() {
		return bod;
	}
	public void setBod(Date bod) {
		this.bod = bod;
	}*/
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	public CardManagement() {
		
	}
	
	public CardManagement(String accountName,String accountNumber,String accountTypeName,String accountType,
			String accountStatus,String gender,Long customerId,String customerAddress,String customerEmail,
			String customerMobile,String birthday,String currency,Long currencyCode) {
		this.accountName     = accountName;
		this.accountNumber   = accountNumber;
		this.accountTypeName = accountTypeName;
		this.accountType     = accountType;
		this.accountStatus   = accountStatus;
		this.gender          = gender;
		this.customerId      = customerId;
		this.customerAddress = customerAddress;
		this.customerEmail   = customerEmail;
		this.customerMobile  = customerMobile;
		this.birthday        = birthday;
		this.currency        = currency;
		this.currencyCode    = currencyCode;
		
		
	}
	
	@Override
    public String toString() {
        return "CardManagement{" +
                "accountName='" + accountName + '\'' +
                ", accountNumber=" + accountNumber +
                ", accountTypeName='" + accountTypeName+ '\'' +
                ", accountType=" + accountType +
                ", accountStatus=" + accountStatus +
                ", gender=" + gender +
                ", customerId=" + customerId +
                ", customerAddress=" + customerAddress +
                ", customerEmail=" + customerEmail +
                ",customerMobile=" + customerMobile +
                ", birthday=" + birthday +
                ", currency=" + currency +
                ", currencyCode=" + currencyCode +
                '}';
    }
	

}
