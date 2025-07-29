package oopClass.sec06;

public class CircleMain {

	public static void main(String[] args) {
		// Circle 클래스 사용
		Circle ci = new Circle();
		
		ci.setCircle(5);
		float result = ci.area();
		System.out.println("원의 넓이 : " + ci.area());

	}

}
