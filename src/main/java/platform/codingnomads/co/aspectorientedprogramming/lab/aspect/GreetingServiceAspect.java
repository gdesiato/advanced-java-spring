package platform.codingnomads.co.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServiceAspect {

    @Before("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.*(..))")
    public void beforeGreeting(JoinPoint joinPoint) {
        System.out.println("Before executing greeting method...");
    }

    @After("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.*(..))")
    public void afterGreeting(JoinPoint joinPoint) {
        System.out.println("After executing greeting method...");
    }

    // Create Pointcut that targets motivating()
    @Pointcut("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.motivating(..))")
    public void motivatingPointcut() {}

    @Before("motivatingPointcut()")
    public void beforeMotivating() {
        System.out.println("Before executing motivating method...");
    }

    @After("motivatingPointcut()")
    public void afterMotivating() {
        System.out.println("After executing motivating method...");
    }
}
