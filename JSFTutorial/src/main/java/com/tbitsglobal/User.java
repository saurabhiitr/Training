package com.tbitsglobal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.UploadedFile;


@ManagedBean(name = "user")
@SessionScoped
public class User implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	private long id;

	private String firstname;
     
    private String lastname;
     
    private String gender;
    
    private Date dob = new Date();

	private String street;
	
	private String state;
     
    private String city;
     
    private String postalCode;
     
    private String info;
     
    private String email;
     
    private String phone;
    
    private String text;
    
    private UploadedFile file;
    
	public ArrayList<User> getMessages() {
		return UserDao.getUser();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
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
 
    public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
    
   public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getStreet() {
        return street;
    }
 
    public void setStreet(String street) {
        this.street = street;
    }
 
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
 
    public String getPostalCode() {
        return postalCode;
    }
 
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
 
    public String getInfo() {
        return info;
    }
 
    public void setInfo(String info) {
        this.info = info;
    }
     
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPhone() {
        return phone;
    }
 
    public void setPhone(String phone) {
        this.phone = phone;
    }

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}