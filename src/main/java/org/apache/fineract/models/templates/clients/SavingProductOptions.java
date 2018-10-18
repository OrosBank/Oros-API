package org.apache.fineract.models.templates.clients;

public class SavingProductOptions {

    int id;
    String name;
    boolean withdrawalFeeForTransfers;
    boolean allowOverdraft;

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

    public boolean isWithdrawalFeeForTransfers() {
        return withdrawalFeeForTransfers;
    }

    public void setWithdrawalFeeForTransfers(boolean withdrawalFeeForTransfers) {
        this.withdrawalFeeForTransfers = withdrawalFeeForTransfers;
    }

    public boolean isAllowOverdraft() {
        return allowOverdraft;
    }

    public void setAllowOverdraft(boolean allowOverdraft) {
        this.allowOverdraft = allowOverdraft;
    }

    @Override
    public String toString() {
        return "SavingProductOptions{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", withdrawalFeeForTransfers=" + withdrawalFeeForTransfers +
                ", allowOverdraft=" + allowOverdraft +
                '}';
    }


    public SavingProductOptions() {
    }
}
