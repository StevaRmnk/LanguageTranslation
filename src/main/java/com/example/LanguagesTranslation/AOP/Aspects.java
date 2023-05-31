package com.example.LanguagesTranslation.AOP;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aspects {

    Logger logger = LoggerFactory.getLogger(Aspects.class);

    @Pointcut(value = "execution(* com.example.LanguagesTranslation.Controller.HelloWorldController.*.(..))"+
            "|| execution(* com.example.LanguagesTranslation.Controller.HelloWorldRestController.*.(..))"+
            "|| execution(* com.example.LanguagesTranslation.Controller.TranslationController.*.(..)")

    public void pointcutJoinPoint() {

    }

    @Pointcut(value = "execution(* com.example.LanguagesTranslation.Controller.SecureHelloWorldController.*(..))")
    public void pointcutProceed() {

    }

    @After("pointcutJoinPoint()")
    public void applicationLogger(JoinPoint joinPoint) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        logger.info("Method invoked : " +
                joinPoint.getTarget().getClass().getName() + " : " +
                joinPoint.getSignature().getName() + "()" +
                " - arguments : " +  mapper.writeValueAsString(joinPoint.getArgs()));
    }

    @Around("pointcutProceed()")
    public Object proceedLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();
        Object object = proceedingJoinPoint.proceed();
        logger.info("Method invoked : " + proceedingJoinPoint.getTarget().getClass().getName() + " : " +
                proceedingJoinPoint.getSignature().getName() + "()" +
                " - page : " +  mapper.writeValueAsString(object));
        return object;
    }
}
