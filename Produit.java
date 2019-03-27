import java.time.LocalDate;
import java.lang.Comparable;
import java.lang.Class;

public abstract class Produit implements Comparable<Produit>{
	private float poids;
	private float coutFabrication;
	private float prixVente;
	private LocalDate dateLimite;
	private Usine usine;
	private int codeProduit;

	public Produit(float poids, float coutFabrication, float prixVente, LocalDate dateLimite, Usine usine, int codeProduit) {
		if (poids < 0)
			this.poids = 0;
		else
			this.poids = poids;
		if (coutFabrication < 0)
			this.coutFabrication = 0;
		else
			this.coutFabrication = coutFabrication;
		this.prixVente = prixVente;
		this.dateLimite = dateLimite;
		this.usine = usine;
		this.codeProduit = codeProduit;
	}

	public int compareTo(Produit produit) {
		return this.dateLimite.compareTo(produit.dateLimite);
	}

	public String toString() {
		return this.getClass().getName() + " : " + 
			"\npoids : \n\t" + this.poids + 
			"\ncoutFabrication : \n\t" 	+ this.coutFabrication + 
			"\nprixVente : \n\t" + this.prixVente + 
			"\ndateLimite : \n\t" + this.dateLimite + 
			"\nusine : \n" + this.usine.toString();
	}

	public void setPrixVente(float prixVente) {
		this.prixVente = prixVente;
	}
	public float getPrixVente() {
		return this.prixVente;
	}
	public float getCoutFabrication() {
		return this.coutFabrication;
	}
	public float getPoids() {
		return this.poids;
	}
	public LocalDate getDateLimite() {
		return this.dateLimite;
	}
	public Usine getUsine() {
		return this.usine;
	}
	public int getCodeProduit() {
		return this.codeProduit;
	}
}
