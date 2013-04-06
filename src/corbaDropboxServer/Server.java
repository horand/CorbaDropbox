package corbaDropboxServer;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import CorbaDropbox.DocService;
import CorbaDropbox.DocServicePOATie;
import CorbaDropbox.UserService;
import CorbaDropbox.UserServicePOATie;

public class Server {
	public static void main (String[] args){
try{
			
			// create and initialize the ORB
		      ORB orb = ORB.init(args, null);

		      // Get reference to rootpoa & activate the POAManager
		      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		      rootpoa.the_POAManager().activate();

		      // create servant and register it with the ORB
		      DocServiceServant dss = new DocServiceServant();
		      dss.setORB(orb);
		      
		      UserServiceServant uss = new UserServiceServant();
		      uss.setORB(orb);

		      // create a tie, with servant being the delegate.
		      DocServicePOATie dstie = new DocServicePOATie(dss, rootpoa);
		      UserServicePOATie ustie = new UserServicePOATie(uss, rootpoa);

		      // obtain the objectRef for the tie
		      // this step also implicitly activates the 
		      // the object
		      DocService dsref = dstie._this(orb);
		      UserService usref = ustie._this(orb);
			    
		      // get the root naming context
		      org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
		      
		      // Use NamingContextExt which is part of the Interoperable
		      // Naming Service specification.
		      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

		      // bind the Object Reference in Naming
		      String dname = "Documents";
		      NameComponent cpath[] = ncRef.to_name( dname );
		      ncRef.rebind(cpath, dsref);
		      
		      String uname = "Users";
		      NameComponent epath[] = ncRef.to_name( uname );
		      ncRef.rebind(epath, usref);

		      System.out.println("Server Running...");

		      // wait for invocations from clients
		      orb.run();
			
		} catch (Exception e) {
			
			System.err.println(e.getMessage());
			e.printStackTrace(System.out);
			
		}
	}
}
