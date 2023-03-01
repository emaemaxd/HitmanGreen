package api;

import dto.HitmanDTO;
import dto.UserDTO;
import model.Auftrag;
import model.Hitman;
import model.User;
import org.bson.types.ObjectId;
import repo.HitmanRepo;
import repo.UserRepo;
import service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/hitman")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HitmanResource {

    @Inject
    HitmanRepo hitmanRepo;
    @Inject
    UserRepo userRepo;

    @GET
    public List<Hitman> getAllHitman() {
        return hitmanRepo.listAll();
    }

    @POST
    public Response createHitman(HitmanDTO hitmanDTO) {
        User user = new User();
        user.setUsername(hitmanDTO.username);
        user.setPassword(hitmanDTO.password);

        Hitman hitman = new Hitman();
        hitman.setAreaOfOperation(hitmanDTO.area);
        hitman.setType(hitmanDTO.type);
        hitman.setTorture(hitmanDTO.torture);
        hitman.setUser(user);
        hitmanRepo.persist(hitman);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/rating/{hitmanId}")
    public Response getHitmanRatings(@PathParam("hitmanId") String hitmanId) {
        try {
            ObjectId id = new ObjectId(hitmanId);
            Hitman hitman = hitmanRepo.findById(id);
            if (hitman == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok(hitman.getRatings()).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("remove/{id}")
    public Response removeHitman(@PathParam("id") String name) {
        if(hitmanRepo.findHitmanByName(name) == null || userRepo.findByUsername(name) == null) {
            return Response.status(400).build();
        }
        User user = userRepo.findByUsername(name);
        Hitman hitman = hitmanRepo.findHitmanByName(name);

        // delete hitman and user
        userRepo.delete(user);
        hitmanRepo.delete(hitman);
        return Response.ok(hitman).build();
    }

}
