//David Horan - 09107771
package corbaDropboxServer;

import java.util.Scanner;

import CorbaDropbox.User;
import CorbaDropbox.UserServiceOperations;

import java.util.HashMap;
import java.util.Map;

public class UserServiceServant implements UserServiceOperations {

	public Map<String,User> userMap = new HashMap<String,User>();
	Scanner input = new Scanner(System.in);
	
	@Override
	public boolean register(String username, String password) {
		// TODO Auto-generated method stub
		//create new user 
		//print line "Please enter user requested username
		//if username does not exist already proceed to password
		//Please enter password for username
		//confirm password and check with 1st attempt
		//if matches all ok and log user in
		//else please re enter password
		//else username already exists please choose another username
		//Try again
		
		System.out.println("Please enter your requested username: ");
		username = input.toString();
		
		if(userMap.containsValue(username))
		{
			//return true;
			System.out.println("This username is already in use please enter new username: ");
			return false;
		}
		else
		{
			//return false;
			System.out.println("Please enter a password: ");
			password = input.toString();

			User newUser = new User(username, password, false );
			
			userMap.put(username, newUser);
			System.out.println("You are now a registered user. Thank you for registering with us.");
			return true;
		}
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		//check if user exists and if password matches
		//print line please enter your username
		//if username matches existing username please enter password
			//if password matches username password log user in
			//else please reenter password
				//if password matches username password log user in
				//else please reenter password
					//if password matches username password log user in
					//else return to beginning
		//else please reenter username 
		
		System.out.println("Please enter your username: ");
		username = input.toString();
		
		if(userMap.containsValue(username))
		{
			User foundUser = userMap.get(username);
			//String existingUser = foundUser.toString();
			System.out.println("Please enter your password: ");
			String enteredPassword = input.toString();
			//how to find the password value in the user object
			//String storedPassword = foundUser.nextElement();
			
			//for (Enumeration<E> e = foundUser.nextElement();)
			if(enteredPassword == foundUser.password)
			{
				System.out.println("You are now logged in.");
			}
			else
			{
				System.out.println("Incorrect password. Attempt 1 of 3. Please re-enter your password: ");
				String enteredPassword2 = input.toString();
				if(enteredPassword2 == foundUser.password)
				{
					System.out.println("You are now logged in.");
				}
				else
				{
					System.out.println("Incorrect password. Attempt 2 of 3. Please re-enter your password: ");
					String enteredPassword3 = input.toString();
					if(enteredPassword3 == foundUser.password)
					{
						System.out.println("You are now logged in.");
					}
					else
					{
						System.out.println("Incorrect password. Attempt 3 of 3.");
						
					}
				}
			}
			//return type? 
		}
		else
		{
			//return false;
			System.out.println("Username not found please try again: ");
			
		}
		return null;
	}
}
