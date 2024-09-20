package banque;

import org.omg.CORBA.ORB;

public class CompteImpl extends ComptePOA {
	private double solde;
	private ORB orb;
	
	public CompteImpl() {
		solde = 0;
	}

	@Override
	public void lireMontant() {
		System.out.println(solde);
	}

	@Override
	public void crediter(double montant) {
		if(montant > 0) {
			solde += montant;
			System.out.println("Crédité: " + montant + ", Nouveau solde: " + solde);
		} else {
			System.out.println("Montant invalide pour le crédit.");
		}
		
	}

	@Override
	public void debiter(double montant) {
		if (montant > 0 && montant <= solde) {
            solde -= montant; 
            System.out.println("Débité: " + montant + ", Nouveau solde: " + solde);
        } else {
            System.out.println("Montant invalide pour le débit.");
        }
		
	}
	
	public void setORB(ORB orb_val) {
        orb = orb_val;
    }

}
