import java.time.LocalDate;
import java.lang.Object;
import java.util.LinkedList;

public class Usine implements Observateur {
	private String nom;
	private String ville;

	public Usine(String nom, String ville) {
		this.nom = nom;
		this.ville = ville;
	}

	public void evenementProduitVendu(Magasin magasin, int codeProduit, LocalDate aujourdhui, Usine usine) {
		int i = 0;
		for (Produit produit : magasin.getGamme()) {
			if (produit.getCodeProduit() == codeProduit && produit.getDateLimite().isBefore(aujourdhui))
				i += 1;
		}
		if (i == 0 && this.equals(usine)) {
			for (int k = 0; k < 10; k += 1) {
				magasin.ajouterProduit(this.produire(codeProduit, aujourdhui));
			}
		}
	}

	public Produit produire(int codeProduit, LocalDate aujourdhui) {
		if (codeProduit == CodeProduit.choucrouteGarnie) {
			return new ChoucrouteGarnie(aujourdhui, this);
		}
		else if (codeProduit == CodeProduit.lasagneBoeuf) {
			return new LasagneBoeuf(aujourdhui, this);
		}
		else 
			return new ChampignonPersille(aujourdhui, this);
	}

	public boolean equals(Object object) {
		if (object == null)
			return false;
		if (this.getClass() != object.getClass())
			return false;
		Usine usine = (Usine) object;
		if (!this.getNom().equals(usine.getNom()))
			return false;
		if (!this.getVille().equals(usine.getVille()))
			return false;
		return true;
	}

	public String toString() {
		return "nom : \n\t" + this.nom + "\nville : \n\t" + this.ville + "\n";
	}

	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getVille() {
		return this.ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
}
