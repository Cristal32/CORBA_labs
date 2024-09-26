package banque;

import org.omg.CORBA.ORB;

// Implementation du Compte Courant Heritage
public class ImplCcrHeritage extends CompteCourantRemunerePOA {
	private float _montant = 0; 
	private int _taux = 0; 
	private boolean _decouvert = false;
	private ORB orb;
	
	// Constructeur
	public ImplCcrHeritage(float montant, int taux, boolean decouvert) {
		_montant = montant;
		_taux = taux;
		_decouvert = decouvert;
	}
	
	@Override
	public float lire_montant() {
		return _montant;
	}
	
	@Override
	public void crediter(float somme_credit) {
		if(somme_credit > 0) {
			_montant += somme_credit;
			System.out.println("Crédité: " + somme_credit + ", Nouveau solde: " + _montant);
		} else {
			System.out.println("Montant invalide pour le credit.");
		}
	}
	
	@Override
	public void debiter(float somme_debit) {
		// La somme a debiter > 0 et soit decouvert non autorise, dans ce case montant > somme, soit decouvert autorise et montant peut devenir negatif
		if (somme_debit > 0 && ((!_decouvert && _montant > somme_debit) || _decouvert)) {
			_montant -= somme_debit;
            System.out.println("Débité: " + somme_debit + ", Nouveau solde: " + _montant);
        } else {
            System.out.println("Montant invalide pour le debit.");
        }
	}
	
	@Override
	public int taux() {
		return _taux;
	}
	
	@Override
	public void taux(int newTaux) {
		if(newTaux >= 0) {
			_taux = newTaux;
			System.out.println("Nouveau taux: " + newTaux);
		} else {
			System.out.println("Taux invalide.");
		}
	}
	
	@Override
	public boolean DecouvertAutorise() {
		return _decouvert;
	}
	
	@Override
	public void DecouvertAutorise(boolean newDecouvertAutorise) {
		_decouvert = newDecouvertAutorise;
		if(_decouvert) {
			System.out.println("Le compte est maintenant à découvert.");
		} else {
			System.out.println("Le compte est maintenant non à découvert.");
		}
	}
	
	public void setORB(ORB orb_val) {
        orb = orb_val;
    }
}