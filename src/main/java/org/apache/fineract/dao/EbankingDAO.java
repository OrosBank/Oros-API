package org.apache.fineract.dao;

import org.apache.fineract.models.CardManagement;
import org.apache.fineract.models.ChannelUsers;
import org.apache.fineract.models.ChargeMappingValue;
import org.apache.fineract.models.ChargeTransaction;
import org.apache.fineract.models.Ebanking;
import org.apache.fineract.models.PasswordChange;
import org.apache.fineract.models.TransactionResponse;

import java.util.List;
public interface EbankingDAO {
	
	List<Ebanking> getAllEbankings();
	Ebanking getId(int id);
    void addEbanking(Ebanking ebanking);
    void updateEbanking(Ebanking ebanking);
    void deleteEbanking(int id);
    boolean ebankingExists(String username, Long client_id);
    Ebanking findUserInfo(String username);
    List<String> getUserRoles(String username);
    Ebanking userLogin(String username,String password);
    ChannelUsers findAauthUser(String username,String password);
    List<String> getRoleNames(int userId);
    ChannelUsers findUserAuthInfo(String username);
    void updateClientPassword(Long userId,PasswordChange clientpwd);
    CardManagement getCustId(String accountId);
    TransactionResponse getDebitCredit(Long savingsId,Long resourceId);
    ChargeMappingValue getDebitCreditMapping(ChargeTransaction chrgreq);

}
