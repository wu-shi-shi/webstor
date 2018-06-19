package com.bdqn.test;

import lombok.var;
import org.junit.Before;
import org.junit.Test;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.Assert.assertEquals;


public class Testsssss {
    @Test
    public void asd(){
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);

    // 以前的循环方式
        System.out.println("以前的循环方式:");
            for (String player : players) {
                System.out.print(player + "; ");
            }

    // 使用 lambda 表达式以及函数操作(functional operation)
        System.out.println("使用 lambda 表达式以及函数操作(functional operation)；");
            players.forEach((player) -> System.out.print(player + "; "));

        // 在 Java 8 中使用双冒号操作符(double colon operator)
        System.out.println("在 Java 8 中使用双冒号操作符(double colon operator):");
            players.forEach(System.out::println);
    }
    @Test
    public void yg(){
        List<Person> phpProgrammers = new ArrayList<Person>() {
            {
                add(new Person(1550));
                add(new Person(1200));
                add(new Person(1600));
                add(new Person(1000));
                add(new Person(1100));
                add(new Person(1300));
                add(new Person(1100));
                add(new Person(1000));
                add(new Person(1600));
                add(new Person(1800));
            }
        };
        Consumer<Person> personConsumer=e -> e.setMoney(e.getMoney()+10000);
        phpProgrammers.forEach(personConsumer);
//        phpProgrammers.forEach(ph -> System.out.println(ph));
        phpProgrammers.stream().
                limit(3)
                .sorted((p,p2) -> (p2.getMoney())-p.getMoney())
                .forEach(p -> System.out.println(p));
        var list = new ArrayList<String>();
        list.add("1");
        System.out.println(list.get(0));
    }
    private Person handleTarget =new Person();
    private VarHandle varHandle;
    @Before
    public void setUp() throws Exception {
        this.handleTarget = new Person();
        this.varHandle = MethodHandles
                .lookup()
                .findVarHandle(Person.class, "count", int.class);
    }
    @Test
    public void testGet() throws Exception {
        assertEquals(1, this.varHandle.get(this.handleTarget));
        assertEquals(1, this.varHandle.getVolatile(this.handleTarget));
        assertEquals(1, this.varHandle.getOpaque(this.handleTarget));
        assertEquals(1, this.varHandle.getAcquire(this.handleTarget));
    }
    String asd="123";
    @Test
    public void asdasdadsdad(){

    }
}
