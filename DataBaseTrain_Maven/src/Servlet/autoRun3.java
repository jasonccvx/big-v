package Servlet;

import Dao.combin;
import Service.addCombinService;
import Service.addNavService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

@WebServlet(name = "autoRun3")
public class autoRun3 extends HttpServlet {
    public void init(){

        //写入combin表
        Process proc5;
        try {
            ArrayList<String> all=new ArrayList<String>(){};
            proc5 = Runtime.getRuntime().exec("python C:\\code\\databaseTrainPython\\.idea\\database2\\main6.py");// 执行py文件
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc5.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                for (String retval: line.split(",|'|]| ")){
                    all.add(retval);
                }
            }
            String comName;
            String Vname;
            String type;
            double annuRate;
            double dayIncrease;
            double newNetWorth;
            double newMarketValue;
            String estabDay;
            combin stage=new combin();
            addCombinService serb=new addCombinService();
            for(int i=1,j=5,k=9,l=12,a=15,b=19,c=23,d=27;d<all.size();i+=28,j+=28,k+=28,l+=28,a+=28,b+=28,c+=28,d+=28){
                comName=all.get(i);
                Vname=all.get(j);
                type=all.get(k);
                annuRate=Double.parseDouble(all.get(l));
                dayIncrease=Double.parseDouble(all.get(a));
                newNetWorth=Double.parseDouble(all.get(b));
                newMarketValue=Double.parseDouble(all.get(c));
                estabDay=all.get(d);
                stage.setComName(comName);
                stage.setVname(Vname);
                stage.setType(type);
                stage.setAnnuRate(annuRate);
                stage.setDayIncrease(dayIncrease);
                stage.setNewNetWorth(newNetWorth);
                stage.setNewMarketValue(newMarketValue);
                stage.setEstabDay(estabDay);
                boolean result=serb.addCombin(stage);
            }

            in.close();
            proc5.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 写入nav表
        Process proc3;
        try {
            ArrayList<String> all=new ArrayList<String>(){};
            proc3 = Runtime.getRuntime().exec("python C:\\code\\databaseTrainPython\\.idea\\database2\\main4.py");// 执行py文件
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc3.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                for (String retval: line.split(",|'|]| ")){
                    all.add(retval);
                }
            }
            String comName;
            String time;
            double nav;
            double DailyIncrease;
            Dao.nav stage=new Dao.nav();
            addNavService serb=new addNavService();
            for(int i=1,j=5,k=8,l=10;l<all.size();i+=11,j+=11,k+=11,l+=11){
                comName=all.get(i);
                time=all.get(j);
                nav=Double.parseDouble(all.get(k));
                DailyIncrease=Double.parseDouble(all.get(l));
                stage.setComName(comName);
                stage.setTime(time);
                stage.setNav(nav);
                stage.setDailyIncrease(DailyIncrease);
                boolean result=serb.addNav(stage);
            }

            in.close();
            proc3.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
