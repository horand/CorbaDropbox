package corbaDropboxServer;

import CorbaDropbox.User;
import CorbaDropbox.UserServiceOperations;

import java.util.HashMap;
import java.util.Map;

public class UserServiceServant implements UserServiceOperations {

	public Map<String,User> userMap = new HashMap<String,User>();

	
	@Override
	public boolean register(String username, String password) {

		// check if username is already registered
		if(userMap.containsValue(username))
		{
			// map already contains a user with the same username, return false

			return false;
		}
		else
		{
			// user doesn't already exist; create and add user to map and return true
			User newUser = new User(username, password, false );
			
			userMap.put(username, newUser);

			return true;
		}
	}

	@Override
	public User login(String username, String password) {

		// check if the username exists in the map
		if(userMap.containsKey(username))
		{
			// get the user object from the map
			User foundUser = userMap.get(username);

			// check if the password matches the supplied pass
			if(password == foundUser.password)
			{
				// set isLoggedIn variable to true if they match
				foundUser.isLoggedIn = true;

			}
			else
			{
				// set isLoggedIn variable to false if they don't match
				foundUser.isLoggedIn = false;

			}
			// send back the validated or invalidated user 
			return foundUser;
		}
		else
		{
			// return null for no user found.
			return null;
		}
	}
}
