package randomEx;
import java.util.Random;

public class RandomNum2 {

	public static void main(String[] args) {
		// 난수발생 : Random 클래스 사용
		// import java.util.Random;
		// 참조 객체 생성해서 사용해야 함
		// 객체.nextInt(숫자) 특정범위에서 생성

		Random r = new Random();
		
		for(int i=1; i<=10; i++) {
			int num = r.nextInt(10); // 0 ~ 9 사이의 난수
			int num2 = r.nextInt(10) + 1; // 1 ~ 10 사이의 난수
			System.out.println(num);
			System.out.println(num2);
		}
	}

}
