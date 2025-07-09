/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.institute.common;

/**
 *
 * @author pasindu hathurushigh
 */
public class FormatName {
    public static String getFormatName(String name){
        String names[] = name.split(" ");
        String current_name = "";
        for (String text : names) {
            String firstLatter = text.substring(0, 1).toUpperCase();
            String otherletter = text.substring(1).toLowerCase();
            current_name += (firstLatter + otherletter);
            current_name += " ";
        }
        return current_name.trim();
    }
    
   
}
