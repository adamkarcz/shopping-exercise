package basket;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock;
    private int reserved;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
        this.reserved = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public int getReserved() {
        return reserved;
    }

    public void setPrice(double price) {
        if (price > 0){
            this.price = price;
            }
    }

    public void reserve (int reserved){
        int newReserved = this.reserved + reserved;
        if (newReserved <= this.quantityStock){
            this.reserved = newReserved;
        }
    }

    public void unreserve (int reserved){
        int newReserved = this.reserved - reserved;
        if (newReserved >= 0){
            this.reserved = newReserved;
        }
    }


    public void adjustStock(int reserved) {
        int newQuantity = this.quantityStock - reserved;
        if (newQuantity >= 0){
            this.quantityStock = newQuantity;
        }
    }

    public void checkOut(int value) {
        this.quantityStock -= value;
        this.reserved -= value;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (obj == null || (obj.getClass() != this.getClass())){
            return false;
        }

        String objName = ((StockItem)obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
        if (o == this){
            return 0;
        }
        if (o != null){
            return this.name.compareTo(o.getName());
        }
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return name + " : price: " + price + " : stock: " + quantityStock + " : reserved in stock: " + reserved;
    }
}
