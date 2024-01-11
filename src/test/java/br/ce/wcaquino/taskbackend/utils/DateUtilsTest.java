package br.ce.wcaquino.taskbackend.utils;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class DateUtilsTest {
    @Test
    public void testShouldReturnTrueForFutureDate(){
        LocalDate localDate = LocalDate.of(2025,01,01);
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(localDate));
    }
    @Test
    public void testShouldReturnTrueForPastDate(){
        LocalDate localDate = LocalDate.now();
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(localDate));
    }
    @Test
    public void testShouldReturnTrueForTheCurrentDate(){
        LocalDate localDate = LocalDate.of(2023,01,01);
        Assert.assertFalse(DateUtils.isEqualOrFutureDate(localDate));
    }

}