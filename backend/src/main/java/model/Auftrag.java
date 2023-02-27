package model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.types.Binary;
import org.bson.types.ObjectId;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@MongoEntity(collection = "Auftrag")
public class Auftrag extends PanacheMongoEntity {
        public Boolean successful;
        public Double price;
        public String description;
        public LocalDate deadline;
        public Binary proof;
        public Boolean acceptedByHitman;
        public Boolean proofAcceptedByUser;

        @OneToOne(mappedBy="auftrag",cascade = CascadeType.ALL)
        @JoinColumn(name = "hitman_id", referencedColumnName = "id")
        public Hitman hitman;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "opfer_id", referencedColumnName = "id")
        public Opfer opfer;

        @OneToMany(mappedBy = "auftrag")
        public List<Rating> ratings;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        private User user;
    }


