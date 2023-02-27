package api;


import model.User;
import org.bson.types.ObjectId;
import repo.UserRepo;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/users")
public class UserResource {

    @Inject
    UserRepo userRepo;

    @GET
    public List<User> getAllUsers() {
        return userRepo.listAll();
    }

    @GET
    @Path("/{username}")
    public User getUserByUsername(@PathParam("username") String username) {
        return userRepo.findByUsername(username);
    }


}
