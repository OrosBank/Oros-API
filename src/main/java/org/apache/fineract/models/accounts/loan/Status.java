package org.apache.fineract.models.accounts.loan;

public class Status {

    Integer id;
    String code;
    String value;
    Boolean pendingApproval;
    Boolean waitingForDisbursal;
    Boolean active;
    Boolean closedObligationsMet;
    Boolean closedWrittenOff;
    Boolean closedRescheduled;
    Boolean closed;
    Boolean overpaid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Status withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Status withCode(String code) {
        this.code = code;
        return this;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Status withValue(String value) {
        this.value = value;
        return this;
    }

    public Boolean getPendingApproval() {
        return pendingApproval;
    }

    public void setPendingApproval(Boolean pendingApproval) {
        this.pendingApproval = pendingApproval;
    }

    public Status withPendingApproval(Boolean pendingApproval) {
        this.pendingApproval = pendingApproval;
        return this;
    }

    public Boolean getWaitingForDisbursal() {
        return waitingForDisbursal;
    }

    public void setWaitingForDisbursal(Boolean waitingForDisbursal) {
        this.waitingForDisbursal = waitingForDisbursal;
    }

    public Status withWaitingForDisbursal(Boolean waitingForDisbursal) {
        this.waitingForDisbursal = waitingForDisbursal;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Status withActive(Boolean active) {
        this.active = active;
        return this;
    }

    public Boolean getClosedObligationsMet() {
        return closedObligationsMet;
    }

    public void setClosedObligationsMet(Boolean closedObligationsMet) {
        this.closedObligationsMet = closedObligationsMet;
    }

    public Status withClosedObligationsMet(Boolean closedObligationsMet) {
        this.closedObligationsMet = closedObligationsMet;
        return this;
    }

    public Boolean getClosedWrittenOff() {
        return closedWrittenOff;
    }

    public void setClosedWrittenOff(Boolean closedWrittenOff) {
        this.closedWrittenOff = closedWrittenOff;
    }

    public Status withClosedWrittenOff(Boolean closedWrittenOff) {
        this.closedWrittenOff = closedWrittenOff;
        return this;
    }

    public Boolean getClosedRescheduled() {
        return closedRescheduled;
    }

    public void setClosedRescheduled(Boolean closedRescheduled) {
        this.closedRescheduled = closedRescheduled;
    }

    public Status withClosedRescheduled(Boolean closedRescheduled) {
        this.closedRescheduled = closedRescheduled;
        return this;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Status withClosed(Boolean closed) {
        this.closed = closed;
        return this;
    }

    public Boolean getOverpaid() {
        return overpaid;
    }

    public void setOverpaid(Boolean overpaid) {
        this.overpaid = overpaid;
    }

    public Status withOverpaid(Boolean overpaid) {
        this.overpaid = overpaid;
        return this;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", value='" + value + '\'' +
                ", pendingApproval=" + pendingApproval +
                ", waitingForDisbursal=" + waitingForDisbursal +
                ", active=" + active +
                ", closedObligationsMet=" + closedObligationsMet +
                ", closedWrittenOff=" + closedWrittenOff +
                ", closedRescheduled=" + closedRescheduled +
                ", closed=" + closed +
                ", overpaid=" + overpaid +
                '}';
    }

    public Status() {
    }
}
