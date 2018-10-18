package org.apache.fineract.models;

public class PasswordChange {
	
	private String firstname;
    private String password;
    private String repeatPassword;
   
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	
	@Override
	   public String toString() {
	        return "PasswordChange{" +
	        		" firstname='" + firstname + '\'' +
	                ", password='" + password + '\'' +
	                ", repeatPassword='" + repeatPassword + '\'' +
	                '}';
	}
	public PasswordChange() {
    }
    public PasswordChange(String firstname,String password,String repeatPassword) {
    	this.firstname = firstname;
    	this.password = password;
    	this.repeatPassword = repeatPassword;
    }

}
