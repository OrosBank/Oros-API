package org.apache.fineract.models.clients;

import java.util.ArrayList;
import java.util.List;

public class ClientTransaction {
	private int id;
	private Long officeId;
	private String officeName;
	private Type type; 
	List<Integer> date = new ArrayList<Integer>();
    private Currency currency;
    private Double amount;
    List<Integer> submittedOnDate = new ArrayList<Integer>();
    private boolean reversed;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getOfficeId() {
		return officeId;
	}
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public List<Integer> getDate() {
		return date;
	}
	public void setDate(List<Integer> date) {
		this.date = date;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public List<Integer> getSubmittedOnDate() {
		return submittedOnDate;
	}
	public void setSubmittedOnDate(List<Integer> submittedOnDate) {
		this.submittedOnDate = submittedOnDate;
	}
	public boolean isReversed() {
		return reversed;
	}
	public void setReversed(boolean reversed) {
		this.reversed = reversed;
	}
	
	@Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", officeId='" + officeId + '\'' +
                ", officeName=" + officeName +
                ", type=" + type +
                ", date=" + date +
                ", currency='" + currency + '\'' +
                ", amount='" + amount + '\'' +
                ", submittedOnDate='" + submittedOnDate + '\'' +
                ", reversed='" + reversed + '\'' +
                '}';
    }
}
