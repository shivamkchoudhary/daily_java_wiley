package UserPackage;

public class User {
	
	private String username;
	private String email;
	private String password;
	private String password2;
	private boolean tnc;
	
	public static int userCounter = 0;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public boolean isTnc() {
		return tnc;
	}
	public void setTnc(boolean tnc) {
		this.tnc = tnc;
	}
	
	public User(String username, String email, String password, String password2, boolean tnc) {
		super();		
		this.username = username;
		this.email = email;
		this.password = password;
		this.password2 = password2;
		this.tnc = tnc;
		
		userCounter++;
	}
	
	public User() {
		
	}
	
	public static boolean isValidEmail(String email) {
		
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		return email.matches(regex);
	}
	
	public static boolean isValidPassword(String password) {
		String regex  = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
		return password.matches(regex);
	}
	
}
