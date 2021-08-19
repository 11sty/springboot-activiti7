package com.example.bootactiviti7.aspect.log;

import com.alibaba.fastjson.JSON;
import com.example.bootactiviti7.util.SecurityUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName LogAspect.java
 * @Description TODO
 * @createTime 2021年08月19日 14:11:00
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private SecurityUtil securityUtil;

    /***
     * 配置织入点
     */
    @Pointcut("@annotation(com.example.bootactiviti7.aspect.log.Log)")
    public void logPointCut() {
    }

    @AfterReturning(pointcut = "logPointCut()", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Object jsonResult) {
        handle(joinPoint, null, jsonResult);
    }

    @AfterThrowing(pointcut = "logPointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        handle(joinPoint, e, null);
    }

    private void handle(JoinPoint joinPoint, Exception e, Object jsonResult) {
        Log annotationLog = getAnnotationLog(joinPoint);
        if (Objects.isNull(annotationLog)) {
            return;
        }
        // 获取当前登录用户
        securityUtil.logInAs("system");
        Long userId = 100L;
        // 返回信息或者异常信息
        log.info("jsonResult====== " + JSON.toJSONString(jsonResult));
        if (Objects.nonNull(e)) {
            log.info("Exception ====== " + e.getMessage());
        }
        // 请求方法
        log.info("methodName ====== " + joinPoint.getSignature().getName());
        log.info("className ====== " + joinPoint.getTarget().getClass().getName());
        // 请求参数
        log.info("parameter ====== " + Arrays.toString(joinPoint.getArgs()));
        log.info("joinPoint ====== " + Arrays.toString(((MethodSignature) joinPoint.getSignature()).getParameterNames()));

        // 打印注解上的东西
        log.info("title ====== " + annotationLog.title());
        log.info("businessType().ordinal ====== " + annotationLog.businessType().ordinal());
        log.info("annotationLog.isSaveRequestData ====== " + annotationLog.isSaveRequestData());

        // 打印请求地址
        log.info("Request URL ===== " + ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest().getRequestURI());
    }

    /***
     判断方法是否存在Log注解，并且返回Log包含的信息
     */
    public Log getAnnotationLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null) {
            return method.getAnnotation(Log.class);
        }
        return null;
    }

}
