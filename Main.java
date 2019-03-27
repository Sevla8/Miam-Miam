import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		// creation SiegeMiamMiam
		SiegeMiamMiam siegeMiamMiam = new SiegeMiamMiam();
		// creation Magasins + Usines
		siegeMiamMiam.ajouterMagasin(new Magasin("Store", "Paris"));
		siegeMiamMiam.ajouterUsine(new Usine("Alpha", "Singapour"));
		siegeMiamMiam.ajouterUsine(new Usine("Beta", "Moscow"));
		siegeMiamMiam.ajouterUsine(new Usine("Gama", "Tokyo"));
		// ajout lien Magasin - Usine
		siegeMiamMiam.getMagasins().getFirst().ajouterObservateur(siegeMiamMiam.getUsines().getFirst());
		siegeMiamMiam.getMagasins().getFirst().ajouterObservateur(siegeMiamMiam.getUsines().get(1));
		siegeMiamMiam.getMagasins().getFirst().ajouterObservateur(siegeMiamMiam.getUsines().getLast());
		// creation gamme
		siegeMiamMiam.getMagasins().getFirst().ajouterProduit(siegeMiamMiam.getUsines().getFirst().produire(CodeProduit.choucrouteGarnie, LocalDate.now()));
		siegeMiamMiam.getMagasins().getFirst().ajouterProduit(siegeMiamMiam.getUsines().getLast().produire(CodeProduit.lasagneBoeuf, LocalDate.now()));
		siegeMiamMiam.getMagasins().getFirst().ajouterProduit(siegeMiamMiam.getUsines().get(2).produire(CodeProduit.champignonPersille, LocalDate.now()));
		siegeMiamMiam.getMagasins().getFirst().ajouterProduit(siegeMiamMiam.getUsines().getFirst().produire(CodeProduit.choucrouteGarnie, LocalDate.now()));
		siegeMiamMiam.getMagasins().getFirst().ajouterProduit(siegeMiamMiam.getUsines().getLast().produire(CodeProduit.lasagneBoeuf, LocalDate.now()));
		// destruction Produits
		System.out.println(siegeMiamMiam.detruireProduit(CodeProduit.champignonPersille, LocalDate.now()));
		System.out.println(siegeMiamMiam.detruireProduit(CodeProduit.champignonPersille, LocalDate.now().plusYears(3).plusMonths(5)));
		System.out.println(siegeMiamMiam.detruireProduit(CodeProduit.champignonPersille, LocalDate.now().plusYears(10)));
		// vente Produits
		System.out.println(siegeMiamMiam.getMagasins().getFirst().vendreProduit(CodeProduit.champignonPersille, 15, LocalDate.now()));
		// description SiegeMiamMiam
		System.out.println(siegeMiamMiam.toString());
	}
}
