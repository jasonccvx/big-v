package Servlet;

import Dao.*;
import Service.*;
import util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

@WebServlet(name = "autoRun")
public class autoRun extends HttpServlet {
    public void init(){
        //写入stageinf表
        Process proc6;
        try {
            ArrayList<String> all=new ArrayList<String>(){};
            proc6 = Runtime.getRuntime().exec("python C:\\code\\databaseTrainPython\\.idea\\database2\\main7.py");// 执行py文件
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc6.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                for (String retval: line.split(",|'|]| ")){
                    all.add(retval);
                }
            }
            String comName;
            String timeQuantum;
            double maxRec;
            double SharpeRatio;
            double Volatility;
            double firstHeavyProp;
            double positiveProfitRate;
            double profitRec;
            double conScore;
            stageInf stage=new stageInf();
            addStageInfService serb=new addStageInfService();
            for(int i=1,j=4,k=7,l=11,a=15,b=19,c=23,d=27,e=31;e<all.size();i+=32,j+=32,k+=32,l+=32,a+=32,b+=32,c+=32,d+=32,e+=32){
                if(all.get(k).equals("--")){
                    i-=4;
                    j-=4;
                    k-=4;
                    l-=4;
                    a-=4;
                    b-=4;
                    c-=4;
                    d-=4;
                    e-=4;

                    continue;
                }
                comName=all.get(i);
                timeQuantum=all.get(j);
                maxRec=Double.parseDouble(all.get(k));
                SharpeRatio=Double.parseDouble(all.get(l));
                Volatility=Double.parseDouble(all.get(a));
                firstHeavyProp=Double.parseDouble(all.get(b));
                positiveProfitRate=Double.parseDouble(all.get(c));
                profitRec=Double.parseDouble(all.get(d));
                conScore=Double.parseDouble(all.get(e));
                stage.setComName(comName);
                stage.setTimeQuantum(timeQuantum);
                stage.setMaxRec(maxRec);
                stage.setSharpeRatio(SharpeRatio);
                stage.setVolatility(Volatility);
                stage.setFirstHeavyProp(firstHeavyProp);
                stage.setPositiveProfitRate(positiveProfitRate);
                stage.setProfitRec(profitRec);
                stage.setConScore(conScore);
                boolean result=serb.addStageInf(stage);
            }

            in.close();
            proc6.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       // 写入bigV表：参数：name，score
            Process proc;
            try {
                ArrayList<String> all=new ArrayList<String>(){};
                proc = Runtime.getRuntime().exec("python C:\\code\\databaseTrainPython\\.idea\\database2\\v_main_func.py");// 执行py文件
                //用输入输出流来截取结果
                BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                String line = null;
                while ((line = in.readLine()) != null) {
                    for (String retval: line.split(",|'|]| ")){
                        all.add(retval);
                    }
                }
                String name;
                int fansNUM;
                bigV stage=new bigV();
                addBigVService serb=new addBigVService();
                for(int i=1,j=4;i<all.size();i+=5,j+=5){
                    name=all.get(i);
                    fansNUM=Integer.parseInt((all.get(j)));
                    stage.setName(name);
                    stage.setFansNUM(fansNUM);
                    boolean result=serb.addBigV(stage);
                }

                in.close();
                proc.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        // 写入profitRate表
        Process proc2;
        try {
            ArrayList<String> all=new ArrayList<String>(){};
            proc2 = Runtime.getRuntime().exec("python C:\\code\\databaseTrainPython\\.idea\\database2\\main3.py");// 执行py文件
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc2.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                for (String retval: line.split(",|'|]| ")){
                    all.add(retval);
                }
            }
            String comName;
            String time;
            double realIncrease;
            double referIncrease;
            profitRate stage=new profitRate();
            addProfitRateService serb=new addProfitRateService();
            for(int i=1,j=5,k=8,l=10;l<all.size();i+=11,j+=11,k+=11,l+=11){
                comName=all.get(i);
                time=all.get(j);
                realIncrease=Double.parseDouble(all.get(k));
                referIncrease=Double.parseDouble(all.get(l));
                stage.setComName(comName);
                stage.setTime(time);
                stage.setRealIncrease(realIncrease);
                stage.setReferIncrease(referIncrease);
                boolean result=serb.addProfitRate(stage);
            }

            in.close();
            proc2.waitFor();
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
