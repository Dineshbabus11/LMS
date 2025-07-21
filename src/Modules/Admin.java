package Modules;

public class Admin {
	private int id;
	private String name;
	private String email;
	private String phone;
	private String role;
	private String username;
	private String password;
	private boolean status;
	
	//parameterized constructor
	
	public Admin(int id,String name, String email, String phone,String role,String username, String password, String status) {
		this.id=id;
		this.name=name;
		this.email=email;
		this.phone=phone;
		this.role=role;
		this.username=username;
		this.password=password;
		this.status=status.equalsIgnoreCase("Active")?true:false;
	}
	
	//getter()
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getRole() {
		return role;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public boolean getStatus() {
		return status;
	}
	
	
}
