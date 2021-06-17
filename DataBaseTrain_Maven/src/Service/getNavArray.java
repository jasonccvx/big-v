package Service;

import Dao.nav;
import Dao.navDao;
import Dao.profitRate;
import Dao.profitRateDao;

import java.util.ArrayList;

public class getNavArray {
    public ArrayList<nav> getNavArray(String com, String time1, String time2){
        navDao n=new navDao();
        return n.queryNavAll(com,time1,time2);
    }
}
