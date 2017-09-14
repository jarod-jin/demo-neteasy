package cn.jarod.csd.demo;

import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateStringTest {

    protected String sourceDateStr = "2017-09-17 13:40:45 678";

    @Test
    public void date2StringTest() throws ParseException {
        DateString dateString = new DateString(new TestNowTimeProvider());
        Assert.assertEquals(sourceDateStr,dateString.formatString());

    }

    public class TestNowTimeProvider implements TimeProvider {

        public Date getNow() throws ParseException {
            DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            return fmt.parse(sourceDateStr);
        }
    }
}
