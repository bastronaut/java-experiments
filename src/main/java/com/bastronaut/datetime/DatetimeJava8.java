package com.bastronaut.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

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
}
