package Service;

import Dao.*;

import java.util.ArrayList;

public class getProfitRateArray {
    public ArrayList<profitRate> getPRArray(String com, String time1, String time2){
        profitRateDao pdao=new profitRateDao();
        return pdao.queryProfitRateAll(com,time1,time2);
    }
}
