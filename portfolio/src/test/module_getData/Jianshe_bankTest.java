package test.module_getData; 

import entity.SessionInstance;
import module_getData.Guangda_bank;
import module_getData.Jianshe_bank;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;


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
    SessionInstance.getSession();
    SessionInstance.closeSession();
} 


} 
