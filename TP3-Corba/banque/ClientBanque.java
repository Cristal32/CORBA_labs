package banque;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import org.omg.CORBA.ORB;
import org.omg.CORBA.SystemException;

// Import …

public class ClientBanque { 
	public static void main (String args[]) {	
		try {
			Properties props = System.getProperties();
			
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
			 
	      } catch(SystemException ex) {
	    	  ex.printStackTrace();
	      }
	}
	
	static int run(ORB orb) throws IOException {
		 org.omg.CORBA.Object obj = null;
		 
		 // Link to distant object
		 String ref = null;
		 String refFile = "Compte_courant_remunere.ref";
		 FileInputStream file = new FileInputStream(refFile);
		 BufferedReader in = new BufferedReader(new InputStreamReader(file));
		 ref = in.readLine();
		 file.close();

		 obj = orb.string_to_object(ref);
		 
		 CompteCourantRemunere compte = CompteCourantRemunereHelper.narrow(obj);
		 
		 System.out.println( "+------------------+");
	      System.out.println( "| Service bancaire |");
	      System.out.println( "+------------------+\n");
	      System.out.println( "1 : Lecture du montant du compte\n");
	      System.out.println( "2 : Credit du compte" );
	      System.out.println( "3 : Debit du compte\n" );
	      System.out.println( "4 : Lecture du taux de rémunération" );
	      System.out.println( "5 : Mise à jour du taux de rémunération\n" );
	      System.out.println( "6 : Lecture de l'autorisation de découvert" );
	      System.out.println( "7 : Mise à jour de l'autorisation de découvert\n" );
	      System.out.println( "0 : Quitter\n");
		 
		 // Call operations
		 try {
			 char ch = lire_char() ;
				
				while (ch != '0') {
					  switch(ch) {
					  	case '1':
					  		// Lecture du montant du compte
					  		float montant = compte.lire_montant();
					  		System.out.println("Montant: " + montant);
					  		break;
					  		
			            case '2':
			            	// Crediter le compte
			            	System.out.print("Montant à créditer: ");
			            	float credit = lire_float();
			            	compte.crediter(credit);
			            	break;
			            	
			            case '3':
			            	// Debiter le compte
			            	System.out.print("Montant à débiter: ");
			            	float debit = lire_float();
			            	compte.debiter(debit);
			            	break;
			            	
			            case '4':
			            	// Lecture du taux de rémunération
			            	int taux = compte.taux();
			            	System.out.print("Taux: " + taux + "\n");
			            	break;
			            	
			            case '5':
			                // Mise à jour du taux de rémunération
			            	System.out.print("Nouveau taux: ");
			            	int newTaux = lire_int();
			            	compte.taux(newTaux);
			            	break;
		
			            case '6':
			                // Lecture de l’autorisation de découvert
			            	boolean decouvert = compte.DecouvertAutorise();
			            	if(decouvert) {
			            		System.out.println("Le compte à découvert est autorisé\n");
			            	} else {
			            		System.out.println("Le compte à découvert n'est pas autorisé\n");
			            	}
			            	break;
		
			            case '7':
			                // Mise à jour de l’autorisation de découvert 
			            	System.out.println("Mettre à jour l'autorisation du découvert (O: découvert, N: non découvert): ");
			            	int newDecouvert = lire_char();
			            	if(newDecouvert == 'o' || newDecouvert == 'O') {
			            		compte.DecouvertAutorise(true);
			            	} else {
			            		if(newDecouvert == 'n' || newDecouvert == 'N') {
			            			compte.DecouvertAutorise(false);
			            		} else {
			            			System.out.println("Mauvaise saisie, ré-essayer.\n");
			            		}
			            	}
			            	break;
		
			           default:
			        	   	// Erreur de saisie
			        	   	System.out.println("Mauvaise saisie, ré-essayer.\n");
			        	   	break;
			          }
						  
					  ch = lire_char();      
		         }
			 
		 } catch(SystemException ex) {
			 System.err.println(" -- Erreur CORBA -- \n" + ex.getMessage());
			 ex.printStackTrace();
			 return 1;
		 }
		 
		 return 0;
	}
 
  static char lire_char() {
	System.out.println( "Taper le code de l'opération à effectuer : ");
    String chaine;
    
    try {
      java.io.DataInputStream dataIn = new java.io.DataInputStream(System.in);
      BufferedReader in = new BufferedReader(new InputStreamReader(dataIn));
      chaine = in.readLine();
    } catch(java.io.IOException ex) {
    	System.err.println(ex.getMessage());
    	ex.printStackTrace();
    	return(' ');
    }
    
    return(chaine.charAt(0));
  }
  
  static float lire_float() {
	  String chaine;
	  
	  try {
		  java.io.DataInputStream dataIn = new java.io.DataInputStream(System.in);
		  BufferedReader in = new BufferedReader(new InputStreamReader(dataIn));
		  chaine = in.readLine();
	  } catch(java.io.IOException ex) {
		  System.err.println(ex.getMessage());
		  ex.printStackTrace();
		  return(0);
	  }
		
	  return(Float.parseFloat(chaine));
  }
  
  static int lire_int() {
	  String chaine;
	  
	  try {
		  java.io.DataInputStream dataIn = new java.io.DataInputStream(System.in);
	      BufferedReader in = new BufferedReader(new InputStreamReader(dataIn));
	      chaine = in.readLine();
	   } catch(java.io.IOException ex) {
		   System.err.println(ex.getMessage());
		   ex.printStackTrace();
		   return(0);
	   }
	    
	  return(Integer.parseInt(chaine));
  }
  
 }