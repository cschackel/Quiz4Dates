package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        Date joshuahTree = new GregorianCalendar(1987,2,9).getTime();
        Date rattleAndHum = new GregorianCalendar(1988,9,10).getTime();

        GregorianCalendar joshuahTreeC = new GregorianCalendar(1987,2,9);
        GregorianCalendar rattleAndHumC = new GregorianCalendar(1988,9,10);
/*
        //System.out.println(joshuahTree.toString());
        //System.out.println(rattleAndHum);

        BigDecimal test1 = BigDecimal.valueOf(rattleAndHum.getTime() - joshuahTree.getTime());
        BigDecimal days1 = test1.divide(BigDecimal.valueOf(1000*60*60.0),BigDecimal.ROUND_HALF_UP);
        days1 = days1.divide(BigDecimal.valueOf(24),BigDecimal.ROUND_HALF_UP);
        //int testDays = Integer.parseInt(days1.toString());
        System.out.println(days1);

        //BigInteger days2 = BigInteger.valueOf(rattleAndHum.getTime() - joshuahTree.getTime());
*/

        Date today = new Date();
        //System.out.println(today);
        Date newDay = new Date(today.getTime()+(rattleAndHum.getTime() - joshuahTree.getTime()));
        //System.out.println(newDay);
        //Date t = new GregorianCalendar(today.getYear(),today.getMonth(),today.getDay()).getTime();
        //long todayNum = today.getTime();
        //long newDate = todayNum + rattleAndHum.getTime() - joshuahTree.getTime();

        System.out.println("Time from Album A to B: \n"+getDuration(joshuahTree,rattleAndHum));
        System.out.println("If album A was released today, " + today+ ", Album B would be released on " + newDay);

    }

    public static String getDuration(Date startingDate, Date endingDate)
    {
        //Calenders
        Calendar start = new GregorianCalendar();
        start.setTime(startingDate);
        Calendar end = new GregorianCalendar();
        end.setTime(endingDate);

        //Vars
        int days=0;
        int months=0;
        int years=0;

        int carryover=0;  //Ammount To Carryover if StartDate is Larger than EndDate

        if(start.get(Calendar.DAY_OF_MONTH)> end.get(Calendar.DAY_OF_MONTH))
        {
            carryover = end.getActualMaximum(Calendar.DAY_OF_MONTH);  //Days Needed to Get day Difference Pulled From Other Month
        }

        if(carryover>0)  //Carry Over Borrowed Month
        {
            days = end.get((Calendar.DAY_OF_MONTH) + carryover)-end.get(Calendar.DAY_OF_MONTH);
            carryover = 1; //Month Carried Over
        }
        else
        {
            days = end.get(Calendar.DAY_OF_MONTH)-start.get(Calendar.DAY_OF_MONTH);
        }

        if(start.get(Calendar.MONTH)+carryover > end.get(Calendar.MONTH))
        {
            months = (end.get(Calendar.MONTH)+12) - (start.get(Calendar.MONTH)+carryover); //Carry Over Borrowed year
            carryover=1; // Carry over Year
        }
        else
        {
            months = (end.get(Calendar.MONTH)) - (start.get(Calendar.MONTH)+carryover);
        }

        years = end.get(Calendar.YEAR) - (start.get(Calendar.YEAR)+carryover);
        return "Years: "+years + " Months: " + months + " Days: " + days;
    }

}
