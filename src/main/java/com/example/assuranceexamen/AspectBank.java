package com.example.assuranceexamen;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class AspectBank {
    @After("execution(* com.example.assuranceexamen.services.*.get*(..))")
    void aop(){
        log.info("La date et l'heure actuelles sont : " + LocalDateTime.now());

    }
}
