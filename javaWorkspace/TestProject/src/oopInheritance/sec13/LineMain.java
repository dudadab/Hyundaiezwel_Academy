package oopInheritance.sec13;

public class LineMain {

	public static void main(String[] args) {
		// Line 클래스 사용
		Line line = new Line();
		line.draw();
		
		Circle ci = new Circle();
		ci.draw();
		
		Rect re = new Rect();
		re.draw();
		
		//추상클래스 객체 생성 불가
		//DrawingObject dot = new DrawingObject(); // 추상 클래스이므로 객체 생성 불가능 

	}

}
