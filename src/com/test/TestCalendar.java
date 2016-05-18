package com.test;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCalendar{

    public static String name;

    public static int testId;

    static{
        testId = 5;
    }

    public static void main(String[] args){
        System.out.println(testId);

        Calendar calendar =  Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(date));

        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));

        calendar.set(Calendar.DATE, -1);
        date = calendar.getTime();
        System.out.println(format.format(date));

        calendar.set(Calendar.MONTH, -1);
        date = calendar.getTime();
        System.out.println(format.format(date));


        String str;

        Boolean tew = null;
        if  (tew){
            System.out.println("4343");

        }



    }
}