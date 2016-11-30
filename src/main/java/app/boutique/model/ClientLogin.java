package app.boutique.model;

public class ClientLogin {
	private String email_c;
	private String password_c;
	
	
	public ClientLogin() {
		super();
	}

	public ClientLogin(String email, String password){
		this.email_c= email;
		this.password_c = password;
	}
	
	public String getEmail_c() {
		return email_c;
	}
	public void setEmail_c(String email_c) {
		this.email_c = email_c;
	}
	public String getPassword_c() {
		return password_c;
	}
	public void setPassword_c(String password_c) {
		this.password_c = password_c;
	}
	

}
