package oopInheritance.sec09;

public class Mycar extends SportsCar { // Mycar 클래스가 final이면 상속 불가
	@Override
	public void speedUp() {
		speed += 10;
	}
	
	@Override
	public void stop() { // 부모 클래스에서 stop 메서드를 final로 지정 - Override 불가
		System.out.println("멈춤");
		speed = 0;
	}
}
