package corbaDropboxServer;

import CorbaDropbox.ClientCallback;
import CorbaDropbox.DocServiceOperations;
import CorbaDropbox.Document;
import CorbaDropbox.User;

public class DocServiceServant implements DocServiceOperations{

	@Override
	public Document downloadDoc(String filename, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean queryDocuments(String filename, User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String listDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean uploadDoc(Document document, ClientCallback updatedDoc) {
		// TODO Auto-generated method stub
		return false;
	}

}
