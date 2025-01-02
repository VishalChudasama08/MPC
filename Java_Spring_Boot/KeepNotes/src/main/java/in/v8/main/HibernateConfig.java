package in.v8.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
	public static SessionFactory getSessionFactory() {
		Configuration cfg = new Configuration();
        cfg.configure("in/v8/main/hibernate.cfg.xml");
        
		return cfg.buildSessionFactory();
	}
}
