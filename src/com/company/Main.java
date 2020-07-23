package com.company;

import com.company.Classes.StoreItem;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        StoreItem item = new StoreItem();

        if (!item.setTitle("Tiger Vika"))
            System.out.println(item.getErrorMessage());
        else
            System.out.println(item.getTitle());


        if (item.setBirthday(19, 10, 1998))
            System.out.println(item.getBirthday().getTime().toLocaleString());
        else
            System.out.println(item.getErrorMessage());

        if (item.setPrice(1000000))
            System.out.println(item.getPrice());
        else
            System.out.println(item.getErrorMessage());

        if (item.setArrivalDate(19, 5, 2020))
            System.out.println(item.getArrivalDate().getTime().toLocaleString());
        else
            System.out.println(item.getErrorMessage());
    }
}
