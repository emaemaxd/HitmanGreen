package model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@MongoEntity(collection = "Hitman")
@DiscriminatorValue("hitman")
public class Hitman extends PanacheMongoEntity {

    public TYPE_OF_EXECUTION type;
    public Boolean torture;
    public AREA_OF_OPERATION[] area;

    @OneToOne
    public Auftrag auftrag;

    @OneToMany(mappedBy = "hitman")
    public List<Rating> ratings;

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

    public AREA_OF_OPERATION[] getArea() {
        return area;
    }

    public void setArea(AREA_OF_OPERATION[] area) {
        this.area = area;
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
}
