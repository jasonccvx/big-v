package Servlet;

import Dao.profitRate;
import Service.addProfitRateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addProfitRateServlet")
public class addProfitRateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String comName=request.getParameter("comName");
        String time=request.getParameter("time");
        double realIncrease=Double.parseDouble(request.getParameter("realIncrease"));
        double referIncrease=Double.parseDouble(request.getParameter("referIncrease"));
        profitRate stage=new profitRate(comName,time,realIncrease,referIncrease);
        addProfitRateService serb=new addProfitRateService();
        boolean result=serb.addProfitRate(stage);

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
