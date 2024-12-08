import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Evenement evenement ;
        GestionnaireEvenement GestionnaireEvenements = new GestionnaireEvenement();
        Scanner scanner = new Scanner(System.in);
        LocalDate date = null ;
        LocalTime time = null ;   ;
        String dateStr , timeStr,titre ,comfirmation;
        int nombreAjout=0;

        while (true) {

            System.out.println("Menu :");
            System.out.println("1 : Ajouter un événement");
            System.out.println("2 : Afficher les événements d'une date");
            System.out.println("3 : Supprimer un événement");
            System.out.println("4 : Afficher tous les événements futurs");
            System.out.println("5 : Quitter");
            System.out.print("Choisissez une option : ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Combier d'événement souhaitez vous ajouter ?  ");
                    nombreAjout = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < nombreAjout; i++) {
                        System.out.print("Entrez le titre de l'événement N"+(i+1)+": ");
                        titre = scanner.nextLine();
                        while (date == null) {
                            System.out.print("Entrez la date (YYYY-MM-DD) : ");
                            dateStr = scanner.nextLine();
                            try {
                                date = LocalDate.parse(dateStr);
                            } catch (Exception e) {
                                System.out.println("Format incorrect ! Exemple de format valide : 2024-12-08");
                            }
                        }
                        while (time == null) {
                            System.out.print("Entrez l'heure  (HH:MM) : ");
                            timeStr = scanner.nextLine();
                            try {
                                time = LocalTime.parse(timeStr);
                            } catch (Exception e) {
                                System.out.println("Format incorrect ! Exemple de format valide : 14:30");
                            }
                        }
                        evenement = new Evenement(titre, date, time);
                        GestionnaireEvenements.ajouterEvenement(evenement);
                        System.out.println(" L'evenement " + titre + " a été ajouté avec succes !!!! ");
                        date = null;
                        time = null;
                    }
                    break;
                case 2:
                    while (date == null) {
                        System.out.print("Entrez la date de l'événement (YYYY-MM-DD) : ");
                        dateStr = scanner.nextLine();
                        try {
                            date = LocalDate.parse(dateStr);
                        } catch (Exception  e) {
                            System.out.println("Format incorrect ! Exemple de format valide : 2024-12-08");
                        }
                    }
                    while (time == null) {
                        System.out.print("Entrez l'heure de l'événement (HH:MM) : ");
                        timeStr = scanner.nextLine();
                        try {
                            time = LocalTime.parse(timeStr);
                        } catch (Exception e) {
                            System.out.println("Format incorrect ! Exemple de format valide : 14:30");
                        }
                    }
                    GestionnaireEvenements.afficherEvenements(date, time);
                    date = null;
                    time = null ;
                    break;
                case 3:
                    System.out.print("Entrez le titre de l'événement à supprimer  : ");
                    titre = scanner.nextLine();
                    while (date == null) {
                        System.out.print("Entrez la date de l'événement (YYYY-MM-DD) : ");
                        dateStr = scanner.nextLine();
                        try {
                            date = LocalDate.parse(dateStr);
                        } catch (Exception  e) {
                            System.out.println("Format incorrect ! Exemple de format valide : 2024-12-08");
                        }
                    }
                    while (time == null) {
                        System.out.print("Entrez l'heure de l'événement (HH:MM) : ");
                        timeStr = scanner.nextLine();
                        try {
                            time = LocalTime.parse(timeStr);
                        } catch (Exception e) {
                            System.out.println("Format incorrect ! Exemple de format valide : 14:30");
                        }
                    }
                    Evenement evenementASupprimer = null;
                    for (Evenement e : GestionnaireEvenements.getEvenement()) {
                        if (e.getTitre().equals(titre) && e.getDate().equals(date) && e.getTime().equals(time)) {
                            evenementASupprimer = e;
                            break;
                        }
                    }
                    if (evenementASupprimer != null) {
                        System.out.print("êtes vous sûre de supprimer l'événement ? si sûre : 'tapez oui' sinon : 'n'importe quelle caractère' => ");
                        comfirmation = scanner.nextLine();
                        if(comfirmation.equals("oui")){
                        GestionnaireEvenements.supprimerEvenement(evenementASupprimer);
                        System.out.println("Événement supprimé avec succès.");}
                        else
                            System.out.println("suppression annuléé !!!!");


                    } else {
                        System.out.println("Événement non trouvé.");
                    }
                    date = null;
                    time = null ;
                    break;
                case 4:
                    System.out.println(" Voila tous les événements futurs : ");
                    GestionnaireEvenements.afficherEvenementsFuture();
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;
                default:
                    System.out.println("Option invalide , Veuillez réssayer !");


            }


        }
    }
}