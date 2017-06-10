package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Session单例类
 * Created by p on 2017/5/4.
 */
public class SessionInstance {
    private static Configuration configuration;
    private static SessionFactory factory = buildFactory();
    private static Session session;

    /**
     * 得到Session
     * @return Session
     */
    public static Session getSession() {
        if (session == null||!session.isOpen()){
            System.out.println("new session");
            session = factory.openSession();
            return session;
        }
        else{
            return session;
        }
    }

    /**
     * 关闭Session
     */
    public static void closeSession(){
        if (session!=null && session.isOpen()) {
            session.close();
            System.out.println("close session");
        }
    }
    private static SessionFactory buildFactory(){
        configuration = new Configuration();
        return configuration.configure().buildSessionFactory();
    }
}
