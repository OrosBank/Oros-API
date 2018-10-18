package org.apache.fineract.models;

import javax.persistence.*;

@Entity
public class Ebanking {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private boolean is_deleted;
	private Long office_id;
	private Long client_id;
	private Long staff_id;
	private String username;
	private String firstname;
	private String lastname;
	private String password;
	private String email;
	private String mobile_number;
	
	public Ebanking() {
		
	}
	public Ebanking(Boolean is_deleted,Long office_id,Long client_id,Long staff_id,String username,
			String firstname,String lastname,String password,String email,String mobile_number) {
		this.is_deleted = is_deleted;
        this.office_id  = office_id;
        this.client_id  = client_id;
        this.staff_id   = staff_id;
        this.firstname  = firstname;
        this.username   = username;
        this.lastname   = lastname;
        this.password   = password;
        this.email      = email;
        this.mobile_number = mobile_number;
		
	}
	public Ebanking(int id,Boolean is_deleted,Long office_id,Long client_id,Long staff_id,String username,
			String firstname,String lastname,String password,String email,String mobile_number) {
		this.id         = id;
		this.is_deleted = is_deleted;
        this.office_id  = office_id;
        this.client_id  = client_id;
        this.staff_id   = staff_id;
        this.firstname  = firstname;
        this.username   = username;
        this.lastname   = lastname;
        this.password   = password;
        this.email      = email;
        this.mobile_number = mobile_number;
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
	public Long getOffice_id() {
		return office_id;
	}
	public void setOffice_id(Long office_id) {
		this.office_id = office_id;
	}
	public Long getClient_id() {
		return client_id;
	}
	public void setClient_id(Long client_id) {
		this.client_id = client_id;
	}
	public Long getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(Long staff_id) {
		this.staff_id = staff_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	
	@Override
    public String toString() {
        return "Ebanking{" +
                "id=" + id +
                ", is_deleted='" + is_deleted + '\'' +
                ", office_id='" + office_id + '\'' +
                ", client_id='" + client_id + '\'' +
                ", staff_id='" + staff_id + '\'' +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobile_number='" + mobile_number + '\'' +
                '}';
    }

}
