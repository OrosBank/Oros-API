package org.apache.fineract.models;

public class Changes {
	//PasswordChange user = new PasswordChange();
	//private String firstname;
    private String passwordEncoded;
    
	/*public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
		//this.firstname = user.getFirstname();
	}*/
	public String getPasswordEncoded() {
		return passwordEncoded;
	}
	public void setPasswordEncoded(String passwordEncoded) {
		this.passwordEncoded = passwordEncoded;
	}
	
	 @Override
	    public String toString() {
	        return "Role{" +
	                //"firstname=" + firstname +
	                ", passwordEncoded='" + passwordEncoded + '\'' +
	                '}';
	    }
    
    
}
