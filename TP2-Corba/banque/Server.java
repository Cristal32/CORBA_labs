package banque;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import org.omg.CORBA.ORB;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.UserException;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManager;

public class Server {
	public static void main(String args[]) {
	      Properties props = System.getProperties();
	      
	      int status = 0 ;
	      ORB orb = null ;

	      try {
	         orb = ORB.init ( args, props) ;
	         status = run (orb) ;
	      } catch (Exception ex) {
	         ex.printStackTrace ();
	         status = 1;
	       } 

	      if (orb != null) {
	         try {
	           orb.destroy() ;
	         } catch (Exception ex) {
	            ex.printStackTrace ();
	            status = 1;
	         } 
	      }
	      System.exit(status) ;
	  }
	
	static int run(ORB orb) throws UserException, IOException {
		 POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		 POAManager manager = rootPOA.the_POAManager();
		
		 // Create the (servant) object
		 CompteImpl compteImpl = new CompteImpl();
		 
		 // Create the CORBA reference
		 Compte compte = compteImpl._this(orb);
		 
		 // Copy the reference from a separate file
		 String ref = orb.object_to_string(compte);
		 String refFile = "Compte.ref";
		 try (FileOutputStream file = new FileOutputStream(refFile);
			    PrintWriter out = new PrintWriter(file)) {
			    out.println(ref);
			    out.flush();  // Ensure data is written to the file
			    System.out.println("Server waiting for client:\nref: " + ref);
			} catch (IOException e) {
			    System.err.println("Error writing to file: " + e.getMessage());
			}
		 
		 try {
			 manager.activate();
			 orb.run();
		 } catch(SystemException ex) {
			 System.err.println(" -- CORBA error -- \n" + ex.getMessage());
			 ex.printStackTrace();
			 return 1;
		}
		 
		return 0;
	  } 
}
