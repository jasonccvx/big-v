package Dao;

public class nav {
    private String comName;
    private String time;
    private double nav;
    private double DailyIncrease;

    public nav(String comName, String time, double nav, double dailyIncrease) {
        this.comName = comName;
        this.time = time;
        this.nav = nav;
        DailyIncrease = dailyIncrease;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public nav() {
    }

    public nav(String time, double nav, double dailyIncrease) {
        this.time = time;
        this.nav = nav;
        DailyIncrease = dailyIncrease;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getNav() {
        return nav;
    }

    public void setNav(double nav) {
        this.nav = nav;
    }

    public double getDailyIncrease() {
        return DailyIncrease;
    }

    public void setDailyIncrease(double dailyIncrease) {
        DailyIncrease = dailyIncrease;
    }
}
