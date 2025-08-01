package genericCollection.sec06;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {

    public static void main(String[] args) {
        ArrayList<String> wordList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        for(int i=0; i<4; i++){
            System.out.print("단어를 입력하세요>>");
            String word = scan.next();
            wordList.add(word);
        }

        System.out.println("----------------------------");

        for(String word : wordList){
            System.out.print(word + " ");
        }

        System.out.println();

        String longWord = "";
        for(String word : wordList){
            if(word.length() > longWord.length()){
                longWord = word;
            }
        }

        System.out.println("가장 긴 단어는 : " + longWord);
        System.out.println("가장 긴 단어의 길이는 : " + longWord.length());

        scan.close();

    }
}
