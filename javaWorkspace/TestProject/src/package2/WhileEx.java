package package2;
import java.util.Scanner;

public class WhileEx {

	public static void main(String[] args) {
		// 사용자가 숫자 7을 입력할 때 까지 계속 반복 입력받는 예제
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.print("숫자 입력 : ");
		num = sc.nextInt();
		
		// while과 for는 반복 시작 전 조건 검사
		while(num != 7) { // 7이 아니면 다시 입력
			System.out.print("다시 입력 : ");
			num = sc.nextInt();
		}
		System.out.print("7입력. 종료");
		sc.close();
		
	}

}
