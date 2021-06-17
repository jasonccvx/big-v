package Service;

import Dao.sRDao;
import Dao.vol;
import Dao.volDao;

import java.util.ArrayList;

public class getVolArray {
    public ArrayList<vol> getVolArray(String index){
        volDao n=new volDao();
        return n.queryVolAll(index);
    }
}
