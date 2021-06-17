package Servlet;

import Dao.fansAndIncome;
import Dao.nav;
import Service.*;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/FIServlet")
public class FIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        getFIArray p = new getFIArray();
        getNowDate date = new getNowDate();//获取当前日期
        ArrayList<fansAndIncome> pArray = p.getFIArray(date.getNowTime());
        /*        ArrayList<fansAndIncome> pArray=p.getFIArray("2021-6-12");*/
        response.setContentType("text/html;charset=utf-8");
        JSONArray json = JSONArray.fromObject(pArray);
        PrintWriter writer = response.getWriter();
        writer.println(json);
        writer.flush();
        writer.close(); //关闭输出流

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
