package oopInheritance.sec09;

public final class SportsCar {
	public int speed;
	
	public void speedUp() {
		speed += 1;
	}
	
	public void speedDown() {
		speed -= 1;
	}
	
	public final void stop() { // final 메서드는 자식 class에서 재정의 불가
		System.out.println("정지");
		speed = 0;
	}
}
