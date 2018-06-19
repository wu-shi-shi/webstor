package com.bdqn.annotation;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {
    @annotation(isCanNull = false,isCanZero = false,isCanEmpty = false)
    private Integer money;
    public int count = 1;
    public Person(Integer money) {
        this.money = money;
    }
    public Person() {
    }
}
