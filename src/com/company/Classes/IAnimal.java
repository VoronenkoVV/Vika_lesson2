package com.company.Classes;

import java.util.Calendar;
import java.util.Date;

public interface IAnimal {
    String getTitle();
    boolean setTitle(String title);

    Calendar getBirthday();
    boolean setBirthday(int day, int month, int year);
}
