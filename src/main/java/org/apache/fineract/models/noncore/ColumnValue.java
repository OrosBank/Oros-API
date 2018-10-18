package org.apache.fineract.models.noncore;

public class ColumnValue {

    Integer id;
    String value;
    Integer score;
    String registeredTableName;

    public String getRegisteredTableName() {
        return registeredTableName;
    }

    public void setRegisteredTableName(String registeredTableName) {
        this.registeredTableName = registeredTableName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ColumnValues{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", score=" + score +
                '}';
    }

    public ColumnValue() {
    }
}
