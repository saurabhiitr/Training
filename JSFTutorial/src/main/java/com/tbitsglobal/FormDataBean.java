package com.tbitsglobal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import javax.annotation.PostConstruct;

@ManagedBean( name="formdata")
public class FormDataBean {

	private	String firstName;
	private String lastName;
	private Date date;
	private String gender;
	private String city;  
    private Map<String,String> cities = new HashMap<String, String>();
    private String state;
    private Map<String,String> states = new HashMap<String, String>();;
    private String pincode;
    
    public FormDataBean() {
	}
    
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@PostConstruct
    public void init() {
        //cars
      
         
        //cities
        cities = new HashMap<String, String>();
        cities.put("Patna", "Patna");
        cities.put("Hyderabad", "Hyderabad");
        cities.put("Dehradun","Dehradun");
        cities.put("bhuvaneshwar", "Bhuvaneshwar");
        cities.put("Varanasi","Varanasi");
        cities.put("Lucknow","Lucknow");
        
        //States
         states=new HashMap<String,String>();
         states.put("Bihar", "Bihar");
         states.put("Telangana","Telengana");
         states.put("Odisha","Odisha");
         states.put("Uttrakhand","Uttrakhand");
         
    }
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Map<String, String> getStates() {
		return states;
	}

	public void setStates(Map<String, String> states) {
		this.states = states;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Map<String, String> getCities() {
		return cities;
	}

	public void setCities(Map<String, String> cities) {
		this.cities = cities;
	}

	public void onDateSelect(SelectEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
	}

	public void click() {
		RequestContext requestContext = RequestContext.getCurrentInstance();

		requestContext.update("form:display");
		requestContext.execute("PF('dlg').show()");
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {

		this.firstName = firstName;
		System.out.println(firstName);
		System.out.println(this.firstName);
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
