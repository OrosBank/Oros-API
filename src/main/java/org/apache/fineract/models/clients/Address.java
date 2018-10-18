package org.apache.fineract.models.clients;


public class Address {

    Integer addressTypeId;
    Boolean isActive;
    String street;
    Integer stateProvinceId;
    Integer countryId;

    public Integer getAddressTypeId() {
        return addressTypeId;
    }

    public void setAddressTypeId(Integer addressTypeId) {
        this.addressTypeId = addressTypeId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getStateProvinceId() {
        return stateProvinceId;
    }

    public void setStateProvinceId(Integer stateProvinceId) {
        this.stateProvinceId = stateProvinceId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressTypeId=" + addressTypeId +
                ", isActive=" + isActive +
                ", street='" + street + '\'' +
                ", stateProvinceId=" + stateProvinceId +
                ", countryId=" + countryId +
                '}';
    }
    public Address() {
    }
}
