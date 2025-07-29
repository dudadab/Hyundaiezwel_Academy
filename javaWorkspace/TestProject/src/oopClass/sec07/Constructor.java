package oopClass.sec07;

public class Constructor {
	// 멤버변수
	private int y;
	private int x;
	
	// 생성자 : 클래스 이름과 동일한 메소드, 반환타입 없음
	// 객체 생성될 때 한번만 호출 가능
	// 생성자 역할 : 멤버변수 값 초기화 
	// 명시적 생성자가 구현되었으므로 default 생성자(컴파일러가 생성하는)는 구현하지 않음	
	public Constructor(int x) {
		// 메서드 바디 영역이므로 x는 매개변수 x(지역변수)를 지칭하게 됨
		// 멤버변수 x 지칭시에는 class 영역을 지칭하는 this 레퍼런스 사용
		// this 레퍼런스 : 현재 클래스를 참조하는 예약어
		this.x=x;
	}
	
	// 멤버메서드
	public void show() {
		System.out.println("x: " + this.x);
	}
}
