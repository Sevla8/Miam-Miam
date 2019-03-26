import java.util.LinkedList;
import java.util.Iterator;
import java.time.LocalDate;
import java.util.Collections;

public class Magasin implements Observable {
	private String nom;
	private String ville;
	private LinkedList<Produit> gamme = new LinkedList<Produit>();
	private LinkedList<Observateur> observateurs = new LinkedList<Observateur>();

	public Magasin(String nom, String ville) {
		this.nom = nom;
		this.ville = ville;
	}

	public void ajouterObservateur(Observateur observateur) {
		this.observateurs.add(observateur);
	}

	public void supprimerObservateur(Observateur observateur) {

	}

	public void ajouterProduit(Produit produit) {
		this.gamme.add(produit);
	}

	public float vendreProduit(int codeProduit, int quantite, LocalDate aujourdhui) {
		Collections.sort(this.gamme);

		float prix = 0f;
		int i = 0;

		Iterator<Produit> it = this.gamme.iterator();
		while(it.hasNext() && i <= quantite) {
			Produit produit = it.next();

			if (codeProduit == CodeProduit.choucrouteGarnie && 
					aujourdhui.isBefore(produit.getDateLimite())) {
				prix += produit.getPrixVente();
				it.remove();
				quantite += 1 ;
			}
			
			else if (codeProduit == CodeProduit.lasagneBoeuf && 
					aujourdhui.isBefore(produit.getDateLimite())) {
				prix += produit.getPrixVente();
				it.remove();
				quantite += 1 ;
			}

			else {
				prix += produit.getPrixVente();
				it.remove();
				quantite += 1 ;
			}
		}

		for (Observateur obs : this.observateurs)
			obs.evenementProduitVendu(this, codeProduit, aujourdhui);

		return prix;
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

	public String toString() {
		String string = new String("");
		string += "nom : \n\t" + this.nom + "\nville : \n\t" + this.ville + "\ngamme : \n";
		for (Produit produit : gamme)
			string += produit.toString();
		return string;
	}
}
