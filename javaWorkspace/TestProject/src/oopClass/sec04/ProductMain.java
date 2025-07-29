package oopClass.sec04;
import java.util.Scanner;

class Product{
	Scanner sc = new Scanner(System.in);
	String prdName;
	int prdPrice;
	int prdSold;
	int prdStock;
	
	public void inputPrdInfo() {
		System.out.println("****상품 정보 입력****");
        System.out.printf("상품명: ");
        prdName = sc.next();
        System.out.printf("가격: ");
        prdPrice = sc.nextInt();
        System.out.printf("판매 수량: ");
        prdSold = sc.nextInt();
        System.out.printf("재고 수량: ");
        prdStock = sc.nextInt();
        
    }
	
	public void showPrdInfo() {
		System.out.println("****상품 정보 출력****");
		System.out.println("상품명: " + prdName);
		System.out.println("가격: " + prdPrice);
		System.out.println("판매 수량: " + prdSold);
		System.out.println("재고 수량: " + prdStock);
	}
	
	public void showSalesAmount() {
		int slaesAmount = prdPrice * prdSold;
		System.out.printf("매출액: %d \n", slaesAmount);
		
	}
	
	public void showStockAmount() {
		int stockAmount = prdPrice * prdStock;
		System.out.printf("재고액: %d", stockAmount);
	}
	
	
}


public class ProductMain {
	
	public static void main(String[] args) {
		Product product = new Product();
		product.inputPrdInfo();
        product.showPrdInfo(); 
        product.showSalesAmount(); 
        product.showStockAmount();   
		
		
	}
}
