package expackage;

import java.util.Scanner;

public class Array2DEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[][] word = {{"chair", "의자"},
				 			{"computer", "컴퓨터"},
				 			{"integer", "정수"}};
		
		for(int i=0; i<word.length; i++) {
			System.out.printf("Q%d.%s의 뜻은? : ", i+1,word[i][0]);
			String answer = sc.next();
			if(word[i][1].equals(answer)) {
				System.out.println("정답입니다.\n");
			}else {
				System.out.printf("틀렸습니다. 정답은 %s입니다.\n\n", word[i][1]);
			}
		}
		sc.close();
	}

}
