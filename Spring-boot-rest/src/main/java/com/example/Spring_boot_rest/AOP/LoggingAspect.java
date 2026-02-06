package com.example.Spring_boot_rest.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class LoggingAspect {

    public static final Logger logger=LoggerFactory.getLogger(LoggingAspect.class);


    //PointCut is expression that tell to advice impliment in this class
    // execution (return-type class-name.method-name(args) or for all (* *.*(..))

// execution → PCD
//
//* → any return type
//
// com.example.service.* → any class in package
//
// * → any method
//
// (..) → any input parameters
    @Before("execution (* com.example.Spring_boot_rest.service.JobService.*(..))")
    public void  BeforeMethodCall(JoinPoint jp) {
        logger.info("Before execution : " + jp.getSignature().getName());
    }

    @After("execution(* com.example.Spring_boot_rest.service.JobService.getalljobs(..))")
    public void AfterMethodCall(JoinPoint jp){
        logger.info("After execution : " +  jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.example.Spring_boot_rest.service.JobService.getalljobs(..))")
    public void AfterReturning(JoinPoint jp){
        logger.info("After Returning execution : " +  jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.example.Spring_boot_rest.service.JobService.getalljobs(..))")
    public void AfterThrowing(JoinPoint jp){
        logger.info("After Throwing execution : " +  jp.getSignature().getName());
    }

}