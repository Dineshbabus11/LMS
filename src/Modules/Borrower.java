package Modules;

public class Borrower {
	private int id;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String dob;
	private String type;
	private String dept;
	private String username;
	private String password;
	private String joinDate;
	private String expDate;
	private boolean status;
	
	//parameterized constructor
	
	public Borrower(int id,String name,String email,String phone,String address,String dob,String type,String dept,String username,String password,String joinDate,String expDate,String status) {
		this.id=id;
		this.name=name;
		this.email=email;
		this.phone=phone;
		this.address=address;
		this.dob=dob;
		this.type=type;
		this.dept=dept;
		this.username=username;
		this.password=password;
		this.joinDate=joinDate;
		this.expDate=expDate;
		this.status=status.equalsIgnoreCase("Active")?true:false;
	}
	
	//getters()
	
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
	public String getAddress() {
		return address;
	}
	public String getDob() {
		return dob;
	} 
	public String getType() {
		return type;
	}
	public String getDept() {
		return dept;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public String getExpDate() {
		return expDate;
	}
	public boolean getStatus() {
		return status;
	}
	
}
