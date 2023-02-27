package repo;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import model.User;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepo implements PanacheMongoRepository<User> {


    public User findByUsername(String username){
        return find("username", username).firstResult();
    }
}