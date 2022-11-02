package platform.codingnomads.co.springdata.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.codingnomads.co.springdata.lab.models.Area;

import java.util.List;

public interface AreaRepository extends JpaRepository<Area,Long> {

    Area findAreaByCode(String code);
    boolean existsByCode(String code);
    Area findByCode(String code);
    List<Area> findAllByPointsOfInterest_typeIgnoreCase(String name);

}
