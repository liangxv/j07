package com.woniuxy.p3;

import org.junit.*;

public class AppDemoTest {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("方法后执行一次");
    }

    @AfterClass
    public static  void init(){
        System.out.println("方法前执行一次");
    }

    @After
    public  void after(){
        System.out.println("方法前执行");
    }

    @Before
    public  void before(){
        System.out.println("方法执行后");
    }

    @Test
    public void add(){
        System.out.println("test");
    }

    @Test
    public void del(){
        int i = 0;
        int a=6/ i;
        System.out.println(a);
    }
}
