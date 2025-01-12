package in.v8.request;

import java.util.List;

public class GroupChatRequest {
	private List<Integer> userIds;
	private String chatName;
	private String chatImage;
	public GroupChatRequest() {
		// TODO Auto-generated constructor stub
	}
	public GroupChatRequest(List<Integer> userIds, String chatName, String chatImage) {
		super();
		this.userIds = userIds;
		this.chatName = chatName;
		this.chatImage = chatImage;
	}
	public List<Integer> getUserIds() {
		return userIds;
	}
	public void setUserIds(List<Integer> userIds) {
		this.userIds = userIds;
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
}
