package Servlet;

import Dao.bigV;
import Dao.combin;
import Service.getBigVArray;
import Service.getCombinArray;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/comListServlet")
public class comListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        getCombinArray com=new getCombinArray();
        ArrayList<combin> c=new ArrayList<>();
        c=com.getComArray();
        response.setContentType("text/html;charset=utf-8");
        JSONArray json= JSONArray.fromObject(c);
        PrintWriter writer =response.getWriter();
        writer.println(json);
        writer.flush();
        writer.close(); //关闭输出流
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
