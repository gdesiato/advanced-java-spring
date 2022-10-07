package platform.codingnomads.co.corespring.lab;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class CoreLabApplication {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(StudioConfig.class);

        Microphone microphone = ctx.getBean(Microphone.class);

        System.out.println("The microphone used for the recording will be a "
                + microphone.getMake() + " " + microphone.getModel() + " microphone.");

        AudioInterface audioInterface = ctx.getBean(AudioInterface.class);

        System.out.println("The session will be recorded using a "
                + audioInterface.getMake() + " " + audioInterface.getModel() + " audio interface.");
    }
}
