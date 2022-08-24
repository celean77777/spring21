package com.celean.spring21.aspect;

import com.celean.spring21.models.ServicesLog;
import com.celean.spring21.models.ServicesLogItem;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class ServiceLogAspect {
    @Autowired
    private final ServicesLog servicesLog;
  //  @Around("@annotation(Timed)")
    @Around("execution(* com.celean.spring21.services.*.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        servicesLog.getItem().add(new ServicesLogItem(joinPoint.getSignature().toString(), executionTime));
        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }

}
