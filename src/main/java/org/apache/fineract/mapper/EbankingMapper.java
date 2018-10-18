package org.apache.fineract.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.fineract.models.Ebanking;
import org.springframework.jdbc.core.RowMapper;
public class EbankingMapper implements RowMapper<Ebanking>{
	
	@Override
    public Ebanking mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("Id");
		boolean is_deleted = rs.getBoolean("Is_deleted");
		Long office_id = rs.getLong("office_id");
		Long client_id = rs.getLong("client_id");
		Long staff_id = rs.getLong("staff_id");
		String username = rs.getString("Username");
        String password = rs.getString("Password");
        String firstname = rs.getString("Firstname");
        String lastname = rs.getString("Lastname");
        String email = rs.getString("Email");
        String mobile_number = rs.getString("Mobile_Number");
 
        return new Ebanking(id,is_deleted,office_id,client_id,staff_id,username,firstname,lastname,password,email,mobile_number);
	}

}
