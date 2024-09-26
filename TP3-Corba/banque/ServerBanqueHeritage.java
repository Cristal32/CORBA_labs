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

public class ServerBanqueHeritage {
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
	  	System.out.println( "+------------------+");
	    System.out.println( "| Service bancaire |");
	    System.out.println( "+------------------+\n");
	    
		 POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		 POAManager manager = rootPOA.the_POAManager();
		
		 // Création de l’objet d’implantation
		ImplCcrHeritage compteImpl = new ImplCcrHeritage(500,0,false);
		 
		 // Create the CORBA reference
		 CompteCourantRemunere compte = compteImpl._this(orb);
		 
		 // Copy the reference from a separate file
		 String ref = orb.object_to_string(compte);
		 String refFile = "Compte_courant_remunere.ref";
		 try (FileOutputStream file = new FileOutputStream(refFile);
				 PrintWriter out = new PrintWriter(file)) {
			     out.println(ref);
			     out.flush();  // Ensure data is written to the file
			     System.out.println("Serveur en attente d'un client:\n");
		} catch (IOException e) {
			System.err.println("Erreur lors de l'ecriture du fichier: " + e.getMessage());
		}
		 
		 try {
			 manager.activate();
			 orb.run();
		 } catch(SystemException ex) {
			 System.err.println(" -- Erreur CORBA -- \n" + ex.getMessage());
			 ex.printStackTrace();
			 return 1;
		}
		 
		return 0;
	  } 
}
