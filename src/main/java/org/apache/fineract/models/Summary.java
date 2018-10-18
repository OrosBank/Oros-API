package org.apache.fineract.models;

public class Summary {
	
	Currency currency;
	Double totalDeposits;
	Double accountBalance;
	Double totalWithdrawals;
	Double totalInterestEarned;
	Double availableBalance;
	
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public Double getTotalDeposits() {
		return totalDeposits;
	}
	public void setTotalDeposits(Double totalDeposits) {
		this.totalDeposits = totalDeposits;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Double getTotalWithdrawals() {
		return totalWithdrawals;
	}
	public void setTotalWithdrawals(Double totalWithdrawals) {
		this.totalWithdrawals = totalWithdrawals;
	}
	public Double getTotalInterestEarned() {
		return totalInterestEarned;
	}
	public void setTotalInterestEarned(Double totalInterestEarned) {
		this.totalInterestEarned = totalInterestEarned;
	}
	public Double getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
	}

}
