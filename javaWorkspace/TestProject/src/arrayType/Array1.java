package arrayType;

import java.util.Arrays;

public class Array1 {

	public static void main(String[] args) {
		// 배열 기본 문법
		// 배열 선언 - 사용 불가
		int[] a;
		int b[];
		
		// 배열 생성 - 메모리 할당
		a = new int[3];
		
		// 값 직접 저장
		a[0] = 10;
		a[1] = 20;
		a[2] = 30;

		// 원소 접근
		System.out.println(a[1]);
		
		// 전체 원소 접근
		// for 문 활용
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
		
		// 배열 변수에 저장된 값 출력
		System.out.println(a); // [I@2ff4acd0 - 실제 주소가 아닌 16진수로 구성된 내부 가상주소가 반환됨
		// [I@2ff4acd0 : [ -> 1차원 배열, I -> int @16진수 가상 주소
		
		// 배열 선언, 할당, 값 저장
		int[] score = new int[] {90,30,40};
		for(int i=0; i<score.length; i++) {
			System.out.println(score[i]);
		}
		int[] score1 = new int[] {90,30,40};
		
		// 선언해 놓은 b 배열 생성하고 값 저장 -> {} : 선언 시에만 가능한 
		// b = {10,45,70};
		
		b = new int[3]; //생성
		for(int i=0; i<b.length; i++) {
			b[i] = i; // 0,1,2 저장
		}
		
		// 참조 타입의 배열
		String[] flowers = {"해바라기", "장미", "진달래"};
		for(int i=0; i<flowers.length; i++) {
			System.out.print(flowers[i] + " ");
		}
		
		System.out.println();
		
		// Arrays 클래스의 toString() 메소드 사용 - 전체 배열 값 출력
		// import java.util.Arrays 필요함
		System.out.println(Arrays.toString(flowers));
		
		// 배열 길이(크기)가 0인 배열 생성
		int score2[] = new int[0];
		int score3[] = new int[] {};
		int[] score4 = {};
		System.out.println(score2.length);
	}

}
