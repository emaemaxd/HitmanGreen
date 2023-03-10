package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dto.UserDTO;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.jboss.logging.annotations.Field;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@MongoEntity(collection = "Hitman")
@DiscriminatorValue("hitman")
public class Hitman extends PanacheMongoEntity {

    public TYPE_OF_EXECUTION type;
    public Boolean torture;

    public List<AREA_OF_OPERATION> areaOfOperation;

    @OneToOne
    public Auftrag auftrag;

    @OneToMany(mappedBy = "hitman", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Rating> ratings = new ArrayList<>();

    public Hitman() {
    }

    @OneToOne(mappedBy = "hitman", cascade = CascadeType.REMOVE)
    public User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public enum TYPE_OF_EXECUTION {
        KNIVES,
        GUN,
        BARE_HANDS
    }
    public enum AREA_OF_OPERATION {
        AUSTRIA,
        GERMANY,
        ITALY
    }

    public Hitman(String username, String password) {
        super();
    }

    public TYPE_OF_EXECUTION getType() {
        return type;
    }

    public void setType(TYPE_OF_EXECUTION type) {
        this.type = type;
    }

    public Boolean getTorture() {
        return torture;
    }

    public void setTorture(Boolean torture) {
        this.torture = torture;
    }

    public List<AREA_OF_OPERATION> getAreaOfOperation() {
        return areaOfOperation;
    }

    public void setAreaOfOperation(List<AREA_OF_OPERATION> areaOfOperation) {
        this.areaOfOperation = areaOfOperation;
    }

    public Auftrag getAuftrag() {
        return auftrag;
    }

    public void setAuftrag(Auftrag auftrag) {
        this.auftrag = auftrag;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public void addRating(Rating rating) {
        ratings.add(rating);
        //rating.setHitman(this); circular reference error???
    }

    public void removeRating(Rating rating) {
        ratings.remove(rating);
        rating.setHitman(null);
    }

}
