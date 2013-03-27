package corbaDropboxServer;

import java.util.ArrayList;

import CorbaDropbox.User;
import CorbaDropbox.UserServiceOperations;

public class UserServiceServant implements UserServiceOperations {

	ArrayList<String> docList = new ArrayList<String>();
	
	@Override
	public boolean register(String username, String password) {
		// TODO Auto-generated method stub
		//create new user 
		return false;
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		//check if user exists and if password matches
		return null;
	}

	@Override
	public String doclist(User user) {
		// TODO Auto-generated method stub
		//show all docs created by user
		return null;
	}

}
