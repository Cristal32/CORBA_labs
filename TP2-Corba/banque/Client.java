package banque;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.omg.CORBA.ORB;
import org.omg.CORBA.SystemException;

public class Client {
	public static void main(String args[]) {
		 
		 java.util.Properties props = System.getProperties();
		
		 int status = 0;
		 ORB orb = null;
		
		 try {
			 // Initialize orb
			 orb = ORB.init(args, props);
			 status = run(orb);
		 } catch(Exception ex) {
			 ex.printStackTrace();
			 status = 1;
		 }
		
		 if(orb != null) {
			 try {
				 orb.destroy();
			 } catch(Exception ex) {
				 ex.printStackTrace();
				 status = 1;
			 }
		 }
		
		 System.exit(status);
	 }
	
	 static int run(ORB orb) throws IOException {
		 org.omg.CORBA.Object obj = null;
		 
		 // Link to distant object
		 String ref = null;
		 String refFile = "Compte.ref";
		 FileInputStream file = new FileInputStream(refFile);
		 BufferedReader in = new BufferedReader(new InputStreamReader(file));
		 ref = in.readLine();
		 file.close();

		 obj = orb.string_to_object(ref);
		 
		 Compte compte = CompteHelper.narrow(obj);
		 
		 // Call operations
		 try {
			 Scanner scanner = new Scanner(System.in);
			 int choice;
			 
			 System.out.println("+---------------------------+");
             System.out.println("|      Service bancaire      |");
             System.out.println("+---------------------------+");
             System.out.println("1 : Lecture du montant du compte");
             System.out.println("2 : Crédit du compte");
             System.out.println("3 : Débit du compte");
             System.out.println("0 : Quitter");
             System.out.print("Taper le code de l'opération à effectuer : ");
             
			 do {
				 choice = scanner.nextInt();
				 
				 switch (choice) {
	                 case 1:
	                	 compte.lireMontant();
	                     break;
	                 case 2:
	                     System.out.print("Montant à créditer: ");
	                     float credit = scanner.nextFloat();
	                     compte.crediter(credit);
	                     break;
	                 case 3:
	                     System.out.print("Montant à débiter: ");
	                     float debit = scanner.nextFloat();
	                     compte.debiter(debit);
	                     break;
	             }
			 } while(choice != 0);
			 scanner.close();
			 
		 } catch(SystemException ex) {
			 System.err.println(" -- Erreur CORBA -- \n" + ex.getMessage());
			 ex.printStackTrace();
			 return 1;
		 }
		 
		 return 0;
	}
}
