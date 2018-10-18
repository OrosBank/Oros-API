package org.apache.fineract.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.fineract.models.ChannelUsers;
import org.apache.fineract.models.Role;
import org.springframework.jdbc.core.RowMapper;

public class ChannelUsersMapper implements RowMapper<ChannelUsers>{
	
	public static final String BASE_SQL
   // = "Select u.User_Id, u.User_Name, u.Encryted_Password From App_User u ";
	  = "Select a.id as userId,username,password,a.office_id as officeId,e.name as officeName,client_id as clientId,"
			+ " a.staff_id as staffId,b.id as roleId,b.name as rolename,description,mpassword,"
			+ " is_self_service_user as onlineUser,d.name as cardname from m_appuser a,m_role b,m_appuser_role c,"
			+ " m_ebanking d, m_office e ";
	
	@Override
    public ChannelUsers mapRow(ResultSet rs, int rowNum) throws SQLException {
		boolean authenticated;
        int userId = rs.getInt("userId");
        String username = rs.getString("username");
        String base64EncodedAuthenticationKey = rs.getString("password");
        if(username != "" && userId != 0) {
        	authenticated = true;
        }else {
        	authenticated = false;
        }
        Long officeId = rs.getLong("officeId");
        String officeName = rs.getString("officeName");
        Long clientId = rs.getLong("clientId");
        Long staffId  = rs.getLong("staffId");
        
        List<Role> roles = new ArrayList<Role>();
        Role item = new Role();         
        item.setId(rs.getInt("roleId"));
        item.setName(rs.getString("rolename"));
        item.setDescription(rs.getString("description"));
        roles.add(item);
        
        boolean isSelfServiceUser = rs.getBoolean("onlineUser");
        String name = rs.getString("cardname");
        String bcryptEncodedAuthenticationKey = rs.getString("mpassword");
        
		return new ChannelUsers(userId, username, base64EncodedAuthenticationKey,authenticated,officeId,officeName,
				clientId,staffId,roles,isSelfServiceUser,name,bcryptEncodedAuthenticationKey);
    }

}
