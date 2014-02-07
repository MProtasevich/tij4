package concurrency.ex24;


public class Item {
    private final int itemNum;

    public Item(int itemNum) {
        this.itemNum = itemNum;
    }

    @Override
    public String toString() {
        return "Item " + itemNum;
    }
}