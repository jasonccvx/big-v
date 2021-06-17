package Dao;

public class sR {
    private double newMarketValue;
    private double SharpeRatio;

    public sR() {
    }

    public sR(double newMarketValue, double sharpeRatio) {
        this.newMarketValue = newMarketValue;
        SharpeRatio = sharpeRatio;
    }

    public double getNewMarketValue() {
        return newMarketValue;
    }

    public void setNewMarketValue(double newMarketValue) {
        this.newMarketValue = newMarketValue;
    }

    public double getSharpeRatio() {
        return SharpeRatio;
    }

    public void setSharpeRatio(double sharpeRatio) {
        SharpeRatio = sharpeRatio;
    }
}
