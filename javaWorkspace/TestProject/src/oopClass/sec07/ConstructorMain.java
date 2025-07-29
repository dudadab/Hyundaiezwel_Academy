package oopClass.sec07;

public class ConstructorMain {

	public static void main(String[] args) {
		// 생성자 호출
		Constructor con = new Constructor(5); // 클래스 내에 명시적 생성자가 있음, 해당 생성자 호출  // 생성자가 정수형 인수 1개를 요구함
		// 객체 생성 시 생성자 인수로 정수형 값을 전달해야 함
		
		// show 호출
		con.show(); // x:100 출력
		
		// 명시적 생성자가 없으면 x:0 출력
	}

}
