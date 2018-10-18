package org.apache.fineract.services;

import java.util.List;

import org.apache.fineract.models.CardManagement;
import org.apache.fineract.models.ChannelUsers;
import org.apache.fineract.models.ChargeMappingValue;
import org.apache.fineract.models.ChargeTransaction;
import org.apache.fineract.models.DebitClientCreditAccountInt;
import org.apache.fineract.models.DebitCreditResponse;
import org.apache.fineract.models.DebitCreditTransaction;
import org.apache.fineract.models.Ebanking;
import org.apache.fineract.models.PasswordChange;
import org.apache.fineract.models.PasswordChangeRes;
import org.apache.fineract.models.TransactionResponse;
import org.apache.fineract.models.accounts.ClientAccounts;
import org.apache.fineract.models.clients.Client;
import org.apache.fineract.models.clients.ClientRequest;
import org.apache.fineract.models.clients.ClientResponse;
import org.apache.fineract.models.clients.ClientTransaction;
import org.apache.fineract.models.clients.Page;
import org.apache.fineract.models.clients.PageableClients;
import org.springframework.http.ResponseEntity;
public interface IEbankingService {
	
	List<Ebanking> getAllEbankings();
	Ebanking getEbankingById(int id);
    boolean addEbanking(Ebanking ebanking);
    void updateEbanking(Ebanking ebanking);
    void deleteEbanking(int id);
    Ebanking getEbankingLogin(String username,String password);
    ChannelUsers getAauthUser(String username,String password);
    ResponseEntity<Client> findClientById(int clientId,String username,String password);
    Page<Client> getAllClients(String username,String password);
    ClientResponse clientCreation(ClientRequest creq,String username,String password);
    ResponseEntity<ClientAccounts> getAllClientAccounts(int clientId,String username,String password);
    Page<ClientTransaction> getAllClientTransactions(int clientId,String username,String password);
    ResponseEntity<ClientTransaction> getClientTransactionById(int clientId,int transactionId,String username,String password);
    PasswordChangeRes updateClientPassword(Long userId,PasswordChange clientpwd,String username,String password);
    CardManagement getCustId(String accountId);
    DebitCreditResponse debitCreditCreation(DebitClientCreditAccountInt tranreq,Long accountId,String username,String password);
    DebitCreditResponse internalDebitCreditCreation (DebitClientCreditAccountInt tranreq,Long clientId,String username,String password);
    TransactionResponse getTranDebitCredit(Long savingsId,Long resourceId);
    ChargeMappingValue getAcctMapping(ChargeTransaction chrgreq);

}
