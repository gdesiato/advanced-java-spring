package platform.codingnomads.co.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Aspect
@Component
public class PrintableAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrintableAspect.class);

    // Define the Point-cut expression
    @Pointcut("@annotation(Printable)")
    public void executePrinting() {
    }

    @Before("executePrinting()")
    public void printAdvice() {
        System.out.println("Executing method annotated with @Printable.");
    }

}
