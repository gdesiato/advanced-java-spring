package platform.codingnomads.co.springdata.lab;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.models.Route;
import platform.codingnomads.co.springdata.lab.repositories.AreaRepository;
import platform.codingnomads.co.springdata.lab.repositories.RouteRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataLab implements CommandLineRunner {

    private final AreaRepository areaRepository;
    private final RouteRepository routeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataLab.class);
    }

    @Override
    public void run(String... args) throws Exception {

//        final List<Area> areas = areaRepository.saveAll(
//                Arrays.asList(
//                        Area.builder().code("G").build(),
//                        Area.builder().code("H").build(),
//                        Area.builder().code("Y").build(),
//                        Area.builder().code("Z").build(),
//                        Area.builder().code("A").build(),
//                        Area.builder().code("B").build(),
//                        Area.builder().code("C").build(),
//                        Area.builder().code("D").build()
//                )
//        );



                Arrays.asList(
                        Area.builder().code("D").build(),
                        Area.builder().code("E").build(),
                        Area.builder().code("F").build(),
                        Area.builder().code("G").build(),
                        Area.builder().code("H").build(),
                        Area.builder().code("I").build(),
                        Area.builder().code("L").build()
                ).forEach(area -> {
                    if (!areaRepository.existsByCode(area.getCode())){
                        areaRepository.save(area);
                    }
                });

        Area a = areaRepository.findAreaByCode("D");
        Area b = areaRepository.findAreaByCode("E");
        Area c = areaRepository.findAreaByCode("F");
        Area d = areaRepository.findAreaByCode("G");
        Area e = areaRepository.findAreaByCode("H");
        Area f = areaRepository.findAreaByCode("I");

        // Route route = Route.builder().origin(a).destination(b).build();
        Route route1 = new Route(a, b);
        routeRepository.save(route1);

        Route route2 = new Route(c, d);
        routeRepository.save(route2);

        Route route3 = new Route(e, f);
        routeRepository.save(route3);


        System.out.println(routeRepository.findRouteByCode("G-H"));
        System.out.println(routeRepository.findRouteByCode("D-E"));


    }
}
