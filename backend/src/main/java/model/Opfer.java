package model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.OneToMany;
import java.util.List;

@MongoEntity(collection = "Opfer")
@DiscriminatorValue("opfer")
public class Opfer extends User {

    public String firstname;
    public String lastname;
    public String address;
    public int zip;
    public String city;
    public String country;

    @Column(nullable = true)
    public int age;
    @Column(nullable = true)
    public String[] socialmedia;

    @OneToMany(mappedBy = "opfer")
    public List<Auftrag> auftraege;

    public Opfer(String username, String password) {
        super(username, password);
    }

}
