package org.apache.fineract.models.templates.clients;



public class OfficeOptions {

    int id;
    String name;
    String nameDecorated;

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

    public String getNameDecorated() {
        return nameDecorated;
    }

    public void setNameDecorated(String nameDecorated) {
        this.nameDecorated = nameDecorated;
    }

    @Override
    public String toString() {
        return "OfficeOptions{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameDecorated='" + nameDecorated + '\'' +
                '}';
    }


    public OfficeOptions() {
    }
}