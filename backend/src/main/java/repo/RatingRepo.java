package repo;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import model.Opfer;
import model.Rating;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RatingRepo implements PanacheMongoRepository<Rating> {

}
