package org.tbitsglobal;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.configuration.ConfigurationException;
import org.tbitsglobal.Persistance.Test;


@Path("/UserService")
public class UserService {

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static Response storeUser(User user)
    {
		try {
			Test.storeClient(user);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
//		 UserDao.storeUser(user);
		return Response.status(Response.Status.CREATED).entity(user).build();
//		return Response.status(200).build();
	}
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
}
