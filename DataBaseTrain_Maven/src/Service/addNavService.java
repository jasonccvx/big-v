package Service;

import Dao.nav;
import Dao.navDao;

public class addNavService {
    public boolean addNav(nav v){//调用Dao层增加nav
        navDao nav=new navDao();

        if(nav.isExist(v.getTime(),v.getComName())){
            System.out.println("该nav已存在");
            return false;

        }else{
            nav.addNav(v);
            return true;
        }
    }
}
