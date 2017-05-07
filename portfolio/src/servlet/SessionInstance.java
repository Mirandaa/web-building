package servlet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by p on 2017/5/4.
 */
public class SessionInstance {
    private static Configuration configuration;
    private static SessionFactory factory = buildFactory();
    private static Session session;

    public static Session getSession() {
        if (session == null){
            session = factory.openSession();
            return session;
        }
        else{
            return session;
        }
    }
    public static void closeSession(){
        if (session!=null)
            session.close();
    }
    private static SessionFactory buildFactory(){
        configuration = new Configuration();
        return configuration.configure().buildSessionFactory();
    }
}
