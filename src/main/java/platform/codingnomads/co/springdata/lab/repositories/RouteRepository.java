package platform.codingnomads.co.springdata.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.models.Route;

import java.util.List;


public interface RouteRepository extends JpaRepository<Route,Long> {

    //List<Route> findRoutesByOriginArea(Area origin);
    //List<Route> findRoutesByOriginCode(String originCode);

    Route findByCode(String code);
    boolean existsByCode(String code);
    List<Route> findRoutesByOrigin(Area origin);
    List<Route> findRoutesByOriginCode(String originCode);
    List<Route> findByDestination_code(String code);
    List<Route> findByOrigin_code(String code);
    List<Route> findAllByCodeContaining(String code);

}
