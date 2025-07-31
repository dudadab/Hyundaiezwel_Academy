package oopInheritance.sec10;

public class ParentChildMain {

	public static void main(String[] args) {
		 Child child = new Child(); // Child 타입 객체
		 
		 // 자동타입변환과 다형성
		 // 부모 클래스 타입의 참조변수 선언
		 Parent parent;
		 // Parent 타입 객체 인스턴스 참조를 Child 타입의 인스턴스 연결 
		 parent = child; // 자동 타입 변환 -> sub class의 객체가 super class의 객체로 자동 타입 변환
		 // parent 변수는 child 객체 참조하지만
		 // 사용 가능한 멤버는 Parent 것만 사용 가능
		 parent.method1(); // Parent 클래스의 method 사용 가능
		 
		 parent.method3(); // Child 클래스의 method 사용 불가
		 
		 // 예외적으로 sub class가 super class의 메서드 재정의 했으면 sub class의 메서드가 호출이 되게 됨
		 parent.method2(); // sub class의 메서드가 호출되게 됨
	}

}
