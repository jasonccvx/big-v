package Service;

import Dao.profitRate;
import Dao.profitRateDao;

public class addProfitRateService {
    public boolean addProfitRate(profitRate v){//调用Dao层增加profitRate
        profitRateDao p=new profitRateDao();

        if(p.isExist(v.getTime(),v.getComName())){
            System.out.println("该profitRate已存在"+v.getTime()+v.getComName());
            return false;

        }else{
            p.addProfitRate(v);
            return true;
        }
    }
}
