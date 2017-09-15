package cn.jarod.csd.demo;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TotalAmountTest {

    public TotalAmount totalAmount;

    public void getTotalAmount(List<Budget> budgetList){
        BudgetRepo stubBudgetRepo = mock (BudgetRepo.class);
        when(stubBudgetRepo.findAll()).thenReturn(budgetList);
        totalAmount = new TotalAmount(stubBudgetRepo);
    }

    @Test
    public  void no_planned_budget() throws ParseException {
        List<Budget> budgetList = new ArrayList<Budget>();
        budgetList.add(new Budget("201708",310));
        getTotalAmount(budgetList);
        double amount = totalAmount.query("20170615","20170715");
        assertEquals(0,amount,0.001);
    }

    @Test
    public  void one_month_planned_budget() throws ParseException {
        List<Budget> budgetList = new ArrayList<Budget>();
        budgetList.add(new Budget("201707",310));
        getTotalAmount(budgetList);
        double amount = totalAmount.query("20170615","20170715");
        assertEquals(150,amount,0.001);
    }


    @Test
    public  void tow_month_planned_budget() throws ParseException {
        List<Budget> budgetList = new ArrayList<Budget>();
        budgetList.add(new Budget("201707",310));
        budgetList.add(new Budget("201706",300));
        getTotalAmount(budgetList);
        double amount = totalAmount.query("20170615","20170715");
        assertEquals(310,amount,0.001);
    }


    @Test
    public  void three_month_planned_budget() throws ParseException {
        List<Budget> budgetList = new ArrayList<Budget>();
        budgetList.add(new Budget("201707",310));
        budgetList.add(new Budget("201706",300));
        budgetList.add(new Budget("201708",310));
        getTotalAmount(budgetList);
        double amount = totalAmount.query("20170615","20170815");
        assertEquals(620,amount,0.001);
    }

    @Test
    public  void three_month_pass_year_planned_budget() throws ParseException {
        List<Budget> budgetList = new ArrayList<Budget>();
        budgetList.add(new Budget("201612",310));
        budgetList.add(new Budget("201701",310));
        budgetList.add(new Budget("201702",280));
        getTotalAmount(budgetList);
        double amount = totalAmount.query("20161215","20170204");
        assertEquals(520,amount,0.001);
    }


    @Test
    public  void in_one_month_planned_budget() throws ParseException {
        List<Budget> budgetList = new ArrayList<Budget>();
        budgetList.add(new Budget("201706",300));
        getTotalAmount(budgetList);
        double amount = totalAmount.query("20170615","20170625");
        assertEquals(110,amount,0.001);
    }

    @Test
    public  void one_day_planned_budget() throws ParseException {
        List<Budget> budgetList = new ArrayList<Budget>();
        budgetList.add(new Budget("201706",300));
        getTotalAmount(budgetList);
        double amount = totalAmount.query("20170615","20170615");
        assertEquals(10,amount,0.001);
    }



    @Test
    public void two_month_getMonthBetweenTest() throws ParseException {
        LocalDate localDate1 = LocalDate.of(2017,6,14);
        LocalDate localDate2 = LocalDate.of(2017,7,16);
        List<String> listMonth = TotalAmount.getMonthBetween(localDate1,localDate2);
        List<String> targetMonthList = new ArrayList<String>();
        targetMonthList.add("201706");
        targetMonthList.add("201707");
        Assert.assertEquals(targetMonthList,listMonth);
    }

    @Test
    public void one_month_getMonthBetweenTest() throws ParseException {
        LocalDate localDate1 = LocalDate.of(2017,6,14);
        LocalDate localDate2 = LocalDate.of(2017,6,14);
        List<String> listMonth = TotalAmount.getMonthBetween(localDate1,localDate2);
        List<String> targetMonthList = new ArrayList<String>();
        targetMonthList.add("201706");
        Assert.assertEquals(targetMonthList,listMonth);
    }





}
