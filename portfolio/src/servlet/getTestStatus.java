package servlet;

import entity.SessionInstance;
import entity.UserInfoEntity;
import entity.UserRiskAbilityEntity;
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
 * Created by p on 2017/6/2.
 */
@WebServlet(name = "getTestStatus")
public class getTestStatus extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/javaScript; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        boolean isOk = false;
        UserInfoEntity entity = null;
        UserRiskAbilityEntity abilityEntity = null;
        try {
            entity = (UserInfoEntity) request.getSession().getAttribute("user");
            if (entity == null){
                System.out.println("null");
            }
            System.out.println("name:" + entity.getName());
            Session session = SessionInstance.getSession();
            String query = "from UserRiskAbilityEntity where name = ?";
            Query query1 = session.createQuery(query);
            query1.setParameter(0,entity.getName());
            List<UserRiskAbilityEntity> list = (List<UserRiskAbilityEntity>) query1.list();
            if (list.size() == 0){
                isOk = false;
            }
            else {
                abilityEntity = list.get(0);
                isOk = true;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            isOk = false;
        }
        finally {
            SessionInstance.closeSession();
            JSONObject object = new JSONObject();
            object.put("isOk",isOk);
            if (isOk){
                object.put("ability",abilityEntity.getAbility());
                int x = 0;
                x += abilityEntity.getOption1();
                x += abilityEntity.getOption2();
                x += abilityEntity.getOption3();
                x += abilityEntity.getOption4();
                x += abilityEntity.getOption5();
                x += abilityEntity.getOption6();
                x += abilityEntity.getOption7();
                x += abilityEntity.getOption8();
                x += abilityEntity.getOption9();
                x += abilityEntity.getOption10();

                object.put("score",x);
            }
            else {
                object.put("ability",null);
                object.put("score",null);
            }
            response.getWriter().write(object.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
