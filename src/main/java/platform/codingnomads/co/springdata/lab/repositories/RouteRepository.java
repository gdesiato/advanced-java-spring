package platform.codingnomads.co.springdata.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.codingnomads.co.springdata.lab.models.Route;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route,Long> {

    Route findRouteByCode(String code);
    Route findRouteByParam(String code);
    boolean existsByCode(String code);

}
