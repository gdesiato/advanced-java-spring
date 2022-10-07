package platform.codingnomads.co.corespring.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import platform.codingnomads.co.corespring.lab.AudioInterface;
import platform.codingnomads.co.corespring.lab.Microphone;

@Configuration
@ImportResource({"classpath*:xml-config/records.xml"})
public class StudioConfig {

    @Bean
    public Microphone microphone() {
        return new Microphone("Neumann", "U87");
    }

    @Bean
    public AudioInterface audioInterface() {
        return new AudioInterface("RME", "UFX-II");
    }

}
