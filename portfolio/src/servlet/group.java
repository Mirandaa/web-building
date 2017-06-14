package servlet;

import entity.*;
import net.sf.json.JSONObject;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.jetbrains.annotations.NotNull;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by p on 2017/6/6.
 */
@WebServlet(name = "group")
public class group extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/javaScript; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        boolean isOk = false;
        List res = new ArrayList();
        try {
            //得到参数
            int day = Integer.parseInt(request.getParameter("day"));
            int money = Integer.parseInt(request.getParameter("money"));
            //得到当前用户信息，及测试信息
            UserInfoEntity entity = (UserInfoEntity) request.getSession().getAttribute("user");
            Session session = SessionInstance.getSession();
            String query = "from UserRiskAbilityEntity where name = ?";
            Query query1 = session.createQuery(query);
            query1.setParameter(0,entity.getName());
            List<UserRiskAbilityEntity> list = (List<UserRiskAbilityEntity>) query1.list();
            UserRiskAbilityEntity abilityEntity = list.get(0);

            //根据测试等级，以及参数信息，对用户进行组合
            switch (abilityEntity.getAbility()){
                case 1:
                    res = getDate1(session,day,money);
                    isOk = true;
                    break;
                case 2:
                    res = getDate2(session,day,money);
                    isOk = true;
                    break;
                case 3:
                    res = getDate3(session,day,money);
                    isOk = true;
                    break;
                case 4:
                    res = getDate4(session,day,money);
                    isOk = true;
                    break;
                case 5:
                    res = getDate5(session,day,money);
                    isOk = true;
                    break;
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
            object.put("count",res==null?0:res.size());
            object.put("list",res);
            response.getWriter().write(object.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private List getDate1(Session session,int day,int money){
        System.out.println("1111");
        System.out.println(day);
        System.out.println(money);
        List res = new ArrayList();
        Long time = new Date().getTime();
        System.out.println(time);
        //得到无风险的理财产品
        String query_temp1 = "from ProductsEntity where risk = 1 and guaranteed = true and save = false " +
                "and minMoney < ? and days < ? order by earn desc ";
        Query query1_temp1 = session.createQuery(query_temp1);
//        query1_temp1.setParameter(0, time);
//        query1_temp1.setParameter(1, time);
        setParameter(money,day,query1_temp1);
        List<ProductsEntity> productsEntities = (List<ProductsEntity>) query1_temp1.list();
        productsEntities = productsEntities.subList(0, productsEntities.size() > 5 ? 5 : productsEntities.size());
        for (int i = 0; i < productsEntities.size(); i++) {

            ProductsEntity product = productsEntities.get(i);
            GroupsEntity entity1 = new GroupsEntity();
            entity1.setName("安心计划");
            entity1.setDays(product.getDays());
            entity1.setAgree(0);
            entity1.setMinMoney(product.getMinMoney());
            entity1.setType(1);
            //计算年利率
            entity1.setYearRate(product.getEarn() * 0.8 + 1.75 * 0.2);
            Transaction transaction = session.beginTransaction();
            //存放组合信息
            session.save(entity1);
            entity1.setName(entity1.getName() + entity1.getId());
            session.update(entity1);
            //在关系表中，存放组合和产品之间的关系
            RelationProductGroupEntity relationEntity1 = new RelationProductGroupEntity();
            relationEntity1.setGroupId(entity1.getId());
            relationEntity1.setProductId(product.getId());
            session.save(relationEntity1);
            RelationProductGroupEntity relationEntity2 = new RelationProductGroupEntity();
            relationEntity2.setGroupId(entity1.getId());
            relationEntity2.setProductId(100000001);
            session.save(relationEntity2);
            transaction.commit();
            res.add(entity1);
        }
        return res;
    }

    private List getDate2(Session session, int day, int money){
        List res = new ArrayList();
        Long time = new Date().getTime();
        //选择保本的理财产品
        String hql_selectGua = "from ProductsEntity where guaranteed = true and save = false " +
                "and minMoney < ? and days < ? order by earn desc ";
        Query selectGua = session.createQuery(hql_selectGua);
//        selectGua.setParameter(0, time);
//        selectGua.setParameter(1, time);
        setParameter(money,day,selectGua);
        List<ProductsEntity> guaEntity = (List<ProductsEntity>) selectGua.list();
        guaEntity = guaEntity.subList(0, guaEntity.size() > 3 ? 3 : guaEntity.size());
        //选择低风险的产品groups
        String hql_selectUngua = "from ProductsEntity where guaranteed = false and risk = 2 and save = false " +
                "and minMoney < ? and days < ? order by earn desc ";
        Query selectUngua = session.createQuery(hql_selectUngua);
//        selectUngua.setParameter(0, time);
//        selectUngua.setParameter(1, time);
        setParameter(money,day,selectUngua);
        List<ProductsEntity> unGuaEntity = (List<ProductsEntity>) selectUngua.list();
        unGuaEntity = unGuaEntity.subList(0, unGuaEntity.size() > 3 ? 3 : unGuaEntity.size());
        //进行组合并且保存相关信息
        for (int i = 0; i < guaEntity.size(); i++) {
            for (int j = 0; j < unGuaEntity.size(); j++){
                ProductsEntity gua = guaEntity.get(i);
                ProductsEntity unGua = unGuaEntity.get(j);
                GroupsEntity entity1 = new GroupsEntity();
                entity1.setName("有一点不安心计划");
                entity1.setDays(gua.getDays()>unGua.getDays()?gua.getDays():unGua.getDays());
                entity1.setAgree(0);
                entity1.setMinMoney(gua.getMinMoney() > unGua.getMinMoney()?gua.getMinMoney():unGua.getMinMoney());
                entity1.setType(1);
                entity1.setYearRate(gua.getEarn() * 0.8 + unGua.getEarn() * 0.2);
                Transaction transaction = session.beginTransaction();
                session.save(entity1);
                entity1.setName(entity1.getName() + entity1.getId());
                session.update(entity1);
                RelationProductGroupEntity relationEntity1 = new RelationProductGroupEntity();
                relationEntity1.setGroupId(entity1.getId());
                relationEntity1.setProductId(gua.getId());
                System.out.println(relationEntity1.getGroupId());
                System.out.println(relationEntity1.getProductId());
                session.save(relationEntity1);
                RelationProductGroupEntity relationEntity2 = new RelationProductGroupEntity();
                relationEntity2.setGroupId(entity1.getId());
                relationEntity2.setProductId(unGua.getId());

                System.out.println(relationEntity2.getGroupId());
                System.out.println(relationEntity2.getProductId());
                session.save(relationEntity2);
                transaction.commit();
                res.add(entity1);
            }
        }
        return res.subList(0,res.size()>5?5:res.size());
    }

    private List getDate3(Session session, int day, int money){
        List res = new ArrayList();
        Long time = new Date().getTime();
        String hql_selectGua = "from ProductsEntity where guaranteed = false and risk = 2 " +
                "and save = false and minMoney < ? " +
                "and days < ? order by earn desc ";
        Query selectGua = session.createQuery(hql_selectGua);
//        selectGua.setParameter(0, time);
//        selectGua.setParameter(1, time);
        setParameter(money,day,selectGua);
        List<ProductsEntity> guaEntity = (List<ProductsEntity>) selectGua.list();
        guaEntity = guaEntity.subList(0, guaEntity.size() > 3 ? 3 : guaEntity.size());
        String hql_selectUngua = "from ProductsEntity where guaranteed = false and risk = 3 and save = false " +
                "and minMoney < ? and days < ? order by earn desc ";
        Query selectUngua = session.createQuery(hql_selectUngua);
//        selectUngua.setParameter(0, time);
//        selectUngua.setParameter(1, time);
        setParameter(money,day,selectUngua);
        setParameter(money,day,selectGua);
        List<ProductsEntity> unGuaEntity = (List<ProductsEntity>) selectUngua.list();
        unGuaEntity = unGuaEntity.subList(0, unGuaEntity.size() > 3 ? 3 : unGuaEntity.size());
        for (int i = 0; i < guaEntity.size(); i++) {
            for (int j = 0; j < unGuaEntity.size(); j++){
                ProductsEntity gua = guaEntity.get(i);
                ProductsEntity unGua = unGuaEntity.get(j);
                GroupsEntity entity1 = new GroupsEntity();
                entity1.setName("有两点不安心计划");
                entity1.setDays(gua.getDays()>unGua.getDays()?gua.getDays():unGua.getDays());
                entity1.setAgree(0);
                entity1.setMinMoney(gua.getMinMoney() > unGua.getMinMoney()?gua.getMinMoney():unGua.getMinMoney());
                entity1.setType(1);
                entity1.setYearRate(gua.getEarn() * 0.8 + unGua.getEarn() * 0.2);
                Transaction transaction = session.beginTransaction();
                session.save(entity1);
                entity1.setName(entity1.getName() + entity1.getId());
                session.update(entity1);
                RelationProductGroupEntity relationEntity1 = new RelationProductGroupEntity();
                relationEntity1.setGroupId(entity1.getId());
                relationEntity1.setProductId(gua.getId());
                System.out.println(relationEntity1.getGroupId());
                System.out.println(relationEntity1.getProductId());
                session.save(relationEntity1);
                RelationProductGroupEntity relationEntity2 = new RelationProductGroupEntity();
                relationEntity2.setGroupId(entity1.getId());
                relationEntity2.setProductId(unGua.getId());

                System.out.println(relationEntity2.getGroupId());
                System.out.println(relationEntity2.getProductId());
                session.save(relationEntity2);
                transaction.commit();
                res.add(entity1);
            }
        }
        return res.subList(0,res.size()>5?5:res.size());
    }

    private List getDate4(Session session, int day, int money){
        List res = new ArrayList();
        Long time = new Date().getTime();
        String hql_selectGua = "from ProductsEntity where guaranteed = false and risk = 3 and save = false " +
                "and minMoney < ? and days < ? order by earn desc ";
        Query selectGua = session.createQuery(hql_selectGua);
//        selectGua.setParameter(0, time);
//        selectGua.setParameter(1, time);
        setParameter(money,day,selectGua);
        List<ProductsEntity> guaEntity = (List<ProductsEntity>) selectGua.list();
        guaEntity = guaEntity.subList(0, guaEntity.size() > 3 ? 3 : guaEntity.size());
        String hql_selectUngua = "from ProductsEntity where guaranteed = false and risk = 4 and save = false " +
                "and minMoney < ? and days < ? order by earn desc ";
        Query selectUngua = session.createQuery(hql_selectUngua);
//        selectUngua.setParameter(0, time);
//        selectUngua.setParameter(1, time);
        setParameter(money,day,selectUngua);
        setParameter(money,day,selectGua);
        List<ProductsEntity> unGuaEntity = (List<ProductsEntity>) selectUngua.list();
        unGuaEntity = unGuaEntity.subList(0, unGuaEntity.size() > 3 ? 3 : unGuaEntity.size());
        for (int i = 0; i < guaEntity.size(); i++) {
            for (int j = 0; j < unGuaEntity.size(); j++){
                ProductsEntity gua = guaEntity.get(i);
                ProductsEntity unGua = unGuaEntity.get(j);
                GroupsEntity entity1 = new GroupsEntity();
                entity1.setName("有三点不安心计划");
                entity1.setDays(gua.getDays()>unGua.getDays()?gua.getDays():unGua.getDays());
                entity1.setAgree(0);
                entity1.setMinMoney(gua.getMinMoney() > unGua.getMinMoney()?gua.getMinMoney():unGua.getMinMoney());
                entity1.setType(1);
                entity1.setYearRate(gua.getEarn() * 0.8 + unGua.getEarn() * 0.2);
                Transaction transaction = session.beginTransaction();
                session.save(entity1);
                entity1.setName(entity1.getName() + entity1.getId());
                session.update(entity1);
                RelationProductGroupEntity relationEntity1 = new RelationProductGroupEntity();
                relationEntity1.setGroupId(entity1.getId());
                relationEntity1.setProductId(gua.getId());
                System.out.println(relationEntity1.getGroupId());
                System.out.println(relationEntity1.getProductId());
                session.save(relationEntity1);
                RelationProductGroupEntity relationEntity2 = new RelationProductGroupEntity();
                relationEntity2.setGroupId(entity1.getId());
                relationEntity2.setProductId(unGua.getId());

                System.out.println(relationEntity2.getGroupId());
                System.out.println(relationEntity2.getProductId());
                session.save(relationEntity2);
                transaction.commit();
                res.add(entity1);
            }
        }
        return res.subList(0,res.size()>5?5:res.size());
    }

    private List getDate5(Session session, int day, int money){
        List res = new ArrayList();
        Long time = new Date().getTime();
        String hql_selectGua = "from ProductsEntity where guaranteed = false and risk = 4 and save = false" +
                "and minMoney < ? and days < ? order by earn desc ";
        Query selectGua = session.createQuery(hql_selectGua);
//        selectGua.setParameter(0, time);
//        selectGua.setParameter(1, time);
        setParameter(money,day,selectGua);
        List<ProductsEntity> guaEntity = (List<ProductsEntity>) selectGua.list();
        guaEntity = guaEntity.subList(0, guaEntity.size() > 3 ? 3 : guaEntity.size());
        String hql_selectUngua = "from ProductsEntity where guaranteed = false and risk = 5 and save = false " +
                "and minMoney < ? and days < ? order by earn desc ";
        Query selectUngua = session.createQuery(hql_selectUngua);
//        selectUngua.setParameter(0, time);
//        selectUngua.setParameter(1, time);
        setParameter(money,day,selectUngua);
        setParameter(money,day,selectGua);
        List<ProductsEntity> unGuaEntity = (List<ProductsEntity>) selectUngua.list();
        unGuaEntity = unGuaEntity.subList(0, unGuaEntity.size() > 3 ? 3 : unGuaEntity.size());
        for (int i = 0; i < guaEntity.size(); i++) {
            for (int j = 0; j < unGuaEntity.size(); j++){
                ProductsEntity gua = guaEntity.get(i);
                ProductsEntity unGua = unGuaEntity.get(j);
                GroupsEntity entity1 = new GroupsEntity();
                entity1.setName("有一点不安心计划");
                entity1.setDays(gua.getDays()>unGua.getDays()?gua.getDays():unGua.getDays());
                entity1.setAgree(0);
                entity1.setMinMoney(gua.getMinMoney() > unGua.getMinMoney()?gua.getMinMoney():unGua.getMinMoney());
                entity1.setType(1);
                entity1.setYearRate(gua.getEarn() * 0.8 + unGua.getEarn() * 0.2);
                Transaction transaction = session.beginTransaction();
                session.save(entity1);
                entity1.setName(entity1.getName() + entity1.getId());
                session.update(entity1);
                RelationProductGroupEntity relationEntity1 = new RelationProductGroupEntity();
                relationEntity1.setGroupId(entity1.getId());
                relationEntity1.setProductId(gua.getId());
                System.out.println(relationEntity1.getGroupId());
                System.out.println(relationEntity1.getProductId());
                session.save(relationEntity1);
                RelationProductGroupEntity relationEntity2 = new RelationProductGroupEntity();
                relationEntity2.setGroupId(entity1.getId());
                relationEntity2.setProductId(unGua.getId());

                System.out.println(relationEntity2.getGroupId());
                System.out.println(relationEntity2.getProductId());
                session.save(relationEntity2);
                transaction.commit();
                res.add(entity1);
            }
        }
        return res.subList(0,res.size()>5?5:res.size());
    }

    private void setParameter(int money,int day,Query query){
        System.out.println(day);
        System.out.println(money);
        switch (money) {
            case 0:
                query.setParameter(0, 1000.0);
                break;
            case 1:
                query.setParameter(0, 5000.0);
                break;
            case 2:
                query.setParameter(0, 10000.0);
                break;
            case 3:
                query.setParameter(0, 50000.0);
                break;
            case 4:
                query.setParameter(0, Double.MAX_VALUE);
                break;
        }
        switch (day) {
            case 0:
                query.setParameter(1, 30);
                break;
            case 1:
                query.setParameter(1, 150);
                break;
            case 2:
                query.setParameter(1, 365);
                break;
            case 3:
                query.setParameter(1, 365 * 3);
                break;
            case 4:
                query.setParameter(1, Integer.MAX_VALUE);
                break;
        }
    }
}

