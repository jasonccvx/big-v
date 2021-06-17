package Dao;

public class fansAndIncome {
    private int fansNUM;
    private double income;

    public fansAndIncome() {
    }

    public fansAndIncome(int fansNUM, double income) {
        this.fansNUM = fansNUM;
        this.income = income;
    }

    public int getFansNUM() {
        return fansNUM;
    }

    public void setFansNUM(int fansNUM) {
        this.fansNUM = fansNUM;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
}
