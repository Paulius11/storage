import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private CSVParser parser;
    private CSVFormat format;
    private List<Item> itemArray;
    private List<Item> mergedItemArray;
    private String path;

    public CSVParser getParser() {
        return parser;
    }

    public CSVFormat getFormat() {
        return format;
    }

    public List<Item> getItemArray() {
        return itemArray;
    }

    public String getPath() {
        return path;
    }

    public List<Item> getMergedItemArray() {
        return mergedItemArray;
    }

    public void parseCSV(String csvPath) throws IOException, ParseException {
        //Create the CSVFormat object
        format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

        //initialize the CSVParser object
        this.path = csvPath;
        parser = new CSVParser(new FileReader(this.path), format);

        //create array list
        itemArray = new ArrayList<>();
        //create items as objects and add it to item list
        for (CSVRecord record : parser) {
            Item itemObj = new Item();
            itemObj.setItemName(record.get("Item Name"));
            itemObj.setCode(new BigInteger(record.get("Code")));
            itemObj.setQuantity(Integer.parseInt(record.get("Quantity")));
            SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
            itemObj.setExpirationData(formatter1.parse(record.get("Expiration Date")));
            itemArray.add(itemObj);
        }
        //close the parser
        parser.close();

    }

    // Item is considered equal if itemName, code, expirationData are equal
    public void mergeEqualItems() {
        mergedItemArray = new ArrayList<>();
        for (Item p : itemArray) {
            int index = mergedItemArray.indexOf(p);
            if (index != -1) {
                mergedItemArray.set(index, mergedItemArray.get(index).merge(p));
            } else {
                mergedItemArray.add(p);
            }
        }
    }

    // return how many items are merged into one item.
    public int getMergeDifference() {
        return itemArray.size() - mergedItemArray.size();
    }
}

