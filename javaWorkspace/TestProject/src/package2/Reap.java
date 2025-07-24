package package2;

public class Reap {

	public static void main(String[] args) {
		// for : 반복 횟수를 알고 있을 때 주로 사용
		int sum = 0;
		int i ;
		for(i=1; i<=100; i++) {
			System.out.println(i);
			sum += i;
		}
		System.out.println(sum);
		
		for(int dan=1; dan<=9; dan++) {
			for(i=1; i<=9; i++) {
				System.out.println(dan + " x " + i + "=" + dan * i);
			}

		}
	}

}
