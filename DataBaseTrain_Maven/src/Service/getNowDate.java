package Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class getNowDate {
    public String getNowTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String nowTime=dateFormat.format(date);
        String[]a=new String[]{};
        a= nowTime.split("/");
        String a1=a[0];String a2=a[1];String a3=a[2];
        a3=String.valueOf(Integer.parseInt(a3)-1);
        if(Integer.parseInt(a3)<10)a3='0'+a3;
        return a1+'-'+a2+'-'+a3;

    }
}
