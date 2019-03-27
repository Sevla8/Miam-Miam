import java.time.LocalDate;
import java.time.Month;

public class LasagneBoeuf extends Produit {
	public LasagneBoeuf(LocalDate dateCreation, Usine usine) {
		super(0.280f, 0.30f, 3.20f, dateCreation.plusYears(3), usine, CodeProduit.lasagneBoeuf);
	}

	public LocalDate getDateLimite() {
		if (super.getDateLimite().getMonth() == Month.JUNE) {
			return super.getDateLimite().plusMonths(9);
		}
		else if (super.getDateLimite().getMonth() == Month.JANUARY && super.getDateLimite().getDayOfMonth() == 10) 
			return super.getDateLimite().plusYears(69);
		else 
			return super.getDateLimite();
	}
}
