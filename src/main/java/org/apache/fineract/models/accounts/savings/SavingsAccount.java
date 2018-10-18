package org.apache.fineract.models.accounts.savings;

public class SavingsAccount {

    //long clientId;
    //long groupId;
    //long centerId;
    Integer id;
    String accountNo;
    Integer productId;
    String productName;
    Status status;
    Currency currency;
    Double accountBalance;
    DepositType depositType;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public DepositType getDepositType() {
		return depositType;
	}

	public void setDepositType(DepositType depositType) {
		this.depositType = depositType;
	}

	public SavingsAccount() {
    }

 /*   public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getClientId() {
        return this.clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getCenterId() {
        return this.centerId;
    }

    public void setCenterId(long centerId) {
        this.centerId = centerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SavingsAccount withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public SavingsAccount withAccountNo(String accountNo) {
        this.accountNo = accountNo;
        return this;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public SavingsAccount withProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public SavingsAccount withProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public SavingsAccount withStatus(Status status) {
        this.status = status;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public SavingsAccount withCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public SavingsAccount withAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
        return this;
    }

    public DepositType getDepositType() {
        return depositType;
    }

    public void setDepositType(DepositType depositType) {
        this.depositType = depositType;
    }

    public boolean isRecurring() {
        return this.getDepositType() == null ? false : this.getDepositType().isRecurring();
    }
*/
	@Override
    public String toString() {
        return "SavingsAccount{" +
                "accountBalance=" + accountBalance +
                ", id=" + id +
                ", accountNo='" + accountNo + '\'' +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", status=" + status +
                ", currency=" + currency +
                ", depositType=" + depositType +
                '}';
    }
}
