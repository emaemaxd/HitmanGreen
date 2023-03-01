package repo;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import model.Opfer;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OpferRepo implements PanacheMongoRepository<Opfer> {

    public Opfer findByLastname(String name){
        return find("lastname", name).firstResult();
    }

}
