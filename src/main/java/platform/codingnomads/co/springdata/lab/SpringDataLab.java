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
                        Area.builder().code("G").build(),
                        Area.builder().code("H").build(),
                        Area.builder().code("Y").build(),
                        Area.builder().code("Z").build(),
                        Area.builder().code("A").build(),
                        Area.builder().code("B").build(),
                        Area.builder().code("C").build(),
                        Area.builder().code("D").build()
                ).forEach(area -> {
                    if (!areaRepository.existsByCode(area.getCode())){
                        areaRepository.save(area);
                    }
                });

        Area a = areaRepository.findAreaByCode("A");
        Area b = areaRepository.findAreaByCode("B");

       // Route route = Route.builder().origin(a).destination(b).build();

        Route route = new Route(a, b);

        routeRepository.save(route);



    }
}
