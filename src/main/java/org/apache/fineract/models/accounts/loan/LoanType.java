package org.apache.fineract.models.accounts.loan;

public class LoanType {

    Integer id;
    String code;
    String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LoanType withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LoanType withCode(String code) {
        this.code = code;
        return this;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LoanType withValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "LoanType{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public LoanType() {
    }
}
