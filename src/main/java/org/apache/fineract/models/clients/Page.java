package org.apache.fineract.models.clients;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {

    private int totalFilteredRecords;
    private List<T> pageItems = new ArrayList<T>();


    public List<T> getPageItems() {
        return pageItems;
    }

    public void setPageItems(List<T> pageItems) {
        this.pageItems = pageItems;
    }


    public int getTotalFilteredRecords() {
        return totalFilteredRecords;
    }

    public void setTotalFilteredRecords(int totalFilteredRecords) {
        this.totalFilteredRecords = totalFilteredRecords;
    }


}
