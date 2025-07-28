package randomEx;

public class RandomNum1 {

	public static void main(String[] args) {
		// 랜덤숫자 생성 - 1. Math.random()
		// Math 클래스는 기본 라이브러리 -> import 없이 사용 가능
		for(int i=1; i<=10; i++) {
			double num = Math.random() * 10; // 0.xxxxx ~ 9.99999
			int num1 = (int)(Math.random() * 10); // 0 ~ 9 범위의 난수
			int num2 = (int)(Math.random() * 10) + 1; // 1 ~ 10 범위의 난수
			System.out.println(num); 
			System.out.println(num1);
			System.out.println(num2);
		}
	}

}
