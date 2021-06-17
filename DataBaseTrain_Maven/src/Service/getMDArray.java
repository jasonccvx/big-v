package Service;

import Dao.mD;
import Dao.mDDao;
import Dao.nav;
import Dao.navDao;

import java.util.ArrayList;

public class getMDArray {
    public ArrayList<mD> getMDArray(String index){
        mDDao n=new mDDao();
        return n.queryMDAll(index);
    }
}
