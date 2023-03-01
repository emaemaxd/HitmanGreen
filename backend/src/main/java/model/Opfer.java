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
    @Column(nullable = true)
    public List<Auftrag> auftraege;


    public Opfer(){}

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getSocialmedia() {
        return socialmedia;
    }

    public void setSocialmedia(String[] socialmedia) {
        this.socialmedia = socialmedia;
    }

    public List<Auftrag> getAuftraege() {
        return auftraege;
    }

    public void setAuftraege(List<Auftrag> auftraege) {
        this.auftraege = auftraege;
    }
}
