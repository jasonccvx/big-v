package Service;

import Dao.fansAndIncome;
import Dao.fansAndIncomeDao;
import Dao.mDDao;

import java.util.ArrayList;

public class getFIArray {
    public ArrayList<fansAndIncome> getFIArray(String index){
        fansAndIncomeDao n=new fansAndIncomeDao();
        return n.queryFIAll(index);
    }
}
