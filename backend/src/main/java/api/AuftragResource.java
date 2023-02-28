package api;

import model.Auftrag;
import model.Hitman;
import org.bson.types.ObjectId;
import repo.AuftragRepo;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/order")
public class AuftragResource {
    @Inject
    AuftragRepo ar;

    @POST
    public Response addOrder(Auftrag order) {
    ar.persist(order);
    return Response.ok(ar.persist(order)).build();
    }

    @PUT
    public Response changeOrderState(Auftrag order){
        if(order.getSuccessful()){
            order.setSuccessful(false);
        }else{
            order.setSuccessful(true);
        }
        return Response.ok(ar.persist(order)).build();
    }

}
