package Dao;

public class mD {
    private double newMarketValue;
    private double maxRec;

    public mD() {
    }

    public mD(double newMarketValue, double maxRec) {
        this.newMarketValue = newMarketValue;
        this.maxRec = maxRec;
    }

    public double getNewMarketValue() {
        return newMarketValue;
    }

    public void setNewMarketValue(double newMarketValue) {
        this.newMarketValue = newMarketValue;
    }

    public double getMaxRec() {
        return maxRec;
    }

    public void setMaxRec(double maxRec) {
        this.maxRec = maxRec;
    }
}
