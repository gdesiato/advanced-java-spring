package platform.codingnomads.co.springtest.understandingandusingprofiles;

import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("test")
public class TestMain implements CommandLineRunner {

    @Autowired
    CoffeePreferenceRepo repo;

    @Override
    public void run(String... args) throws Exception {

        repo.save(CoffeePreference.builder()
                .type("Americano")
                .iced(true)
                .size(CoffeePreference.Size.LARGE)
                .intensity(7)
                .sugar(false)
                .build());

        repo.save(CoffeePreference.builder()
                .type("Espresso")
                .iced(false)
                .size(CoffeePreference.Size.SMALL)
                .intensity(4)
                .sugar(true)
                .build());
    }

    @Profile("simply_print")
    @Bean
    public void printConsole(){
        System.out.println("This method simply prints a String");
    }
}
