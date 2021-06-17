package Dao;

public class vol {
    private double newMarketValue;
    private double Volatility;

    public double getNewMarketValue() {
        return newMarketValue;
    }

    public void setNewMarketValue(double newMarketValue) {
        this.newMarketValue = newMarketValue;
    }

    public double getVolatility() {
        return Volatility;
    }

    public void setVolatility(double volatility) {
        Volatility = volatility;
    }

    public vol() {
    }

    public vol(double newMarketValue, double volatility) {
        this.newMarketValue = newMarketValue;
        Volatility = volatility;
    }
}
