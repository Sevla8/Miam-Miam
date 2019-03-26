import java.time.LocalDate;

public class LasagneBoeuf extends Produit {
	public LasagneBoeuf(LocalDate dateCreation, Usine usine) {
		super(0.280f, 0.30f, 3.20f, dateCreation.plusYears(3), usine);
	}
}