package arrayType;

public class Array2D {

	public static void main(String[] args) {
		// 다차원 배열 : 선언 및 생성
		// int[][] score; // 2차원 배열 선언
		// score = new int[행][열]

		int[][] score = new int[5][3];
		
		// 배열 크기 .length
		System.out.println(score.length); // 행 수
		System.out.println(score[0].length); // 열 수 : 각 행의 원소 수
		System.out.println(score[1].length); // 열 수
		System.out.println(score[2].length); // 열 수
		System.out.println(score[3].length); // 열 수
		System.out.println(score[4].length); // 열 수
		
		// 배열명과 각 행의 접근
		System.out.println(score); // 행 수
		System.out.println(score[0]);
		System.out.println(score[1]);
		System.out.println(score[2]);
		System.out.println(score[3]);
		System.out.println(score[4]);
	}

}
