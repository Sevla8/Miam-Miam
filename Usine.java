import java.time.LocalDate;
import java.lang.Object;

public class Usine implements Observateur {
	private String nom;
	private String ville;

	public Usine(String nom, String ville) {
		this.nom = nom;
		this.ville = ville;
	}

	public void evenementProduitVendu(Magasin magasin, int codeProduit, LocalDate aujourdhui) {
	// 	if (codeProduit == CodeProduit.ChoucrouteGarnie) {
	// 		if (magasin.)
	// 	}
	// 	else if (codeProduit == CodeProduit.LasagneBoeuf) {
			
	// 	}
	// 	else {
			
	// 	}
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
		return "nom : \n\t" + this.nom + "\nville : \n\t" + this.ville;
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