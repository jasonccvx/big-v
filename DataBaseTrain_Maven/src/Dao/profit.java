package Dao;

public class profit {
    private String comName;
    private String time;
    private double income;

    public profit(String comName, String time, double income) {
        this.comName = comName;
        this.time = time;
        this.income = income;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public profit() {
    }

    public profit(String time, double income) {
        this.time = time;
        this.income = income;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
}
