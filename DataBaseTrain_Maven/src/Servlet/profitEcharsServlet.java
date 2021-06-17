package Servlet;

import Dao.profit;
import Service.changeMouth;
import Service.getArrayOfProfit;
import Service.getNowDate;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/profitEcharsServlet")
public class profitEcharsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        changeMouth mouth=new changeMouth();
        String time=mouth.timeQuantum(Integer.parseInt(request.getParameter("index")));//获取当前的前1/3/6个月或1年的日期
        String comName=request.getParameter("bigv");
        getArrayOfProfit p=new getArrayOfProfit();
        getNowDate date=new getNowDate();//获取当前日期
        ArrayList<profit> pArray=p.getProArray(comName,time,date.getNowTime());
        response.setContentType("text/html;charset=utf-8");
        JSONArray json= JSONArray.fromObject(pArray);
        PrintWriter writer =response.getWriter();
        writer.println(json);
        writer.flush();
        writer.close(); //关闭输出流
        System.out.println("更新图标profit");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
