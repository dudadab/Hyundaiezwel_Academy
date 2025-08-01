package genericCollection.sec08;

import java.util.LinkedList;


public class ProductMain {

    public static void main(String[] args) {
        LinkedList<Product> proList = new LinkedList<>();

        proList.add(new Product("P01", "모니터", 120000));
        proList.add(new Product("P02", "키보드", 70000));
        proList.add(new Product("P03", "마우스", 35000));

        System.out.println(" -- 상품 목록 -- ");
        for(Product product : proList){
            System.out.println(product);
        }

    }
}
