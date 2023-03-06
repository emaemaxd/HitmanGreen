package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;

@MongoEntity(collection = "Rating")
public class Rating extends PanacheMongoEntity {

    public LocalDate date;
    public Double stars;

    @Column(nullable = true)
    public String description;

    @ManyToOne
    public Auftrag auftrag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    public Hitman hitman;

    public Rating() {}

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getStars() {
        return stars;
    }

    public void setStars(Double stars) {
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Auftrag getAuftrag() {
        return auftrag;
    }

    public void setAuftrag(Auftrag auftrag) {
        this.auftrag = auftrag;
    }

    public Hitman getHitman() {
        return hitman;
    }

    public void setHitman(Hitman hitman) {
        this.hitman = hitman;
    }

}
