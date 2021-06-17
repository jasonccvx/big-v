package Dao;

public class stageInf {
    private String comName;//
    private String timeQuantum;
    private double maxRec;
    private double SharpeRatio;
    private double Volatility;
    private double firstHeavyProp;//
    private double positiveProfitRate;//
    private double profitRec;
    private double conScore;

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public double getFirstHeavyProp() {
        return firstHeavyProp;
    }

    public void setFirstHeavyProp(double firstHeavyProp) {
        this.firstHeavyProp = firstHeavyProp;
    }

    public double getPositiveProfitRate() {
        return positiveProfitRate;
    }

    public void setPositiveProfitRate(double positiveProfitRate) {
        this.positiveProfitRate = positiveProfitRate;
    }

    public stageInf(String comName, String timeQuantum, double maxRec, double sharpeRatio, double volatility, double firstHeavyProp, double positiveProfitRate, double profitRec, double conScore) {
        this.comName = comName;
        this.timeQuantum = timeQuantum;
        this.maxRec = maxRec;
        SharpeRatio = sharpeRatio;
        Volatility = volatility;
        this.firstHeavyProp = firstHeavyProp;
        this.positiveProfitRate = positiveProfitRate;
        this.profitRec = profitRec;
        this.conScore = conScore;
    }

    public stageInf() {
    }

    public stageInf(String timeQuantum, double maxRec, double sharpeRatio, double volatility, double profitRec, double conScore) {
        this.timeQuantum = timeQuantum;
        this.maxRec = maxRec;
        SharpeRatio = sharpeRatio;
        Volatility = volatility;
        this.profitRec = profitRec;
        this.conScore = conScore;
    }

    public String getTimeQuantum() {
        return timeQuantum;
    }

    public void setTimeQuantum(String timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public double getMaxRec() {
        return maxRec;
    }

    public void setMaxRec(double maxRec) {
        this.maxRec = maxRec;
    }

    public double getSharpeRatio() {
        return SharpeRatio;
    }

    public void setSharpeRatio(double sharpeRatio) {
        SharpeRatio = sharpeRatio;
    }

    public double getVolatility() {
        return Volatility;
    }

    public void setVolatility(double volatility) {
        Volatility = volatility;
    }

    public double getProfitRec() {
        return profitRec;
    }

    public void setProfitRec(double profitRec) {
        this.profitRec = profitRec;
    }

    public double getConScore() {
        return conScore;
    }

    public void setConScore(double conScore) {
        this.conScore = conScore;
    }
}
