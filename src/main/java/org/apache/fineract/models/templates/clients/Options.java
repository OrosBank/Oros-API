package org.apache.fineract.models.templates.clients;

public class Options {

    String optionType;
    int id;
    String name;
    int position;
    String description;
    boolean activeStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }

    public boolean isActiveStatus() {
        return this.activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return "Options{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", position=" + position +
                ", description='" + description + '\'' +
                ", activeStatus=" + activeStatus +
                '}';
    }


    public Options() {
    }
}
