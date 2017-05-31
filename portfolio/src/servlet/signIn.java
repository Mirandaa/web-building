package servlet;

import deal.MD5Util;
import entity.SessionInstance;
import entity.UserInfoEntity;
import net.sf.json.JSONObject;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by p on 2017/5/4.
 */
@WebServlet(name = "signIn")
public class signIn extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("name");
        String psw = request.getParameter("psw");
        boolean login = false;
        try {
            psw = MD5Util.md5Encode(psw);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.setContentType("text/javaScript; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");

        String data = "";

        Session session  = SessionInstance.getSession();
        String queryString = "from UserInfoEntity where name = ?";
        Query query = session.createQuery(queryString);
        query.setParameter(0,user);
        List<UserInfoEntity> list = (List<UserInfoEntity>)query.list();
        SessionInstance.closeSession();
        if (list.size() == 0){
            data = "name not found";
        }
        else {
            if (!psw.equals(list.get(0).getPsw())){
                data = "psw is error";
            }
            else {
                request.getSession().setAttribute("user",list.get(0));
                data = "success";
                login = true;
            }
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res",login);
        jsonObject.put("msg",data);
        response.getWriter().print(jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("123466");
    }
}
