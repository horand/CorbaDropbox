package corbaDropboxServer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.omg.CORBA.ORB;

import CorbaDropbox.ClientCallback;
import CorbaDropbox.DocServiceOperations;
import CorbaDropbox.Document;
import CorbaDropbox.User;

public class DocServiceServant implements DocServiceOperations{
	
	public Map<String,Document> docMap = new HashMap<String,Document>();
		
	private ORB orb;
	
	public void setORB(ORB orb_val){
		this.orb = orb_val;
	}
	
	@Override
	public Document downloadDoc(String filename, User user) {

		Document d = docMap.get(filename);

		// if the user is logged in and the file is public or the file belongs to the user download the doc
		if((user.isLoggedIn && !d.isPrivate) || (user.isLoggedIn && d.user.username.equals(user.username))) 
		{
			return d;
		}
		else
		{
			return null;
		}
	}

	@Override
	public boolean queryDocuments(String filename, User user) {
		// TODO Auto-generated method stub
		//subscribe to updates
		return false;
	}

	@Override
	public String[] listDocuments() {
		
		ArrayList<String> docList = new ArrayList<String>();

		for(Document d : docMap.values())
		{
			//If the document is public add it to the ArrayList
			if(!d.isPrivate)
			{
				docList.add(d.filename);
			}
		}

		int docListLength = docList.size();
		
		//Return the docList if populated
		if(docListLength > 0)
		{
			String [] ListDocs = new String[docListLength];
			docList.toArray(ListDocs);
			
			return ListDocs;
		}
		else 
		{
			return new String[0];
		}
	}

	@Override
	public boolean uploadDoc(Document document) {
		
		// check if uploaded document name is already in map
		if(docMap.containsKey(document.filename)){
		
			// if it is return false to the client
			return false;
		
		} else {
			
			// it is not already in the map add it to the map and return true
			docMap.put(document.filename, document);
			return true;
		
		}
	}
	
	@Override
	public boolean updateDoc(Document document) {
	
		// check if uploaded document name is already in map
		if(docMap.containsKey(document.filename))
		{	
			// if it is already in the map put the updated document into the map 
			// and return true
			docMap.put(document.filename, document);
			
			return true;	
		} 
		else 
		{
			// else it is not in the map already, so return false
			return false;
		}

	}
	
	@Override
	public String[] listUserDocuments(User user) {
		
		// creates an array list that we can add any documents found to
		ArrayList<String> fileList = new ArrayList<String>();
		
		for(Document d : docMap.values())
		{		
			if(user.username.equals(d.user.username))
			{
				fileList.add(d.filename);
			}
		}
		
		int fileListLength = fileList.size();
		
		if (fileListLength > 0)
		{
			String[] ListUserDocs = new String[fileListLength];
			fileList.toArray(ListUserDocs);
		
			return ListUserDocs;	
		} 
		else 
		{
			return new String[0];
		}
	}

}
