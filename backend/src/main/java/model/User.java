package model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Inheritance;
import javax.persistence.OneToOne;

@MongoEntity(collection = "User")
@Inheritance
@DiscriminatorValue("user")
public abstract class User extends PanacheMongoEntity {
    public String username;
    public String password;

    @OneToOne(mappedBy = "user")
    private Auftrag auftrag;

}
