package com.bdqn.annotation;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME )
public @interface annotation {
    /**
     * 是否能为null
     * @return
     */
    boolean isCanNull() default true;

    /**
     * 是否能为空字符串
     * @return
     */
    boolean isCanEmpty() default true;

    /**
     * 是否能为0
     * @return
     */
    boolean isCanZero() default true;
}
