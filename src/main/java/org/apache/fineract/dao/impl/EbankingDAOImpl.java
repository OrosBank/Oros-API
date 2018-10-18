package org.apache.fineract.dao.impl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.apache.fineract.models.CardManagement;
import org.apache.fineract.models.ChannelUsers;
import org.apache.fineract.models.ChargeMappingValue;
import org.apache.fineract.models.ChargeTransaction;
import org.apache.fineract.models.Ebanking;
import org.apache.fineract.models.PasswordChange;
import org.apache.fineract.models.TransactionResponse;
import org.apache.fineract.dao.EbankingDAO;
import org.apache.fineract.mapper.CardManagementMapper;
import org.apache.fineract.mapper.ChannelUsersMapper;
import org.apache.fineract.mapper.EbankingMapper;
import org.apache.fineract.mapper.TransactionResponseMapper;

@Transactional
@Repository
public class EbankingDAOImpl implements EbankingDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public Ebanking getId(int id) {
		String sql = "SELECT id,is_deleted,office_id,client_id,staff_id,username,firstname,lastname,";
			   sql = sql + "password,email,mobile_number FROM m_ebanking WHERE Id = ?";
		RowMapper<Ebanking> rowMapper = new BeanPropertyRowMapper<Ebanking>(Ebanking.class);
		Ebanking ebanking = jdbcTemplate.queryForObject(sql, rowMapper, id);
		return ebanking;
	}
	@Override
	public Ebanking userLogin(String username,String password) {
		
		String sql = "SELECT id,is_deleted,office_id,client_id,staff_id,username,firstname,lastname,";
			   sql = sql + "password,email,mobile_number FROM m_ebanking WHERE username = ? ";
		RowMapper<Ebanking> rowMapper = new BeanPropertyRowMapper<Ebanking>(Ebanking.class);
		Ebanking ebanking = jdbcTemplate.queryForObject(sql, rowMapper, username);
		return ebanking;
	}
	
	@Override
	public List<Ebanking> getAllEbankings() {
		String sql = "SELECT id,is_deleted,office_id,client_id,staff_id,username,firstname,lastname,";
		   sql = sql + "password,email,mobile_number FROM m_ebanking";
        //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
		RowMapper<Ebanking> rowMapper = new EbankingMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	@Override
	public void addEbanking(Ebanking ebanking) {
		//Add article
		String sql = "INSERT INTO m_ebanking (client_id, username, password) values (?, ?, ?)";
		jdbcTemplate.update(sql, ebanking.getClient_id(), ebanking.getUsername(), ebanking.getPassword());
		
		//Fetch article id
		sql = "SELECT Id FROM m_ebanking WHERE username = ? and password=?";
		int id = jdbcTemplate.queryForObject(sql, Integer.class, ebanking.getUsername(), ebanking.getPassword());
		
		//Set article id 
		ebanking.setId(id);
	}
	
	@Override
	public void updateEbanking(Ebanking ebanking) {
		String sql = "UPDATE m_ebanking SET username=?, password=? WHERE Id=?";
		jdbcTemplate.update(sql, ebanking.getUsername(), ebanking.getPassword(), ebanking.getId());
	}
	
	@Override
	public void deleteEbanking(int id) {
		String sql = "DELETE FROM m_ebanking WHERE Id=?";
		jdbcTemplate.update(sql, id);
	}
	
	@Override
	public boolean ebankingExists(String username, Long client_id) {
		String sql = "SELECT count(*) FROM m_ebanking WHERE username = ? and clent_id=?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, username, client_id);
		if(count == 0) {
    		return false;
		} else {
			return true;
		}
	}
	
	@Override
    public Ebanking findUserInfo(String username) {
        String sql = "Select u.Username,u.Password From m_ebanking u where u.Username = ? ";
 
        //Object[] params = new Object[] { username };
        //EbankingMapper mapper = new EbankingMapper();
        try {
        	RowMapper<Ebanking> rowMapper = new BeanPropertyRowMapper<Ebanking>(Ebanking.class);
    		Ebanking ebanking = jdbcTemplate.queryForObject(sql, rowMapper, username);
            return ebanking;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
	
	public List<String> getUserRoles(String username) {
        String sql = "Select r.Role  from m_ebanking r where r.Username = ? ";
         
        Object[] params = new Object[] { username };
         
        List<String> roles = jdbcTemplate.queryForList(sql,params, String.class);
         
        return roles;
    }
	
	public ChannelUsers findAauthUser(String username,String password) {
        // Select .. from App_User u Where u.User_Name = ?
        String sql = ChannelUsersMapper.BASE_SQL + " where a.id = c.appuser_id and b.id = c.role_id "
        		+ " and a.id = d.app_user_id and is_self_service_user = 1 and a.office_id = e.id and a.username = ? ";
 
        Object[] params = new Object[] { username };
        ChannelUsersMapper mapper = new ChannelUsersMapper();
        try {
        	ChannelUsers channelusers = jdbcTemplate.queryForObject(sql, params, mapper);
        	
        	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        	boolean isUserExist = encoder.matches(password, channelusers.getBcryptEncodedAuthenticationKey());
        	System.out.println("Does User exist " + isUserExist);
        	if(isUserExist == true) {
            return channelusers;
        	}else {
        		throw new UsernameNotFoundException("User " + username + " was not found in the database");
        	}
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
	
	public List<String> getRoleNames(int userId) {
        String sql = "select name from m_appuser a,m_role b,m_appuser_role "
        		+ " where a.id = appuser_id and b.id = role_id and a.id = ?";
 
        Object[] params = new Object[] { userId };
 
        List<String> roles = jdbcTemplate.queryForList(sql, params, String.class);
 
        return roles;
    }
	
	@Override
    public ChannelUsers findUserAuthInfo(String username) {
        //String sql = "Select u.Username,u.Password From m_ebanking u where u.Username = ? ";
        String sql = ChannelUsersMapper.BASE_SQL + " where a.id = c.appuser_id and b.id = c.role_id "
        		+ " and a.id = d.app_user_id and is_self_service_user = 1 and a.office_id = e.id and a.username = ? ";
        Object[] params = new Object[] { username };
        ChannelUsersMapper mapper = new ChannelUsersMapper();
        try {
        	ChannelUsers eproduct = jdbcTemplate.queryForObject(sql, params, mapper);
            return eproduct;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
	public void updateClientPassword(Long userId,PasswordChange clientpwd) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(clientpwd.getPassword());
		
		String sql = "UPDATE m_ebanking SET mpassword=? WHERE app_user_id=?";
		jdbcTemplate.update(sql,hashedPassword, userId);
		
	}
	
	public CardManagement getCustId(String accountId) {
		String sql = CardManagementMapper.BASE_SQL + " Where a.id = b.client_id and c.id = a.gender_cv_id "
				+ " and d.id = e.address_id and e.client_id = a.id and b.product_id = f.id and b.currency_code = g.code "
				+ " and b.account_no = ? ";
		
		Object[] params = new Object[] { accountId };
		CardManagementMapper mapper = new CardManagementMapper();
		try {
			CardManagement cardmag = jdbcTemplate.queryForObject(sql, params, mapper);
			return cardmag;
		}catch (EmptyResultDataAccessException e) {
            return null;
        }
	}
	public TransactionResponse getDebitCredit(Long savingsId,Long resourceId) {
		String sql = TransactionResponseMapper.BASE_SQL +  "  Where savings_account_transaction_id = a.id  "
				+ " and savings_account_charge_id = ? ";
			   
		//RowMapper<TransactionResponse> rowMapper = new BeanPropertyRowMapper<TransactionResponse>(TransactionResponse.class);
		//TransactionResponse tran = jdbcTemplate.queryForObject(sql, rowMapper, savingsId,resourceId);
		//return tran;
			   Object[] params = new Object[] { resourceId };
			   TransactionResponseMapper mapper = new TransactionResponseMapper();
				try {
					TransactionResponse tran = jdbcTemplate.queryForObject(sql, params, mapper);
					System.out.println("Tran Date is " + tran.getTranDate());
					return tran;
				}catch (EmptyResultDataAccessException e) {
		            return null;
		        }
	}
	public ChargeMappingValue getDebitCreditMapping(ChargeTransaction chrgreq){
		String sql1 = "select charge_id from m_charge_debit_credit where account_no = ?";
		String sql2 = "select acct_id from m_general_ledger where accountNo = ? and schm_type='SBA'";
		
		String chgId = jdbcTemplate.queryForObject(sql1, String.class, chrgreq.getCreditAccount());
		int acctId = jdbcTemplate.queryForObject(sql2, Integer.class, chrgreq.getDebitAccount());
		Long acct_id = Long.valueOf(acctId);
		ChargeMappingValue v_map = new ChargeMappingValue();
		//Set article id 
		v_map.setAccountId(acct_id);
		v_map.setChargeId(chgId);
		v_map.setAmount(chrgreq.getAmount());
		v_map.setAmt(String.valueOf(chrgreq.getAmount()));
		v_map.setDateFormat("dd MMMM yyyy");
		v_map.setLocale("en");
		Date date1 = Calendar.getInstance().getTime();  
		try {
			//date1 = new SimpleDateFormat("dd-MMMM-yyyy").parse(chrgreq.getTransactionDate());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			date1 = sdf.parse(chrgreq.getTransactionDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		v_map.setTransactionDate(date1);
		v_map.setDueDate(date1);
		return v_map;
	}

}
