package Service;

import org.python.antlr.ast.Str;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class changeMouth {
    public String timeQuantum(int i){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String nowTime=dateFormat.format(date);
        String[]a=new String[]{};
        a= nowTime.split("/");
        String a1=a[0];String a2=a[1];String a3=a[2];
        a3=String.valueOf(Integer.parseInt(a3)-1);
        if(i==1){//近一年
            int temp=Integer.parseInt(a1)-1;
            a2=String.valueOf(Integer.parseInt(a2));
            a1=String.valueOf(temp);
        }
        if(i==2){//近6月
            int year=Integer.parseInt(a1);
            int mouth=Integer.parseInt(a2);
            if(mouth>6)mouth-=6;
            else {
                mouth=mouth+6;
                year-=1;
            }
            a1=String.valueOf(year);
            a2=String.valueOf(mouth);
        }
        if(i==3){//近3月
            int year=Integer.parseInt(a1);
            int mouth=Integer.parseInt(a2);
            if(mouth>3)mouth-=3;
            else {
                mouth=mouth+9;
                year-=1;
            }
            a1=String.valueOf(year);
            a2=String.valueOf(mouth);
        }
        if(i==4){//近1月
            int year=Integer.parseInt(a1);
            int mouth=Integer.parseInt(a2);
            if(mouth>1)mouth-=1;
            else {
                mouth=mouth+11;
                year-=1;
            }
            a1=String.valueOf(year);
            a2=String.valueOf(mouth);
        }
        if(Integer.parseInt(a2)<10)a2='0'+a2;
        if(Integer.parseInt(a3)<10)a3='0'+a3;
        return a1+'-'+a2+'-'+a3;
    }
//    public static void main(String[] args) {
//        changeMouth a=new changeMouth();
//        System.out.println(a.timeQuantum(1));
//        System.out.println(a.timeQuantum(2));
//        System.out.println(a.timeQuantum(3));
//        System.out.println(a.timeQuantum(4));
//    }
}
