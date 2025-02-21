package in.v8.response;

public class AuthResponse {
	private String awt;
	private boolean isAuth;
	public AuthResponse() {
		// TODO Auto-generated constructor stub
	}
	public AuthResponse(String awt, boolean isAuth) {
		super();
		this.awt = awt;
		this.isAuth = isAuth;
	}
	public String getAwt() {
		return awt;
	}
	public boolean isAuth() {
		return isAuth;
	}
}
