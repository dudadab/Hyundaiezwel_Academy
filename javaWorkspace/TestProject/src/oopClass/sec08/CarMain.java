package oopClass.sec08;

public class CarMain {

	public static void main(String[] args) {
		// 사용자 정의 클래스 Car를 사용
		// 1. Car 클래스 객체 생성 2. 생성된 객체 이용해 멤버변수나 멤버메소드 사용(사용은 접근제한에 따라 다름)
		// Car 클래스는 현재 클래스(CarMain)와 동일 패키지 내에 있음 -import 없이 사용 가능
		Car c = new Car("11다1133","k5","KIA"); // 객체 생성 - 명시적 생성자 호출
		// c 인스턴스 생성
		
		// 객체를 통해 public 메소드 호출
		c.setCarInfo("11가1111","k7","KIA",2025,1800); // c 참조변수가 참조하고 있는 객체의 멤버변수에 값이 저장됨
		c.showCarInfo(); // c 참조변수가 참조하는 객체의 멤버변수 값을 출력
		
		//Car 클래스 인스턴스 b 생성
		Car b = new Car();
		b.setCarInfo("22나2222","제네시스","현대",2023,2000);
		b.showCarInfo();
	}

}
