package com.example.UserAuthenticationService.aspect;

import com.example.UserAuthenticationService.model.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class UserAuthLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthLoggingAspect.class);

    @Pointcut("execution(* com.example.UserAuthenticationService.controller.UserController.* (..)) and args(user)")
    public void allControllerMethods(){}

    @Before("allControllerMethods()")
    public void beforeEach(JoinPoint joinPoint, User user)
    {
        logger.info("---------Before Advice-------");
        logger.debug("Method Name :" +joinPoint.getSignature());
        logger.debug("Arguments :" + Arrays.toString(joinPoint.getArgs()));
        logger.info("Registering User .."+user);
    }

    @After("allControllerMethods()")
    public void afterAdvice(JoinPoint joinPoint,User user)
    {
        logger.info("-------After Advice--------");
        logger.debug("Method Name :"+joinPoint.getSignature());
        logger.debug("Arguments :"+Arrays.toString(joinPoint.getArgs()));
        logger.info("Login User "+user);
    }

    @AfterReturning(value = "allControllerMethods()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result,User user)
    {
        logger.info("-------After Returning----------");
        logger.debug("Method Name :"+joinPoint.getSignature());
        logger.debug("Arguments :"+Arrays.toString(joinPoint.getArgs()));
        logger.debug("Result :"+result);
        logger.info("Returning :"+user);
    }

    @AfterThrowing(value = "allControllerMethods()",throwing = "error")
    public void afterThrowing(JoinPoint joinPoint,Throwable error)
    {
        logger.info("-------After Throwing--------");
        logger.debug("Method Name :"+joinPoint.getSignature());
        logger.debug("Arguments :"+joinPoint.getArgs());
        logger.debug("Exception :"+error);
        logger.info("Try Again Some Time ..");
    }
    
}
