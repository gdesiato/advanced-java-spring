package platform.codingnomads.co.springdata.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.models.Route;

import java.util.List;


public interface RouteRepository1 extends JpaRepository<Route,Long> {

    //List<Route> findRoutesByOriginArea(Area origin);
    //List<Route> findRoutesByOriginCode(String originCode);

    Route findByCode(String code);
    boolean existsByCode(String code);

}
