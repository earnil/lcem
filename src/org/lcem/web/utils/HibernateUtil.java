package org.lcem.web.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	Configuration cfg = new Configuration().configure();
        	StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();        	
        	ssrb.applySettings(cfg.getProperties());     
            return cfg.buildSessionFactory(ssrb.build());
        }
        catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}