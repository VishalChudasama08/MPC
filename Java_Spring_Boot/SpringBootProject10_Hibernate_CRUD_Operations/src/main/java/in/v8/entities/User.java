package in.v8.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table // same name as database table 
public class User {
	
	@Column // this name crate table column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto generated id 
	private long id; 

	@Column
	private String name, email, gender, city;
	
	public User() {} // default constructor
	
	public User(String name, String email, String gender, String city) {
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.city = city;
	}
	
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
		System.out.println("User ID: "+ this.id +"\tName: "+ this.name + "\tEmail: " + this.email + "\t Gender: " + this.gender + "\t City: " + this.city);
	}
}
