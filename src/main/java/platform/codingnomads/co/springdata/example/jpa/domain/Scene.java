package platform.codingnomads.co.springdata.example.jpa.domain;

import javax.persistence.*;

@Entity
@Table(name = "scenes")
public class Scene {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "latitude")
    private double lat;

    @Column(name = "longitude")
    private double lon;

    private String name;

}
