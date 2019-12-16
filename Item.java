import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

public class Item implements Comparable<Item> {
    private String itemName;
    //        659 879 897 646 897 456
    // int              2 147 483 647
    // long 9 223 372 036 854 775 807

    private BigInteger code;
    private int quantity;
    private Date expirationData;

    public Item() {

    }

    public Item(String itemName, BigInteger code, int quantity, Date expirationData) {
        this.itemName = itemName;
        this.code = code;
        this.quantity = quantity;
        this.expirationData = expirationData;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigInteger getCode() {
        return code;
    }

    public void setCode(BigInteger code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpirationData() {
        return expirationData;
    }

    public void setExpirationData(Date expirationData) {
        this.expirationData = expirationData;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", code=" + code +
                ", quantity=" + quantity +
                ", expirationData=" + expirationData +
                '}';
    }

    @Override
    public int compareTo(Item itm) {
        //Order by item name
        int result = itemName.compareTo(itm.itemName);

        //If names are equal order by code
        if (result == 0) {
            result = code.compareTo(itm.code);
        }
        return result;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemName.equals(item.itemName) &&
                code.equals(item.code) &&
                expirationData.equals(item.expirationData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, code, expirationData);
    }

    // Merges equal elements in list
    public Item merge(Item other) {
        assert (this.equals(other));
        return new Item(this.itemName, this.code, this.quantity + other.quantity, this.expirationData);
    }
}