package in.v8.main.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import in.v8.main.HibernateConfig;
import in.v8.main.entities.Users;

@Service
public class UserServiceImpl implements UserService {
	
	@Override
	public Users login(String email, String password) {
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
		    String hql = "from Users where email = :email";
		    Users validUser = session.createQuery(hql, Users.class)
		    						.setParameter("email", email)
		    						.uniqueResult();
		    
		    if (validUser != null && validUser.getPassword().equals(password)) {
		    	validUser.setPassword(""); // remove password
		    	validUser.setCreateDate(null); // remove date
		    	return validUser;
		    } else {
		    	return null;
		    }
		}
	}

	@Override
	public int createUser(Users user) {
		Transaction transaction = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
		    String hql = "select count(*) from Users where email = :email";
		    Long count = session.createQuery(hql, Long.class)
		                        .setParameter("email", user.getEmail())
		                        .uniqueResult();
		    boolean exists = count > 0; // if user exist than true 
		    if(!exists) { // user not exist than save
		    	session.save(user);
				transaction.commit();	
		    	return 1;
		    } else {
		    	System.out.println("Yser not save becauae user Exists: " + exists + " : " + user.getEmail());
		    	return 0;
		    }
		} catch (Exception e) {
		    if (transaction != null) transaction.rollback();
		    e.printStackTrace();
		    return 0;
		}
	}

	@Override
	public Users updateUser(Long id, Users newUser) {
		Transaction transaction = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			Users user = session.get(Users.class, id);
			
			if(user != null) {
				newUser.setId(user.getId());
				newUser.setPassword(user.getPassword());
				newUser.setCreateDate(user.getCreateDate());
				
				session.merge(newUser); // Merge updates an entity if it exists
	            transaction.commit();
	            return newUser;
			} else {
				throw new RuntimeException("User not found with id:"+ id);
			}
		} catch (Exception e) {
	        if (transaction != null) transaction.rollback();
	        e.printStackTrace();
	        newUser.setFirstName(e.getMessage()); // Indicate an error
	        return newUser;
	    }
	}

	@Override
	public String deleteUser(Long id) {
		Transaction transaction = null;
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
		    transaction = session.beginTransaction();
		    Users user = session.get(Users.class, id); // get this note by id
		    if (user != null) { // user have ? than delete
		        session.delete(user);
		        transaction.commit();
		        return "User deleted successfully";
		    }
		} catch (Exception e) {
		    if (transaction != null) transaction.rollback();
		    e.getMessage();
		}
		return "User not deleted or User not Found."; // Check provided id's user exist!
	}

}
