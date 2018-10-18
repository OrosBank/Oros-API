package org.apache.fineract.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.fineract.models.CardManagement;
import org.springframework.jdbc.core.RowMapper;

public class CardManagementMapper implements RowMapper<CardManagement>{
	
	public static final String BASE_SQL 
	= "select display_name as acct_name,b.account_no as acct_no,f.name as acct_type_name,"
			+ "if((SUBSTR(short_name, 1, 1))=6,'Savings','Current') as acct_type,"
			+ "if(b.status_enum=300,'ACTIVE','INACTIVE') as acct_status,date_of_birth as dob,"
			+ "code_value as acct_gender,a.id as cust_id,mobile_no as acct_mobile,"
			+ "email_address as acct_email,CONCAT(address_line_1,' ',city) as acct_address,"
			+ "b.currency_code as currency, g.id as currencyCode "
			+ " From m_client a,m_savings_account b,m_code_value c,m_address d,m_client_address e,"
			+ "m_savings_product f,m_currency g  ";
	
	public CardManagement mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		String accountName       = rs.getString("acct_name");
		String accountNumber     = rs.getString("acct_no");
		String accountTypeName   = rs.getString("acct_type_name");
		String accountType       = rs.getString("acct_type");
		String accountStatus     = rs.getString("acct_status");
		String gender            = rs.getString("acct_gender");
		//Date bod                 = rs.getDate("dob");
		Long customerId          = rs.getLong("cust_id");
		String customerAddress   = rs.getString("acct_address");
		String customerEmail     = rs.getString("acct_email");
		String customerMobile    = rs.getString("acct_mobile");
		String birthday          = rs.getString("dob");
		String currency          = rs.getString("currency");
		Long currencyCode        = rs.getLong("currencyCode");
		
		return new CardManagement(accountName,accountNumber,accountTypeName,accountType,
				accountStatus,gender,customerId,customerAddress,customerEmail,customerMobile,birthday,currency,currencyCode);
		
	}

}
