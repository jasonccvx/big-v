package Servlet;

import Dao.combin;
import Dao.mD;
import Dao.nav;
import Dao.sR;
import Service.*;
import net.sf.json.JSONArray;
import org.python.antlr.ast.Index;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/boxEcharsServlet")
public class boxEcharsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        changeMouth mouth = new changeMouth();
        String index = String.valueOf(request.getParameter("index"));//获取当前的前1/3/6个月或1年的日期
        getMDArray p = new getMDArray();
        ArrayList<mD> pArray =p.getMDArray(index);
        response.setContentType("text/html;charset=utf-8");
        JSONArray json = JSONArray.fromObject(pArray);
        PrintWriter writer = response.getWriter();
        writer.println(json);

/*
        getSRArray s=new getSRArray();
        ArrayList<sR> sArray=s.getSRArray(index);
        response.setContentType("text/html;charset=utf-8");
        JSONArray json2 = JSONArray.fromObject(sArray);
        PrintWriter writer2 = response.getWriter();
        writer2.println(json2);
*/


        writer.flush();
        writer.close(); //关闭输出流
/*        writer2.flush();
        writer2.close();*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
