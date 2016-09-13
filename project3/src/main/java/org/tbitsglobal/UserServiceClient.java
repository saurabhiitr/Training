package org.tbitsglobal;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;


public class UserServiceClient {
	protected static final String base_svc_url = "http://localhost:8080/project3/webapi";

//	private static final Logger logger = LoggerFactory.getLogger(UserServiceClient.class);
	  protected static Client wsClient = null;

		protected static Client getWsClient() {
			if (wsClient == null) {
				ClientConfig clientConfig = new DefaultClientConfig();
				clientConfig.getFeatures().put(
						JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
				wsClient = Client.create(clientConfig);
			}
			return wsClient;
		}

	public static void storeUser(User user,UserData usrData) {
		String serviceURL = base_svc_url
	            + "/UserService";
		WebResource webResource = getWsClient().resource(serviceURL);
		ClientResponse r = webResource.type(MediaType.TEXT_PLAIN).get(ClientResponse.class);
		if (r.getStatus() != Response.Status.OK.getStatusCode()) {
	    	System.out.println("Failed to write data");
	    }
		 serviceURL = base_svc_url
	            + "/UserService";
		     webResource = getWsClient().resource(serviceURL);
		    r = webResource.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, user);
		    if (r.getStatus() != Response.Status.CREATED.getStatusCode()) {
		    	System.out.println("Failed to write data");
		    }
	}

    
}
