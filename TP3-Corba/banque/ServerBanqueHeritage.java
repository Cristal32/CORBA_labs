package banque;

import java.io.FileOutputStream;
import java.io.PrintWriter;

// import ...

public class ServerBanqueHeritage {
  public static void main(String args[]) {
    // ...

    System.out.println( "+------------------+");
    System.out.println( "| Service bancaire |");
    System.out.println( "+------------------+\n");

    // ...

    // Création de l’objet d’implantation
	ImplCcrHeritage compteImpl = new ImplCcrHeritage(500,0,false);
			
	// ...
			
	// Copie de la référence dans un fichier
	 try {
		 String ref = orb.object_to_string(unCompte);
		 String refFile = "CompteCourantRemunere.ref";
		 FileOutputStream file = new FileOutputStream(refFile);
		 PrintWriter out = new PrintWriter(file);
		 out.println(ref);
		 out.flush() ;
		 file.close();
	 } catch(java.io.IOException ex) {
		// ...
	 }
  }
}
