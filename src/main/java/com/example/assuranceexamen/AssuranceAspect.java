package com.example.assuranceexamen;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AssuranceAspect {
    @AfterReturning("execution(* com.example.assuranceexamen.services.*.get*(..))")
    void aop(){

        log.info("Bon courage! ");
    }
}
