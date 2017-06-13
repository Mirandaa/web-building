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
    System.out.println(new Date().getTime());
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
