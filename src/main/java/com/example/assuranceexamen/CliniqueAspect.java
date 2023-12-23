package com.example.assuranceexamen;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class CliniqueAspect {
    @After("execution(* com.example.assuranceexamen.services.*.add*(..))")
    void aop(){
        log.info("methode executee");
    }
}
