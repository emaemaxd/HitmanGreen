package model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@MongoEntity(collection = "Rating")
public class Rating extends PanacheMongoEntity {

    public LocalDate date;
    public Double stars;

    @Column(nullable = true)
    public String description;

    @ManyToOne
    public Auftrag auftrag;

    @ManyToOne
    public Hitman hitman;

}
