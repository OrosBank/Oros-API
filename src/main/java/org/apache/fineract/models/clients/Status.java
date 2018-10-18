package org.apache.fineract.models.clients;

public class Status{

private static final String STATUS_ACTIVE = "Active";

    int id;
    String code;
    String value;

    public Status() {
    }

    // Helper method to check if status is Active
    public static boolean isActive(String value) {
        return value.equalsIgnoreCase(STATUS_ACTIVE);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
