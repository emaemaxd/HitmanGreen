package api;


import dto.UserDTO;
import model.User;
import org.bson.types.ObjectId;
import repo.OpferRepo;
import repo.UserRepo;
import service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService userService;

    @Inject
    UserRepo userRepo;
    @Inject
    OpferRepo opferRepo;

    @GET
    @Path("all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GET
    @Path("{name}")
    public User findByUsername(@PathParam("name") String name) {
        return userRepo.findByUsername(name);
    }

   @POST
   @Path("create")
    public Response createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.username);
        user.setPassword(userDTO.password);
        userService.createUser(user);
        return Response.status(Response.Status.CREATED).build();
    }

    /*@PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") ObjectId id, User user) {
        User existingUser = userService.getUserById(id);
        if (existingUser != null) {
            existingUser.setUsername(user.username);
            existingUser.setPassword(user.password);
            existingUser.persist();
            return Response.ok(existingUser).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }*/

    @DELETE
    @Path("remove/{name}")
    public Response deleteUser(@PathParam("name") String name) {
        User user = userRepo.findByUsername(name);
        if (user == null) {
            Response.status(400).build();
        }
        userRepo.delete(user);
        return Response.ok(user).build();
    }
}
