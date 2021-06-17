package Service;

import Dao.bigV;
import Dao.combin;
import Dao.combinDao;
import Dao.vDao;

import java.util.ArrayList;

public class getCombinArray {

        public ArrayList<combin> getComArray(){
            combinDao v=new combinDao();
            return  v.queryCombinAll();
        }

}
