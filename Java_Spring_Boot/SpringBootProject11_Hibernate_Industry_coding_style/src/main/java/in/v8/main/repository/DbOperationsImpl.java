package in.v8.main.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import in.v8.main.config.HibernateConfig;
import in.v8.main.entities.Users;

@Repository
public class DbOperationsImpl implements DbOperations {

	@Override
	public Users getUserDetails(Long id) {
		Users user = null; 
		
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			user = session.get(Users.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
