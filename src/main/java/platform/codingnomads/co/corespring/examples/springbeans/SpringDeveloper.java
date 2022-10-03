package platform.codingnomads.co.corespring.examples.springbeans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class SpringDeveloper {

    private Address address;
    private Nationality nationality;

    public SpringDeveloper(Address address, Nationality nationality) {
        this.address = address;
        this.nationality = nationality;
    }
}
