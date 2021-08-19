package com.example.bootactiviti7.aspect.log;

import com.example.bootactiviti7.aspect.enums.BusinessType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName Log.java
 * @Description TODO
 * @createTime 2021年08月19日 13:59:00
 */
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    // 标题
    String title() default "";

    // 设置一个业务类型（新增，删除...）
    BusinessType businessType() default BusinessType.OTHER;

    // 是否保存请求参数
    boolean isSaveRequestData() default true;


}
