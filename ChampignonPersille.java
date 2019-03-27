import java.time.LocalDate;

public class ChampignonPersille extends Produit {
	public ChampignonPersille(LocalDate dateCreation, Usine usine) {
		super(0.150f, 2.0f, 3.90f, dateCreation.plusYears(3), usine);
	}

	public LocalDate getDateLimite() {
		int n = this.getUsine().getNom().length() * this.getUsine().getNom().length();
		return super.getDateLimite().plusMonths(n);
	}
}
