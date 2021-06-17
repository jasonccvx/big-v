package Servlet;

import Dao.combin;
import Dao.nav;
import Service.addCombinService;
import Service.addNavService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addCombinServlet")
public class addCombinServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String comName=request.getParameter("comName");
        String Vname=request.getParameter("Vname");
        String type=request.getParameter("type");
        double annuRate=Double.parseDouble(request.getParameter("annuRate"));
        double dayIncrease=Double.parseDouble(request.getParameter("dayIncrease"));
        double newNetWorth=Double.parseDouble(request.getParameter("newNetWorth"));
        double newMarketValue=Double.parseDouble(request.getParameter("newMarketValue"));
        String estabDay=request.getParameter("estabDay");
        combin stage=new combin(comName,Vname,type,annuRate,dayIncrease,newNetWorth,newMarketValue,estabDay);
        addCombinService serb=new addCombinService();
        boolean result=serb.addCombin(stage);

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
