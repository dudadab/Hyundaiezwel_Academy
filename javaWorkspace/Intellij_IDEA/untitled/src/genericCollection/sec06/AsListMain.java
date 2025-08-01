package genericCollection.sec06;

import java.util.Arrays;
import java.util.List;

public class AsListMain {

    public static void main(String[] args) {
        // Arrays 클래스의 asList 메서드 : 초기화된 List 생성
        List<String> list1 = Arrays.asList("ronaldo","messi","Son");
        for(String name : list1){
            System.out.println(name);
        }

        List<Integer> list2 = Arrays.asList(1,2,3);
        for(int no : list2){
            System.out.println(no);
        }

        list2.set(1,5);
        for(int no : list2){
            System.out.println(no);
        }

//        list2.add(10); // 오류
//        for(int no : list2){
//            System.out.println(no);
//        }
    }
}
