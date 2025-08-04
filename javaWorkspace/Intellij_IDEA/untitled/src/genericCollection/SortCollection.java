package genericCollection;
import java.util.*;

public class SortCollection {

    static void printList(ArrayList<String> list){
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            String ele = iter.next();
            String sep;
            if(iter.hasNext())
                sep = "->";
            else
                sep = "\n";
            System.out.println(ele + sep);
        }
    }

    public static void main(String[] args) {
        // 콜렉션 객체에 사용 가능한 sort, reverse 메서드
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("트랜스포머");
        myList.add("스타워즈");
        myList.add("매트릭스");
        myList.add("터미네이터");
        myList.add("메이즈러너");

        System.out.println("리스트 순서 : "); // 입력순서를 보장
        for(String m : myList){
            System.out.println(m + "|");
        }
        System.out.println("\n오름차순 정렬 : "); // Collection 객체에 대한 정렬 static 메서드 sort()
        Collections.sort(myList);
        printList(myList);

        System.out.println("\n내림차순 정렬 : "); // Collection 객체에 대한 정렬 static 메서드 sort()
        Collections.reverse(myList);
        printList(myList);

        System.out.println(myList.get(1));
    }
}
