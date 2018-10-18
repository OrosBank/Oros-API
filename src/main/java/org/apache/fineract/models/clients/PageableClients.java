package org.apache.fineract.models.clients;

import java.util.List;

import com.google.common.base.Preconditions;

public final class PageableClients {

    private Long totalFilteredRecords;
    private List<Client> pageItems;

    /**
     * Returns the total number of filtered records.
     */
    public Long getTotalFilteredRecords() {
        return this.totalFilteredRecords;
    }

    /**
     * Sets the total number of filtered records.
     * @param totalFilteredRecords the number of filtered records
     */
    public void setTotalFilteredRecords(final Long totalFilteredRecords) {
        Preconditions.checkNotNull(totalFilteredRecords);

        this.totalFilteredRecords = totalFilteredRecords;
    }

    /**
     * Returns the list of clients.
     */
    public List<Client> getClients() {
        return this.pageItems;
    }

    /**
     * Sets the list of clients.
     * @param clients the clients list
     */
    public void setClients(final List<Client> clients) {
        Preconditions.checkNotNull(clients);

        this.pageItems = clients;
    }

}

