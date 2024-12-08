import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;


public class GestionnaireEvenement {

    private List<Evenement> evenements;

    public GestionnaireEvenement() {
        this.evenements = new ArrayList<Evenement>();
    }
    List<Evenement> getEvenement()
    {
        return evenements;
    }

    public void ajouterEvenement(Evenement evenement) {
        evenements.add(evenement);
    }

    public void supprimerEvenement(Evenement evenement) {
        evenements.remove(evenement);
    }

    public void afficherEvenements(LocalDate Date ,LocalTime Time ) {
        for (Evenement e : evenements) {
            if (e.getDate().equals(Date) && e.getTime().equals(Time))
                System.out.println(e.getTitre());
        }
    }
    public void afficherEvenementsFuture() {
        for (Evenement e : evenements) {
            LocalDateTime datetime = LocalDateTime.of(e.getDate(), e.getTime());
            if (datetime.isAfter(LocalDateTime.now()))
                System.out.println(e.getTitre()+ " - " + e.getDate()+ " - " + e.getTime());
        }
    }

}
