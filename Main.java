import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		/*Magasin magasin = new Magasin("O'MarcheFrais", "Corbeil-Essonnes");
		Usine usine = new Usine("AH45-GH", "Lieusaint");
		magasin.ajouterProduit(new ChoucrouteGarnie(LocalDate.now(), usine));
		magasin.vendreProduit(1, 5, LocalDate.now());*/

		Usine usine = new Usine("aaa", "vvvv");
		Magasin magasin = new Magasin("fff", "tttt");
		ChampignonPersille produit = new ChampignonPersille(LocalDate.now(), usine);
		CodeProduit codeProduit = new CodeProduit(); 
		magasin.ajouterProduit(produit);
		SiegeMiamMiam siegeMiamMiam = new SiegeMiamMiam();
		siegeMiamMiam.ajouterUsine(usine);
		siegeMiamMiam.ajouterMagasin(magasin);

		System.out.println(siegeMiamMiam.toString());
	}
}
