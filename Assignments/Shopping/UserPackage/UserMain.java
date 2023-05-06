package UserPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import CustomerPackage.Customer;

import static UserPackage.User.isValidEmail;
import static UserPackage.User.isValidPassword;;

public class UserMain {
	DataOutputStream userOutput;
	public UserMain(String outputFile) {
		
		try {
			userOutput = new DataOutputStream(new FileOutputStream(outputFile));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writer(User user) throws IOException {
		
		userOutput.writeUTF(user.getUsername()); 
		userOutput.writeUTF(user.getEmail());
		userOutput.writeUTF(user.getPassword());
		userOutput.writeUTF(user.getPassword2());
		userOutput.writeBoolean(user.isTnc());
	}
	
	public static void enterUserData() throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Data");
		String username = scan.nextLine();
		String email = scan.nextLine();
		String password = scan.nextLine();
		String password2 = scan.nextLine();
		int tc = scan.nextInt();
		scan.nextLine();
		boolean tnc = tc==1 ? true : false ;
		
		if(isValidEmail(email) && isValidPassword(password) && isValidPassword(password2) && tnc == true) {
			User user  = new User(username,email,password,password2,tnc);
			UserMain userMain = new UserMain("C:\\Users\\Rishav Raj\\Desktop\\data.txt");
			userMain.writer(user);
			System.out.println("Registration Successful");
			Customer customer = new Customer(username);
		}
		else {
			System.out.println("Check the data you entered!!");
			Customer customer = new Customer(username);
		}
	}
	
	public static void showUserData(String inputFile) throws FileNotFoundException {
		DataInputStream dataInput = new DataInputStream(new FileInputStream(inputFile));
		List<User> userList = new ArrayList<>();
		
		
		try {
			while(true) {
				String username = dataInput.readUTF();
				String email = dataInput.readUTF();
				String password = dataInput.readUTF();
				String password2 = dataInput.readUTF();
				boolean tnc = dataInput.readBoolean();
				User user  = new User(username,email,password,password2,tnc);
				
				System.out.println(username+" "+email);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void save() throws IOException {
		userOutput.close();
	}
	
	public static void main(String[] args) throws IOException {
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("-----------------USER MENU-------------------\n");
		System.out.println("1. Register Yourself");
		System.out.println("2. Check User Profiles");
		int choice;
		choice  = scan.nextInt();
		
		switch(choice) {
		case 1:
			enterUserData();
			break;
		case 2:
			showUserData("C:\\Users\\Rishav Raj\\Desktop\\data.txt");
			break;
		
		}
		
		
	}
}
