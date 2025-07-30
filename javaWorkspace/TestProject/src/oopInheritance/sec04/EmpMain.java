package oopInheritance.sec04;

public class EmpMain {
	
	public static void main(String[] args) {
		// 서브 클래스의 인스턴스 생성하면서
		// 서브 클래스의 생성자에게 인수 전달
		// 슈퍼 클래스가 필요한 인수도 같이 전달하고 서브 클래스의 생성자에서 부모클래스로 전달하도록 구현
		Manager mg = new Manager("1234","홍길동","마케팅","대리");
		
		// 자식클래스 인스턴스 출력
		// toString 오버라이딩함
		System.out.println(mg);
	}
}
