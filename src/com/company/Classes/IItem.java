package com.company.Classes;

import java.util.Calendar;
import java.util.Date;

public interface IItem {
    double getPrice();
    boolean setPrice(double price);

    Calendar getArrivalDate();
    boolean setArrivalDate(int year, int month, int day);
}
