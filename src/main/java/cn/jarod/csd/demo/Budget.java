package cn.jarod.csd.demo;


public class Budget {

    private String month;

    private double amount;

    private double avgAmount;

    public Budget() {
    }
    public Budget(String s, double i) {
        this.month = s;
        this.amount = i;
        this.avgAmount = amount/DateString.createLocalDate(month+"01").lengthOfMonth();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAvgAmount() {
        return avgAmount;
    }

    public void setAvgAmount(double avgAmount) {
        this.avgAmount = avgAmount;
    }

}
