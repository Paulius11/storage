import java.util.Scanner;

public class Panel {

    public static final String MENU =
            "\nMeniu:\n" +
                    "1. Find items by quantity.\n" +
                    "2. Find expired items by date.\n" +
                    "x. Exit.\n" +
                    "";

    Scanner scanner = new Scanner(System.in);

    public Scanner getScanner() {

        return scanner;
    }

    // get string input  from keyboard
    public String getStrInput() {
        System.out.print("> ");
        while (true) {
            try {
                return scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Incorrect input, please type again;");
            }
        }

    }

    // get int input from keyboard
    public int getIntInput() {
        System.out.print("> ");
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Incorrect input, please type again;");
            }
        }

    }
}
