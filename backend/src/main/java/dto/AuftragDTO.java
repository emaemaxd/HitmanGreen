package dto;

import org.bson.types.Binary;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class AuftragDTO {

    public Boolean successful;
    public Double price;
    public String description;
    public LocalDate deadline;
    public byte[] proof;
    public Boolean acceptedByHitman;
    public Boolean proofAcceptedByUser;
    public String hitmanName;
    public OpferDTO opfer;

    public String userName;

}
