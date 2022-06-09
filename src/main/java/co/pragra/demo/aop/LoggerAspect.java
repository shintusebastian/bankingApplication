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
@Slf4j// we use this while creating production grade applications

public class LoggerAspect {
    @Pointcut("execution(* co.pragra.demo.api.*.*(*))")
    public void pd1(){//pd corresponds to predicate 1

    }
    @Pointcut("execution(* co.pragra.demo.services.*.*(*))")
    public void pd2(){

    }

    //this means, before execution of the specified methods.
//the first star corresponds to the type of methods(public/private/etc)
//without calling the aspect, the method in the logger aspect will be executed. The aspect automatically weaves it with
// the method calls.
//By adding a join point, we will get more information about the method.

//@Before("execution(* co.pragra.demo.api.*.*(*))")// we say that this aspect should run for any
// method which is public in the package, in the given api, for all the classes, all the methods which takes any arguments.
//@Before("pd1()&&pd2()") //@Before will execute before this method is executed, @Around will execute before and after
//    public void doLogs(JoinPoint joinPoint){
//        log.info("Method Called join point {} ", joinPoint);
//    System.out.println("joinPoint.getTarget() = " + joinPoint.getTarget());

    //target tells you the target method that is called.
//    Arrays.stream(joinPoint.getArgs()).forEach(System.out::println);
    //getArgs will give us the argument that is passed in the method call we make.
//}
    @AfterReturning("pd1()")//this method will only be called if the method in pd1() was successfully called and executed.
    //@AfterThrowing("pd1()") will be executed only if the pd1() throws an exception
    //@After("pd1()") will be executed in both AfterReturning and AfterThrowing cases.
    public void doLogs(JoinPoint joinPoint){
        log.info("Method Called join point {} ", joinPoint);
    }
    //after returning will only execute if the method is completed successfully.
}
