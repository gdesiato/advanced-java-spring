package platform.codingnomads.co.ioc.practice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import platform.codingnomads.co.ioc.lab.completed.CodingNomad;
import platform.codingnomads.co.ioc.lab.completed.CodingNomadConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CodingNomadDemo {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(CodingNomadConfiguration.class);

        platform.codingnomads.co.ioc.lab.completed.CodingNomad codingNomad = ctx.getBean(CodingNomad.class);

        System.out.println(codingNomad.createAwesomeSoftware());
    }
}
