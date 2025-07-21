package Modules;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		ArrayList<Admin> adminDetails=new ArrayList<>();
		
		while(true) {
			System.out.println("====================Welcome to LMS====================\n1.Admin\n2.Borrower\n3.Close");
			int user=sc.nextInt();
			if(user==1) {
				System.out.println("====================Welcome Admin====================\n1.Login\n2.New User\n3.Close");
				int log=sc.nextInt();
				if(log==1) {
					return;
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
					System.out.println("Enter your status(Active/Inactive");
					String status=sc.nextLine();
					
					//admin object creation
					Admin obj=new Admin(id,name,email,phone,role,username,password,status);
					
					adminDetails.add(obj);
				}
				else {
					break;
				}
				
			}
		}

	}

}
