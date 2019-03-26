import java.util.LinkedList;
import java.util.Iterator;

public class SiegeMiamMiam {
	private LinkedList<Usine> usines = new LinkedList<Usine>();
	private LinkedList<Magasin> magasins = new LinkedList<Magasin>();

	public void ajouterUsine(Usine usine) {
		this.usines.add(usine);
	}

	public void ajouterMagasin(Magasin magasin) {
		this.magasins.add(magasin);
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
}