package basket;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {

        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10,7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50,2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0,10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50,200);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95,4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50,36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99,35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40,80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76,40);
        stockList.addStock(temp);

        System.out.println(stockList);
        System.out.println();

        Basket adamsBasket = new Basket("Adam");
        reserveBasket(adamsBasket, "car", 1);
        reserveBasket(adamsBasket,"car", 1);
        reserveBasket(adamsBasket,"car", 1);
        reserveBasket(adamsBasket, "spanner", 5);
        reserveBasket(adamsBasket, "juice", 4);
        reserveBasket(adamsBasket, "cup", 12);
        unReserveBasket(adamsBasket, "cup", 4);
        unReserveBasket(adamsBasket, "cup", 25);
        reserveBasket(adamsBasket, "bread", 2);

        System.out.println(adamsBasket);
        System.out.println();

        Basket timsBasket = new Basket("Tim");
        reserveBasket(timsBasket, "cup", 50);
        reserveBasket(timsBasket, "juice", 32);
        reserveBasket(timsBasket, "car", 2);
        reserveBasket(timsBasket, "chair", 5);
        reserveBasket(timsBasket, "vase", 10);

        System.out.println(timsBasket);
        System.out.println(stockList);

        adamsBasket.basketCheckOut();
        System.out.println(adamsBasket);
        System.out.println(stockList);

        timsBasket.basketCheckOut();
        System.out.println(stockList);
    }

    public static int reserveBasket(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if (stockItem == null){
            System.out.println("We dont sell " + item);
            return 0;
        }
        if (stockList.reserveStock(item, quantity) != 0){
            basket.reserveToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }

    public static int unReserveBasket(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if (stockItem == null){
            System.out.println("You have not this " + item + " in your basket");
            return 0;
        }
        if (stockList.unReserveStock(item, quantity) != 0){
            basket.unReserveToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }
}
