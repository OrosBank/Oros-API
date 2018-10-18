package org.apache.fineract.models.clients;

public class ClientDate {

    long clientId;
    long chargeId;
    int day;
    int month;
    int year;

    public ClientDate(long clientId, long chargeId, int day, int month, int year) {
        this.clientId = clientId;
        this.chargeId = chargeId;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ClientDate() {
    }
}
