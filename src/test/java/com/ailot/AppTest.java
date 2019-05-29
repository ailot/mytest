package com.ailot;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    public static void main(String[] args) {


        BigDecimal bigDecimal = new BigDecimal("2903.11");
        System.out.println(bigDecimal.setScale(0,BigDecimal.ROUND_CEILING));

        String str = "3K345";
        System.out.println(str.substring(0,2));

        Days days = Days.daysBetween(DateTime.parse("2019-05-22"), DateTime.parse("2019-05-23"));
        int day = days.getDays();

        int mod = 418 / 30;
        System.out.println(mod);

        Date today = new Date();
        boolean after = today.after(add(today, - 3));
        System.out.println(after);
    }

    private static Date add(Date date1,int secs){
        return new Date(date1.getTime() + (secs * 60 * 60 * 1000));
    }
}
