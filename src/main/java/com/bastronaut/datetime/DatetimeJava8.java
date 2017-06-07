package com.bastronaut.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/**
 * Created by Bas on 4-6-2017.
 *
 * Core ideas of java 8 date api:
 *
 * - immutable-value classes: previous apis were not thread safe
 * - domain driven design - models domain quite precisely instead of weird toString() seemingly representing a timezone
 * - seperation of chronologies - different calendaring systems
 */
public class DatetimeJava8 {

    public static void main(String[] args) {
        locals();
        localsFactory();
        timeGetters();
        timeCalculation();
        testCompareTo();
    }

    // represent date time from context of observer
    public static void locals() {
        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();

        // composite of the two above:
        LocalDateTime ldt = LocalDateTime.now();

        System.out.println(ld);
        System.out.println(lt);
        System.out.println(ldt);
    }

    public static void localsFactory() {
        LocalDate ld = LocalDate.of(2015, Month.APRIL, 01);
        System.out.println(ld);
        // notice day and month index do not start at 0. previously month did
        LocalDate ld1 = LocalDate.of(2015, 11, 01);
        System.out.println(ld1);

        LocalTime lt1 = LocalTime.of(16, 12);
        System.out.println(lt1);

//        DateTimeException
//        LocalTime lt2 = LocalTime.of(25, 12);
//        System.out.println(lt2);
    }

    public static void timeGetters() {
        LocalDateTime ldt = LocalDateTime.now();
        // getting a date:
        LocalDate ld = ldt.toLocalDate();
        LocalTime lt = ldt.toLocalTime();

        int month = ld.getMonthValue();
        Month month2 = ld.getMonth();

        System.out.println(month);
        System.out.println(month2);

        int day = ld.getDayOfMonth();
        int dayYear = ld.getDayOfYear();

        System.out.println(day);
        System.out.println(dayYear);

        int second = ldt.getSecond();

        int hour = lt.getHour();
        int hour2 = ldt.getHour();
    }

    public static void timeCalculation() {
        LocalDate ld = LocalDate.now();
        LocalDate newDate = ld.plusMonths(2);
        System.out.println(newDate.toString());

        //ChronoUnit allows selecting a time unit for time calculationss
        LocalDate newDate2 = newDate.plus(5, ChronoUnit.DAYS);
        ChronoUnit cu = ChronoUnit.SECONDS; // see public fields here
        System.out.println(cu);
    }

    public static void testCompareTo() {
        LocalDate ld = LocalDate.of(2017, 11, 15);
        LocalDate now = LocalDate.now();
        int difference = ld.compareTo(now); // returns 5? the month diference?
        print(difference);

        LocalDate ld2 = LocalDate.of(2017, 11, 19);
        LocalDate ld3 = LocalDate.of(2017, 11, 16);
        int difference2 = ld2.compareTo(ld3); // returns 3 - the day difference
        print(difference2);

        LocalDate ld4 = LocalDate.of(2017, 12, 19);
        LocalDate ld5 = LocalDate.of(2017, 11, 16);
        int difference3 = ld4.compareTo(ld5); // returns 1 - the month difference
        print(difference3);

        LocalDate ld6 = LocalDate.of(2020, 12, 19);
        LocalDate ld7 = LocalDate.of(2017, 11, 16);
        int difference4 = ld6.compareTo(ld7); // returns 3-  the year difference
        print(difference4);

        // seems compareto returns the difference of the 'highest' time value.
        // api states negative if smaller, 0 if equals, positive if larger


    }

    // function for being lazy
    public static void print(Object o) {
        System.out.println(o.toString());
    }
}
