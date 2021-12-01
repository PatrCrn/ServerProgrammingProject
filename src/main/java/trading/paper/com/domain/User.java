package trading.paper.com.domain;

public class User {
    private int id;
    private String username;
    private String passwordHash;
	private String email;
    private String role;
    
    public User() {
    	this.id = 0;
		this.username = null;
		this.passwordHash = null;
		this.email = null;
		this.role = null;
	}

	public User(String username, String passwordHash, String email, String role) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
		this.email = email;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User : " + username + ", email : " + email + ", role : " + role;
	}
}