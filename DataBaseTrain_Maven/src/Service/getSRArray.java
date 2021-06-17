package Service;

import Dao.mDDao;
import Dao.sR;
import Dao.sRDao;

import java.util.ArrayList;

public class getSRArray {
    public ArrayList<sR> getSRArray(String index){
        sRDao n=new sRDao();
        return n.querySRAll(index);
    }
}
