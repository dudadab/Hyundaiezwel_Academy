package oopInheritance.sec13;

public class Line extends DrawingObject {
	
	public Line() {
		penColor = "red"; // DrawingObject의 필드 penColor가 public이므로 바로 접근 가능
	}
	
	@Override
	public void draw() {
		// 추상메서드
		System.out.println(penColor + "색상으로 선 그리기");
	}
}
