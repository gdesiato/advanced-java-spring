package platform.codingnomads.co.springdata.lab;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.models.Route;
import platform.codingnomads.co.springdata.lab.repositories.AreaRepository1;
import platform.codingnomads.co.springdata.lab.repositories.RouteRepository1;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataLab implements CommandLineRunner {

    private final AreaRepository1 areaRepository1;
    private final RouteRepository1 routeRepository1;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataLab.class);
    }

    @Override
    public void run(String... args) throws Exception {

                Arrays.asList(
                        Area.builder().code("D").build(),
                        Area.builder().code("E").build(),
                        Area.builder().code("F").build(),
                        Area.builder().code("G").build(),
                        Area.builder().code("H").build(),
                        Area.builder().code("I").build(),
                        Area.builder().code("L").build(),
                        Area.builder().code("M").build()
                ).forEach(area -> {
                    if (!areaRepository1.existsByCode(area.getCode())){
                        areaRepository1.save(area);
                    }
                });

        Area a = areaRepository1.findAreaByCode("D");
        Area b = areaRepository1.findAreaByCode("E");
        Area c = areaRepository1.findAreaByCode("F");
        Area d = areaRepository1.findAreaByCode("G");
        Area e = areaRepository1.findAreaByCode("H");
        Area f = areaRepository1.findAreaByCode("I");


                    Arrays.asList(
                            new Route(areaRepository1.findAreaByCode("I"), areaRepository1.findAreaByCode("H")),
                            new Route(areaRepository1.findAreaByCode("D"), areaRepository1.findAreaByCode("E")),
                            new Route(areaRepository1.findAreaByCode("F"), areaRepository1.findAreaByCode("G")),
                            Route.builder().origin(areaRepository1.findAreaByCode("G"))
                                    .destination(areaRepository1.findAreaByCode("I")).code("G-I").build()
//                            Route.builder().origin(areaRepository1.findAreaByCode("F"))
//                                    .destination(areaRepository1.findAreaByCode("G")).build(),
//                            Route.builder().origin(areaRepository1.findAreaByCode("H"))
//                                    .destination(areaRepository1.findAreaByCode("I")).build(),
//                            Route.builder().origin(areaRepository1.findAreaByCode("L"))
//                                    .destination(areaRepository1.findAreaByCode("M")).build()
                    ).forEach(route -> {
                        if (!routeRepository1.existsByCode(route.getCode())){
                            routeRepository1.save(route);
                        }
                    });

        //System.out.println(routeRepository1.findRoutesByOriginArea(a));
        //System.out.println(routeRepository1.findRoutesByOriginCode("G"));

    }
}



