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
import static java.time.format.DateTimeFormatter.ofPattern;

public class TotalAmount {


    private BudgetRepo stubBudgetRepo;

    public TotalAmount(BudgetRepo stubBudgetRepo) {
        this.stubBudgetRepo = stubBudgetRepo;
    }

    public double query(String startDateStr, String endDateStr) throws ParseException {
        double total = 0;
        LocalDate startDate = LocalDate.parse(startDateStr,ofPattern("yyyyMMdd"));
        LocalDate endDate = LocalDate.parse(endDateStr,ofPattern("yyyyMMdd"));
        if (startDate.isAfter(endDate)) {
            return total;
        }
        List<String> monthList = getMonthBetween(startDate,endDate);
        if (isInOneMonth(monthList.size())){
            total =  getAmountByMonth(startDateStr.substring(0,6),(endDate.getDayOfMonth()-startDate.getDayOfMonth() + 1));
            return total;
        }
        for (String monthStr : monthList){
            if (monthStr.equals(startDateStr.substring(0,6))) {
                total += getAmountByMonth(monthStr, (startDate.lengthOfMonth() - startDate.getDayOfMonth() + 1));
            }else if (monthStr.equals(endDateStr.substring(0,6))){
                total += getAmountByMonth(monthStr, endDate.getDayOfMonth());
            }else{
                for (Budget b : stubBudgetRepo.findAll()) {
                    if (b.getMonth().equals(monthStr)){
                        total +=  b.getAmount();
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
