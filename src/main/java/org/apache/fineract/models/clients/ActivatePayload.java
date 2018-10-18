package org.apache.fineract.models.clients;

public class ActivatePayload{

    String activationDate;
    String dateFormat = "dd MMMM YYYY";
    String locale = "en";

    public String getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
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

    public ActivatePayload(String activationDate) {
        this.activationDate = activationDate;
    }

    public ActivatePayload() {
    }
}
