package genericCollection.sec13;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> map = new HashMap<String, String>();
        // 1. 사용자로부터 영문단어 = 한글단어 형태의 entry를 입력받아 HashMap에 저장하는 로직 구현
        System.out.println("영문=한글 형식으로 입력하세요. 종료하려면 'exit' 입력.");
        while(true){
            System.out.println(">> ");
            String input = scan.nextLine();
            if (input.equals("exit")) {
                System.out.println("종료합니다...");
                break;
            }
            String[] parts = input.split("=");
            map.put(parts[0], parts[1]);
        }

        System.out.println("\n--- 사전 검색을 시작합니다 ---");


        // 2. HashMap에 입력된 영단어를 검색할 수 있는 로직을 구현
        // exit 입력되면 종료
        // 없는 단어 검색 시 "사전에 없는 단어 입니다." 출력

        while(true){
            System.out.println("찾고 싶은 단어는? ");
            String word = scan.nextLine();

            if (word.equalsIgnoreCase("exit")) {
                System.out.println("종료합니다...");
                break;
            }
            String meaning = map.get(word);
            if (meaning != null) {
                System.out.println(meaning);
            } else {
                System.out.println(word + "는 없는 단어입니다.");
            }
            scan.close();
        }
    }
}
