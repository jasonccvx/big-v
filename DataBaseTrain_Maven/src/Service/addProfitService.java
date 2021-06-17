package Service;

import Dao.profit;
import Dao.profitDao;

public class addProfitService {
    public boolean addProfit(profit v){//调用Dao层增加profit
        profitDao p=new profitDao();

        if(p.isExist(v.getTime(),v.getComName())){
            System.out.println("该profit已存在");
            return false;

        }else{
            p.addProfit(v);
            return true;
        }
    }
}
