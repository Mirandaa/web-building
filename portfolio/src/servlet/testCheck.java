package servlet;

import entity.SessionInstance;
import entity.UserInfoEntity;
import entity.UserRiskAbilityEntity;
import net.sf.json.JSONObject;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        boolean isOk = false;
        String msg = "";
        try {
            UserRiskAbilityEntity entity = new UserRiskAbilityEntity();
            UserInfoEntity infoEntity = (UserInfoEntity)request.getSession().getAttribute("user");
            entity.setName(infoEntity.getName());
            int a = Integer.parseInt(request.getParameter("1"));
            risk += a;
            entity.setOption1(a);

            a = Integer.parseInt(request.getParameter("2"));
            risk += a;
            entity.setOption2(a);

            a = Integer.parseInt(request.getParameter("3"));
            risk += a;
            entity.setOption3(a);

            a = Integer.parseInt(request.getParameter("4"));
            risk += a;
            entity.setOption4(a);

            a = Integer.parseInt(request.getParameter("5"));
            risk += a;
            entity.setOption5(a);

            a = Integer.parseInt(request.getParameter("6"));
            risk += a;
            entity.setOption6(a);

            a = Integer.parseInt(request.getParameter("7"));
            risk += a;
            entity.setOption7(a);

            a = Integer.parseInt(request.getParameter("8"));
            risk += a;
            entity.setOption8(a);

            a = Integer.parseInt(request.getParameter("9"));
            risk += a;
            entity.setOption9(a);

            a = Integer.parseInt(request.getParameter("10"));
            risk += a;
            entity.setOption10(a);

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
            entity.setAbility(res);
            Session session = SessionInstance.getSession();
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(entity);
            transaction.commit();
            isOk = true;
        }catch (Exception e){
            e.printStackTrace();
            isOk = false;
            msg = "请先登录~";
        }
        finally {
            SessionInstance.closeSession();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("isOk",isOk);
            jsonObject.put("msg",msg);
            response.getWriter().print(jsonObject);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
