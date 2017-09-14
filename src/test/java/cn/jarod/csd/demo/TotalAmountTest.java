package cn.jarod.csd.demo;

import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TotalAmountTest {

    @Test
    public  void no_planned_budget() throws ParseException {
        BudgetRepo stubBudgetRepo = mock (BudgetRepo.class);
        when(stubBudgetRepo.findAll()).thenReturn(new ArrayList<>());
        TotalAmount totalAmount = new TotalAmount(stubBudgetRepo);
        double amount = totalAmount.query("20170615","20170715");
        assertEquals(0,amount,0.001);
    }

    @Test
    public  void one_month_planned_budget() throws ParseException {
        BudgetRepo stubBudgetRepo = mock (BudgetRepo.class);
        List<Budget> budgetList = new ArrayList<Budget>();
        budgetList.add(new Budget("201707",310));
        when(stubBudgetRepo.findAll()).thenReturn(budgetList);
        TotalAmount totalAmount = new TotalAmount(stubBudgetRepo);
        double amount = totalAmount.query("20170615","20170715");
        assertEquals(150,amount,0.001);
    }


    @Test
    public  void tow_month_planned_budget() throws ParseException {
        BudgetRepo stubBudgetRepo = mock (BudgetRepo.class);
        List<Budget> budgetList = new ArrayList<Budget>();
        budgetList.add(new Budget("201707",310));
        budgetList.add(new Budget("201706",300));
        when(stubBudgetRepo.findAll()).thenReturn(budgetList);
        TotalAmount totalAmount = new TotalAmount(stubBudgetRepo);
        double amount = totalAmount.query("20170615","20170715");
        assertEquals(310,amount,0.001);
    }



}
