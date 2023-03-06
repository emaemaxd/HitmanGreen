package dto;

import javax.persistence.Column;
import java.time.LocalDate;

public class RatingDTO {

    public LocalDate date;
    public Double stars;

    @Column(nullable = true)
    public String description;

    public String hitmanName;
}
