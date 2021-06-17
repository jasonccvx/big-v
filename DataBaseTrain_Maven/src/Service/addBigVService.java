package Service;

import Dao.bigV;
import Dao.vDao;

public class addBigVService {
    public boolean addBigV(bigV v){//调用Dao层增加大V
        vDao bigv=new vDao();

        if(bigv.isExist(v.getName())){
            System.out.println("此人已存在");
            return false;

        }else{
            bigv.addBigV(v);
            return true;
        }
    }
}
