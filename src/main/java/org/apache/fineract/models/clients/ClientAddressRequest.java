package org.apache.fineract.models.clients;

public class ClientAddressRequest{

    String placeId;
    String placeAddress;
    Double latitude;
    Double longitude;

    // Defaults
    String dateFormat = "dd MMMM YYYY";
    String locale = "en";

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getPlaceAddress() {
        return placeAddress;
    }

    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public String toString() {
        return "ClientAddressRequest{" +
                "placeId='" + placeId + '\'' +
                ", placeAddress='" + placeAddress + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", dateFormat='" + dateFormat + '\'' +
                ", locale='" + locale + '\'' +
                '}';
    }

    public ClientAddressRequest(String placeId, String placeAddress, Double latitude,
                                Double longitude) {
        this.placeId = placeId;
        this.placeAddress = placeAddress;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public ClientAddressRequest() {
    }
}
