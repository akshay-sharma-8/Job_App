package com.example.Spring_boot_rest.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class PerformanceAspect {

    private static final Logger logger =LoggerFactory.getLogger(PerformanceAspect.class);

//    Around advice runs code before and after the target method executes.
    @Around("execution (* com.example.Spring_boot_rest.service.JobService.*(..))")
    public Object  logExecutionTime(ProceedingJoinPoint jp) throws Throwable {

        long start = System.currentTimeMillis();   // Code before method execution
        Object obj = jp.proceed();                 // Executes the target method
        long end = System.currentTimeMillis();     //  Code after method execution


        logger.info("Time of exicution  " + (end-start));
        return obj;                                //  Return the method’s result
    }

}
