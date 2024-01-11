package br.ce.wcaquino.taskbackend.utils;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class DateUtilsTest {
    @Test
    public void testShouldReturnTrueForFutureDate(){
        LocalDate localDate = LocalDate.now().plusDays(1);
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(localDate));
    }
    @Test
    public void testShouldReturnTrueForPastDate(){
        LocalDate localDate = LocalDate.now().minusDays(1);
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(localDate));
    }
    @Test
    public void testShouldReturnTrueForTheCurrentDate(){
        LocalDate localDate = LocalDate.now();
        Assert.assertFalse(DateUtils.isEqualOrFutureDate(localDate));
    }

}