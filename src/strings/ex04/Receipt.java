package strings.ex04;


//: strings/Receipt.java
import java.util.*;


public class Receipt {
    private double total = 0;
    private Formatter f = new Formatter(System.out);
    private static final double TAX = 0.06;
    private static final int ITEM = 15, QTY = 5, PRICE = 10;
    private static final String
        TITLE_FORMAT = "%-" + ITEM + "s %" + QTY + "s %" + PRICE + "s\n",
        PRINT_FORMAT = "%-" + ITEM + "." + ITEM + "s %" + QTY + "d %" + PRICE + ".2f\n",
        TOTAL_FORMAT = "%-" + ITEM + "s %" + QTY + "s %" + PRICE + ".2f\n";

    public void printTitle() {
        f.format(TITLE_FORMAT, "Item", "Qty", "Price");
        f.format("%-15s %5s %10s\n", "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        f.format(PRINT_FORMAT, name, qty, price);
        total += price;
    }

    public void printTotal() {
        f.format(TOTAL_FORMAT, "Tax", "", total * TAX);
        f.format(TITLE_FORMAT, "", "", "-----");
        f.format(TOTAL_FORMAT, "Total", "", total * (1.0 + TAX));
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack's Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }
} /* Output:
Item              Qty      Price
----              ---      -----
Jack's Magic Be     4       4.25
Princess Peas       3       5.10
Three Bears Por     1      14.29
Tax                         1.42
                           -----
Total                      25.06
*///:~