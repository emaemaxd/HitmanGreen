package api;


import dto.UserDTO;
import model.User;
import org.bson.types.ObjectId;
import repo.UserRepo;
import service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService userService;

    @Inject
    UserRepo userRepo;

    @GET
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

   @POST
    public Response createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.username);
        user.setPassword(userDTO.password);
        userService.createUser(user);
        return Response.status(Response.Status.CREATED).build();
    }

    /*@POST
    public Response create(User user) {
        user.persist();
        return Response.created(URI.create("/user/" + user.id)).build();
    }*/

    @PUT
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
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") ObjectId id) {
        User existingUser = userService.getUserById(id);
        if (existingUser != null) {
            userService.deleteUser(id);
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


}
