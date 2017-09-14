package cn.jarod.csd.demo;

import java.text.ParseException;
import java.util.Date;

public interface TimeProvider {
    public Date getNow() throws ParseException;
}
