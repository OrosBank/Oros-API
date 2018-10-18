package org.apache.fineract.models;

public class PasswordChangeRes {
	private Long officeId;
    private Long resourceId;
    private Changes changes;
    
	public Long getOfficeId() {
		return officeId;
	}
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}
	public Long getResourceId() {
		return resourceId;
	}
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
	public Changes getChanges() {
		return changes;
	}
	public void setChanges(Changes changes) {
		this.changes = changes;
	}
	@Override
	   public String toString() {
	        return "PasswordChange{" +
	                ", officeId='" + officeId + '\'' +
	                ", resourceId='" + resourceId + '\'' +
	                ", changes='" + changes + '\'' +
	                '}';
	}
    

}
