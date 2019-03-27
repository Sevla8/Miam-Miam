import java.time.LocalDate;

public interface Observateur {
	void evenementProduitVendu(Magasin magasin, int codeProduit, LocalDate aujourdhui, Usine usine);
}