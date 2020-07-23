package com.company.Classes;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class StoreItem implements IAnimal, IItem {
    public static final int MAX_AGE = 120;
    private String title;
    private Calendar birthdayDate;
    private Calendar arrivalDate;
    private Calendar tempDate;
    private double price;
    private String errorMessage;

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public boolean setTitle(String title) {
        for (Character c : title.toCharArray()) {
            if (!(Character.isAlphabetic(c) || c == '-' || c == ' ')) {
                this.errorMessage = "Inappropriate title";
                return false;
            }
        }
        this.title = title;
        return true;
    }

    @Override
    public Calendar getBirthday() {
        return this.birthdayDate;
    }

    @Override
    public boolean setBirthday(int day, int month, int year) {
        if (checkDate(day,month, year, MAX_AGE)) {
            this.birthdayDate = tempDate;
            return true;
        }
        return false;
    }

    private Calendar setDate(int day, int month, int year) {
        Calendar tempDate = new GregorianCalendar(year, month - 1, day);
        if (tempDate.getTime().after(Calendar.getInstance().getTime())) {
            errorMessage = "Date cannot be in future";
        }
        return tempDate;
    }


    @Override
    public double getPrice() {

        return this.price;
    }

    @Override
    public boolean setPrice(double price) {
        if (price > 0) {
            this.price = price;
            return true;
        }
        this.errorMessage = "Inappropriate price";
        return false;

    }

    @Override
    public Calendar getArrivalDate() {
        return this.arrivalDate;
    }

    @Override
    public boolean setArrivalDate(int day, int month, int year) {
        if (checkDate(day,month, year, 1)) {
            this.arrivalDate = tempDate;
            return true;
        }
        return false;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean checkDate(int day, int month, int year, int yearDifference) {
        if (year <= Calendar.getInstance().get(Calendar.YEAR) && year > Calendar.getInstance().get(Calendar.YEAR) - yearDifference) {
            if (month <= 12 && month > 0) {
                if (day > 0) {
                    switch (month) {
                        case 1, 3, 5, 7, 8, 10, 12:
                            if (day <= 31) {
                                tempDate = setDate(day, month, year);
                                return true;
                            }
                            break;
                        case 4, 6, 9, 11:
                            if (day <= 30) {
                                tempDate = setDate(day, month, year);
                                return true;
                            }
                            break;
                        case 2:
                            boolean isLeapYear = false;
                            if (year % 4 == 0 && (year % 100 == 0 && year % 400 == 0))
                                isLeapYear = true;
                            if (isLeapYear && day <= 29) {
                                tempDate = setDate(day, month, year);
                                return true;
                            } else if (day <= 28) {
                                tempDate = setDate(day, month, year);
                                return true;
                            }
                            break;
                    }
                } else {
                    this.errorMessage = "Inappropriate date";
                    return false;
                }
            } else {
                this.errorMessage = "Inappropriate date";
                return false;
            }
        } else {
            this.errorMessage = "Inappropriate date";
            return false;
        }
        return true;
    }

}
