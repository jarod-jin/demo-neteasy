package cn.jarod.csd.demo;

import java.time.LocalDate;

public class BudgetRepo {




    public int getDays(String str) {
        int year = Integer.parseInt(str.substring(0,3));
        int month = Integer.parseInt(str.substring(4,5));
        LocalDate localDate =  LocalDate.of(year,month,1);
        return localDate.lengthOfMonth();
    }

    public Object findAll() {

        return null;
    }
}
