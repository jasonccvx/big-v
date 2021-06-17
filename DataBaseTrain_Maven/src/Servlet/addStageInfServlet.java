package Servlet;

import Dao.stageInf;
import Service.addStageInfService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addStageInfServlet")
public class addStageInfServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String comName=request.getParameter("comName");
        String timeQuantum=request.getParameter("timeQuantum");
        double maxRec=Double.parseDouble(request.getParameter("maxRec"));
        double SharpeRatio=Double.parseDouble(request.getParameter("SharpeRatio"));
        double Volatility=Double.parseDouble(request.getParameter("Volatility"));
        double firstHeavyProp=Double.parseDouble(request.getParameter("firstHeavyProp"));
        double positiveProfitRate=Double.parseDouble(request.getParameter("positiveProfitRate"));
        double profitRec=Double.parseDouble(request.getParameter("profitRec"));
        double conScore=Double.parseDouble(request.getParameter("conScore"));
        stageInf stage=new stageInf(comName,timeQuantum,maxRec,SharpeRatio,Volatility,firstHeavyProp,positiveProfitRate,profitRec,conScore);
        addStageInfService serb=new addStageInfService();
        boolean result=serb.addStageInf(stage);
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        if(result){
            out.println("增加成功");

        }else{
            out.println("增加失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
