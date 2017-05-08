package servlet;

import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by p on 2017/5/7.
 */
@WebServlet(name = "testCheck")
public class testCheck extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/javaScript; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        int risk = 0;
        int res = 1;
        for (int i = 1; i < 11; i++) {
            String a = request.getParameter(i + "");
            System.out.println(a);
            risk += Integer.parseInt(a);
        }
        if (risk <= 15){
            res = 1;
        }
        else if (risk >= 16 && risk <= 20){
            res = 2;
        }
        else if (risk >= 21 && risk <= 30){
            res = 3;
        }
        else if (risk >= 31 && risk <= 38){
            res = 4;
        }
        else{
            res = 5;
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sco",risk);
        jsonObject.put("cla",res);
        response.getWriter().print(jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
