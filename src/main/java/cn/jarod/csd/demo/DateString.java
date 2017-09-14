package cn.jarod.csd.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DateString {

    private static final String FORMMAT = "yyyy-MM-dd HH:mm:ss SSS";

    private final TimeProvider timeProvider;

    public DateString(){
        this(new SystemNowTimeProvider());
    }

    public DateString(TimeProvider timeProvider){
        this.timeProvider = timeProvider;
    }

    public String formatString() throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat(FORMMAT);
        return sdf.format(timeProvider.getNow());
    }

    public static LocalDate createLocalDate(String str){
        int year = Integer.parseInt(str.substring(0,4));
        int month = Integer.parseInt(str.substring(4,6));
        int day = Integer.parseInt(str.substring(6,8));
        return LocalDate.of(year,month,day);
    }
}
