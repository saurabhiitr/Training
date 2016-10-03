package com.tbitsglobal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name="selectedUser" , eager=true)
@ApplicationScoped
public class SelectedUser implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private String user;
	private static Map<String,Object> user2value;
	private long requestId;
	

	@PostConstruct
    public void init() {
		
		user2value = new HashMap<String, Object>();
		user2value.put("saurabh", "saurabh"); //label, value
		user2value.put("ram", "ram");
		user2value.put("anish", "anish");
		user2value.put("surrendra", "surrendra");
		user2value.put("govind", "govind");
		user2value.put("mukesh", "mukesh");
	}
	
	public Map<String, Object> getUser2value() {
		return user2value;
	}

	public void setUser2value(Map<String, Object> user2value) {
		SelectedUser.user2value = user2value;
	}
	public List<Object> getUser2values(){
		return new ArrayList<Object>(user2value.values());
	}
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public Map<String,Object> getUserList() {
		return user2value;
	}
	
	public void changeUser(ValueChangeEvent e){
		//assign new value to localeCode
		user = e.getNewValue().toString();

	}
	public void changeRequestId(AjaxBehaviorEvent e)
	{
		System.out.println(user);
	}
	public void save() {
		System.out.println("");
	}
}
