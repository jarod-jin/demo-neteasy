package cn.jarod.csd.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static cn.jarod.csd.demo.DateString.createLocalDate;

public class TotalAmount {


    private BudgetRepo stubBudgetRepo;

    public TotalAmount(BudgetRepo stubBudgetRepo) {
        this.stubBudgetRepo = stubBudgetRepo;
    }

    public double query(String startDateStr, String endDateStr) throws ParseException {
        double total = 0;
        LocalDate startDate = createLocalDate(startDateStr);
        LocalDate endDate = createLocalDate(endDateStr);
        if (startDate.minusDays(1).isBefore(endDate)){
            List<String> monthList = getMonthBetween(startDate,endDate);
            if (isInOneMonth(monthList.size())){
                int d_day = endDate.getDayOfMonth()-startDate.getDayOfMonth() + 1;
                total +=  getAmountByMonth(startDateStr.substring(0,6),d_day);
            }
            else
            {
                for (int m = 0 ; m<monthList.size(); m++){
                    if (monthList.get(m).equals(startDateStr.substring(0,6))) {
                        int firstMonthDays = startDate.lengthOfMonth() - startDate.getDayOfMonth() + 1;
                        total += getAmountByMonth(monthList.get(m), firstMonthDays);
                    }else if (monthList.get(m).equals(endDateStr.substring(0,6))){
                        int lastMonthDays = endDate.getDayOfMonth();
                        total += getAmountByMonth(monthList.get(m), lastMonthDays);
                    }else{
                        for (Budget b : stubBudgetRepo.findAll()) {
                            if (b.getMonth().equals(monthList.get(m))){
                                total +=  b.getAmount();
                            }
                        }
                    }
                }
            }

        }
        return total;
    }

    /**
     * 判断同一个月
     * @param size
     * @return
     */
    private boolean isInOneMonth(int size){
        return size==1?true:false;
    }

    /**
     * 计算当月天数的amount
     * @param month
     * @param days
     * @return
     */
    private double getAmountByMonth(String month, int days){
        double total = 0;
        for (Budget b : stubBudgetRepo.findAll()) {
            if (b.getMonth().equals(month)){
                total += days * b.getAvgAmount();
            }
        }
        return total;
    }

    /**
     * 获得2个LocalDate中间所有的月份
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static List<String> getMonthBetween(LocalDate startDate, LocalDate endDate) throws ParseException {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");//格式化为年月
        LocalDate tmpDate = LocalDate.of(startDate.getYear(),startDate.getMonth(),1);
        while (tmpDate.isBefore(endDate)){
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zdt = tmpDate.atStartOfDay(zoneId);
            Date date = Date.from(zdt.toInstant());
            result.add(sdf.format(date));
            tmpDate = tmpDate.plusMonths(1);
        }
        return result;
    }


}
