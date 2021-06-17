package Service;

import Dao.stageInf;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class getPythonPath {

    public String path() {
//        File f = new File(this.getClass().getResource("/").getPath());
//
//        String p=String.valueOf(f);
//        System.out.println(p);
        Process procP;
        String x=new String();
        try {
            procP = Runtime.getRuntime().exec("python databaseTrainPython\\.idea\\database2\\path.py");// 执行py文件
            //用输入输出流来截取结果
            ArrayList<String>a=new ArrayList<>();
            String[]a2=new String[10];
            int i=0;
            BufferedReader in = new BufferedReader(new InputStreamReader(procP.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                   a2[i]=line;i++;
            }
            for(int k=0;k<i;k++){
                if(a2[k].equals("databaseTrainPython")){i=k;break;}
            }
            for(int t=0;t<i;t++){
                x=x+a2[t]+"\\";
            }

            in.close();
            procP.waitFor();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return x;
    }

}
