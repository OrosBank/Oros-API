package org.apache.fineract.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.fineract.models.TransactionResponse;
import org.springframework.jdbc.core.RowMapper;

public class TransactionResponseMapper implements RowMapper<TransactionResponse> {
	public static final String BASE_SQL = "Select transaction_date as tran_date,a.id as tran_id,"
			+ " transaction_date as posted_date,'Y' as posted_flag,'00' as respCode "
			+ " from m_savings_account_transaction a,m_savings_account_charge_paid_by b ";
	
	public TransactionResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		String responseCode = rs.getString("respCode");
		Date tranDate       = rs.getDate("tran_date");
		Date postedDate     = rs.getDate("posted_date");
		String postedFlag = rs.getString("posted_flag");
		String tranId     = rs.getString("tran_id");
		

        return new TransactionResponse(responseCode,tranDate,postedDate,postedFlag,tranId);
		
	}

}
