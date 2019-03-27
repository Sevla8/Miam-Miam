import java.util.LinkedList;
import java.util.Iterator;
import java.time.LocalDate;

public class SiegeMiamMiam {
	private LinkedList<Usine> usines = new LinkedList<Usine>();
	private LinkedList<Magasin> magasins = new LinkedList<Magasin>();

	public void ajouterUsine(Usine usine) {
		this.usines.add(usine);
	}

	public void ajouterMagasin(Magasin magasin) {
		this.magasins.add(magasin);
	}

	public float detruireProduit(int codeProduit, LocalDate aujourdhui) {
		float perte = 0f;
		for (Magasin magasin : this.magasins)
			perte += magasin.detruireProduit(codeProduit, aujourdhui);
		return perte;
	}

	public String toString() {
		String string = new String("");
		string += "usines : \n";
		for (Usine usine : this.usines)
			string += usine.toString();
		string += "\nmagasins : \n";
		for (Magasin magasin : this.magasins)
			string += magasin.toString();
		return string;
	}

	public LinkedList<Usine> getUsines() {
		return this.usines;
	}
	public LinkedList<Magasin> getMagasins() {
		return this.magasins;
	}
}