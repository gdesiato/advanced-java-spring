package platform.codingnomads.co.springdata.lab;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.models.Route;
import platform.codingnomads.co.springdata.lab.repositories.AreaRepository;
import platform.codingnomads.co.springdata.lab.repositories.RouteRepository;
import platform.codingnomads.co.springdata.lab_complete.models.PointOfInterest;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataLab implements CommandLineRunner {

    private final AreaRepository areaRepository1;
    private final RouteRepository routeRepository1;

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
                            platform.codingnomads.co.springdata.lab.models.Route.builder().origin(areaRepository1.findAreaByCode("D"))
                                    .destination(areaRepository1.findAreaByCode("E")).build(),
                            platform.codingnomads.co.springdata.lab.models.Route.builder().origin(areaRepository1.findAreaByCode("F"))
                                    .destination(areaRepository1.findAreaByCode("G")).build(),
                            platform.codingnomads.co.springdata.lab.models.Route.builder().origin(areaRepository1.findAreaByCode("H"))
                                    .destination(areaRepository1.findAreaByCode("I")).build(),
                            Route.builder().origin(areaRepository1.findAreaByCode("L"))
                                    .destination(areaRepository1.findAreaByCode("M")).build()
                    ).forEach(route -> {
                        if (!routeRepository1.existsByCode(route.getCode())){
                            routeRepository1.save(route);
                        }
                    });

                    Route route = Route.builder().origin(a).destination(b).build();
                    Route route1 = new Route(a, b);
                    routeRepository1.save(route1);

                    Route route2 = new Route(c, d);
                    routeRepository1.save(route2);

                    Route route3 = new Route(e, f);
                    routeRepository1.save(route3);


          System.out.println(routeRepository1.findRouteByParam("D-E"));


//        if (pointOfInterestRepository.findAll().size() == 0) {
//
//            PointOfInterest poi1 = new PointOfInterest("Gas Station", "Buc-ee's",
//                    areaRepository1.findByCode("A"));
//            // if a poi has an associated area, it may have routes as well
//            poi1.addRoutes(routeRepository1.findAllByCodeContaining("A"));
//
//            PointOfInterest poi2 = new PointOfInterest("Gas Station", "Shell",
//                    areaRepository1.findByCode("Z"));
//            poi2.addRoutes(routeRepository1.findAllByCodeContaining("Z"));
//
//            PointOfInterest poi3 = new PointOfInterest("Restaurant", "Brick House",
//                    areaRepository1.findByCode("O"));
//            poi3.addRoutes(routeRepository1.findAllByCodeContaining("O"));
//
//            PointOfInterest poi4 = new PointOfInterest("Restaurant", "Nirmanz",
//                    areaRepository1.findByCode("L"));
//            poi4.addRoutes(routeRepository1.findAllByCodeContaining("L"));
//
//            // a poi can be associated with a route only, not a particular area (somewhere between 2 areas)
//            PointOfInterest poi5 = new PointOfInterest("Roadside Attraction", "Ufo",
//                    routeRepository1.findByCode("B-A"));
//            PointOfInterest poi6 = new PointOfInterest("Roadside Attraction", "Waterfall",
//                    routeRepository1.findByCode("H-Y"));
//
//            final List<PointOfInterest> poiList = pointOfInterestRepository.saveAll(
//                    List.of(poi1, poi2, poi3, poi4, poi5, poi6)
//            );
//        }
//
//        System.out.println(pointOfInterestRepository.findAllByArea_code("A"));
//        System.out.println(pointOfInterestRepository.findAllDistinctByRoutes_codeContaining("A"));
//
//        System.out.println(areaRepository1.findAllByPointsOfInterest_typeIgnoreCase("gas station"));
//        System.out.println(areaRepository1.findByCode("A"));
//
//        System.out.println(routeRepository1.findByOrigin_code("T"));
//        System.out.println(routeRepository1.findByOrigin_code("Y"));
//        System.out.println(routeRepository1.findByOrigin_code("H"));
//
//        System.out.println(routeRepository1.findByDestination_code("R"));
//        System.out.println(routeRepository1.findByDestination_code("Y"));
//        System.out.println(routeRepository1.findByDestination_code("Z"));
//
//        System.out.println(routeRepository1.findByCode("T-Z"));
//        System.out.println(routeRepository1.findByCode("H-Z"));
//        System.out.println(routeRepository1.findByCode("L-O"));


    }
}



