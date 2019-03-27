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
		Iterator<Observateur> it = this.observateurs.iterator();
		while (it.hasNext()) {
			Observateur obs = it.next();
			if (observateur.equals(obs))
				it.remove();
		}
	}

	public void ajouterProduit(Produit produit) {
		this.gamme.add(produit);
	}

	public float vendreProduit(int codeProduit, int quantite, LocalDate aujourdhui) {
		float prix = 0f;
		Collections.sort(this.gamme);
		int i = 0;
		Iterator<Produit> it = this.gamme.iterator();
		Usine usine = null;
		while (it.hasNext() && i < quantite) {
			Produit produit = it.next();
			if (codeProduit == produit.getCodeProduit() && aujourdhui.isBefore(produit.getDateLimite())) {
				prix += produit.getPrixVente();
				usine = new Usine(produit.getUsine().getNom(), produit.getUsine().getVille());
				it.remove();
				quantite += 1 ;
			}
		}
		for (Observateur obs : this.observateurs)
			obs.evenementProduitVendu(this, codeProduit, aujourdhui, usine);
		return prix;
	}

	public float detruireProduit(int codeProduit, LocalDate aujourdhui) {
		float perte = 0f;
		Iterator<Produit> it = this.gamme.iterator();
		Usine usine = null;
		while(it.hasNext()) {
			Produit produit = it.next();
			if (codeProduit == produit.getCodeProduit() && produit.getDateLimite().isBefore(aujourdhui)) {
				perte += produit.getPrixVente();
				usine = new Usine(produit.getUsine().getNom(), produit.getUsine().getVille());
				it.remove();
			}
		}
		for (Observateur obs : this.observateurs)
			obs.evenementProduitVendu(this, codeProduit, aujourdhui, usine);
		return perte;
	}

	public String toString() {
		String string = new String("");
		string += "nom : \n\t" + this.nom + "\nville : \n\t" + this.ville + "\ngamme : \n";
		for (Produit produit : this.gamme)
			string += produit.toString();
		string += "observateurs : \n";
		for (Observateur obs : this.observateurs)
			string += obs.toString();
		return string;
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
	public LinkedList<Produit> getGamme() {
		return this.gamme;
	}
	public LinkedList<Observateur> getObservateurs() {
		return this.observateurs;
	}
}
