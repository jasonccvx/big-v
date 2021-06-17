package Dao;

public class bigV {
    private String name;
    private int fansNUM;

    public bigV() {
    }

    public bigV(String name, int fansNUM) {
        this.name = name;
        this.fansNUM = fansNUM;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFansNUM() {
        return fansNUM;
    }

    public void setFansNUM(int fansNUM) {
        this.fansNUM = fansNUM;
    }
}
