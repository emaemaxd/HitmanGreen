package service;

import model.User;
import org.bson.types.ObjectId;
import repo.UserRepo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepo userRepo;

    public List<User> getAllUsers() {
        return userRepo.listAll();
    }

    public User getUserById(ObjectId id) {
        return userRepo.findById(id);
    }

    public void createUser(User user) {
        userRepo.createUser(user);
    }

    public Optional<User> updateUser(ObjectId id, User updatedUser) {
        return userRepo.updateUser(id, updatedUser);
    }

    public void deleteUser(ObjectId id) {
        userRepo.deleteUser(id);
    }
}
