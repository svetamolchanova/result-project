package com.example.demo.aspect;

import java.util.*;
import java.util.stream.*;
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.slf4j.*;
import org.springframework.stereotype.*;

@Aspect
@Component
public class MyAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.example.demo.service.UserService.*(..)) || bean(studentServiceImpl)")
    public void callAtMyServicePublic() { }

    @Pointcut("@annotation(com.example.demo.annotation.MyAnnotation)")
    public void callGetMethodPublic() { }

    @Before("callAtMyServicePublic()")
    public void beforeCallAtMethod1(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        logger.info("before " + jp.toString() + ", args=[" + args + "]");
    }

    @After("callAtMyServicePublic()")
    public void afterCallAt(JoinPoint jp) {
        logger.info("after " + jp.toString());
    }

    @AfterReturning("callGetMethodPublic()")
    public void afterMethodWithAnnotation() {
        logger.info("GET NAME");
    }
}
