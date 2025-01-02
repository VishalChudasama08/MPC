package in.v8.main.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table
public class Notes {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_id", nullable = false)
	private Long userId;
	@Column
	private String title;
	@Column
	private String description;
	
	@Column(name = "pinned", columnDefinition = "BIT(1) DEFAULT b'0'") // Default is false (0)
	private boolean pinned;
	@Column(name = "bg_color", columnDefinition = "VARCHAR(255) DEFAULT ''") // Default is empty
	private String bg_color;
	
	@Column
	@CreationTimestamp
	private LocalDateTime created_date;
	@Column
	@UpdateTimestamp
	private LocalDateTime updated_date;
	
	public Long getId() {
		return id;
	}
	public boolean isPinned() {
		return pinned;
	}
	public void setPinned(boolean pinned) {
		this.pinned = pinned;
	}
	public String getBg_color() {
		return bg_color;
	}
	public void setBg_color(String bg_color) {
		this.bg_color = bg_color;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getCreated_date() {
		return created_date;
	}
	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}
	public LocalDateTime getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(LocalDateTime updated_date) {
		this.updated_date = updated_date;
	}
}
