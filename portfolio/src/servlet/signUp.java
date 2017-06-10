package servlet;

import deal.MD5Util;
import entity.SessionInstance;
import entity.UserInfoEntity;
import net.sf.json.JSONObject;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
@WebServlet(name = "signUp")
public class signUp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/javaScript; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        String name = request.getParameter("name");
        String psw = request.getParameter("psw");
        String email = request.getParameter("email");
        boolean sign = false;
        UserInfoEntity entity = new UserInfoEntity();
        entity.setName(name);
        entity.setEmail(email);
        try {
            //密码进行加密
            entity.setPsw(MD5Util.md5Encode(psw));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Session session  = SessionInstance.getSession();
        String queryString = "from UserInfoEntity where name = ?";
        Query query = session.createQuery(queryString);
        query.setParameter(0,name);
        List<UserInfoEntity> list = (List<UserInfoEntity>)query.list();
        String data = "";
        //判断用户名是否存在
        if (list.size() == 0) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
            sign = true;
        }
        else {
            data = "该用户名已被使用";
        }
        SessionInstance.closeSession();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res",sign);
        jsonObject.put("msg",data);
        response.getWriter().print(jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
