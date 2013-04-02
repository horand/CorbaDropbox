package corbaDropboxServer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import CorbaDropbox.ClientCallback;
import CorbaDropbox.DocServiceOperations;
import CorbaDropbox.Document;
import CorbaDropbox.User;

public class DocServiceServant implements DocServiceOperations{
	
	public Map<String,Document> docMap = new HashMap<String,Document>();
	Scanner input = new Scanner(System.in);
	
	@Override
	public Document downloadDoc(String filename, User user) {
		// TODO Auto-generated method stub
		//return doc with filename x if private and user == user ok 
		return null;
	}

	@Override
	public boolean queryDocuments(String filename, User user) {
		// TODO Auto-generated method stub
		//subscribe to updates
		return false;
	}

	@Override
	public String listDocuments() {
		// TODO Auto-generated method stub
		//list all docs that are public
		return null;
	}

	@Override
	public boolean uploadDoc(Document document) {
		// TODO Auto-generated method stub
		String uploadFileName = document.filename;
		
		if(docMap.containsKey(uploadFileName)){
			
			return false;
		} else {
			
			docMap.put(uploadFileName, document);
			return true;
		}
	}
	
	@Override
	public boolean updateDoc(Document document, ClientCallback updatedDoc) {
		// TODO Auto-generated method stub
		
		return false;
	}
	
	@Override
	public String doclist(User user) {
		// TODO Auto-generated method stub
		//show all docs created by user
		//find all doc's with user name matching logged in user and print filenames and privacy	
		//Iterate Map
		//Check Object username
		//If username matches username add to array
		
		String docFilename = null;
		for(int i = 0; i <= docMap.size(); i++)
		{
			Document doc = docMap.get(i);
			
			if(user == doc.user)
			{
				docFilename = doc.filename;
			}
		}
		return docFilename;
	}
}
