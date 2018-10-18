package org.apache.fineract.models.clients;

import java.util.ArrayList;
import java.util.List;

import org.apache.fineract.models.Timeline;

public class Client {
	
    int id;
    String accountNo;
    Status status;
    boolean active;
    List<Integer> activationDate = new ArrayList<Integer>();
    List<Integer> dateOfBirth = new ArrayList<Integer>();
    String firstname;
    String middlename;
    String lastname;
    String displayName;
    String fullname;
    String mobileNo;
    int officeId;
    String officeName;
    boolean isStaff;
    int staffId;
    String staffName;
    Timeline timeline;
    int imageId;
    boolean imagePresent;
    String externalId;
    Long savingsAccountId;
    Gender gender;
    
    

    public List<Integer> getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(List<Integer> dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public boolean isStaff() {
		return isStaff;
	}

	public void setStaff(boolean isStaff) {
		this.isStaff = isStaff;
	}

	public Long getSavingsAccountId() {
		return savingsAccountId;
	}

	public void setSavingsAccountId(Long savingsAccountId) {
		this.savingsAccountId = savingsAccountId;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Integer> getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(List<Integer> activationDate) {
        this.activationDate = activationDate;
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public boolean isImagePresent() {
        return imagePresent;
    }

    public void setImagePresent(boolean imagePresent) {
        this.imagePresent = imagePresent;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }
	
	@Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", accountNo='" + accountNo + '\'' +
                ", status=" + status +
                ", active=" + active +
                ", activationDate=" + activationDate +
                ", dateOfBirth=" + dateOfBirth +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", displayName='" + displayName + '\'' +
                ", officeId=" + officeId +
                ", officeName='" + officeName + '\'' +
                ", staffId=" + staffId +
                ", staffName='" + staffName + '\'' +
                ", timeline=" + timeline +
                ", fullname='" + fullname + '\'' +
                ", imageId=" + imageId +
                ", imagePresent=" + imagePresent +
                ", externalId='" + externalId + '\'' +
                ", savingsAccountId='" + savingsAccountId + '\'' +
                ", mobileNo=" + mobileNo +
                ", isStaff=" + isStaff +
                ", gender=" + gender +
                '}';
    }

    
}

