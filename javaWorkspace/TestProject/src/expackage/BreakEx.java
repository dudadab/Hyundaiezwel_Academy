package expackage;
import java.util.Scanner;

public class BreakEx {

	public static void main(String[] args) {
		int balance = 100000;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("현재 잔액 : " + balance);
		while (balance > 0) {
			System.out.println("인출액 입력 : ");
			int withdrawal = sc.nextInt();
			if((balance - withdrawal) < 0) {
				System.out.println("잔액부족. 현재 잔액 : " + balance);
				break;
			}
			else {
				balance -= withdrawal;
			}
			System.out.println("남은 잔액 : " + balance);
		}
		sc.close();
	}

}
