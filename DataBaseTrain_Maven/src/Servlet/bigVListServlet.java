package Servlet;

import Dao.bigV;
import Dao.profit;
import Service.getArrayOfProfit;
import Service.getBigVArray;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/bigVListServlet")
public class bigVListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        getBigVArray v=new getBigVArray();
        ArrayList<bigV> vArray=v.getVArray();
        response.setContentType("text/html;charset=utf-8");
        JSONArray json= JSONArray.fromObject(vArray);
        PrintWriter writer =response.getWriter();
        writer.println(json);
        writer.flush();
        writer.close(); //关闭输出流
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
