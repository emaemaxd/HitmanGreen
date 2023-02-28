package dto;

import model.Auftrag;
import model.Hitman;
import model.Rating;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

public class HitmanDTO {

    public String username;
    public String password;

    public Hitman.TYPE_OF_EXECUTION type;
    public Boolean torture;
    public List<Hitman.AREA_OF_OPERATION> area;


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
}
