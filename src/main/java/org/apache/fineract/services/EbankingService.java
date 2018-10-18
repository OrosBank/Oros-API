package org.apache.fineract.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
import org.apache.fineract.dao.EbankingDAO;
import org.apache.fineract.services.ClientsService;
@Service
public class EbankingService implements IEbankingService {
	
	@Autowired
	private EbankingDAO ebankingDAO;
	ClientsService clientService = new ClientsService();
	UserService userService = new UserService();
	SavingsService saveService = new SavingsService();
	
	@Override
	public Ebanking getEbankingById(int id) {
		Ebanking obj = ebankingDAO.getId(id);
		return obj;
	}
	public Ebanking getEbankingLogin(String username,String password) {
		Ebanking obj = ebankingDAO.userLogin(username,password);
		return obj;
	}
	public ChannelUsers getAauthUser(String username,String password) {
		ChannelUsers chanUser = ebankingDAO.findAauthUser(username,password);
		return chanUser;
	}
	@Override
	public List<Ebanking> getAllEbankings(){
		return ebankingDAO.getAllEbankings();
	}
	@Override
	public synchronized boolean addEbanking(Ebanking ebanking){
       if (ebankingDAO.ebankingExists(ebanking.getUsername(), ebanking.getClient_id())) {
    	   return false;
       } else {
    	   ebankingDAO.addEbanking(ebanking);
    	   return true;
       }
	}
	@Override
	public void updateEbanking(Ebanking ebanking) {
		ebankingDAO.updateEbanking(ebanking);
	}
	@Override
	public void deleteEbanking(int id) {
		ebankingDAO.deleteEbanking(id);
	}
	public ResponseEntity<Client> findClientById(int clientId,String username,String password) {
		ResponseEntity<Client> obj = null;
		try {
			obj = clientService.getClientId(clientId,username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	public Page<Client> getAllClients(String username,String password){
		//return ebankingDAO.getAllClients();
		return clientService.getAllClients(username,password);
	}
	public ClientResponse clientCreation(ClientRequest creq,String username,String password) {
		ClientResponse obj = null;
		try {
			obj = clientService.clientCreation(creq, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	public ResponseEntity<ClientAccounts> getAllClientAccounts(int clientId,String username,String password) {
		ResponseEntity<ClientAccounts> account = null;
		try {
			account = clientService.getAllClientAccounts(clientId,username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}
	public Page<ClientTransaction> getAllClientTransactions(int clientId,String username,String password){
		return clientService.getAllClientTransactions(clientId,username,password);
	}
	public ResponseEntity<ClientTransaction> getClientTransactionById(int clientId,int transactionId,
			String username,String password){
		ResponseEntity<ClientTransaction> trans = null;
		try {
			trans = clientService.getClientTransactionById(clientId,transactionId,username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trans;
	}
	public PasswordChangeRes updateClientPassword(Long userId,PasswordChange clientpwd,String username,String password){
		PasswordChangeRes pwds = null;
		try {
			pwds = 	userService.updateclientpwd(userId,clientpwd,username,password);
			if(pwds != null) {
				ebankingDAO.updateClientPassword(userId, clientpwd);
			}else {
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return pwds;
	}
	
	public CardManagement getCustId(String accountId) {
		CardManagement obj = ebankingDAO.getCustId(accountId);	
		return obj;
	}
	
	public DebitCreditResponse debitCreditCreation(DebitClientCreditAccountInt tranreq,Long accountId,String username,String password) {
		DebitCreditResponse obj = null;
		try {
			obj = saveService.DebitSavingsCreditInternalAccount(tranreq,accountId, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	public DebitCreditResponse internalDebitCreditCreation (DebitClientCreditAccountInt tranreq,Long clientId,String username,String password) {
		DebitCreditResponse obj = null;
		try {
			obj = saveService.DebitClientCreditInternalAccount(tranreq,clientId,username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	public TransactionResponse getTranDebitCredit(Long savingsId,Long resourceId) {
		TransactionResponse obj = ebankingDAO.getDebitCredit(savingsId,resourceId);	
		return obj;
	}
	public ChargeMappingValue getAcctMapping(ChargeTransaction chrgreq) {
		ChargeMappingValue obj = ebankingDAO.getDebitCreditMapping(chrgreq);	
		return obj;
	}

}
