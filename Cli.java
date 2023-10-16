import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class Cli {

    public static void main(String[] args) {

        // Crée un scanner pour lire l'entrée de l'utilisateur
        Scanner sc = new Scanner(System.in);

        // Affiche le menu de commandes
        System.out.println("Veuillez choisir une commande :");
        System.out.println("* date : Affiche la date actuelle");
        System.out.println("* time : Affiche l'heure actuelle");
        System.out.println("* datetime : Affiche la date et l'heure actuelles");
        System.out.println("* useraccount : Affiche le nom d'utilisateur");
        System.out.println("* userhome : Affiche le répertoire home de l'utilisateur");
        System.out.println("* os : Affiche le nom et la version du système d'exploitation");
        System.out.println("* printenv : Affiche la valeur d'une variable d'environnement");
        System.out.println("* echo : Affiche les arguments de la commande");

        // Récupère la commande de l'utilisateur
        String commande = sc.nextLine();

        // Traite la commande
        switch (commande) {
            case "date":
                // Affiche la date actuelle
                Date date = new Date();
                System.out.println(date);
                break;
            case "time":
                // Affiche l'heure actuelle
                System.out.println(System.currentTimeMillis());
                break;
            case "datetime":
                // Affiche la date et l'heure actuelles
                System.out.println(new Date());
                break;
            case "useraccount":
                // Affiche le nom d'utilisateur
                System.out.println(System.getProperty("user.name"));
                break;
            case "userhome":
                // Affiche le répertoire home de l'utilisateur
                System.out.println(System.getProperty("user.home"));
                break;
            case "os":
                // Affiche le nom et la version du système d'exploitation
                System.out.println(System.getProperty("os.name") + " " + System.getProperty("os.version"));
                break;
            case "printenv":
                // Affiche la valeur d'une variable d'environnement
                System.out.println(System.getenv(args[0]));
                break;
            case "echo":
                // Affiche les arguments de la commande
                for (String arg : args) {
                    System.out.println(arg);
                }
                break;
            default:
                // Commande inconnue
                System.out.println("Commande inconnue");
        }
    }
}

