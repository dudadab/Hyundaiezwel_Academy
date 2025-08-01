package genericCollection.sec08;

public class Product {
    private String productId;
    private String productName;
    private int price;

    public Product(String productId, String productName, int price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    @Override
    public String toString(){
        return "상품(ID: " + productId + ", 이름: " + productName + ", 가격: " +price + "원)";
    }
}
