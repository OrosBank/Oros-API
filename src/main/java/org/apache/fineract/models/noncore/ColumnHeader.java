package org.apache.fineract.models.noncore;

import java.util.ArrayList;
import java.util.List;

public class ColumnHeader{

    Integer id;
    String columnCode;
    String columnDisplayType;
    Integer columnLength;
    String dataTableColumnName;
    String columnType;
    Boolean isColumnNullable;
    Boolean isColumnPrimaryKey;
    String registeredTableName;

    List<ColumnValue> columnValues = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegisteredTableName() {
        return registeredTableName;
    }

    public void setRegisteredTableName(String registeredTableName) {
        this.registeredTableName = registeredTableName;
    }

    public String getColumnCode() {
        return columnCode;
    }

    public void setColumnCode(String columnCode) {
        this.columnCode = columnCode;
    }

    public String getColumnDisplayType() {
        return columnDisplayType;
    }

    public void setColumnDisplayType(String columnDisplayType) {
        this.columnDisplayType = columnDisplayType;
    }

    public Integer getColumnLength() {
        return columnLength;
    }

    public void setColumnLength(Integer columnLength) {
        this.columnLength = columnLength;
    }

    public String getColumnName() {
        return dataTableColumnName;
    }

    public void setColumnName(String columnName) {
        this.dataTableColumnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public Boolean getColumnNullable() {
        return isColumnNullable;
    }

    public void setColumnNullable(Boolean columnNullable) {
        isColumnNullable = columnNullable;
    }

    public Boolean getColumnPrimaryKey() {
        return isColumnPrimaryKey;
    }

    public void setColumnPrimaryKey(Boolean columnPrimaryKey) {
        isColumnPrimaryKey = columnPrimaryKey;
    }

    public List<ColumnValue> getColumnValues() {
        return columnValues;
    }

    public void setColumnValues(List<ColumnValue> columnValues) {
        this.columnValues = columnValues;
    }

    @Override
    public String toString() {
        return "ColumnHeader{" +
                "columnCode='" + columnCode + '\'' +
                ", columnDisplayType='" + columnDisplayType + '\'' +
                ", columnLength=" + columnLength +
                ", dataTableColumnName='" + dataTableColumnName + '\'' +
                ", columnType='" + columnType + '\'' +
                ", isColumnNullable=" + isColumnNullable +
                ", isColumnPrimaryKey=" + isColumnPrimaryKey +
                ", columnValues=" + columnValues +
                '}';
    }


    public ColumnHeader() {
    }
}
