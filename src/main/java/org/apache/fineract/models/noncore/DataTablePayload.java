package org.apache.fineract.models.noncore;


import java.util.HashMap;

public class DataTablePayload {

    Integer id;

    transient Long clientCreationTime;

    transient String dataTableString;

    String registeredTableName;

    HashMap<String, Object> data;

    public Long getClientCreationTime() {
        return clientCreationTime;
    }

    public void setClientCreationTime(Long clientCreationTime) {
        this.clientCreationTime = clientCreationTime;
    }

    public String getDataTableString() {
        return dataTableString;
    }

    public void setDataTableString(String dataTableString) {
        this.dataTableString = dataTableString;
    }

    public String getRegisteredTableName() {
        return registeredTableName;
    }

    public void setRegisteredTableName(String registeredTableName) {
        this.registeredTableName = registeredTableName;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    public DataTablePayload() {
    }

}
