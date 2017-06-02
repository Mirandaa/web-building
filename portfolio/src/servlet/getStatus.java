package servlet;

import entity.UserInfoEntity;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by p on 2017/5/31.
 */
@WebServlet(name = "setStatus")
public class getStatus extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/javaScript; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        boolean isOk = false;
        UserInfoEntity entity = null;
        try {
            entity = (UserInfoEntity) request.getSession().getAttribute("user");
            isOk = entity != null;
        }
        catch (Exception e){
            e.printStackTrace();
            isOk = false;
        }
        finally {
            JSONObject object = new JSONObject();
            object.put("isOk",isOk);
            if (isOk){
                object.put("name",entity.getName());
            }
            else {
                object.put("name",null);
            }
            response.getWriter().write(object.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
