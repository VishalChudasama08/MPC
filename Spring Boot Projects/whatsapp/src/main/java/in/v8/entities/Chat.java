package in.v8.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Chat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column(name = "chat_name")
	private String chatName;
	
	@Column(name = "chat_image")
	private String chatImage;
	
	@Column(name = "is_group")
	private boolean isGroup;
	
	@JoinColumn(name = "created_by")
	@ManyToOne
	private User createdBy;
	
	@ManyToMany
	private Set<User> admins = new HashSet<>();
	
	@ManyToMany
	private Set<User> users = new HashSet<>();
	
	@OneToMany
	private List<Message> messages = new ArrayList<>();
	
	public Chat() {
		// TODO Auto-generated constructor stub
	}
	public Chat(Integer id, String chatName, String chatImage, boolean isGroup, User createdBy, Set<User> admins,
			Set<User> users, List<Message> messages) {
		super();
		this.id = id;
		this.chatName = chatName;
		this.chatImage = chatImage;
		this.isGroup = isGroup;
		this.createdBy = createdBy;
		this.admins = admins;
		this.users = users;
		this.messages = messages;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getChatName() {
		return chatName;
	}
	public void setChatName(String chatName) {
		this.chatName = chatName;
	}
	public String getChatImage() {
		return chatImage;
	}
	public void setChatImage(String chatImage) {
		this.chatImage = chatImage;
	}
	public boolean isGroup() {
		return isGroup;
	}
	public void setGroup(boolean isGroup) {
		this.isGroup = isGroup;
	}
	public User getCreatedBy() {
		return createdBy;
	}
	public Set<User> getAdmins() {
		return admins;
	}
	public void setAdmins(Set<User> admins) {
		this.admins = admins;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
}
