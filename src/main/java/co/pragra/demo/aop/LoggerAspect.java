package co.pragra.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LoggerAspect {
    @Pointcut("execution(* co.pragra.demo.api.*.*(*))")
    public void pd1(){

    }
    @Pointcut("execution(* co.pragra.demo.services.*.*(*))")
    public void pd2(){

    }

//@Before("execution(* co.pragra.demo.api.*.*(*))")// we say that this aspect should run for any
// method which is public in the package, in the given api, for all the classes, all the methods which takes any arguments.
//@Before("pd1()&&pd2()") //@Before will execute before this method is executed, @Around will execute before and after
//    public void doLogs(JoinPoint joinPoint){
//        log.info("Method Called join point {} ", joinPoint);
//    System.out.println("joinPoint.getTarget() = " + joinPoint.getTarget());
//    Arrays.stream(joinPoint.getArgs()).forEach(System.out::println);
//}
    @AfterReturning("pd1()")
    public void doLogs(JoinPoint joinPoint){
        log.info("Method Called join point {} ", joinPoint);
    }
}
