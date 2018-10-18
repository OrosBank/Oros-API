package org.apache.fineract;
import java.util.ArrayList;
import java.util.List;

import org.apache.fineract.models.ChannelUsers;
import org.apache.fineract.models.Ebanking;
import org.apache.fineract.dao.EbankingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationService implements UserDetailsService{
	@Autowired
    private EbankingDAO ebankingDAO;
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//Ebanking userInfo = ebankingDAO.findUserInfo(username);
		ChannelUsers userInfo = ebankingDAO.findUserAuthInfo(username);
        System.out.println("UserInfo= " + userInfo);
 
        if (userInfo == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        
        //List<String> roles= ebankingDAO.getUserRoles(username);
        List<String> roles= ebankingDAO.getRoleNames(userInfo.getUserId());
        
        List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
        if(roles!= null)  {
            for(String role: roles)  {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }       
        
        //UserDetails userDetails = (UserDetails) new User(userInfo.getUsername(),userInfo.getPassword(),grantList);
        UserDetails userDetails = (UserDetails) new User(userInfo.getUsername(),userInfo.getBcryptEncodedAuthenticationKey(),grantList);
 
        return userDetails;
    }

}
