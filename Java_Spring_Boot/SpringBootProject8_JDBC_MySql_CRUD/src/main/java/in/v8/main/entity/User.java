package in.v8.main.entity;

public class User {
	private String name, email, gender, city;
	
	public User() {}
	
	public User(String name, String email, String gender, String city) {
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.city = city;
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
		System.out.println("User Name: "+ this.name + "\t Email: " + this.email + "\t Gender: " + this.gender + "\t City: " + this.city);
	}
}
