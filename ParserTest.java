import java.io.IOException;
import java.text.ParseException;

public class ParserTest {
    public static void main(String[] args) throws IOException, ParseException {
        Parser parse = new Parser();
        parse.parseCSV("/home/sup/IdeaProjects/vismaPraktika/src/csv_data/sample.csv");
        parse.mergeEqualItems();
        System.out.println("Merged items: " + parse.getMergeDifference());
    }


}