package repo;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import model.Auftrag;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuftragRepo implements PanacheMongoRepository<AuftragRepo> {


    public AuftragRepo findById(int id){
        return find("id", id).firstResult();
    }
    public AuftragRepo persist(Auftrag auftrag) {
        return persist(auftrag);
    }
}