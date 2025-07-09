/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.institute.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pasindu hathurushigh
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class DateAndTime {

    public static String getDateTime() {
        Date d = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String format_date = sdf.format(d);

        return format_date;
    }

    public static String getDate() {
        Date d = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String format_date = sdf.format(d);

        return format_date;
    }

    public static String getYearMonth() {
        Date d = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

        String format_date = sdf.format(d);

        return format_date;
    }

    public static String getDateInWord() {
        Date d = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");

        String format_date = sdf.format(d);

        return format_date;
    }

    public static String getTime() {
        Date d = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        String format_date = sdf.format(d);

        return format_date;
    }

}
