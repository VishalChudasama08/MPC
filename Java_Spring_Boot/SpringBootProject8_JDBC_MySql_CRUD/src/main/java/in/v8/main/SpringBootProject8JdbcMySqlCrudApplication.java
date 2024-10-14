package in.v8.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.v8.main.dao.UserCrudOperationsDOA;
import in.v8.main.entity.User;

@SpringBootApplication
public class SpringBootProject8JdbcMySqlCrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject8JdbcMySqlCrudApplication.class, args);
	}
	
	@Autowired
	private UserCrudOperationsDOA userCrud;

	@Override
	public void run(String... args) throws Exception {
//		//----------Insert Operation------------------------------------------------------------------
//		User user = new User("Vishal", "vishal@gmail.com", "male", "Rajkot");
//		User user = new User("Darshan", "darshan@gmail.com", "male", "Rajkot");
//		boolean status = userCrud.insertUser(user);
//		System.out.println(status ? "Record Insert Successfully" : "Record Not Inserted");
		
//		// ----------Update Operation------------------------------------------------------------------
//		User user = new User("Vishal", "vishal@gmail.com", "male", "Kotadiya");
//		boolean status = userCrud.updateUser(user);
//		System.out.println(status ? "Record Update Successfully" : "Record Not Updated");
		
		// ----------Update Operation Dynamic----------------------------------------------------------
		User user = userCrud.getUserByEmail("vishal@gmail.com");
		user.setCity("Kotaditya"); // this updated, and that updated object insert in data base
		boolean status = userCrud.updateUser(user);
		System.out.println(status ? "Record Update Successfully" : "Record Not Updated");
		
//		// ----------Delete Operation------------------------------------------------------------------
//		boolean status = userCrud.deleteUserByEmail("darshan@gmail.com");
//		System.out.println(status ? "Record Delete Successfully" : "Record Not Deleted");
		
//		// ----------Select Operation------------------------------------------------------------------
//		User user = userCrud.getUserByEmail("vishal@gmail.com");
//		user.displayUser();
		
		// ----------Select All Data ------------------------------------------------------------------
		List<User> userList = userCrud.getAllUsers(); // get user data in user object list 
		for (User u : userList) {
			u.displayUser();
		}
	}

}
