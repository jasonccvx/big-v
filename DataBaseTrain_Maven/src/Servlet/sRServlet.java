package Servlet;

import Dao.sR;
import Service.changeMouth;
import Service.getSRArray;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/sRServlet")
public class sRServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        changeMouth mouth = new changeMouth();
        String index = String.valueOf(request.getParameter("index"));//获取当前的前1/3/6个月或1年的日期
        getSRArray s=new getSRArray();
        ArrayList<sR> sArray=s.getSRArray(index);
        response.setContentType("text/html;charset=utf-8");
        JSONArray json2 = JSONArray.fromObject(sArray);
        PrintWriter writer2 = response.getWriter();
        writer2.println(json2);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
