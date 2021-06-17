package Service;

import Dao.bigV;
import Dao.vDao;

import java.util.ArrayList;

public class getBigVArray {
    public ArrayList<bigV> getVArray(){
        vDao v=new vDao();
        return  v.queryUserAll();
    }


}
