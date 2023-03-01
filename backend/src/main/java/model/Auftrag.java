package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.types.Binary;
import org.bson.types.ObjectId;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@MongoEntity(collection = "Auftrag")
public class Auftrag extends PanacheMongoEntity {

        public int order_id;

        public static final AtomicInteger idGenerator = new AtomicInteger(0);

        public static Integer generateOrderId() {
                return idGenerator.incrementAndGet();
        }

        public Auftrag() {
                this.order_id = generateOrderId();
        }

        public Boolean successful;
        public Double price;
        public String description;
        public LocalDate deadline;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "base64")
        public byte[] proof;
        public Boolean acceptedByHitman;
        public Boolean proofAcceptedByUser;

        public Boolean getSuccessful() {
                return successful;
        }

        public void setSuccessful(Boolean successful) {
                this.successful = successful;
        }

        public Double getPrice() {
                return price;
        }

        public void setPrice(Double price) {
                this.price = price;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public LocalDate getDeadline() {
                return deadline;
        }

        public void setDeadline(LocalDate deadline) {
                this.deadline = deadline;
        }

        public byte[] getProof() {
                return proof;
        }

        public void setProof(byte[] proof) {
                this.proof = proof;
        }

        public Boolean getAcceptedByHitman() {
                return acceptedByHitman;
        }

        public void setAcceptedByHitman(Boolean acceptedByHitman) {
                this.acceptedByHitman = acceptedByHitman;
        }

        public Boolean getProofAcceptedByUser() {
                return proofAcceptedByUser;
        }

        public void setProofAcceptedByUser(Boolean proofAcceptedByUser) {
                this.proofAcceptedByUser = proofAcceptedByUser;
        }


        public Hitman getHitman() {
                return hitman;
        }

        public void setHitman(Hitman hitman) {
                this.hitman = hitman;
        }

        public User getUser() {
                return user;
        }
        public void setUser(User user) {
                this.user = user;
        }

        public Opfer getOpfer() {
                return opfer;
        }

        public void setOpfer(Opfer opfer) {
                this.opfer = opfer;
        }

        public List<Rating> getRatings() {
                return ratings;
        }

        public void setRatings(List<Rating> ratings) {
                this.ratings = ratings;
        }

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


