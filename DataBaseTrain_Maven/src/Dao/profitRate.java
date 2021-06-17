package Dao;

public class profitRate {
    private String comName;
    private String time;
    private double realIncrease;
    private double referIncrease;

    public profitRate(String comName, String time, double realIncrease, double referIncrease) {
        this.comName = comName;
        this.time = time;
        this.realIncrease = realIncrease;
        this.referIncrease = referIncrease;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public profitRate() {
    }

    public profitRate(String time, double realIncrease, double referIncrease) {
        this.time = time;
        this.realIncrease = realIncrease;
        this.referIncrease = referIncrease;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getRealIncrease() {
        return realIncrease;
    }

    public void setRealIncrease(double realIncrease) {
        this.realIncrease = realIncrease;
    }

    public double getReferIncrease() {
        return referIncrease;
    }

    public void setReferIncrease(double referIncrease) {
        this.referIncrease = referIncrease;
    }
}
