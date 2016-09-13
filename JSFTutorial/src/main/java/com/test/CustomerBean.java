package com.test;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "customer")
@SessionScoped
public class CustomerBean {
	private String lastname, firstname, email, address;

	// insert getter setter here
	public ArrayList<CustomerBean> getMessages() {
		return UserDAO.getCustomer();
	}

	
	
	public void setFirstname(String string) {
		firstname=string;
	}
	public String getFirstname()
	{
		return firstname;
	}

	public void setLastname(String string) {
		lastname=string;
	}
	public String getLastname()
	{
		return lastname;
	}

	public void setAddress(String string) {
		address= string;
	}
	public String getAddress()
	{
		return address;
	}


	public void setEmail(String string) {
		email=string;
	}
	public String getEmail()
	{
		return email;
	}
}