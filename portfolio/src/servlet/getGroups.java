package servlet;

import entity.GroupsEntity;
import entity.SessionInstance;
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
 * Created by p on 2017/6/6.
 */
@WebServlet(name = "getGroups")
public class getGroups extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/javaScript; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        boolean isOk = false;
        List res = null;
        try {
            Session session = SessionInstance.getSession();
            String query = "from GroupsEntity order by agree";
            Query query1 = session.createQuery(query);
            List<GroupsEntity> list = (List<GroupsEntity>) query1.list();
            System.out.println(list.size());
            res = list.subList(0,list.size()>6?6:list.size());
            isOk = true;
        }
        catch (Exception e){
            e.printStackTrace();
            isOk = false;
        }
        finally {
            SessionInstance.closeSession();
            JSONObject object = new JSONObject();
            object.put("isOk",isOk);
            object.put("count",res==null?0:res.size());
            object.put("list",res);
            response.getWriter().write(object.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
