package Servlet;

import Dao.profit;
import Service.addProfitService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addProfitServlet")
public class addProfitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String comName=request.getParameter("comName");
        String time=request.getParameter("time");
        double income=Double.parseDouble(request.getParameter("income"));
        profit pro=new profit(comName,time,income);
        addProfitService serb=new addProfitService();
        boolean result=serb.addProfit(pro);

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
