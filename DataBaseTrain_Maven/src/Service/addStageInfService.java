package Service;

import Dao.stageInf;
import Dao.stageInfDao;

public class addStageInfService {
    public boolean addStageInf(stageInf v){//调用Dao层增加profit
        stageInfDao p=new stageInfDao();

        if(p.isExist(v.getTimeQuantum(),v.getComName())){
            System.out.println("该stageInf已存在");
            return false;

        }else{
            p.addstageInf(v);
            return true;
        }
    }
}
