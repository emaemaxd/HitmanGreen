package repo;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import model.User;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class UserRepo implements PanacheMongoRepository<User> {


    public User findByUsername(String username){
        return find("username", username).firstResult();
    }

    public User findById(long id){
        return find("id", id).firstResult();
    }

    public void createUser(User user) {
        user.persist();
    }

    public Optional<User> updateUser(ObjectId id, User updatedUser) {
        User existingUser = findById(id);
        if (existingUser != null) {
            existingUser.setUsername(updatedUser.username);
            existingUser.setPassword(updatedUser.password);
            existingUser.persist();
            return Optional.of(existingUser);
        } else {
            return Optional.empty();
        }
    }

    public void deleteUser(ObjectId id) {
        User existingUser = findById(id);
        if (existingUser != null) {
            existingUser.delete();
        }
    }
}