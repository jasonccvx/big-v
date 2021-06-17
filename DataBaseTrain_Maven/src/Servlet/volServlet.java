package Servlet;

import Dao.vol;
import Service.changeMouth;
import Service.getMDArray;
import Service.getVolArray;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/volServlet")
public class volServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        changeMouth mouth = new changeMouth();
        String index = String.valueOf(request.getParameter("index"));//获取当前的前1/3/6个月或1年的日期
        getVolArray p = new getVolArray();
        ArrayList<vol> pArray =p.getVolArray(index);
        response.setContentType("text/html;charset=utf-8");
        JSONArray json = JSONArray.fromObject(pArray);
        PrintWriter writer = response.getWriter();
        writer.println(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
