package spring.web.mvc.beans;

public class User {
	private String name, email, number; // variable name as form field name attribute value like name="email" than variable email
	
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number2) {
		this.number = number2;
	}
}
