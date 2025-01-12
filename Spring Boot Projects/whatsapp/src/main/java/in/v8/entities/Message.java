package in.v8.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column(name = "contect")
	private String contect;
	
	@Column(name = "create_timestamp")
	private LocalDateTime createTimestamp;
	
	@JoinColumn(name = "user_id")
	@ManyToOne
	private User user;
	
	@JoinColumn(name = "chat_id")
	@ManyToOne
	private Chat chat;
	
	public Message() {
		// TODO Auto-generated constructor stub
	}
	public Message(Integer id, String contect, LocalDateTime createTimestamp, User user, Chat chat) {
		super();
		this.id = id;
		this.contect = contect;
		this.createTimestamp = createTimestamp;
		this.user = user;
		this.chat = chat;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContect() {
		return contect;
	}
	public void setContect(String contect) {
		this.contect = contect;
	}
	public LocalDateTime getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(LocalDateTime createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Chat getChat() {
		return chat;
	}
	public void setChat(Chat chat) {
		this.chat = chat;
	}
}
