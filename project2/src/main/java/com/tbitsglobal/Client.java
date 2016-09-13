package com.tbitsglobal;

import java.io.Serializable;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Index;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Unique;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 *@author: gaurav,gaurav.n@tbitsglobal.com
 * Date:Dec 28, 2012
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@PersistenceCapable(detachable = "true")
@Index(name = "client_id_idx", members = {"clientId"})
public class Client implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Persistent(primaryKey = "true", valueStrategy = IdGeneratorStrategy.INCREMENT)
//	@Extension(vendorName = "datanucleus", key = "strategy-when-notnull", value = "false")
	private long clientId;
	
	@Column(jdbcType = "VARCHAR", length = 100)
    @Unique(name = "unique_clientname")
	private String clientName;
	
	private long shardId;
	
	private String image;
	private String loginPageContent;
	private String hostName;
	private String fileValue;
	
	public Client(){
		
	}

	public Client(long clientId, String clientName, long shardId) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.shardId = shardId;
	}
	
	public Client(long clientId, String clientName, long shardId, String image,
			String loginPageContent,String hostName,String fileValue) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.shardId = shardId;
		this.image = image;
		this.loginPageContent = loginPageContent;
		this.hostName=hostName;
		this.fileValue=fileValue;
		
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public long getShardId() {
		return shardId;
	}

	public void setShardId(long shardId) {
		this.shardId = shardId;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLoginPageContent() {
		return loginPageContent;
	}

	public void setLoginPageContent(String loginPageContent) {
		this.loginPageContent = loginPageContent;
	}
	
	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getFileValue() {
		return fileValue;
	}

	public void setFileValue(String fileValue) {
		this.fileValue = fileValue;
	}

	@Override
	public int hashCode() {
		long clId = 0;
		
		clId = clientId;
		
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (clId ^ (clId >>> 32));
		result = prime * result
				+ ((clientName == null) ? 0 : clientName.hashCode());
		result = prime * result + (int) (shardId ^ (shardId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (clientId != other.clientId)
			return false;
		if (clientName == null) {
			if (other.clientName != null)
				return false;
		} else if (!clientName.equals(other.clientName))
			return false;
		if (shardId != other.shardId)
			return false;
		return true;
	}
	
	public void updateClient(Client client){
		this.setFileValue(client.getFileValue());
		this.setImage(client.getImage());
		this.setLoginPageContent(client.getLoginPageContent());
	}
}


