package org.apache.fineract.models.clients;

public class ClientResponse {
	private Long officeId;	
	private Long clientId;
	private Long resourceId;
	private Long savingsId;
	
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
	public Long getResourceId() {
		return resourceId;
	}
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
	public Long getSavingsId() {
		return savingsId;
	}
	public void setSavingsId(Long savingsId) {
		this.savingsId = savingsId;
	}
	
	public String toString() {
        return "ClientResponse{" +
                "officeId=" + officeId +
                ", clientId='" + clientId + '\'' +
                ", resourceId=" + resourceId +
                ", savingsId=" + savingsId +
                '}';
    }
}
