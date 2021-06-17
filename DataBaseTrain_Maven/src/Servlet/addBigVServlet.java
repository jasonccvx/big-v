package Servlet;

import Dao.bigV;
import Service.addBigVService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addBigVServlet")
public class addBigVServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("name");
        int fansNUM=Integer.parseInt(request.getParameter("fansNUM"));
        bigV stage=new bigV(name,fansNUM);
        addBigVService serb=new addBigVService();
        boolean result=serb.addBigV(stage);

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
