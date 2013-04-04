package corbaDropboxClient;

import java.util.Scanner;

import CorbaDropbox.User;

public class Client  {

	static String welcome = "Welcome to CorbaDropbox";
	static String header = "Num	Option";
	static String headerLine = "----------------------------";
	static String regOption = "1	Register";
	static String loginOption = "2	Login";
	static String uploadOption = "3	Upload File";
	static String updateOption = "4	Update File";
	static String subscribe = "5	Subscribe to File";
	static String viewOwnDocs = "6	Subscribe to File";
	static String viewPublicDocs = "7	Subscribe to File";
	static String exit = "8	Exit";
	
	
	public static void main(String[] args){
		
		// TODO Corba Stuff Here
		
		
		// Client UI Section

		// variables
		int option = 0;
		
		String selOption = "Please select an option from the above list: ";
		String exitMsg = "Now exiting CorbaDropbox.";

		User currentUser = null;
		
		Scanner keyIn = new Scanner(System.in);
	
		System.out.println(welcome);
		displayUserMenu();
		displayDocMenu();
		
		while (option != 6){
			System.out.print(selOption);
			option = keyIn.nextInt();
			
			switch (option){
			
			case 1:
				if (currentUser != null && currentUser.isLoggedIn){
					System.out.print("User "+currentUser.username+" is already logged in");
					displayDocMenu();
					
				} else {
					System.out.print("Please select a username: ");
					String regUser = keyIn.nextLine();
					
					System.out.print("Please select a password: ");
					String regPass = keyIn.nextLine();
					/*
					if(userServ.register(regUser,regPass)){
						System.out.println("User registration complete.");
						
						
					} else {
						System.out.println("User could not be registered, please try again with a different username.");
	
					}
					*/
					displayUserMenu();
				}
				break;
				
			case 2:
				if (currentUser != null && currentUser.isLoggedIn){
					System.out.print("User "+currentUser.username+" is already logged in");
					displayDocMenu();
					
				} else {
				
					System.out.print("Please enter your username: ");
					String loginUser = keyIn.nextLine();
					
					System.out.print("Please enter your password: ");
					String loginPass = keyIn.nextLine();
					/*
					currentUser = userServ.login(loginUser,loginPass);
					*/
					if(currentUser == null){
						System.out.println("Unknown username");
						displayUserMenu();
						
					} else if (currentUser.isLoggedIn) {
						System.out.println("Login Successful");
						displayDocMenu();
					} else {
						System.out.println("Login Unsuccessful");
						displayUserMenu();
					}
					
				}
				break;

			case 3:
				if(currentUser != null && currentUser.isLoggedIn){
					System.out.print("Please enter file path and name to upload: ");
					// TODO Add code to handle upload file request
					displayDocMenu();
				} else {
					System.out.println("User not logged in");
					displayUserMenu();
				}
				break;
				
			case 4:
				if(currentUser != null && currentUser.isLoggedIn){
					System.out.print("Please enter file path and name to update: ");
					// TODO Add code to handle upload file request
					displayDocMenu();
				} else {
					System.out.println("User not logged in");
					displayUserMenu();
				}
				break;
				
			case 5:
				if(currentUser != null && currentUser.isLoggedIn){
					System.out.print("Please enter filename to subscribe to: ");
					// TODO Add code to subscribe to file
					displayDocMenu();
				} else {
					System.out.println("User not logged in");
					displayUserMenu();
				}
				break;
				
			case 6:
				if(currentUser != null && currentUser.isLoggedIn){
					// TODO Add code to display files
					displayDocMenu();
				} else {
					System.out.println("User not logged in");
					displayUserMenu();
				}
				break;
				
			case 7:
				if(currentUser != null && currentUser.isLoggedIn){
					// TODO Add code to display files
					displayDocMenu();
				} else {
					System.out.println("User not logged in");
					displayUserMenu();
				}
				break;
				
			case 8:
				System.out.println(exitMsg);
				break;
			}

		}
		
		keyIn.close();
		
	}
	
	public static void displayUserMenu(){

		System.out.println(header);
		System.out.println(headerLine);
		System.out.println(regOption);
		System.out.println(loginOption);
		System.out.println(exit);
		System.out.println();
		
	}
	
	public static void displayDocMenu(){

		System.out.println(header);
		System.out.println(headerLine);
		System.out.println(uploadOption);
		System.out.println(updateOption);
		System.out.println(subscribe);
		System.out.println(exit);
		System.out.println();
	}

}
