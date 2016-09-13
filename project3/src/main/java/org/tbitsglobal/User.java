package org.tbitsglobal;

import java.io.Serializable;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@PersistenceCapable(detachable = "true",table="user")
public class User implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Persistent(primaryKey = "true")
	private long id;

	@Column(jdbcType = "VARCHAR", length = 45)
	private String firstname;
 
	@Column(jdbcType = "VARCHAR", length = 45)
    private String lastname;
	
	public User(){}
	
	public User(long id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
    
    @Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
    
}