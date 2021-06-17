package Dao;

public class combin {
    private String comName ;
    private String Vname;
    private String type;
    private double annuRate;
    private double dayIncrease;
    private double newNetWorth;
    private double newMarketValue;
    private String estabDay;

    public combin() {
    }

    public combin(String comName, String vname, String type, double annuRate, double dayIncrease, double newNetWorth, double newMarketValue, String estabDay) {
        this.comName = comName;
        Vname = vname;
        this.type = type;
        this.annuRate = annuRate;
        this.dayIncrease = dayIncrease;
        this.newNetWorth = newNetWorth;
        this.newMarketValue = newMarketValue;
        this.estabDay = estabDay;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getVname() {
        return Vname;
    }

    public void setVname(String vname) {
        Vname = vname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAnnuRate() {
        return annuRate;
    }

    public void setAnnuRate(double annuRate) {
        this.annuRate = annuRate;
    }

    public double getDayIncrease() {
        return dayIncrease;
    }

    public void setDayIncrease(double dayIncrease) {
        this.dayIncrease = dayIncrease;
    }

    public double getNewNetWorth() {
        return newNetWorth;
    }

    public void setNewNetWorth(double newNetWorth) {
        this.newNetWorth = newNetWorth;
    }

    public double getNewMarketValue() {
        return newMarketValue;
    }

    public void setNewMarketValue(double newMarketValue) {
        this.newMarketValue = newMarketValue;
    }

    public String getEstabDay() {
        return estabDay;
    }

    public void setEstabDay(String estabDay) {
        this.estabDay = estabDay;
    }
}
