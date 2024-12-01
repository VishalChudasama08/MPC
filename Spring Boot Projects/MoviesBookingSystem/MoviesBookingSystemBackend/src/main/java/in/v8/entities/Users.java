package in.v8.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column(name = "first_name", nullable = false, length = 200)
	@NotBlank(message = "First Name is mandatory")
	private String firstName;
	
	@Column(name = "last_name", nullable = false, length = 200)
	@NotBlank(message = "Last Name is mandatory")
	private String lastName;
	
	@Column(name = "email", unique = true, nullable = false)
	@NotBlank(message = "Email is mandatory")
	private String email;
	
	@Column(name = "password", nullable = false, length = 255)
	@NotBlank(message = "Password is mandatory")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$", 
	         message = "Password must include at least one digit, one uppercase letter, and one special character")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // to allow the field to be populated via API calls but not included in responses.
	private String password;
	
	@Column(name = "mobile_number", nullable = false, length = 20)
	@NotBlank(message = "Mobile Number is mandatory")
	@Pattern(regexp = "^[0-9]{10,15}$", message = "Mobile Number must be 10 to 15 digits")
	private String mobileNumber;
	
	@Column(name = "created_date_time", nullable = false)
	@CreationTimestamp // Automatically populated with the current timestamp during creation
	private LocalDateTime createDateTime;
	
	@Column(name = "modify_date_time")
	@UpdateTimestamp // Automatically populated with the current timestamp during updates
	private LocalDateTime modifyDateTime;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getModifyDateTime() {
		return modifyDateTime;
	}

	public void setModifyDateTime(LocalDateTime modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}
}
