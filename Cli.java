import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import java.util.Scanner;

public class Cli {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");

        while (true) {
            String command = scanner.nextLine();
            String output = "";

            if (command.equals("exit")) {
                break;
            } else {
                String[] arguments = command.split(" ");

                switch (arguments[0]) {
                    case "date":
                        output = LocalDate.now().toString();
                        break;
                    case "time":
                        output = LocalTime.now().toString();
                        break;
                    case "datetime":
                        output = LocalDateTime.now().toString();
                        break;
                    case "useraccount":
                        output = System.getProperty("user.name");
                        break;
                    case "userhome":
                        output = System.getProperty("user.home");
                        break;
                    case "os":
                        output = System.getProperty("os.name") + " " + System.getProperty("os.version");
                        break;
                    case "printenv":
                        if (arguments.length == 1) {
                            Map<String, String> env = System.getenv();
                            for (String key : env.keySet()) {
                                System.out.println(key + "=" + env.get(key));
                            }
                        } else if (arguments.length == 2) {
                            String variableName = arguments[1];
                            String value = System.getenv(variableName);
                            if (value != null) {
                                System.out.println(variableName + "=" + value);
                            } else {
                                System.out.println("Variable d'environnement " + variableName + " introuvable.");
                            }
                        } else {
                            output = "Commande 'printenv' invalide.";
                        }
                        break;
                    case "logout":
                        output = "Fermeture du CLI.";
                        System.exit(0);
                        break;
                    case "print":
                        if (arguments.length == 1) {
                            output = "";
                        } else {
                            output = String.join(" ", arguments);
                        }
                        break;
                    case "ls":
                        String path = arguments.length == 1 ? "." : arguments[1];
                        File directory = new File(path);
                        if (directory.isDirectory()) {
                            for (String fileName : directory.list()) {
                                System.out.println(fileName);
                            }
                        } else {
                            output = "Not a directory.";
                        }
                        break;
                    default:
                        if (command.startsWith("printenvx")) {
                            output = "commande printenvx not found.";
                        } else {
                            output = command + ", commande not found.";
                        }
                        break;
                }
            }

            System.out.println(output);
            System.out.print("> ");
        }

        scanner.close();
    }
}

