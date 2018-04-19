package ru.tisov.denis.crx.service;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class InMemoryRainHillServiceTest {

    private RainHillService rainHillService = new InMemoryRainHillService();

    @Test
    public void testCalc1() {
        Assert.assertEquals(2, rainHillService.calc(Arrays.asList(3, 2, 4, 1, 2)));
    }

    @Test
    public void testCalc2() {
        Assert.assertEquals(8, rainHillService.calc(Arrays.asList(4, 1, 1, 0, 2, 3)));
    }

    @Test
    public void testCalc3() {
        Assert.assertEquals(0, rainHillService.calc(Collections.singletonList(0)));
    }

    @Test
    public void testCalc4() {
        Assert.assertEquals(0, rainHillService.calc(Arrays.asList(1, 1, 1)));
    }

    @Test
    public void testCalc5() {
        Assert.assertEquals(0, rainHillService.calc(Arrays.asList(0, 1, 0)));
    }

    @Test
    public void testCalc6() {
        Assert.assertEquals(0, rainHillService.calc(Arrays.asList(0, 1, 2, 1)));
    }

    @Test
    public void testCalc7() {
        Assert.assertEquals(0, rainHillService.calc(Arrays.asList(0, 1, 2)));
    }

    @Test
    public void testCalc8() {
        Assert.assertEquals(0, rainHillService.calc(Arrays.asList(2, 1, 0)));
    }

    @Test
    public void testCalc9() {
        Assert.assertEquals(0, rainHillService.calc(Arrays.asList(1, 2, 1, 0)));
    }

    @Test
    public void testCalc10() {
        Assert.assertEquals(1, rainHillService.calc(Arrays.asList(0, 1, 0, 1, 0)));
    }

    @Test
    public void testCalc11() {
        Assert.assertEquals(1, rainHillService.calc(Arrays.asList(0, 2, 0, 1, 0)));
    }

    @Test
    public void testCalc12() {
        Assert.assertEquals(2, rainHillService.calc(Arrays.asList(0, 2, 0, 2, 1)));
    }

}