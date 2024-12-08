import java.time.LocalDate;
import java.time.LocalTime;

public class Evenement {
    private String titre;
    private LocalDate date;
    private LocalTime time;

    Evenement(String titre, LocalDate date, LocalTime time) {
        this.titre = titre;
        this.date = date;
        this.time = time;
    }
    public String getTitre() {
        return titre;
    }
    public LocalDate getDate() {
        return date;
    }
    public LocalTime getTime() {
        return time;
    }


}
