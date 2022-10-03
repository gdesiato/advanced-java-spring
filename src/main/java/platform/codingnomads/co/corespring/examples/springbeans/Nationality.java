package platform.codingnomads.co.corespring.examples.springbeans;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Nationality {

    private String nation;
    private String mainLanguange;

    public Nationality(String nation, String mainLanguange) {
        this.nation = nation;
        this.mainLanguange = mainLanguange;
    }
}
