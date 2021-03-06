package corbaDropboxClient;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

import org.omg.CORBA.ORB;

import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import corbaDropboxServer.ListenerServant;


import CorbaDropbox.DocService;
import CorbaDropbox.DocServiceHelper;
import CorbaDropbox.Document;
import CorbaDropbox.Listener;
import CorbaDropbox.ListenerHelper;
import CorbaDropbox.MessageServer;
import CorbaDropbox.MessageServerHelper;

import CorbaDropbox.User;
import CorbaDropbox.UserService;
import CorbaDropbox.UserServiceHelper;


public class Client  {

	static String welcome = "Welcome to CorbaDropbox";
	static String header = "Num	Option";
	static String headerLine = "----------------------------";
	static String regOption = "1	Register";
	static String loginOption = "2	Login";
	static String uploadOption = "3	Upload File";
	static String updateOption = "4	Update File";
	static String subscribe = "5	Subscribe to File";
	static String viewOwnDocs = "6	List My Files";
	static String viewPublicDocs = "7	List Public Files";
	static String downloadDocs = "8	Download Document";
	static String exit = "9	Exit";
	
	
	public static void main(String[] args){
		
		try{
			ORB orb = ORB.init(args, null);

			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
					  
	      // Use NamingContextExt instead of NamingContext. This is 
	      // part of the Interoperable naming Service.  
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
				 
	      // resolve the Object Reference in Naming
	      String docName = "Documents";
	      DocService docServ = DocServiceHelper.narrow(ncRef.resolve_str(docName));
		
	      String userName = "Users";
	      UserService userServ = UserServiceHelper.narrow(ncRef.resolve_str(userName));
		/*
	      String MsgName = "Messages";
	      MessageServer MsgServ = MessageServerHelper.narrow(ncRef.resolve_str(MsgName));

	      ListenerServant ls  = new ListenerServant();
	      POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

	      rootPOA.activate_object(ls);
	      Listener lstnr = ListenerHelper.narrow(rootPOA.servant_to_reference(ls));
		 */
	      
	      
			// Client UI Section
			// variables
			int option = 0;
			
			String selOption = "Please select an option from the above list: ";
			String exitMsg = "Now exiting CorbaDropbox. Have a nice day.";
	
			User currentUser = null;
			
			Scanner keyIn = new Scanner(System.in);
		
			System.out.println(welcome);
			displayUserMenu();
			
			while (option != 9){
				System.out.print(selOption);
				option = keyIn.nextInt();
				keyIn.nextLine();
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
						
						if(userServ.register(regUser,regPass)){
							System.out.println("User registration complete.");
							
							
						} else {
							System.out.println("User could not be registered, please try again with a different username.");
		
						}
						
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
						
						currentUser = userServ.login(loginUser,loginPass);
						
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
						String filePath = keyIn.nextLine();
						
						try {
						
						String fileContent = readFileAsString(filePath);
							
							System.out.print("Would you like to make this file private (y/n): ");
							String privacyResp = keyIn.nextLine();
							String fileName = filePath.substring(filePath.lastIndexOf('\\')+1, filePath.length());
	
							if (privacyResp.toLowerCase().equals("y")){
								boolean isPriv = true;
								Document doc = new Document();
								doc.filename = fileName;
								doc.contents = fileContent;
								doc.isPrivate = isPriv;
								doc.user = currentUser;
								
								
								if (docServ.uploadDoc(doc)){
									System.out.println("Document uploaded successfully.");
								} else {
									System.out.println("A document with the same name already exists.");
									System.out.println("Please try again with a different file name.");
								}
								
							} else if (privacyResp.toLowerCase().equals("n")){
								boolean isPriv = false;
								Document doc = new Document();
								doc.filename = fileName;
								doc.contents = fileContent;
								doc.isPrivate = isPriv;
								doc.user = currentUser;
						
								if (docServ.uploadDoc(doc)){
									System.out.println("Document uploaded successfully.");
								} else {
									System.out.println("A document with the same name already exists.");
									System.out.println("Please try again with a different file name.");
								}
								
							} else {
								
								System.out.println("Invalid response to file privacy option.");
								System.out.println("Please try again.");
								
							}
							
						} catch (IOException e) {
							
							System.out.println("Something went wrong reading your file. :-(");
							System.out.println("Please try again.");
						}
						
						displayDocMenu();
					} else {
						System.out.println("User not logged in");
						displayUserMenu();
					}
					break;
					
				case 4:
					if(currentUser != null && currentUser.isLoggedIn){
						System.out.print("Please enter file path and name to update: ");
						String filePath = keyIn.nextLine();
						
						try {
							String fileContent = readFileAsString(filePath);
							
							System.out.print("Would you like to make this file private (y/n): ");
							String privacyResp = keyIn.nextLine();
							String fileName = filePath.substring(filePath.lastIndexOf('\\')+1, filePath.length());
	
							if (privacyResp.toLowerCase().equals("y")){
								boolean isPriv = true;
								Document doc = new Document();
								doc.filename = fileName;
								doc.contents = fileContent;
								doc.isPrivate = isPriv;
								doc.user = currentUser;
								
								
								if (docServ.updateDoc(doc)){
									System.out.println("Document updated successfully.");
								} else {
									System.out.println("No such document to be updated");
								}
								
							} else if (privacyResp.toLowerCase().equals("n")){
								boolean isPriv = false;
								Document doc = new Document();
								doc.filename = fileName;
								doc.contents = fileContent;
								doc.isPrivate = isPriv;
								doc.user = currentUser;
								
								
								if (docServ.updateDoc(doc)){
									System.out.println("Document updated successfully.");
								} else {
									System.out.println("No such document to be updated");
								}
								
							} else {
								
								System.out.println("Invalid response to file privacy option.");
					System.out.println("Please try again.");
								
							}
							
						} catch (IOException e) {
							
							System.out.println("Something went wrong reading your file. :-(");

							System.out.println("Please try again.");
						}
						
						displayDocMenu();
						
					} else {
						System.out.println("User not logged in");
						displayUserMenu();
					}
					break;
					
				case 5:
					if(currentUser != null && currentUser.isLoggedIn){
						System.out.print("Please enter filename to subscribe to: ");
						// MsgServ.register(lstnr);
						displayDocMenu();
					} else {
						System.out.println("User not logged in");
						displayUserMenu();
					}
					break;
					
				case 6:
					if(currentUser != null && currentUser.isLoggedIn){
						
						String[] myDocs = docServ.listUserDocuments(currentUser);
						if (myDocs == null) {
							
							System.out.println("You do not have any documents.");
							
						} else {
							System.out.println("FileName");
							System.out.println(headerLine);
							for (String s : myDocs) {
								System.out.println(s);
							}
						}
						displayDocMenu();
					} else {
						System.out.println("User not logged in");
						displayUserMenu();
					}
					break;
					
				case 7:
					if(currentUser != null && currentUser.isLoggedIn){
						String[] pubDocs = docServ.listDocuments();
						if (pubDocs == null) {
							
							System.out.println("You do not have any documents.");
							
						} else {
							System.out.println("FileName");
							System.out.println(headerLine);
							for (String s : pubDocs) {
								System.out.println(s);
							}
						}
						displayDocMenu();
					} else {
						System.out.println("User not logged in");
						displayUserMenu();
					}
					break;
					
				case 8:
					if(currentUser != null && currentUser.isLoggedIn){
						System.out.print("Please enter filename to download: ");
						String downFileRef = keyIn.nextLine();
						
						Document downDoc = docServ.downloadDoc(downFileRef,currentUser);
						
						if(downDoc.user == null){
							System.out.println("File does not exist, or you do not have access to the file.");
						} else {
							String downPath = "c:\\Docs\\"+downDoc.filename;
							
							writeFileFromString(downPath, downDoc.contents);
							
							System.out.println("Your file has been downloaded to "+downPath);
						}
						displayDocMenu();
					} else {
						System.out.println("User not logged in");
						displayUserMenu();
					}
					
					break;
								
				case 9:
					System.out.println(exitMsg);
					break;
				}
	
			}
			
			
			keyIn.close();
		} catch (Exception e) {
			System.out.println("ERROR : " + e); e.printStackTrace(System.out);
		}
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
		System.out.println(viewOwnDocs);
		System.out.println(viewPublicDocs);
		System.out.println(downloadDocs);
		System.out.println(exit);
		System.out.println();
	}
	
	/* The following method is taken from
	 * http://stackoverflow.com/questions/326390/how-to-create-a-java-string-from-the-contents-of-a-file
	 * accessed 08:46 05/04/2013
	 * Title: How to read a file into string in java? - Stack Overflow
	 */
	private static String readFileAsString(String path) throws IOException {
		  FileInputStream stream = new FileInputStream(new File(path));
		  try {
		    FileChannel fc = stream.getChannel();
		    MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
		    /* Instead of using default, pass in a decoder. */
		    stream.close();
		    return Charset.defaultCharset().decode(bb).toString();
		    
		  }
		  finally {
		    stream.close();
		  }
		}
	// End of copied code

	
	private static void writeFileFromString(String filePath, String fileContent){
		/* The following code is taken from
		 * http://stackoverflow.com/questions/2885173/java-how-to-create-and-write-to-a-file
		 * accessed 11:48 05/04/2013
		 * Title: Java: how to create and write to a file - Stack Overflow
		 */
		Writer writer = null;
	
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
		    writer.write(fileContent);
		} catch (IOException ex){
		  // report
		} finally {
		   try {writer.close();} catch (Exception ex) {}
		}
	// end of copied code	
	} 	
}
