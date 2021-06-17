package Service;

import Dao.profit;
import Dao.profitDao;

import java.util.ArrayList;

public class getArrayOfProfit {
    public ArrayList<profit> getProArray(String com,String time1,String time2){
        profitDao pdao=new profitDao();
        return pdao.queryProfit2(com,time1,time2);
    }

}
