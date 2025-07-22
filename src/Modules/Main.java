package Modules;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		ArrayList<Admin> adminDetails=new ArrayList<>();
		ArrayList<Borrower> borrowerDetails=new ArrayList<>();
		
		while(true) {
			System.out.println("====================Welcome to LMS====================\n1.Admin\n2.Borrower\n3.Close");
			int user=sc.nextInt();
			if(user==1) {
				System.out.println("====================Welcome Admin====================\n1.Login\n2.New User\n3.Close");
				int log=sc.nextInt();
				if(log==1) {
					sc.nextLine();
					System.out.println("===============Admin Login Page===============");
					System.out.println("Enter your username:");
					String username=sc.nextLine();
					System.out.println("Enter your password:");
					String password=sc.nextLine();
					for(Admin i:adminDetails) {
						if(username.equals(i.getUsername()) && password.equals(i.getPassword())){
							while(true) {
							System.out.println("Welcome to admin dashboard");
							System.out.println("1.Add Books\n2.Edit Books\n3.View Books\n4.My Profile\n5.Add User\n6.Edit User\n7.View User\n8.Exit");
							int ch=sc.nextInt();
							
								if(ch==1) {
									return;
								}
								else if(ch==4) {
									i.printDetails();
								}
								else {
									break;
								}
							}
							break;
						}
					}
				}
				else if(log==2) {
					System.out.println("Enter the details to create an account as an Admin:");
					System.out.println("Enter the Admin ID:");
					int id=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter your name:");
					String name=sc.nextLine();
					System.out.println("Enter your email:");
					String email=sc.nextLine();
					System.out.println("Enter your phone number:");
					String phone=sc.nextLine();
					System.out.println("Enter your role(Librarian/Admin/Clerk):");
					String role=sc.nextLine();
					System.out.println("Enter your username:");
					String username=sc.nextLine();
					System.out.println("Enter your password:");
					String password=sc.nextLine();
					System.out.println("Enter your status(Active/Inactive):");
					String status=sc.nextLine();
					
					//admin object creation
					Admin obj=new Admin(id,name,email,phone,role,username,password,status);
					
					adminDetails.add(obj);
				}
				else {
					break;
				}
				
			}
			else if(user==2) {
				System.out.println("====================Welcome Borrower====================\n1.Login\n2.New User\n3.Close");
				int log=sc.nextInt();
				if(log==1) {
					sc.nextLine();
					System.out.println("===============Borrower Login Page===============");
					System.out.println("Enter username:");
					String username=sc.nextLine();
					System.out.println("Enter password:");
					String password=sc.nextLine();
					for(Borrower i:borrowerDetails) {
						if(username.equals(i.getUsername()) && password.equals(i.getPassword())) {
							while(true) {
							System.out.println("Welcome to Borrower Dashboard");
							System.out.println("1.Profile\n2.View My Book Details\n3.Exit");
							int ch=sc.nextInt();
								if(ch==1) {
									i.printDetails();
								}
								else if(ch==2) {
									return;
								}
								else {
									break;
								}
							}
							break;
						}
					}
				}
				else if(log==2) {
					System.out.println("Enter the details to create an account as an Borrower:");
					System.out.println("Enter the Borrower ID:");
					int id=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter your name:");
					String name=sc.nextLine();
					System.out.println("Enter your email:");
					String email=sc.nextLine();
					System.out.println("Enter your phone number:");
					String phone=sc.nextLine();
					System.out.println("Enter your address:");
					String address=sc.nextLine();
					System.out.println("Enter your Date of Birth:");
					String dob=sc.nextLine();
					System.out.println("Enter your Type:");
					String type=sc.nextLine();
					System.out.println("Enter your Department:");
					String dept=sc.nextLine();
					System.out.println("Enter your username:");
					String username=sc.nextLine();
					System.out.println("Enter your password:");
					String password=sc.nextLine();
					System.out.println("Enter your Date of join:");
					String joinDate=sc.nextLine();
					System.out.println("Enter your Expiry date:");
					String expDate=sc.nextLine();
					System.out.println("Enter your status(Active/Inactive):");
					String status=sc.nextLine();
					
					//borrower object creation
					Borrower obj=new Borrower(id,name,email,phone,address,dob,type,dept,username,password,joinDate,expDate,status);
					
					borrowerDetails.add(obj);
				}
				else {
					break;
				}
				
			}
			else {
				break;
			}
		}

	}

}
