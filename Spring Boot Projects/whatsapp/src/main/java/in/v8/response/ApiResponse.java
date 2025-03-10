package in.v8.response;

public class ApiResponse {
	private String message;
	private boolean status;
	public ApiResponse() {
		// TODO Auto-generated constructor stub
	}
	public ApiResponse(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public boolean isStatus() {
		return status;
	}
}
