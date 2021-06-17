package Servlet;

import Dao.nav;
import Service.addNavService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addNavServlet")
public class addNavServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String comName=request.getParameter("comName");
        String time=request.getParameter("time");
        double nav=Double.parseDouble(request.getParameter("nav"));
        double DailyIncrease=Double.parseDouble(request.getParameter("DailyIncrease"));
        nav stage=new nav(comName,time,nav,DailyIncrease);
        addNavService serb=new addNavService();
        boolean result=serb.addNav(stage);

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
