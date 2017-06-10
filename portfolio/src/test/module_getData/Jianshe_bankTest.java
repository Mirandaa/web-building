package test.module_getData; 

import entity.GroupsEntity;
import entity.ProductsEntity;
import entity.RelationProductGroupEntity;
import entity.SessionInstance;
import module_getData.Jianshe_bank;
import module_getData.Zhaoshang_bank;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/** 
* Jianshe_bank Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 23, 2017</pre> 
* @version 1.0 
*/ 
public class Jianshe_bankTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getInfo() 
* 
*/ 
@Test
public void testGetInfo() throws Exception { 
//TODO: Test goes here...
    //测试得到数据筛选过程
    Session session = SessionInstance.getSession();
    int money = 4;
    int day = 4;
    List res = new ArrayList();
    Long time = new Date().getTime();
    String hql_selectGua = "from ProductsEntity where guaranteed = true " +
            "and dateStart < ? and dateEnd > ? " +
            "and minMoney < ? and days < ? order by earn desc ";
    Query selectGua = session.createQuery(hql_selectGua);
    selectGua.setParameter(0, time);
    selectGua.setParameter(1, time);
    setParameter(money,day,selectGua);
    List<ProductsEntity> guaEntity = (List<ProductsEntity>) selectGua.list();
    guaEntity = guaEntity.subList(0, guaEntity.size() > 3 ? 3 : guaEntity.size());
    String hql_selectUngua = "from ProductsEntity where guaranteed = false and risk = 2" +
            "and dateStart < ? and dateEnd > ? " +
            "and minMoney < ? and days < ? order by earn desc ";
    Query selectUngua = session.createQuery(hql_selectUngua);
    selectUngua.setParameter(0, time);
    selectUngua.setParameter(1, time);
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
    System.out.println(res.subList(0,res.size()>5?5:res.size()));
}
    private void setParameter(int money,int day,Query query){
        switch (money) {
            case 0:
                query.setParameter(2, 1000.0);
                break;
            case 1:
                query.setParameter(2, 5000.0);
                break;
            case 2:
                query.setParameter(2, 10000.0);
                break;
            case 3:
                query.setParameter(2, 50000.0);
                break;
            case 4:
                query.setParameter(2, Double.MAX_VALUE);
                break;
        }
        switch (day) {
            case 0:
                query.setParameter(3, 30);
                break;
            case 1:
                query.setParameter(3, 150);
                break;
            case 2:
                query.setParameter(3, 365);
                break;
            case 3:
                query.setParameter(3, 365 * 3);
                break;
            case 4:
                query.setParameter(3, Integer.MAX_VALUE);
                break;
        }
    }

} 
