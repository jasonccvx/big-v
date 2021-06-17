package Servlet;

import Dao.combin;
import Dao.nav;
import Dao.profit;
import Service.addCombinService;
import Service.addNavService;
import Service.addProfitService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

@WebServlet(name = "autoRun2")
public class autoRun2 extends HttpServlet {
    public void init(){

        //写入profit表
        Process proc4;
        try {
            ArrayList<String> all=new ArrayList<String>(){};
            proc4 = Runtime.getRuntime().exec("python C:\\code\\databaseTrainPython\\.idea\\database2\\main5.py");// 执行py文件
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc4.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                for (String retval: line.split(",|'|]| ")){
                    all.add(retval);
                }
            }
            String comName;
            String time;
            double income;
            profit pro=new profit();
            addProfitService serb=new addProfitService();
            for(int i=1,j=5,k=8;k<all.size();i+=9,j+=9,k+=9){
                comName=all.get(i);
                time=all.get(j);
                income=Double.parseDouble(all.get(k));
                pro.setComName(comName);
                pro.setTime(time);
                pro.setIncome(income);
                boolean result=serb.addProfit(pro);
            }

            in.close();
            proc4.waitFor();
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
