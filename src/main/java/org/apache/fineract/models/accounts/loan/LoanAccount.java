package org.apache.fineract.models.accounts.loan;

public class LoanAccount{

    Long clientId;
    Long groupId;
    Long centerId;
    Integer id;
    String accountNo;
    String externalId;
    Integer productId;
    String productName;
    Status status;
    LoanType loanType;
    Integer loanCycle;
    Boolean inArrears;

    public LoanAccount() {
    }

    public long getGroupId() {
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

    public LoanAccount withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public LoanAccount withAccountNo(String accountNo) {
        this.accountNo = accountNo;
        return this;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public LoanAccount withExternalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public LoanAccount withProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LoanAccount withProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LoanAccount withStatus(Status status) {
        this.status = status;
        return this;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public LoanAccount withLoanType(LoanType loanType) {
        this.loanType = loanType;
        return this;
    }

    public Integer getLoanCycle() {
        return loanCycle;
    }

    public void setLoanCycle(Integer loanCycle) {
        this.loanCycle = loanCycle;
    }

    public Boolean getInArrears() {
        return inArrears;
    }

    public void setInArrears(Boolean inArrears) {
        this.inArrears = inArrears;
    }

    @Override
    public String toString() {
        return "LoanAccount{" +
                "id=" + id +
                ", accountNo='" + accountNo + '\'' +
                ", externalId='" + externalId + '\'' +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", status=" + status +
                ", loanType=" + loanType +
                ", loanCycle=" + loanCycle +
                '}';
    }
}
