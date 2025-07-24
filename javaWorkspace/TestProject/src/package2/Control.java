package package2;
import java.util.Scanner;

public class Control {

	public static void main(String[] args) {
		// 제어문 반복문 : 프로그램의 흐름은 위에서 아래로 진행이 됨 -> 방향을 바꾸는 역할 
		// if 문
		int score = 85;
		String grade ="" ;
		if(score>=90) {
			if(score>=95) {
				grade = "A+";
			}else {
				grade = "A0";
			}
		}else {
			if(score>=85) {
				grade = "B+";
			}else {
				
			}
		}
		
		Scanner sc = new Scanner(System.in);
		// switch
		// 사용자에게 값을 입력받아서 분기
		int year;
		String year1;
		System.out.println("학년 입력 : ");
		year = sc.nextInt(); // 정수반환
		//year1 = sc.next(); // 문자열로 입력
		
		switch(year) {
		case 1 : System.out.println("1학년"); break;
		case 2 : System.out.println("2학년"); break;
		case 3 : System.out.println("3학년"); break;
		case 4 : System.out.println("4학년"); break;
		default:System.out.println("잘못입력했습니다.");
		}
		
		// //////////////////////////////////////////
		int score1;
		char grade1;
		
		System.out.println("점수 입력(0~100) : ");
		score1 = sc.nextInt();
		
		switch(score1/10) {
		case 10:
		case 9: grade1='A'; break;
		case 8: grade1='B'; break;
		case 7: grade1='C'; break;
		case 6: grade1='D'; break;
		default: grade1='F';  
		}
		System.out.println(grade1);
	}

}
