package model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Inheritance;
import javax.persistence.OneToOne;

@MongoEntity(collection = "users")
@Inheritance
@DiscriminatorValue("user")
public class User extends PanacheMongoEntity {
    public String username;
    public String password;

    @OneToOne(mappedBy = "user")
    @Column(nullable = true)
    private Auftrag auftrag;

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
}
