package com.feel.backend.api;

import com.feel.backend.controller.UserController;
import com.feel.backend.model.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.glassfish.jersey.server.JSONP;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by S on 09.04.2016.
 */

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserApi {
    private static final String ITEMS_URL = "/api/users";

    @GET
    @JSONP(queryParam = "callback")
    public String getAllUsers(@QueryParam("callback") String callback) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_DEFAULT);
        List<User> users = UserController.getInstance().getAllUsers();
        for (User User : users) {
            User.setLink(ITEMS_URL + "/" + User.getUserID());
        }
        return mapper.writeValueAsString(users);
    }

    @DELETE
    @JSONP(queryParam = "callback")
    public void deleteAllUsers() throws Exception {
        UserController.getInstance().deleteAllUsers();
    }

    @GET
    @Path("/{id}")
    @JSONP(queryParam = "callback")
    public String getUser(@PathParam("id") int id) throws Exception {
        User User = UserController.getInstance().getUser(id);
        return new ObjectMapper().writeValueAsString(User);
    }

    @PUT
    @JSONP(queryParam = "callback")
    public void putUser(String UserJson) throws Exception {
        User user = new ObjectMapper().readValue(UserJson, User.class);
        UserController.getInstance().saveOrUpdate(user);
    }

    @DELETE
    @Path("/{id}")
    @JSONP(queryParam = "callback")
    public void deleteUser(@PathParam("id") int id) throws Exception {
        UserController.getInstance().deleteUser(id);
    }

}
