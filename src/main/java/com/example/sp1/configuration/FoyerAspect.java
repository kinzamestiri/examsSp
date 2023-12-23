package com.example.sp1.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class FoyerAspect {
    @Before("execution(* com.example.sp1.Services.*.*(..))")//**toutes les methodes de toutes les classes / .. nombres des parametres (peut importe)peut etre aussi 0 ou 1
    //@After("execution(* com.example.sp1.Services.*.*(..))")(try)
    //@AfterReturning("execution(* com.example.sp1.Services.*.*(..))")(finally)
    //@AfterThrowing("execution(* com.example.sp1.Services.*.retreive*(String,..))")//baed erreur(catch)
    void aop(JoinPoint joinPoint){
        log.info("Avant l'execution de la methode "+joinPoint.getSignature().getName());
    }


    //Around
    void calculPerformance(ProceedingJoinPoint pjp) throws Throwable {
        long start =System.currentTimeMillis();
        Object obj =pjp.proceed();
        long elapsedTime=System.currentTimeMillis() - start;
        log.info("methode execution time: " +elapsedTime + "ms");
    }
}
