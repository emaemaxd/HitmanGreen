package repo;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import model.Auftrag;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuftragRepo implements PanacheMongoRepository<Auftrag> {


    public Auftrag findById(int id){
        return find("order_id", id).firstResult();
    }
}