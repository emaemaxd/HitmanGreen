package repo;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import model.Hitman;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;

@ApplicationScoped
public class HitmanRepo implements PanacheMongoRepository<Hitman> {


    public Hitman findHitmanByName(String name) {
        return find("user.username", name).firstResult();
    }
}
