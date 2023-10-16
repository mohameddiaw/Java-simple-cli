import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Cli {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Listen to the standard input (console)
        System.out.print("> "); // Prompt
        while (true) { // Infinite loop
            String command = scanner.nextLine(); // Get input from console as a string
            String output = ""; // A variable named output of type String
            if (command.equals("exit")) {
                break; // Forces exit of the while loop
            } else {
                switch (command) {
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
                        output = System.getenv(args[0]);
                        break;
                    case "echo":
                        for (String arg : args) {
                            output += arg + " ";
                        }
                        break;
                    default:
                        output = "Command '" + command + "' not found.";
                        break;
                }
            }
            System.out.println(output); // Print with new line (ln)
            System.out.print("> "); // Prompt
        }
    }
}

