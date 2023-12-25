package com.example.assuranceexamen;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AspectScrum {
    @AfterReturning("execution(* com.example.assuranceexamen.services.*.*(..))")
    void aop(JoinPoint joinPoint){
        if (joinPoint.getSignature() instanceof MethodSignature) {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            if (signature.getReturnType().equals(void.class)) {
                log.info("Apres l'execution de la methode de type void" + joinPoint.getSignature().getName());
            }
        }
    }

}
