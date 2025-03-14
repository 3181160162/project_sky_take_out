package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 公共字段填充
@Target(ElementType.METHOD) // 指定注解使用位置（方法上）
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {

    // 指定数据库操作类型：UPDATE INSERT
    OperationType value();
}
