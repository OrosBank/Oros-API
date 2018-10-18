package org.apache.fineract.models.clients;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

//import java.util.ArrayList;
//import java.util.List;

//import org.apache.fineract.models.noncore.DataTablePayload;

public class ClientRequest {

	 private String fullname;
     private String firstname;
     private String middlename;
     private String lastname;
     private Long officeId;
     private boolean active;
     private String activationDate;     
     private String dateFormat;
     private String locale;
     private Long groupId;
     private String externalId;
     private String accountNo;
     private Long staffId;
     private String mobileNo;
     private Long savingsProductId;
     private Long genderId;
     private Long clientTypeId;
     private Long clientClassificationId;
     private String submittedOnDate;
     
		public String getFullname() {
			return fullname;
		}
		public void setFullname(String fullname) {
			this.fullname = fullname;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getMiddlename() {
			return middlename;
		}
		public void setMiddlename(String middlename) {
			this.middlename = middlename;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public Long getOfficeId() {
			return officeId;
		}
		public void setOfficeId(Long officeId) {
			this.officeId = officeId;
		}
		public boolean isActive() {
			return active;
		}
		public void setActive(boolean active) {
			this.active = active;
		}
		public String getActivationDate() {
			return activationDate;
		}
		public void setActivationDate(String activationDate) {
			this.activationDate = activationDate;
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
		public Long getGroupId() {
			return groupId;
		}
		public void setGroupId(Long groupId) {
			this.groupId = groupId;
		}
		public String getExternalId() {
			return externalId;
		}
		public void setExternalId(String externalId) {
			this.externalId = externalId;
		}
		public String getAccountNo() {
			return accountNo;
		}
		public void setAccountNo(String accountNo) {
			this.accountNo = accountNo;
		}
		public Long getStaffId() {
			return staffId;
		}
		public void setStaffId(Long staffId) {
			this.staffId = staffId;
		}
		public String getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		public Long getSavingsProductId() {
			return savingsProductId;
		}
		public void setSavingsProductId(Long savingsProductId) {
			this.savingsProductId = savingsProductId;
		}
		public Long getGenderId() {
			return genderId;
		}
		public void setGenderId(Long genderId) {
			this.genderId = genderId;
		}
		public Long getClientTypeId() {
			return clientTypeId;
		}
		public void setClientTypeId(Long clientTypeId) {
			this.clientTypeId = clientTypeId;
		}
		public Long getClientClassificationId() {
			return clientClassificationId;
		}
		public void setClientClassificationId(Long clientClassificationId) {
			this.clientClassificationId = clientClassificationId;
		}
		public String getSubmittedOnDate() {
			return submittedOnDate;
		}
		public void setSubmittedOnDate(String submittedOnDate) {
			this.submittedOnDate = submittedOnDate;
		}

  @Override
   public String toString() {
        return "ClientRequest{" +
        		" fullname='" + fullname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", officeId=" + officeId +
                ", groupId=" + groupId +
                ", staffId=" + staffId +
                ", genderId=" + genderId +
                ", active=" + active +
                ", accountNo=" + accountNo +
                ", activationDate='" + activationDate + '\'' +
                ", submittedOnDate='" + submittedOnDate + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", savingsProductId='" + savingsProductId + '\'' +
                ", externalId='" + externalId + '\'' +
                ", clientTypeId=" + clientTypeId +
                ", clientClassificationId=" + clientClassificationId +
                ", dateFormat='" + dateFormat + '\'' +
                ", locale='" + locale + '\'' +
                '}';
    } 
    public ClientRequest() {
    }
    public ClientRequest(String fullname,String firstname,String middlename,String lastname,Long officeId,
                   boolean active,String activationDate,String dateFormat,String locale,Long groupId,String externalId,
                   String accountNo,Long staffId,String mobileNo,Long savingsProductId,Long genderId,Long clientTypeId,
                   Long clientClassificationId,String submittedOnDate) {
    	this.fullname = fullname;
    	this.firstname = firstname;
    	this.middlename = middlename;
    	this.lastname = lastname;
    	this.officeId = officeId;
    	this.active = active;
    	this.activationDate = activationDate;
    	this.dateFormat = dateFormat;
    	this.locale = locale;
    	this.groupId = groupId;
    	this.externalId = externalId;
    	this.accountNo = accountNo;
    	this.staffId = staffId;
    	this.mobileNo = mobileNo;
    	this.savingsProductId = savingsProductId;
    	this.genderId = genderId;
    	this.clientTypeId = clientTypeId;
    	this.clientClassificationId = clientClassificationId;
    	this.submittedOnDate = submittedOnDate;
    }

}

