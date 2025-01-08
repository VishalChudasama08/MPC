package in.v8.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class HibernateConfig {
	@Bean
	public static SessionFactory getSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}
}
