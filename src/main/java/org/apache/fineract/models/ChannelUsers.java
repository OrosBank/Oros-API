package org.apache.fineract.models;

import java.util.ArrayList;
import java.util.List;

public class ChannelUsers {
	
	private String username;
	private int userId;
    private String base64EncodedAuthenticationKey;
    private boolean authenticated;
    private Long officeId;
    private String officeName;
	private Long clientId ;
    private Long staffId;
    //private Role roles;
    List<Role> roles = new ArrayList<Role>();
    private boolean isSelfServiceUser ;
    private String name;
    private String bcryptEncodedAuthenticationKey;
    
    public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
    
    public String getBcryptEncodedAuthenticationKey() {
		return bcryptEncodedAuthenticationKey;
	}
	public void setBcryptEncodedAuthenticationKey(String bcryptEncodedAuthenticationKey) {
		this.bcryptEncodedAuthenticationKey = bcryptEncodedAuthenticationKey;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getBase64EncodedAuthenticationKey() {
		return base64EncodedAuthenticationKey;
	}
	public void setBase64EncodedAuthenticationKey(String base64EncodedAuthenticationKey) {
		this.base64EncodedAuthenticationKey = base64EncodedAuthenticationKey;
	}
	public boolean isAuthenticated() {
		return authenticated;
	}
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
	public Long getOfficeId() {
		return officeId;
	}
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	
	/*public Role getRoles() {
		return roles;
	}
	public void setRoles(Role roles) {
		this.roles = roles;
	}*/
	public boolean isSelfServiceUser() {
		return isSelfServiceUser;
	}
	public void setSelfServiceUser(boolean isSelfServiceUser) {
		this.isSelfServiceUser = isSelfServiceUser;
	}
	
	@Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", userId=" + userId +
                ", base64EncodedAuthenticationKey='" + base64EncodedAuthenticationKey + '\'' +
                ", authenticated=" + authenticated +
                ", officeId=" + officeId +
                ", officeName=" + officeName +
                ", clientId='" + clientId + '\'' +
                ", staffId=" + staffId +
                ", roles=" + roles +
                ", isSelfServiceUser=" + isSelfServiceUser +
                ", name=" + name +
                ",bcryptEncodedAuthenticationKey=" + bcryptEncodedAuthenticationKey +
                '}';
    }
	
	//public ChannelUsers(String username,int userId,String base64EncodedAuthenticationKey,boolean authenticated,
    //Long officeId,Long clientId,Long staffId,List<Role> roles,boolean isSelfServiceUser,String name) {
		public ChannelUsers(int userId,String username, String base64EncodedAuthenticationKey,boolean authenticated,
				Long officeId,String officeName,Long clientId,Long staffId,List<Role> roles,boolean isSelfServiceUser,String name,
				String bcryptEncodedAuthenticationKey) {
		
		this.userId = userId;
        this.username = username;
        this.base64EncodedAuthenticationKey = base64EncodedAuthenticationKey;
        this.clientId = clientId;
        this.authenticated = authenticated;
        this.officeId = officeId;
        this.officeName = officeName;
        this.staffId = staffId;
        this.roles = roles;
        this.isSelfServiceUser = isSelfServiceUser;
        this.name = name;
        this.bcryptEncodedAuthenticationKey = bcryptEncodedAuthenticationKey;
		
	}
	

}
