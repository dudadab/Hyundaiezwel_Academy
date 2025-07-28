package package2;

public class ForNested {

	public static void main(String[] args) {
		// 중첩 for 문 구구단 전체 테이블 형식 출력
		// 2 ~ 9단 : 2x1=2 3x1=3 ... 9x1=9
		for(int i=1; i<9; i++) {
			for(int dan=2; dan<=9; dan++) {
				System.out.print(dan + "x" + i + "=" + dan*i + '\t');
			}
			System.out.println();
		}
	}

}
