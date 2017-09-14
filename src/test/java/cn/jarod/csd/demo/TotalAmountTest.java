package cn.jarod.csd.demo;

import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;

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


}
