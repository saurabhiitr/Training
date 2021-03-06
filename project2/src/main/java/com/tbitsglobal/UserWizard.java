package com.tbitsglobal;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
@ManagedBean(name = "userWizard")
@ViewScoped
public class UserWizard implements Serializable {
	public static final Logger logger = LoggerFactory.getLogger(UserWizard.class);
	private static final long serialVersionUID = 1L;

	private User user = new User();
     
    private boolean skip;

	private Map<String, String> states;
    private Map<String,String> cities;
	private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
	private String city;
	private String state;
	private static boolean show=false;
	

	public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
     
    public void save() {        
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + user.getFirstname());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        UserDao data=new UserDao();
        data.usr=this.user;
        data.input();
        System.out.println(show);
        logger.error("the value of show before save : " + show);
        show=true;
        logger.error("the value of show after save : " + show);
        System.out.println(show);
    }
     
    public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
     
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
    
    @PostConstruct
    public void init() {
        states  = new HashMap<String, String>();
		states.put("Bihar", "Bihar");
		states.put("Jharkhand", "Jharkhand");
		states.put("Uttrakhand", "Uttrakhand");
         
        Map<String,String> map = new HashMap<String, String>();
        map.put("Patna", "Patna");
        map.put("Gaya", "Gaya");
        map.put("Motihari", "Motihari");
        data.put("Bihar", map);
         
        map = new HashMap<String, String>();
        map.put("Ranchi", "Ranchi");
        map.put("Bokaro", "Bokaro");
        map.put("Dhanbad", "Dhanbad");
        data.put("Jharkhand", map);
         
        map = new HashMap<String, String>();
        map.put("Roorkee", "Roorkee");
        map.put("Haridwar", "Haridwar");
        map.put("Dehradun", "Dehradun");
        data.put("Uttrakhand", map);
    }
    
    public void onStateChange() {
        if(user.getState() !=null && !user.getState().equals(""))
            cities = data.get(user.getState());
        else
            cities = new HashMap<String, String>();
    }
    
	public Map<String, String> getStates() {
		return states;
	}

	public void setStates(Map<String, String> states) {
		this.states = states;
	}

	public Map<String, String> getCities() {
		return cities;
	}

	public void setCities(Map<String, String> cities) {
		this.cities = cities;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public Map<String, Map<String, String>> getData() {
        return data;
    }

	public boolean getShow() {
		return show;
	}

	public void setShow(boolean show1) {
		show = show1;
	}
}