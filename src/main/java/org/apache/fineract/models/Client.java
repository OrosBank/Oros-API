package org.apache.fineract.models;

import com.google.common.base.Preconditions;
import org.apache.fineract.utils.StatusCode;
import org.apache.fineract.utils.Timeline;

import java.util.Date;

public final class Client {

        private String fullname;
        private String firstname;
        private String middlename;
        private String lastname;
        private Long officeId;
        private boolean active;
        private Date activationDate;
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
        private Date submittedOnDate;
        //private Timeline timeline;
        
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
		public Date getActivationDate() {
			return activationDate;
		}
		public void setActivationDate(Date activationDate) {
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
		public Date getSubmittedOnDate() {
			return submittedOnDate;
		}
		public void setSubmittedOnDate(Date submittedOnDate) {
			this.submittedOnDate = submittedOnDate;
		}

        
}
