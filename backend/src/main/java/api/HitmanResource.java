package api;

import model.Hitman;
import org.bson.types.ObjectId;
import repo.HitmanRepo;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/hitman")
public class HitmanResource {

    @Inject
    HitmanRepo hr;


    @GET
    @Path("/rating/{hitmanId}")
    public Response getHitmanRatings(@PathParam("hitmanId") String hitmanId) {
        try {
            ObjectId id = new ObjectId(hitmanId);
            Hitman hitman = hr.findById(id);
            if (hitman == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok(hitman.getRatings()).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
