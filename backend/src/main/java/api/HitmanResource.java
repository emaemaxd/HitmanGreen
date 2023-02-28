package api;

import model.Hitman;
import model.User;
import org.bson.types.ObjectId;
import repo.HitmanRepo;
import repo.UserRepo;
import service.UserService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/hitman")
public class HitmanResource {

    @Inject
    HitmanRepo hitmanRepo;

    @GET
    public List<Hitman> getAllHitman() {
        return hitmanRepo.listAll();
    }

    @POST
    public Response createHitman(Hitman hitman) {
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
}
