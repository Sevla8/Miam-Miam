import java.time.LocalDate;

public class ChoucrouteGarnie extends Produit {
	public ChoucrouteGarnie(LocalDate dateCreation, Usine usine) {
		super(0.24f, 1.80f, 3.40f, dateCreation.plusYears(5), usine);
	}
}