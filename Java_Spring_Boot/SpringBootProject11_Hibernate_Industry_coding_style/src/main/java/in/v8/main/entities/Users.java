package in.v8.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table // same name as database table (if not exist Users name table than create as class name)
public class Users {
	@Column // variable name as field name
	@Id // variable as unique id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto generated id value 
	private long id;
	@Column
	private String name, email, password, gender, city;
	
	public Users() {} // default constructor

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public void displayUser() {
		System.out.println("User ID: "+ this.id +"\tName: "+ this.name + "\tEmail: " + this.email + "\tPassword" + this.password + "\t Gender: " + this.gender + "\t City: " + this.city);
	}
}
