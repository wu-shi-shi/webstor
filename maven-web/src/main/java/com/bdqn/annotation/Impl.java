package com.bdqn.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class Impl{

    public static boolean check(Object obj){
        // list = Arrays.asList(AnnotationParsing.class.getClassLoader().loadClass(((Class)obj).getClass().getName()).getDeclaredFields());
        List<Field> list = Arrays.asList(obj.getClass().getDeclaredFields());
        for(int i=0;i<list.size();i++){
            Field field = list.get(i);
            if(field.isAnnotationPresent(annotation.class)){//是否使用MyAnno注解
                for (Annotation anno : field.getDeclaredAnnotations()) {//获得所有的注解
                    if(anno.annotationType().equals(annotation.class) ){//找到自己的注解
                        if(!((annotation)anno).isCanNull()){//注解的值
                            System.out.println("weikong");
                        }
                        if(!((annotation)anno).isCanEmpty()){
                            System.out.println("notweikong");
                        }
                        if(!((annotation)anno).isCanZero()){
                            System.out.println("notasdasdasdweikong");
                        }
                    }
                }
            }

        }
        return  true;
    }

}
