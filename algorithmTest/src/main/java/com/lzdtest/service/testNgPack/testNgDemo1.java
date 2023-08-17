package com.lzdtest.service.testNgPack;

import org.testng.Assert;
import org.testng.annotations.*;

public class testNgDemo1 {
    @BeforeTest
    public void beforeCase() {
        System.out.println("BeforeTest");
    }

    @AfterTest
    public void afterCase() {
        System.out.println("AfterTest");
    }

    @Test
    public void testNgCase1() {
        Assert.assertEquals("1", "1", "等于");
        System.out.println("1");
    }

    @Test
    public void testNgCase2() {
        System.out.println("2");
    }
}
