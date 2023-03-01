package api;

import dto.AuftragDTO;
import dto.HitmanDTO;
import model.Auftrag;
import model.Hitman;
import model.Opfer;
import model.User;
import org.bson.types.ObjectId;
import repo.AuftragRepo;
import repo.HitmanRepo;
import repo.OpferRepo;
import repo.UserRepo;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.List;

@Path("/order")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuftragResource {
    @Inject
    AuftragRepo ar;
    @Inject
    HitmanRepo hr;
    @Inject
    UserRepo ur;
    @Inject
    OpferRepo or;

    @GET
    public List<Auftrag> getAllAuftraege() {
        return ar.listAll();
    }

    @GET
    @Path("victims")
    public List<Opfer> getAllVictims() {
        return or.listAll();
    }

    @POST
    @Path("create")
    public Response addOrder(AuftragDTO order) {
        if (order == null) {
            return Response.status(400).build();
        }
        Hitman hitman = hr.findHitmanByName(order.hitmanName);
        User user = ur.findByUsername(order.userName);
        Opfer opfer = new Opfer();
        opfer.setAddress(order.opfer.address);
        opfer.setCity(order.opfer.city);
        opfer.setCountry(order.opfer.country);
        opfer.setFirstname(order.opfer.firstname);
        opfer.setLastname(order.opfer.lastname);
        opfer.setZip(order.opfer.zip);
        // add new opfer if not existing
        if(or.findByLastname(order.opfer.lastname) == null) {
            or.persist(opfer);
        }
        Auftrag auftrag = new Auftrag();
        auftrag.setDeadline(order.deadline);
        auftrag.setDescription(order.description);
        auftrag.setPrice(order.price);
        auftrag.setProof(order.proof);
        auftrag.setSuccessful(order.successful);
        auftrag.setAcceptedByHitman(order.acceptedByHitman);
        auftrag.setProofAcceptedByUser(order.proofAcceptedByUser);
        auftrag.setHitman(hitman);
        auftrag.setUser(user);
        auftrag.setOpfer(opfer);
        ar.persist(auftrag);
    return Response.ok(auftrag).build();
    }

    @PUT
    public Response changeOrderState(Auftrag order){
        if(order.getSuccessful()){
            order.setSuccessful(false);
        }else{
            order.setSuccessful(true);
        }
        return Response.ok().build();
    }

    @PUT
    @Path("update/{id}")
    public Response updateOrder(AuftragDTO order){
        if(order == null || or.findByLastname(order.opfer.lastname) == null) {
            return Response.status(400).build();
        }else{
            return Response.ok().build();
        }
    }

    @DELETE
    @Path("remove/{id}")
    public Response removeOrder(@PathParam("id") int id) {
        if(ar.findById(id) == null) {
            return Response.status(400).build();
        }
        Auftrag order = ar.findById(id);
        ar.delete(order);
        return Response.ok(order).build();
    }

}
