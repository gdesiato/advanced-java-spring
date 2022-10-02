package platform.codingnomads.co.ioc.practice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@RequiredArgsConstructor
public class CodingNomad {
    private final JDK jdk;
    private final IDE ide;
    private final Framework framework;
    private Language language;

    //Field Injection
    @Autowired
    Computer computer;

    //Setter Injection
    @Autowired
    public void setLanguage(Language language){
        this.language = language;
    }

    public String createAwesomeSoftware() {
        return MessageFormat
                .format("This Coding Nomad is creating awesome software using, " +
                                "IDE: ({0}:{1}), JDK: ({2}:{3}), Framework: ({4}:{5}), Computer: ({6}), Language: ({7})",
                        ide.getName(),
                        ide.getVersion(),
                        jdk.getName(),
                        jdk.getVersion(),
                        framework.getName(),
                        framework.getVersion(),
                        computer.getBrand(),
                        language.getType()
                );
    }
}