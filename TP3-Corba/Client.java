Package banque ;
Import …
Public class client_banque
{ public static void main (String args[])
 {	....
// Liaison à un compte
….
// Déclaration de l’objet compte et des variables
…
// Boucle de saisie du choix du client
char ch = lire_choix() ;
while (ch !=’0’) {
  switch(ch) {
            case '1':
              // Lecture du montant du compte
              		…
            case '2':
              // Crediter le compte
	...
            case '3':
              // Debiter le compte
		…
            case '4':
              // Lecture du taux de rémunération
		…
            case '5':
              // Mise à jour du taux de rémunération
		…
            case '6':
              // Lecture de l’autorisation de découvert
		…
            case '7':
              // Mise à jour de l’autorisation de découvert 
		…
           default:
              // Erreur de saisie
		…
          }
          ch=lire_choix();      
        }
      }
      catch(SystemException ex) …
	...  
  static char lire_choix() {
      System.out.println( "+------------------+");
      System.out.println( "| Service bancaire |");
      System.out.println( "+------------------+\n");
      System.out.println( "1 : Lecture du montant du compte");
      System.out.println( "2 : Credit du compte" );
      System.out.println( "3 : Debit du compte\n" );
      System.out.println( "4 : Lecture du taux de rémunération\n" );
     System.out.println( "5 : Mise a jour du taux de remuneration" );
      System.out.println( "6 : Lecture de l'autorisation de decouvert" );
      System.out.println( "7 : Mise a jour de l'autorisation de decouvert\n" );
      System.out.println( "0 : Quitter\n");
      System.out.println( "Taper le code de l'operation a effectuer : ");
      return(lire_char());
  }
 
  static char lire_char() {
    String chaine;
    try {
      java.io.DataInputStream dataIn = new java.io.DataInputStream(System.in);
      BufferedReader in =  new BufferedReader(new InputStreamReader(dataIn));
      chaine = in.readLine();
    }
    catch(java.io.IOException ex)
    {
      System.err.println(ex.getMessage());
      ex.printStackTrace();
      return(' ');
    }
    return(chaine.charAt(0));
  }
   static float lire_float() {
    String chaine;
    try {
      java.io.DataInputStream dataIn =  new java.io.DataInputStream(System.in);
      BufferedReader in =  new BufferedReader(new InputStreamReader(dataIn));
      chaine = in.readLine();
    }
    catch(java.io.IOException ex)
    {
      System.err.println(ex.getMessage());
      ex.printStackTrace();
      return(0);
    }
    return(Float.parseFloat(chaine));
  }
static int lire_int() {
    String chaine;
    try {
      java.io.DataInputStream dataIn =
      new java.io.DataInputStream(System.in);
      BufferedReader in =
      new BufferedReader(new InputStreamReader(dataIn));
     chaine = in.readLine();
    }
    catch(java.io.IOException ex)
    {
      System.err.println(ex.getMessage());
      ex.printStackTrace();
      return(0);
    }
    return(Integer.parseInt(chaine));
  }
 }
