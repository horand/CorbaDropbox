package corbaDropboxServer;

import java.util.ArrayList;
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
		
		// check if the document exists for the user
		return null;
		
	}

	@Override
	public boolean queryDocuments(String filename, User user) {
		// TODO Auto-generated method stub
		//subscribe to updates
		return false;
	}

	@Override
	public String[] listDocuments() {
		// TODO Auto-generated method stub
		//list all docs that are public
		return null;
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
	public boolean updateDoc(Document document, ClientCallback updatedDoc) {
	
		// check if uploaded document name is already in map
		if(docMap.containsKey(document.filename)){
			
			// if it is already in the map put the updated document into the map 
			// and return true
			docMap.put(document.filename, document);
			updatedDoc.doCallback("Document "+document.filename+" has been updated");
			return true;
			
		} else {
			
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
					
			if(user == d.user)
			{
				fileList.add(d.filename);
			}
		}
		
		int fileListLength = fileList.size();
		
		if (fileListLength > 0){
		
			String[] ListUserDocs = new String[fileListLength];
			fileList.toArray(ListUserDocs);
		
			return ListUserDocs;
			
		} else {
			return null;
		
		}
	}
}
