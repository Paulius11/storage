import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        String csvFilePath = "/home/sup/IdeaProjects/vismaPraktika/src/csv_data/sample.csv";
        start(csvFilePath);


    }

    private static void start(String csvFilePath) throws IOException, ParseException {
        Panel panel = new Panel();
        Parser parse = new Parser();
        parse.parseCSV(csvFilePath);
        parse.mergeEqualItems();
        List<Item> items = parse.getMergedItemArray();


        while (true) {
            System.out.print(Panel.MENU);
            String choice = panel.getStrInput();
            switch (choice) {
                case "1":
                    System.out.print("Please enter item quantity: ");
                    int quantity = panel.getIntInput();
                    for (Item item : items) {
                        if (quantity <= item.getQuantity()) {
                            System.out.println(item);
                        }
                    }
                    break;
                case "2":
                    System.out.print("Please enter date: (format yyyy-mm-dd) : ");
                    DateFormat sourceFormat = new SimpleDateFormat("yyyy-mm-dd");
                    String dateAsString = panel.getStrInput();
                    System.out.println(dateAsString);
                    try {
                        Date date = sourceFormat.parse(dateAsString);
                        for (Item item : items) {
                            if (date.after(item.getExpirationData())) {
                                System.out.println(item);
                            }
                        }
                    } catch (ParseException e) {
                        System.out.println("Incorrect date format");
                    }


                    break;
                case "x":
                    System.exit(0);
            }

        }
    }
}
