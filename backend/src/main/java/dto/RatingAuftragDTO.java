package dto;

import javax.persistence.Column;
import java.time.LocalDate;

public class RatingAuftragDTO {
    public LocalDate date;
    public Double stars;

    @Column(nullable = true)
    public String description;

    public int order_id;
}
