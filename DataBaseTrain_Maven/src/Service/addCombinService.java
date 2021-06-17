package Service;

import Dao.bigV;
import Dao.combin;
import Dao.combinDao;
import Dao.vDao;

public class addCombinService {
    public boolean addCombin(combin v){//调用Dao层增加大V
        combinDao bigv=new combinDao();

        if(bigv.isExist(v.getComName())){
            System.out.println("组合已存在");
            return false;

        }else{
            bigv.addCombin(v);
            return true;
        }
    }
}
