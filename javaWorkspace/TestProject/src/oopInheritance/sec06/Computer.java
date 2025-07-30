package oopInheritance.sec06;

public class Computer extends Calculator {
	// 컴파일러는 부모클래스의 areaCircle 메서드의 정의부와 재정의되는 메서드의 정의부가 같은지 확인
	// 재정의 하려는 메서드가 부모클래스에 없음 : areaircle는 없기 때문에 재정의 불가 에러가 발생
	@Override
	double areaCircle(double r) { //default -> 부모클래스 메서드가 default 이므로 접근제한이 같거나 범위가 넓어야 함
		System.out.println("Computer 객체의 areaCircle() 실행");
		return Math.PI * r * r; // 보다 더 정밀한 계산을 위해 3.14159 대신 Math.PI 상수 이용 
	}
}
