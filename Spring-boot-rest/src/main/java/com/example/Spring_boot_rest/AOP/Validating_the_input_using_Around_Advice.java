package com.example.Spring_boot_rest.AOP;


import org.apache.catalina.Loader;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Validating_the_input_using_Around_Advice {

  private static final Logger logger = LoggerFactory.getLogger(Validating_the_input_using_Around_Advice.class);

  @Around("execution(* com.example.Spring_boot_rest.service.JobService.getJob(..)) && args(postId)")
  public Object validation(ProceedingJoinPoint joinPoint , int postId) throws Throwable {

      if(postId < 0){
          logger.info("postID is negative, update it");
          postId = -postId;
          logger.info("new value " + postId);
      }

      Object obj = joinPoint.proceed(new Object[] {postId});
     return obj;
  }
}
