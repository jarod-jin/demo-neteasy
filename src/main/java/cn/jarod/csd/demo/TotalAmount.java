package cn.jarod.csd.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static javax.xml.bind.DatatypeConverter.parseDate;

public class TotalAmount {



    public TotalAmount(BudgetRepo stubBudgetRepo) {
    }

    public double query(String s, String s1) throws ParseException {

        LocalDate startDate = createLocalDate(s);
        LocalDate endDate = createLocalDate(s1);
        int monthNum = getMonthSpace(s,s1);
        if (monthNum>0){
            double amount = 0;
            int sdays = startDate.lengthOfMonth()-startDate.getDayOfMonth() + 1;
            List<Budget> budgetList =  new BudgetRepo().findAll();
            for (Budget b : budgetList){
                double avgamount = b.getAmount()/startDate.lengthOfMonth();
                amount = sdays*avgamount;
            }

            int edays = endDate.getDayOfMonth()-endDate.lengthOfMonth() + 1;
            for (Budget b : budgetList){
                double avgamount = b.getAmount()/endDate.lengthOfMonth();
                amount =+ edays*avgamount;
            }


            return 0;
        }else if(monthNum == 0 )
        {
            int d_day = Integer.parseInt(s1.substring(4,5))-Integer.parseInt(s1.substring(4,5));
            if (d_day>=0){
                List<Budget> budgetList =  new BudgetRepo().findAll();
                for (Budget b : budgetList){
                    if (b.getMonth().equals(s.substring(0,5))){
                        int day = getDays(s);
                        double avgamount = b.getAmount()/day;
                        return d_day*avgamount;
                    }
                }
                return 0;
            }else {
                return 0;
            }
        }
        else {
            return 0;
        }
    }

    private LocalDate createLocalDate(String str){
        int year = Integer.parseInt(str.substring(0,3));
        int month = Integer.parseInt(str.substring(4,5));
        int day = Integer.parseInt(str.substring(6,7));
        return LocalDate.of(year,month,day);
    }

    public int getDays(String str) {
        int year = Integer.parseInt(str.substring(0,3));
        int month = Integer.parseInt(str.substring(4,5));
        LocalDate localDate =  LocalDate.of(year,month,1);
        return localDate.lengthOfMonth();
    }

    public static int getMonthSpace(String date1, String date2)
            throws ParseException {

        int result = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(sdf.parse(date1));
        c2.setTime(sdf.parse(date2));

        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

        return result == 0 ? 1 : Math.abs(result);

    }


}
