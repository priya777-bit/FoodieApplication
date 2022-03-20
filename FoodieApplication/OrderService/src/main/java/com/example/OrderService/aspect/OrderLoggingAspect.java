package com.example.OrderService.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class OrderLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(OrderLoggingAspect.class);

    @Pointcut("execution(* com.example.OrderService.controller.OrderController.* (..) )")
    public void allControllerMethods(){}

    @Before("allControllerMethods()")
    public void beforeAdvice(JoinPoint joinPoint)
    {
        logger.info("----------@BeforeAdvice------");
        logger.debug("Method Name:::::",joinPoint.getSignature().getName());
        logger.debug("Arguments:::::", Arrays.toString(joinPoint.getArgs()));
        logger.info("--------------@@@-------------");
    }

    @After("allControllerMethods()")
    public void afterAdvice(JoinPoint joinPoint)
    {
        logger.info("::::::::::@After:::::::::::");
        logger.debug("Method Name:::::::",joinPoint.getSignature().getName());
        logger.debug("Arguments:::::::::",Arrays.toString(joinPoint.getArgs()));
        logger.info("$$$$$$$$$$$$$$$$$$$$");
    }

    @AfterReturning(value = "allControllerMethods()", returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result)
    {
        logger.info("[[[[[[[[[----@After Returning-------]]]]]]]]]");
        logger.debug("Method Name::::::",joinPoint.getSignature().getName());
        logger.debug("Arguments:::::::::",Arrays.toString(joinPoint.getArgs()));
        logger.debug("Result:::::",result);
        logger.info("=====================");
    }

    @AfterThrowing(value = "allControllerMethods()",throwing = "error")
    public void afterThrowing(JoinPoint joinPoint,Throwable error)
    {
        logger.info("{{{{{{{{====@After Throwing========}}}}}}}");
        logger.debug("Method Name::::::",joinPoint.getSignature().getName());
        logger.debug("Argument:::",Arrays.toString(joinPoint.getArgs()));
        logger.debug("Exception::::::",error);
        logger.info("************************");
    }

    @Pointcut("execution(* com.example.OrderService.repository.OrderRepository.* (..) )")
    public void allRepositoryMethods(){}

    @Before("allRepositoryMethods()")
    public void beforeAdvice1(JoinPoint joinPoint)
    {
        logger.info("----------@BeforeAdvice1------");
        logger.debug("Method Name:::::",joinPoint.getSignature().getName());
        logger.debug("Arguments:::::", Arrays.toString(joinPoint.getArgs()));
        logger.info("--------------@@@-------------");
    }

    @After("allRepositoryMethods()")
    public void afterAdvice1(JoinPoint joinPoint)
    {
        logger.info("::::::::::@After1:::::::::::");
        logger.debug("Method Name:::::::",joinPoint.getSignature().getName());
        logger.debug("Arguments:::::::::",Arrays.toString(joinPoint.getArgs()));
        logger.info("$$$$$$$$$$$$$$$$$$$$");
    }

    @AfterReturning(value = "allRepositoryMethods()", returning = "result")
    public void afterReturning1(JoinPoint joinPoint,Object result)
    {
        logger.info("[[[[[[[[[----@After Returning One-------]]]]]]]]]");
        logger.debug("Method Name::::::",joinPoint.getSignature().getName());
        logger.debug("Arguments:::::::::",Arrays.toString(joinPoint.getArgs()));
        logger.debug("Result:::::",result);
        logger.info("=====================");
    }

    @AfterThrowing(value = "allRepositoryMethods()",throwing = "error")
    public void afterThrowing1(JoinPoint joinPoint,Throwable error)
    {
        logger.info("{{{{{{{{====@After Throwing One========}}}}}}}");
        logger.debug("Method Name::::::",joinPoint.getSignature().getName());
        logger.debug("Argument:::",Arrays.toString(joinPoint.getArgs()));
        logger.debug("Exception::::::",error);
        logger.info("************************");
    }

    @Pointcut("execution(* com.example.OrderService.service.OrderService.* (..) )")
    public void allServiceMethods(){}

    @Before("allServiceMethods()")
    public void beforeAdvice2(JoinPoint joinPoint)
    {
        logger.info("----------@BeforeAdvice2------");
        logger.debug("Method Name:::::",joinPoint.getSignature().getName());
        logger.debug("Arguments:::::", Arrays.toString(joinPoint.getArgs()));
        logger.info("--------------@@@-------------");
    }

    @After("allServiceMethods()")
    public void afterAdvice2(JoinPoint joinPoint)
    {
        logger.info("::::::::::@After2:::::::::::");
        logger.debug("Method Name:::::::",joinPoint.getSignature().getName());
        logger.debug("Arguments:::::::::",Arrays.toString(joinPoint.getArgs()));
        logger.info("$$$$$$$$$$$$$$$$$$$$");
    }

    @AfterReturning(value = "allServiceMethods()", returning = "result")
    public void afterReturning2(JoinPoint joinPoint,Object result)
    {
        logger.info("[[[[[[[[[----@After Returning Two-------]]]]]]]]]");
        logger.debug("Method Name::::::",joinPoint.getSignature().getName());
        logger.debug("Arguments:::::::::",Arrays.toString(joinPoint.getArgs()));
        logger.debug("Result:::::",result);
        logger.info("=====================");
    }

    @AfterThrowing(value = "allServiceMethods()",throwing = "error")
    public void afterThrowing2(JoinPoint joinPoint,Throwable error)
    {
        logger.info("{{{{{{{{====@After Throwing Two========}}}}}}}");
        logger.debug("Method Name::::::",joinPoint.getSignature().getName());
        logger.debug("Argument:::",Arrays.toString(joinPoint.getArgs()));
        logger.debug("Exception::::::",error);
        logger.info("************************");
    }
}
