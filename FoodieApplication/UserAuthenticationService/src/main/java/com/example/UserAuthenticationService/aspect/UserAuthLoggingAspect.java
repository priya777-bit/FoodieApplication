package com.example.UserAuthenticationService.aspect;

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

    @Pointcut("execution(* com.example.UserAuthenticationService.controller.UserController.* (..))")
    public void allControllerMethods(){}

    @Before("allControllerMethods()")
    public void beforeEach(JoinPoint joinPoint)
    {
        logger.info("---------Before Advice-------");
        logger.debug("Method Name :" +joinPoint.getSignature());
        logger.debug("Arguments :" + Arrays.toString(joinPoint.getArgs()));
        logger.info("Registering User ..");
    }

    @After("allControllerMethods()")
    public void afterAdvice(JoinPoint joinPoint)
    {
        logger.info("-------After Advice--------");
        logger.debug("Method Name :"+joinPoint.getSignature());
        logger.debug("Arguments :"+Arrays.toString(joinPoint.getArgs()));
        logger.info("Login User ");
    }

    @AfterReturning(value = "allControllerMethods()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result)
    {
        logger.info("-------After Returning----------");
        logger.debug("Method Name :"+joinPoint.getSignature());
        logger.debug("Arguments :"+Arrays.toString(joinPoint.getArgs()));
        logger.debug("Result :"+result);
        logger.info("Returning :");
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

    @Pointcut("execution(* com.example.UserAuthenticationService.service.UserService.* (..))")
    public void allServiceMethods(){}

    @Before("allServiceMethods()")
    public void beforeEach2(JoinPoint joinPoint)
    {
        logger.info("---------Before Advice-------");
        logger.debug("Method Name :" +joinPoint.getSignature());
        logger.debug("Arguments :" + Arrays.toString(joinPoint.getArgs()));
        logger.info("Registering User ..");
    }

    @After("allServiceMethods()")
    public void afterAdvice2(JoinPoint joinPoint)
    {
        logger.info("-------After Advice--------");
        logger.debug("Method Name :"+joinPoint.getSignature());
        logger.debug("Arguments :"+Arrays.toString(joinPoint.getArgs()));
        logger.info("Login User ");
    }

    @AfterReturning(value = "allServiceMethods()" , returning = "result")
    public void afterReturning2(JoinPoint joinPoint,Object result)
    {
        logger.info("-------After Returning----------");
        logger.debug("Method Name :"+joinPoint.getSignature());
        logger.debug("Arguments :"+Arrays.toString(joinPoint.getArgs()));
        logger.debug("Result :"+result);
        logger.info("Returning :");
    }

    @AfterThrowing(value = "allServiceMethods()" , throwing = "error")
    public void afterThrowing2(JoinPoint joinPoint,Throwable error)
    {
        logger.info("-------After Throwing--------");
        logger.debug("Method Name :"+joinPoint.getSignature());
        logger.debug("Arguments :"+joinPoint.getArgs());
        logger.debug("Exception :"+error);
        logger.info("Try Again Some Time ..");
    }

    @Pointcut("execution(* com.example.UserAuthenticationService.repository.UserRepository.* (..))")
    public void allRepositoryMethods(){}

    @Before("allRepositoryMethods()")
    public void beforeEach3(JoinPoint joinPoint)
    {
        logger.info("---------Before Advice-------");
        logger.debug("Method Name :" +joinPoint.getSignature());
        logger.debug("Arguments :" + Arrays.toString(joinPoint.getArgs()));
        logger.info("Registering User ..");
    }

    @After("allRepositoryMethods()")
    public void afterAdvice3(JoinPoint joinPoint)
    {
        logger.info("-------After Advice--------");
        logger.debug("Method Name :"+joinPoint.getSignature());
        logger.debug("Arguments :"+Arrays.toString(joinPoint.getArgs()));
        logger.info("Login User ");
    }

    @AfterReturning(value = "allRepositoryMethods()" , returning = "result")
    public void afterReturning3(JoinPoint joinPoint,Object result)
    {
        logger.info("-------After Returning----------");
        logger.debug("Method Name :"+joinPoint.getSignature());
        logger.debug("Arguments :"+Arrays.toString(joinPoint.getArgs()));
        logger.debug("Result :"+result);
        logger.info("Returning :");
    }

    @AfterThrowing(value = "allRepositoryMethods()" , throwing = "error")
    public void afterThrowing3(JoinPoint joinPoint,Throwable error)
    {
        logger.info("-------After Throwing--------");
        logger.debug("Method Name :"+joinPoint.getSignature());
        logger.debug("Arguments :"+joinPoint.getArgs());
        logger.debug("Exception :"+error);
        logger.info("Try Again Some Time ..");
    }
}
