package designpattern.b_coffeemanager;

public class Coffee {
    String name;
    int price, cost, stock, safetyStock, salesAmount;

    public Coffee(String name, int price, int cost, int stock, int safetyStock, int salesAmount) {
        this.name = name;
        this.price = price;
        this.cost = cost;
        this.stock = stock;
        this.safetyStock = safetyStock;
        this.salesAmount = salesAmount;
    }

    public String getName() {
        return name;
    }


    public int getPrice() {
        return price;
    }

    public int getCost() {
        return cost;
    }

    public int getStock() {
        return stock;
    }


    public int getSafetyStock() {
        return safetyStock;
    }

    public void setSafetyStock(int safetyStock) {
        this.safetyStock = safetyStock;
    }

    public int getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(int salesAmount) {
        this.salesAmount = salesAmount;
    }

    public void deductStock(int orderCnt) {
        this.stock -= orderCnt;
    }

    public void addStock(int orderCnt) {
        this.stock += orderCnt;
    }
}
