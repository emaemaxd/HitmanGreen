package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import javax.persistence.*;

@MongoEntity(collection = "users")
@Inheritance
@DiscriminatorValue("user")
public class User extends PanacheMongoEntity {
    public String username;
    public String password;

    @OneToOne(mappedBy = "user")
    @Column(nullable = true)
    public Hitman hitman;

    @OneToOne(mappedBy = "user")
    @Column(nullable = true)
    public Auftrag auftrag;

    public User(){}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Hitman getHitman() {
        return hitman;
    }

    public void setHitman(Hitman hitman) {
        this.hitman = hitman;
    }

    public Auftrag getAuftrag() {
        return auftrag;
    }

    public void setAuftrag(Auftrag auftrag) {
        this.auftrag = auftrag;
    }
}
