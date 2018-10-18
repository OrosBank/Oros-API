package org.apache.fineract.models.accounts;

import java.util.ArrayList;
import java.util.List;

import org.apache.fineract.models.accounts.loan.LoanAccount;
import org.apache.fineract.models.accounts.savings.SavingsAccount;

public class ClientAccounts {

    private List<LoanAccount> loanAccounts = new ArrayList<LoanAccount>();
    private List<SavingsAccount> savingsAccounts = new ArrayList<SavingsAccount>();

    /*public ClientAccounts() {
    }

    public List<LoanAccount> getLoanAccounts() {
        return loanAccounts;
    }

    public void setLoanAccounts(List<LoanAccount> loanAccounts) {
        this.loanAccounts = loanAccounts;
    }

    public ClientAccounts withLoanAccounts(List<LoanAccount> loanAccounts) {
        this.loanAccounts = loanAccounts;
        return this;
    }

    public List<SavingsAccount> getSavingsAccounts() {
        return savingsAccounts;
    }

    public void setSavingsAccounts(List<SavingsAccount> savingsAccounts) {
        this.savingsAccounts = savingsAccounts;
    }

    public ClientAccounts withSavingsAccounts(List<SavingsAccount> savingsAccounts) {
        this.savingsAccounts = savingsAccounts;
        return this;
    }

    public List<SavingsAccount> getRecurringSavingsAccounts() {
        return getSavingsAccounts(true);
    }

    public List<SavingsAccount> getNonRecurringSavingsAccounts() {
        return getSavingsAccounts(false);
    }

    private List<SavingsAccount> getSavingsAccounts(boolean wantRecurring) {
        List<SavingsAccount> result = new ArrayList<SavingsAccount>();
        if (this.savingsAccounts != null) {
            for (SavingsAccount account : savingsAccounts) {
                if (account.isRecurring() == wantRecurring) {
                    result.add(account);
                }
            }
        }
        return result;
    }
*/
    @Override
    public String toString() {
        return "ClientAccounts{" +
                "loanAccounts=" + loanAccounts +
                ", savingsAccounts=" + savingsAccounts +
                '}';
    }

	public List<LoanAccount> getLoanAccounts() {
		return loanAccounts;
	}

	public void setLoanAccounts(List<LoanAccount> loanAccounts) {
		this.loanAccounts = loanAccounts;
	}

	public List<SavingsAccount> getSavingsAccounts() {
		return savingsAccounts;
	}

	public void setSavingsAccounts(List<SavingsAccount> savingsAccounts) {
		this.savingsAccounts = savingsAccounts;
	}
}
